package aiss;

import java.io.IOException;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;

import lolmatch.Match;
import lolmatch.Participant;
import lolmatch.ParticipantIdentity;
import lolmatchsxid.PlayerMatchs;
import lolplayer.Player;

/**
 * Servlet implementation class pubg
 */
public class lolservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public lolservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String apikey = "RGAPI-68413756-87fb-475e-9ba2-8773bb3d5840";
		String nombre = request.getParameter("name");
		System.out.println("NOMBRE->" + nombre );
		HttpSession session = request.getSession();
		try {
		String region = request.getParameter("region");
		String uri3 = "https://"+region+".api.riotgames.com/lol/summoner/v4/summoners/by-name/" + nombre + "?api_key="
				+ apikey;
		ClientResource cr3 = new ClientResource(uri3);
		Player player = cr3.get(Player.class);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String accountid = player.getAccountId();

		String uri2 = "https://"+region+".api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountid + "?api_key="
				+ apikey;
		ClientResource cr2 = new ClientResource(uri2);
		
		PlayerMatchs mm = cr2.get(PlayerMatchs.class);
		List<lolmatchsxid.Match> matches = mm.getMatches();
		List<MatchLoL> toJSP = new ArrayList<MatchLoL>();
		List<List<MatchLoL2>> toJSP2a = new ArrayList<List<MatchLoL2>>();
		List<List<MatchLoL2>> toJSP2r = new ArrayList<List<MatchLoL2>>();
		List<Boolean> wins = new ArrayList<Boolean>();
		List<Integer> tk = new ArrayList<Integer>();
		List<Integer> qk = new ArrayList<Integer>();
		List<Integer> pk = new ArrayList<Integer>();
		List<String> linea = new ArrayList<String>();
		List<Boolean> type0 = new ArrayList<Boolean>();
		List<Boolean> type1 = new ArrayList<Boolean>();
		List<Boolean> type2 = new ArrayList<Boolean>();
		List<Boolean> type3 = new ArrayList<Boolean>();
		List<Boolean> type4 = new ArrayList<Boolean>();
		List<Boolean> type5 = new ArrayList<Boolean>();
		List<Boolean> type6 = new ArrayList<Boolean>();
		List<Integer> baron = new ArrayList<Integer>();
		List<Integer> drake = new ArrayList<Integer>();
		List<Integer> herald = new ArrayList<Integer>();
		List<Integer> tower = new ArrayList<Integer>();
		List<Integer> killsr = new ArrayList<Integer>();
		List<Integer> killsa = new ArrayList<Integer>();
		List<Long> tiempo = new ArrayList<Long>();
		List<Integer> equipos = new ArrayList<Integer>();
		int limit=6;

			for (int i = 0; i <limit; i++) {
				List<MatchLoL2> listajspa = new ArrayList<MatchLoL2>();
				List<MatchLoL2> listajspr = new ArrayList<MatchLoL2>();

				Long gameid = matches.get(i).getGameId();
				String uri = "https://"+region+".api.riotgames.com/lol/match/v4/matches/" + gameid.toString() + "?api_key="
						+ apikey;
				ClientResource cr = new ClientResource(uri);
				Match pp = cr.get(Match.class);
				
				List<ParticipantIdentity> aro = pp.getParticipantIdentities();
				List<Participant> lista = pp.getParticipants();
				int ka=0;
				int kr=0;
				for (int j = 0; j < 10; j++) {
					
					if(lista.get(j).getTeamId()==100) {
						ka=ka+lista.get(j).getStats().getKills();
						MatchLoL2 jugador2 = new MatchLoL2(aro.get(j).getPlayer().getSummonerName(),getNameChamp(lista.get(j).getChampionId()),lista.get(j).getStats().getKills(),lista.get(j).getStats().getDeaths(),lista.get(j).getStats().getAssists());

						listajspa.add(jugador2);

					}else {
						kr=kr+lista.get(j).getStats().getKills();
						MatchLoL2 jugador2 = new MatchLoL2(aro.get(j).getPlayer().getSummonerName(),getNameChamp(lista.get(j).getChampionId()),lista.get(j).getStats().getKills(),lista.get(j).getStats().getDeaths(),lista.get(j).getStats().getAssists());
						listajspr.add(jugador2);

					}
					if(j==9) {
						killsr.add(kr);
						killsa.add(ka);
					}
					if (aro.get(j).getPlayer().getAccountId().equals(accountid)) {
						if(lista.get(j).getTeamId()==pp.getTeams().get(0).getTeamId()) {
							baron.add(pp.getTeams().get(0).getBaronKills());
							drake.add(pp.getTeams().get(0).getDragonKills());
							herald.add(pp.getTeams().get(0).getRiftHeraldKills());
							tower.add(pp.getTeams().get(0).getTowerKills());

						}else {
							baron.add(pp.getTeams().get(1).getBaronKills());
							drake.add(pp.getTeams().get(1).getDragonKills());
							herald.add(pp.getTeams().get(1).getRiftHeraldKills());
							tower.add(pp.getTeams().get(1).getTowerKills());
						}
						MatchLoL jugador = new MatchLoL(
								player.getProfileIconId(),
								getNameChamp(lista.get(j).getChampionId()),
								lista.get(j).getStats().getTotalMinionsKilled(),
								lista.get(j).getStats().getNeutralMinionsKilled(),
								lista.get(j).getStats().getKills(),
								lista.get(j).getStats().getDeaths(), 
								lista.get(j).getStats().getAssists(),
								lista.get(j).getStats().getTrueDamageDealtToChampions(),
								lista.get(j).getStats().getMagicDamageDealtToChampions(),
								lista.get(j).getStats().getPhysicalDamageDealtToChampions(),
								lista.get(j).getStats().getWin(),
								lista.get(j).getSpell1Id(),
								lista.get(j).getSpell2Id(),
								lista.get(j).getStats().getItem0(),
								lista.get(j).getStats().getItem1(),
								lista.get(j).getStats().getItem2(),
								lista.get(j).getStats().getItem3(),
								lista.get(j).getStats().getItem4(),
								lista.get(j).getStats().getItem5(),
								lista.get(j).getStats().getItem6(),
								lista.get(j).getStats().getGoldEarned(),
								pp.getGameDuration());
						toJSP.add(jugador);
						wins.add(lista.get(j).getStats().getWin());
						tk.add(lista.get(j).getStats().getTripleKills());	
						qk.add(lista.get(j).getStats().getQuadraKills());
						pk.add(lista.get(j).getStats().getPentaKills());
						linea.add(lista.get(j).getTimeline().getLane());
						type0.add(lista.get(j).getStats().getItem0().equals(2052));
						type1.add(lista.get(j).getStats().getItem1().equals(2052));
						type2.add(lista.get(j).getStats().getItem2().equals(2052));
						type3.add(lista.get(j).getStats().getItem3().equals(2052));
						type4.add(lista.get(j).getStats().getItem4().equals(2052));
						type5.add(lista.get(j).getStats().getItem5().equals(2052));
						type6.add(lista.get(j).getStats().getItem6().equals(2052));
						tiempo.add(pp.getGameDuration());
						equipos.add(lista.get(j).getTeamId());
					}
				}
				toJSP2a.add(listajspa);
				toJSP2r.add(listajspr);

			}
			for(int i=0;i<limit;i++) {
				request.setAttribute("asistencias"+i, toJSP.get(i).assists);
				request.setAttribute("muertes"+i, toJSP.get(i).deaths);
				request.setAttribute("asesinatos"+i, toJSP.get(i).kills);
				request.setAttribute("campeon"+i, toJSP.get(i).champion);
			}
			request.setAttribute("region", region);
			request.setAttribute("rojo", toJSP2r);
			request.setAttribute("azul", toJSP2a);
			request.setAttribute("equipos", equipos);
			request.setAttribute("tiempo", tiempo);
			request.setAttribute("baron", baron);
			request.setAttribute("drake", drake);
			request.setAttribute("herald", herald);
			request.setAttribute("tower", tower);
			request.setAttribute("killsr", killsr);
			request.setAttribute("killsa", killsa);
			request.setAttribute("type0", type0);
			request.setAttribute("type1", type1);
			request.setAttribute("type2", type2);
			request.setAttribute("type3", type3);
			request.setAttribute("type4", type4);
			request.setAttribute("type5", type5);
			request.setAttribute("type6", type6);
			request.setAttribute("linea", linea);
			request.setAttribute("nombre", player.getName());
			request.setAttribute("icono", player.getProfileIconId());
			request.setAttribute("lvl", player.getSummonerLevel());
			request.setAttribute("lista", toJSP);
			request.setAttribute("wins", wins);
			request.setAttribute("tk", tk);
			request.setAttribute("qk", qk);
			request.setAttribute("pk", pk);
			request.getRequestDispatcher("/muestralol.jsp").forward(request, response);
			
		} catch(ResourceException re) {
			String mensaje = "<div id=\"errorp\" class=\"w-50 alert alert-danger\" role=\"alert\">\r\n" + 
					"  EL USUARIO INTRODUCIDO NO HA JUGADO PARTIDOS RECIENTEMENTE Ó NO EXISTE\r\n" + 
					"</div>";
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("user", nombre);
			request.getRequestDispatcher("/lolbusqueda.jsp").forward(request, response);
		}
		
	}

	public String getNameChamp(int id) {
		String nombre = null;
		switch (id) {

		case 266:
			nombre = "Aatrox";
			break;
		case 412:
			nombre = "Thresh";
			break;
		case 23:
			nombre = "Tryndamere";
			break;
		case 79:
			nombre = "Gragas";
			break;
		case 69:
			nombre = "Cassiopeia";
			break;
		case 136:
			nombre = "AurelionSol";
			break;
		case 13:
			nombre = "Ryze";
			break;
		case 78:
			nombre = "Poppy";
			break;
		case 14:
			nombre = "Sion";
			break;
		case 1:
			nombre = "Annie";
			break;
		case 202:
			nombre = "Jhin";
			break;
		case 43:
			nombre = "Karma";
			break;
		case 111:
			nombre = "Nautilus";
			break;
		case 240:
			nombre = "Kled";
			break;
		case 99:
			nombre = "Lux";
			break;
		case 103:
			nombre = "Ahri";
			break;
		case 2:
			nombre = "Olaf";
			break;
		case 112:
			nombre = "Viktor";
			break;
		case 34:
			nombre = "Anivia";
			break;
		case 27:
			nombre = "Singed";
			break;
		case 86:
			nombre = "Garen";
			break;
		case 127:
			nombre = "Lissandra";
			break;
		case 57:
			nombre = "Maokai";
			break;
		case 25:
			nombre = "Morgana";
			break;
		case 28:
			nombre = "Evelynn";
			break;
		case 105:
			nombre = "Fizz";
			break;
		case 74:
			nombre = "Heimerdinger";
			break;
		case 238:
			nombre = "Zed";
			break;
		case 68:
			nombre = "Rumble";
			break;
		case 82:
			nombre = "Mordekaiser";
			break;
		case 37:
			nombre = "Sona";
			break;
		case 96:
			nombre = "KogMaw";
			break;
		case 55:
			nombre = "Katarina";
			break;
		case 117:
			nombre = "Lulu";
			break;
		case 22:
			nombre = "Ashe";
			break;
		case 30:
			nombre = "Karthus";
			break;
		case 12:
			nombre = "Alistar";
			break;
		case 122:
			nombre = "Darius";
			break;
		case 67:
			nombre = "Vayne";
			break;
		case 110:
			nombre = "Varus";
			break;
		case 77:
			nombre = "Udyr";
			break;
		case 89:
			nombre = "Leona";
			break;
		case 126:
			nombre = "Jayce";
			break;
		case 134:
			nombre = "Syndra";
			break;
		case 80:
			nombre = "Pantheon";
			break;
		case 92:
			nombre = "Riven";
			break;
		case 121:
			nombre = "Khazix";
			break;
		case 42:
			nombre = "Corki";
			break;
		case 268:
			nombre = "Azir";
			break;
		case 51:
			nombre = "Caitlyn";
			break;
		case 76:
			nombre = "Nidalee";
			break;
		case 85:
			nombre = "Kennen";
			break;
		case 3:
			nombre = "Galio";
			break;
		case 45:
			nombre = "Veigar";
			break;
		case 432:
			nombre = "Bard";
			break;
		case 150:
			nombre = "Gnar";
			break;
		case 90:
			nombre = "Malzahar";
			break;
		case 104:
			nombre = "Graves";
			break;
		case 254:
			nombre = "Vi";
			break;
		case 10:
			nombre = "Kayle";
			break;
		case 39:
			nombre = "Irelia";
			break;
		case 64:
			nombre = "LeeSin";
			break;
		case 420:
			nombre = "Illaoi";
			break;
		case 60:
			nombre = "Elise";
			break;
		case 106:
			nombre = "Volibear";
			break;
		case 20:
			nombre = "Nunu";
			break;
		case 4:
			nombre = "TwistedFate";
			break;
		case 24:
			nombre = "Jax";
			break;
		case 102:
			nombre = "Shyvana";
			break;
		case 429:
			nombre = "Kalista";
			break;
		case 36:
			nombre = "DrMundo";
			break;
		case 427:
			nombre = "Ivern";
			break;
		case 131:
			nombre = "Diana";
			break;
		case 223:
			nombre = "TahmKench";
			break;
		case 63:
			nombre = "Brand";
			break;
		case 113:
			nombre = "Sejuani";
			break;
		case 8:
			nombre = "Vladimir";
			break;
		case 154:
			nombre = "Zac";
			break;
		case 421:
			nombre = "RekSai";
			break;
		case 133:
			nombre = "Quinn";
			break;
		case 84:
			nombre = "Akali";
			break;
		case 163:
			nombre = "Taliyah";
			break;
		case 18:
			nombre = "Tristana";
			break;
		case 120:
			nombre = "Hecarim";
			break;
		case 15:
			nombre = "Sivir";
			break;
		case 236:
			nombre = "Lucian";
			break;
		case 107:
			nombre = "Rengar";
			break;
		case 19:
			nombre = "Warwick";
			break;
		case 72:
			nombre = "Skarner";
			break;
		case 54:
			nombre = "Malphite";
			break;
		case 157:
			nombre = "Yasuo";
			break;
		case 101:
			nombre = "Xerath";
			break;
		case 17:
			nombre = "Teemo";
			break;
		case 75:
			nombre = "Nasus";
			break;
		case 58:
			nombre = "Renekton";
			break;
		case 119:
			nombre = "Draven";
			break;
		case 35:
			nombre = "Shaco";
			break;
		case 50:
			nombre = "Swain";
			break;
		case 91:
			nombre = "Talon";
			break;
		case 40:
			nombre = "Janna";
			break;
		case 115:
			nombre = "Ziggs";
			break;
		case 245:
			nombre = "Ekko";
			break;
		case 61:
			nombre = "Orianna";
			break;
		case 114:
			nombre = "Fiora";
			break;
		case 9:
			nombre = "Fiddlesticks";
			break;
		case 31:
			nombre = "ChoGath";
			break;
		case 33:
			nombre = "Rammus";
			break;
		case 7:
			nombre = "LeBlanc";
			break;
		case 16:
			nombre = "Soraka";
			break;
		case 26:
			nombre = "Zilean";
			break;
		case 56:
			nombre = "Nocturne";
			break;
		case 222:
			nombre = "Jinx";
			break;
		case 83:
			nombre = "Yorick";
			break;
		case 6:
			nombre = "Urgot";
			break;
		case 203:
			nombre = "Kindred";
			break;
		case 21:
			nombre = "MissFortune";
			break;
		case 62:
			nombre = "Wukong";
			break;
		case 53:
			nombre = "Blitzcrank";
			break;
		case 98:
			nombre = "Shen";
			break;
		case 201:
			nombre = "Braum";
			break;
		case 5:
			nombre = "XinZhao";
			break;
		case 29:
			nombre = "Twitch";
			break;
		case 11:
			nombre = "MasterYi";
			break;
		case 44:
			nombre = "Taric";
			break;
		case 32:
			nombre = "Amumu";
			break;
		case 41:
			nombre = "Gangplank";
			break;
		case 48:
			nombre = "Trundle";
			break;
		case 38:
			nombre = "Kassadin";
			break;
		case 161:
			nombre = "Velkoz";
			break;
		case 143:
			nombre = "Zyra";
			break;
		case 267:
			nombre = "Nami";
			break;
		case 59:
			nombre = "JarvanIV";
			break;
		case 81:
			nombre = "Ezreal";
			break;
		case 164:
			nombre = "Camille";
			break;
		case 498:
			nombre = "Xayah";
			break;
		case 497:
			nombre = "Rakan";
			break;
		case 141:
			nombre = "Kayn";
			break;
		case 516:
			nombre = "Ornn";
			break;
		case 142:
			nombre = "Zoe";
			break;
		case 145:
			nombre = "Kaisa";
			break;
		case 555:
			nombre = "Pyke";
			break;
		case 518:
			nombre = "Neeko";
			break;
		case 517:
			nombre = "Sylas";
			break;
		case 350:
			nombre = "Yuumi";
			break;
		case 246:
			nombre = "Qiyana";
			break;
		case 235:
			nombre = "Senna";
			break;
		case 523:
			nombre = "Aphelios";
			break;
		case 875:
			nombre = "Sett";
			break;

		default:
			nombre = "No lo conozco";
			break;
		}
		return nombre;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

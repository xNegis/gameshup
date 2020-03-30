package aiss;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
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

import org.codehaus.jackson.map.DeserializationConfig.Feature;

import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import pubfLifeStats.LifeStats;
import pubgmatch.Datum__;
import pubgmatch.Included;
import pubgmatch.Participants;
import pubgmatch.Rosters;
import pubgmatch.Stats;
import pubgplayer.PlayerPubg;
import pubgseason.PubgSeason;
     

/**
 * Servlet implementation class PubgServlet
 */
public class PubgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PubgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			try {
				doTrustToCertificates();
				ObjectMapper objectMapper = new ObjectMapper();
				

				URL url = new URL("https://api.pubg.com/shards/steam/players?filter[playerNames]="+request.getParameter("name"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiMDNhZWE2MC0zNmNlLTAxMzgtYmJjOS0zNzRkM2UxZGEzNjYiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTgyMjg2MDA0LCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InNlcmdpb3JvamFzamltIn0.dFS0GuKAPpTrOEChROMqc3APivDw-NDbwAhDpK4WMT8");
				conn.setRequestProperty("Accept", "application/vnd.api+json");
				PlayerPubg player = objectMapper.readValue(conn.getInputStream(),PlayerPubg.class);
				String id =  player.getData().get(0).getId();
				System.out.println(id);
				List<String> idmatches = new ArrayList<String>();
				for(int i=0;i<9;i++) { 
					idmatches.add(player.getData().get(0).getRelationships().getMatches().getData().get(i).getId());
//					System.out.println(player.getData().get(0).getRelationships().getMatches().getData().get(i).getId());
				}
				
				List<Matchpubg> lista = new ArrayList<Matchpubg>();
				List<List<Matchpubg>> compis = new ArrayList<List<Matchpubg>>();
				for(int j=0;j<idmatches.size();j++) {
					List<String> idpla2 = new ArrayList<String>();
					String idpla="";
					ObjectMapper objectMapper1 = new ObjectMapper();
					objectMapper1.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
					doTrustToCertificates();

					URL url1 = new URL("https://api.pubg.com/shards/steam/matches/"+idmatches.get(j));
					HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
					conn1.setRequestMethod("GET");
					conn1.setRequestProperty("Accept", "application/vnd.api+json");
					pubgmatch.PubgMatch match = objectMapper1.readValue(conn1.getInputStream(),pubgmatch.PubgMatch.class);
					String gamemode="";
					 
//					SACAR STATS JUGADOR
					
					for(int i=0;i<match.getIncluded().size();i++) {
						
						if(match.getIncluded().get(i).getType().equals("participant")) {
							if(match.getIncluded().get(i).getAttributes().getStats().getName().equals(request.getParameter("name") )) {
							Stats stats = match.getIncluded().get(i).getAttributes().getStats();
							idpla = match.getIncluded().get(i).getId();
							
							Matchpubg jugador = new Matchpubg(match.getData().getAttributes().getMapName(),
									stats.getName(), 
									stats.getKills(), 
									stats.getDamageDealt(), 
									stats.getWinPlace(),
									match.getData().getAttributes().getGameMode());
									gamemode = 	match.getData().getAttributes().getGameMode();

							
							lista.add(jugador);
						}
						}
					}
					
					
//						SACAR COMPIS
					
						for(int i=0;i<match.getIncluded().size();i++) {
							int tamequipo=0;
							if(gamemode.equals("duo") || gamemode.equals("duo-fpp")) {
								tamequipo=1;
							}else if(gamemode.equals("solo") || gamemode.equals("solo-fpp")){
								tamequipo=0;
							}else {
								tamequipo=3;
							} 
							
//							SACAMOS COMPAÑEROS DEL JUGADOR PASADO COMO PARAMETRO 
						if(match.getIncluded().get(i).getType().equals("roster")) {
							Included rost = match.getIncluded().get(i); //Roster
							Participants participantes = rost.getRelationships().getParticipants(); //Participantes del roster
							List<Datum__> datosparticipantes = participantes.getData(); //Info de participantes
							for(int b=0;b<datosparticipantes.size();b++) {
								if(datosparticipantes.get(b).getId().equals(idpla)) {
									for(int ñ=0;ñ<=tamequipo;ñ++) {
										if(ñ!=b) {
											idpla2.add(datosparticipantes.get(ñ).getId());
										}
									}
								}
							}
							
							
							}
						}
						
						
						List<Matchpubg> compis1 = new ArrayList<Matchpubg>();

//						COGEMOS LAS STATS DEL COMPI
						
						for(int i=0;i<match.getIncluded().size();i++) {
							if(match.getIncluded().get(i).getType().equals("participant")) {	
							for(int z=0;z<idpla2.size();z++){
								if(match.getIncluded().get(i).getId().equals(idpla2.get(z))){
									Stats stats = match.getIncluded().get(i).getAttributes().getStats();
									idpla = match.getIncluded().get(i).getId();
									Matchpubg jugador = new Matchpubg(match.getData().getAttributes().getMapName(),
											stats.getName(), 
											stats.getKills(), 
											stats.getDamageDealt(), 
											stats.getWinPlace(),
											match.getData().getAttributes().getGameMode());
									compis1.add(jugador);
								}
							} 
							}
						}
						compis.add(compis1);

						
						
					}
								
				List<Matchpubg> listacomp = new ArrayList<Matchpubg>();
					

//				ESTABLECE LA SEASON
				
				String season="";
				String seasonJSP="";
				if(request.getParameter("season")==null) {
					season="division.bro.official.pc-2018-06";
					seasonJSP="SS6";
				}else { 
					if(request.getParameter("season").equals("SS1")) {
						season="division.bro.official.pc-2018-01";
						seasonJSP="SS1";
					}else if(request.getParameter("season").equals("SS2")) {
						season="division.bro.official.pc-2018-02";
						seasonJSP="SS2";
					}else if(request.getParameter("season").equals("SS3")) {
						season="division.bro.official.pc-2018-03";
						seasonJSP="SS3";
					}else if(request.getParameter("season").equals("SS4")) {
						season="division.bro.official.pc-2018-04";
						seasonJSP="SS4";
					}else if(request.getParameter("season").equals("SS5")) {
						season="division.bro.official.pc-2018-05";
						seasonJSP="SS5";
					}else {
						season="division.bro.official.pc-2018-06";
						seasonJSP="SS6";
					}
				}

//				SEASON STATS API
				
				ObjectMapper objectMapper2 = new ObjectMapper();
				objectMapper2.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				doTrustToCertificates();

				URL url2 = new URL("https://api.pubg.com/shards/steam/players/"+id+"/seasons/" + season);
				HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
				conn2.setRequestMethod("GET");
				conn2.setRequestProperty("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiMDNhZWE2MC0zNmNlLTAxMzgtYmJjOS0zNzRkM2UxZGEzNjYiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTgyMjg2MDA0LCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InNlcmdpb3JvamFzamltIn0.dFS0GuKAPpTrOEChROMqc3APivDw-NDbwAhDpK4WMT8");
				conn2.setRequestProperty("Accept", "application/vnd.api+json");
				PubgSeason seasonstats = objectMapper2.readValue(conn2.getInputStream(),PubgSeason.class);
				
				Double kds =0.0;
				Double kdd = 0.0;
				Double kdsq = 0.0;
				Double kdsf = 0.0;
				Double kddf = 0.0;
				Double kdsqf = 0.0;
				String modoJSP="";
				MatchpubgSeason jugadors = new MatchpubgSeason();
				MatchpubgSeason jugadord = new MatchpubgSeason();
				MatchpubgSeason jugadorsq = new MatchpubgSeason();
				MatchpubgSeason jugadorsf = new MatchpubgSeason();
				MatchpubgSeason jugadordf = new MatchpubgSeason();
				MatchpubgSeason jugadorsqf = new MatchpubgSeason();

				
//				COMPRUEBA EL MODO Y EN FUNCION DE EL SACA ESTADISTICAS
				
				if(request.getParameter("modo")==null) {
					DecimalFormat df1 = new DecimalFormat("#.##");
					Integer partidas = seasonstats.getData().getAttributes().getGameModeStats().getSolo().getRoundsPlayed();
					Integer partidad = seasonstats.getData().getAttributes().getGameModeStats().getDuo().getRoundsPlayed();
					Integer partidasq = seasonstats.getData().getAttributes().getGameModeStats().getSquad().getRoundsPlayed();

					kds=(double) (seasonstats.getData().getAttributes().getGameModeStats().getSolo().getKills().doubleValue()/seasonstats.getData().getAttributes().getGameModeStats().getSolo().getLosses().doubleValue());
					kdd=(double) (seasonstats.getData().getAttributes().getGameModeStats().getDuo().getKills().doubleValue()/seasonstats.getData().getAttributes().getGameModeStats().getDuo().getLosses().doubleValue());
					kdsq=(double) (seasonstats.getData().getAttributes().getGameModeStats().getSquad().getKills().doubleValue()/seasonstats.getData().getAttributes().getGameModeStats().getSquad().getLosses().doubleValue());


					try {
						Double wins= (double) seasonstats.getData().getAttributes().getGameModeStats().getSolo().getWins()/partidas * 100;
						Double damage = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSolo().getDamageDealt()/partidas);
						Double time = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSolo().getTimeSurvived()/partidas);
						Double headshot  = (double) seasonstats.getData().getAttributes().getGameModeStats().getSolo().getHeadshotKills()/partidas * 100;
						Double top10 = 	(double) seasonstats.getData().getAttributes().getGameModeStats().getSolo().getTop10s()/partidas * 100;
						Double longestkill = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSolo().getLongestKill());

						jugadors = new MatchpubgSeason(df1.format(kds), 
								wins.toString(), 
								df1.format(damage), 
								df1.format(time), 
								df1.format(headshot), 
								df1.format(top10),
								df1.format(longestkill));
						
					}catch(ArithmeticException e) {
						Double wins= 0.0;
						Double damage =0.0;
						Double time = 0.0;
						Double headshot  = 0.0;
						Double top10 = 	0.0;
						Double longestkill = 0.0;

						jugadors = new MatchpubgSeason(df1.format(kds), 
								wins.toString(), 
								df1.format(damage), 
								df1.format(time), 
								df1.format(headshot), 
								df1.format(top10),
								df1.format(longestkill));
					}
						try {
							Double winsd= (double) seasonstats.getData().getAttributes().getGameModeStats().getDuo().getWins()/partidad *100;
							Double damaged = (double) (seasonstats.getData().getAttributes().getGameModeStats().getDuo().getDamageDealt()/partidad);
							Double timed = (double) (seasonstats.getData().getAttributes().getGameModeStats().getDuo().getTimeSurvived()/partidad);
							Double headshotd  = (double) seasonstats.getData().getAttributes().getGameModeStats().getDuo().getHeadshotKills()/partidad *100;
							Double top10d = 	(double) seasonstats.getData().getAttributes().getGameModeStats().getDuo().getTop10s()/partidad *100;
							Double longestkilld = (double) (seasonstats.getData().getAttributes().getGameModeStats().getDuo().getLongestKill());

							jugadord = new MatchpubgSeason(df1.format(kdd), 
									winsd.toString(), 
									df1.format(damaged), 
									df1.format(timed), 
									df1.format(headshotd), 
									df1.format(top10d),
									df1.format(longestkilld));
						}catch(ArithmeticException e) {
							Double winsd= 0.0;
							Double damaged = 0.0;
							Double timed =0.0;
							Double headshotd  =0.0;
							Double top10d = 	0.0;
							Double longestkilld = 0.0;
	
							jugadord = new MatchpubgSeason(df1.format(kdd), 
									winsd.toString(), 
									df1.format(damaged), 
									df1.format(timed), 
									df1.format(headshotd), 
									df1.format(top10d),
									df1.format(longestkilld));
						}
						
						try {
							Double winssq= (double) seasonstats.getData().getAttributes().getGameModeStats().getSquad().getWins()/partidasq * 100;
							Double damagesq = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSquad().getDamageDealt()/partidasq);
							Double timesq = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSquad().getTimeSurvived()/partidasq);
							Double headshotsq = (double) seasonstats.getData().getAttributes().getGameModeStats().getSquad().getHeadshotKills()/partidasq * 100;
							Double top10sq = 	(double) seasonstats.getData().getAttributes().getGameModeStats().getSquad().getTop10s()/partidasq * 100;
							Double longestkillsq = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSquad().getLongestKill());

							 jugadorsq = new MatchpubgSeason(df1.format(kdsq), 
									df1.format(winssq), 
									df1.format(damagesq), 
									df1.format(timesq), 
									df1.format(headshotsq), 
									df1.format(top10sq),
									df1.format(longestkillsq));
						}catch(ArithmeticException e) {
							Double winssq= 0.0;
							Double damagesq = 0.0;
							Double timesq = 0.0;
							Double headshotsq = 0.0;
							Double top10sq = 	0.0;
							Double longestkillsq = 0.0;
	
							 jugadorsq = new MatchpubgSeason(df1.format(kdsq), 
									df1.format(winssq), 
									df1.format(damagesq), 
									df1.format(timesq), 
									df1.format(headshotsq), 
									df1.format(top10sq),
									df1.format(longestkillsq));
						}
						
					
					modoJSP = "tpp";
				}else {
					if(request.getParameter("modo").equals("tpp")){
						DecimalFormat df1 = new DecimalFormat("#.##");
						Integer partidas = seasonstats.getData().getAttributes().getGameModeStats().getSolo().getRoundsPlayed();
						Integer partidad = seasonstats.getData().getAttributes().getGameModeStats().getDuo().getRoundsPlayed();
						Integer partidasq = seasonstats.getData().getAttributes().getGameModeStats().getSquad().getRoundsPlayed();

						kds=(double) (seasonstats.getData().getAttributes().getGameModeStats().getSolo().getKills().doubleValue()/seasonstats.getData().getAttributes().getGameModeStats().getSolo().getLosses().doubleValue());
						kdd=(double) (seasonstats.getData().getAttributes().getGameModeStats().getDuo().getKills().doubleValue()/seasonstats.getData().getAttributes().getGameModeStats().getDuo().getLosses().doubleValue());
						kdsq=(double) (seasonstats.getData().getAttributes().getGameModeStats().getSquad().getKills().doubleValue()/seasonstats.getData().getAttributes().getGameModeStats().getSquad().getLosses().doubleValue());

						try {
							Double wins= (double) seasonstats.getData().getAttributes().getGameModeStats().getSolo().getWins()/partidas * 100;
							Double damage = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSolo().getDamageDealt()/partidas);
							Double time = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSolo().getTimeSurvived()/partidas);
							Double headshot  = (double) seasonstats.getData().getAttributes().getGameModeStats().getSolo().getHeadshotKills()/partidas * 100;
							Double top10 = 	(double) seasonstats.getData().getAttributes().getGameModeStats().getSolo().getTop10s()/partidas * 100;
							Double longestkill = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSolo().getLongestKill());

							jugadors = new MatchpubgSeason(df1.format(kds), 
									wins.toString(), 
									df1.format(damage), 
									df1.format(time), 
									df1.format(headshot), 
									df1.format(top10),
									df1.format(longestkill));
							
						}catch(ArithmeticException e) {
							Double wins= 0.0;
							Double damage =0.0;
							Double time = 0.0;
							Double headshot  = 0.0;
							Double top10 = 	0.0;
							Double longestkill = 0.0;

							jugadors = new MatchpubgSeason(df1.format(kds), 
									wins.toString(), 
									df1.format(damage), 
									df1.format(time), 
									df1.format(headshot), 
									df1.format(top10),
									df1.format(longestkill));
						}
							try {
								Double winsd= (double) seasonstats.getData().getAttributes().getGameModeStats().getDuo().getWins()/partidad *100;
								Double damaged = (double) (seasonstats.getData().getAttributes().getGameModeStats().getDuo().getDamageDealt()/partidad);
								Double timed = (double) (seasonstats.getData().getAttributes().getGameModeStats().getDuo().getTimeSurvived()/partidad);
								Double headshotd  = (double) seasonstats.getData().getAttributes().getGameModeStats().getDuo().getHeadshotKills()/partidad *100;
								Double top10d = 	(double) seasonstats.getData().getAttributes().getGameModeStats().getDuo().getTop10s()/partidad *100;
								Double longestkilld = (double) (seasonstats.getData().getAttributes().getGameModeStats().getDuo().getLongestKill());

								jugadord = new MatchpubgSeason(df1.format(kdd), 
										winsd.toString(), 
										df1.format(damaged), 
										df1.format(timed), 
										df1.format(headshotd), 
										df1.format(top10d),
										df1.format(longestkilld));
							}catch(ArithmeticException e) {
								Double winsd= 0.0;
								Double damaged = 0.0;
								Double timed =0.0;
								Double headshotd  =0.0;
								Double top10d = 	0.0;
								Double longestkilld = 0.0;
		
								jugadord = new MatchpubgSeason(df1.format(kdd), 
										winsd.toString(), 
										df1.format(damaged), 
										df1.format(timed), 
										df1.format(headshotd), 
										df1.format(top10d),
										df1.format(longestkilld));
							}
							
							try {
								Double winssq= (double) seasonstats.getData().getAttributes().getGameModeStats().getSquad().getWins()/partidasq * 100;
								Double damagesq = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSquad().getDamageDealt()/partidasq);
								Double timesq = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSquad().getTimeSurvived()/partidasq);
								Double headshotsq = (double) seasonstats.getData().getAttributes().getGameModeStats().getSquad().getHeadshotKills()/partidasq * 100;
								Double top10sq = 	(double) seasonstats.getData().getAttributes().getGameModeStats().getSquad().getTop10s()/partidasq * 100;
								Double longestkillsq = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSquad().getLongestKill());

								 jugadorsq = new MatchpubgSeason(df1.format(kdsq), 
										df1.format(winssq), 
										df1.format(damagesq), 
										df1.format(timesq), 
										df1.format(headshotsq), 
										df1.format(top10sq),
										df1.format(longestkillsq));
							}catch(ArithmeticException e) {
								Double winssq= 0.0;
								Double damagesq = 0.0;
								Double timesq = 0.0;
								Double headshotsq = 0.0;
								Double top10sq = 	0.0;
								Double longestkillsq = 0.0;
		
								 jugadorsq = new MatchpubgSeason(df1.format(kdsq), 
										df1.format(winssq), 
										df1.format(damagesq), 
										df1.format(timesq), 
										df1.format(headshotsq), 
										df1.format(top10sq),
										df1.format(longestkillsq));
							}
						
						modoJSP = "tpp";
					}else if(request.getParameter("modo").equals("fpp")){
						DecimalFormat df1 = new DecimalFormat("#.##");
						Integer partidas = seasonstats.getData().getAttributes().getGameModeStats().getSoloFpp().getRoundsPlayed();
						Integer partidad = seasonstats.getData().getAttributes().getGameModeStats().getDuoFpp().getRoundsPlayed();
						Integer partidasq = seasonstats.getData().getAttributes().getGameModeStats().getSquadFpp().getRoundsPlayed();

						kds=(double) (seasonstats.getData().getAttributes().getGameModeStats().getSoloFpp().getKills().doubleValue()/seasonstats.getData().getAttributes().getGameModeStats().getSoloFpp().getLosses().doubleValue());
						kdd=(double) (seasonstats.getData().getAttributes().getGameModeStats().getDuoFpp().getKills().doubleValue()/seasonstats.getData().getAttributes().getGameModeStats().getDuoFpp().getLosses().doubleValue());
						kdsq=(double) (seasonstats.getData().getAttributes().getGameModeStats().getSquadFpp().getKills().doubleValue()/seasonstats.getData().getAttributes().getGameModeStats().getSquadFpp().getLosses().doubleValue());

						try {
							Double wins= (double) seasonstats.getData().getAttributes().getGameModeStats().getSoloFpp().getWins()/partidas * 100;
							Double damage = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSoloFpp().getDamageDealt()/partidas);
							Double time = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSoloFpp().getTimeSurvived()/partidas);
							Double headshot  = (double) seasonstats.getData().getAttributes().getGameModeStats().getSoloFpp().getHeadshotKills()/partidas * 100;
							Double top10 = 	(double) seasonstats.getData().getAttributes().getGameModeStats().getSoloFpp().getTop10s()/partidas * 100;
							Double longestkill = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSoloFpp().getLongestKill());

							jugadorsf = new MatchpubgSeason(df1.format(kds), 
									wins.toString(), 
									df1.format(damage), 
									df1.format(time), 
									df1.format(headshot), 
									df1.format(top10),
									df1.format(longestkill));
							
						}catch(ArithmeticException e) {
							Double wins= 0.0;
							Double damage =0.0;
							Double time = 0.0;
							Double headshot  = 0.0;
							Double top10 = 	0.0;
							Double longestkill = 0.0;

							jugadorsf = new MatchpubgSeason(df1.format(kds), 
									wins.toString(), 
									df1.format(damage), 
									df1.format(time), 
									df1.format(headshot), 
									df1.format(top10),
									df1.format(longestkill));
						}
							try {
								Double winsd= (double) seasonstats.getData().getAttributes().getGameModeStats().getDuoFpp().getWins()/partidad *100;
								Double damaged = (double) (seasonstats.getData().getAttributes().getGameModeStats().getDuoFpp().getDamageDealt()/partidad);
								Double timed = (double) (seasonstats.getData().getAttributes().getGameModeStats().getDuoFpp().getTimeSurvived()/partidad);
								Double headshotd  = (double) seasonstats.getData().getAttributes().getGameModeStats().getDuoFpp().getHeadshotKills()/partidad *100;
								Double top10d = 	(double) seasonstats.getData().getAttributes().getGameModeStats().getDuoFpp().getTop10s()/partidad *100;
								Double longestkilld = (double) (seasonstats.getData().getAttributes().getGameModeStats().getDuoFpp().getLongestKill());

								jugadordf = new MatchpubgSeason(df1.format(kdd), 
										winsd.toString(), 
										df1.format(damaged), 
										df1.format(timed), 
										df1.format(headshotd), 
										df1.format(top10d),
										df1.format(longestkilld));
							}catch(ArithmeticException e) {
								Double winsd= 0.0;
								Double damaged = 0.0;
								Double timed =0.0;
								Double headshotd  =0.0;
								Double top10d = 	0.0;
								Double longestkilld = 0.0;
		
								jugadordf = new MatchpubgSeason(df1.format(kdd), 
										winsd.toString(), 
										df1.format(damaged), 
										df1.format(timed), 
										df1.format(headshotd), 
										df1.format(top10d),
										df1.format(longestkilld));
							}
							
							try {
								Double winssq= (double) seasonstats.getData().getAttributes().getGameModeStats().getSquadFpp().getWins()/partidasq * 100;
								Double damagesq = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSquadFpp().getDamageDealt()/partidasq);
								Double timesq = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSquadFpp().getTimeSurvived()/partidasq);
								Double headshotsq = (double) seasonstats.getData().getAttributes().getGameModeStats().getSquadFpp().getHeadshotKills()/partidasq * 100;
								Double top10sq = 	(double) seasonstats.getData().getAttributes().getGameModeStats().getSquadFpp().getTop10s()/partidasq * 100;
								Double longestkillsq = (double) (seasonstats.getData().getAttributes().getGameModeStats().getSquadFpp().getLongestKill());

								 jugadorsqf = new MatchpubgSeason(df1.format(kdsq), 
										df1.format(winssq), 
										df1.format(damagesq), 
										df1.format(timesq), 
										df1.format(headshotsq), 
										df1.format(top10sq),
										df1.format(longestkillsq));
							}catch(ArithmeticException e) {
								Double winssq= 0.0;
								Double damagesq = 0.0;
								Double timesq = 0.0;
								Double headshotsq = 0.0;
								Double top10sq = 	0.0;
								Double longestkillsq = 0.0;
		
								 jugadorsqf = new MatchpubgSeason(df1.format(kdsq), 
										df1.format(winssq), 
										df1.format(damagesq), 
										df1.format(timesq), 
										df1.format(headshotsq), 
										df1.format(top10sq),
										df1.format(longestkillsq));
							}
						
						
						modoJSP = "fpp";
					}else {
					}
				}

				
//					LIFETIME STATS API
				
				ObjectMapper objectMapper3 = new ObjectMapper();
				objectMapper3.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				doTrustToCertificates();
				URL url3 = new URL("https://api.pubg.com/shards/steam/players/"+id+"/seasons/lifetime");
				HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();
				conn3.setRequestMethod("GET");
				conn3.setRequestProperty("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiMDNhZWE2MC0zNmNlLTAxMzgtYmJjOS0zNzRkM2UxZGEzNjYiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTgyMjg2MDA0LCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InNlcmdpb3JvamFzamltIn0.dFS0GuKAPpTrOEChROMqc3APivDw-NDbwAhDpK4WMT8");
				conn3.setRequestProperty("Accept", "application/vnd.api+json");
				LifeStats lifestats = objectMapper3.readValue(conn3.getInputStream(),LifeStats.class);
				
//				KILLS TOTALES DE TU VIDA
				Integer killsLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getKills()+
				lifestats.getData().getAttributes().getGameModeStats().getDuo().getKills()+
				lifestats.getData().getAttributes().getGameModeStats().getSquad().getKills()+
				lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getKills()+
				lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getKills()+
				lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getKills();
			
				List<Double> longestKillLS = new ArrayList<Double>();
				
//				KILL MAS LEJANA 
				longestKillLS.add(lifestats.getData().getAttributes().getGameModeStats().getSolo().getLongestKill());
				longestKillLS.add(lifestats.getData().getAttributes().getGameModeStats().getDuo().getLongestKill());
				longestKillLS.add(lifestats.getData().getAttributes().getGameModeStats().getSquad().getLongestKill());
				longestKillLS.add(lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getLongestKill());
				longestKillLS.add(lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getLongestKill());
				longestKillLS.add(lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getLongestKill());
				Double maxlongestKillLS=0.0;
				for(int i=0;i<longestKillLS.size();i++) {
					if(maxlongestKillLS<longestKillLS.get(i)) {
						maxlongestKillLS=longestKillLS.get(i);
					}
				}
				
//				KILLS CARRETERA 
				Integer roadKillsLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getRoadKills()+
				lifestats.getData().getAttributes().getGameModeStats().getDuo().getRoadKills()+
				lifestats.getData().getAttributes().getGameModeStats().getSquad().getRoadKills()+
				lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getRoadKills()+
				lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getRoadKills()+
				lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getRoadKills();
				
				
//				ARMAS RECOGIDAS
				Integer armasLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getWeaponsAcquired()+
						lifestats.getData().getAttributes().getGameModeStats().getDuo().getWeaponsAcquired()+
						lifestats.getData().getAttributes().getGameModeStats().getSquad().getWeaponsAcquired()+
						lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getWeaponsAcquired()+
						lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getWeaponsAcquired()+
						lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getWeaponsAcquired();
				
//				TIEMPO TOTAL SOBREVIVIDO
				Double timeSurvivedLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getTimeSurvived()+
						lifestats.getData().getAttributes().getGameModeStats().getDuo().getTimeSurvived()+
						lifestats.getData().getAttributes().getGameModeStats().getSquad().getTimeSurvived()+
						lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getTimeSurvived()+
						lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getTimeSurvived()+
						lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getTimeSurvived();
				
//				DAÑO TOTAL HECHO
				Double dmgDealtLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getDamageDealt()+
						lifestats.getData().getAttributes().getGameModeStats().getDuo().getDamageDealt()+
						lifestats.getData().getAttributes().getGameModeStats().getSquad().getDamageDealt()+
						lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getDamageDealt()+
						lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getDamageDealt()+
						lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getDamageDealt();
				
//				VEHICULOS DESTRUIDOS
				Integer vehiculosDestruidosLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getVehicleDestroys()+
						lifestats.getData().getAttributes().getGameModeStats().getDuo().getVehicleDestroys()+
						lifestats.getData().getAttributes().getGameModeStats().getSquad().getVehicleDestroys()+
						lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getVehicleDestroys()+
						lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getVehicleDestroys()+
						lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getVehicleDestroys();
				
//				SUICIDIOS
				Integer suicidiosLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getSuicides()+
						lifestats.getData().getAttributes().getGameModeStats().getDuo().getSuicides()+
						lifestats.getData().getAttributes().getGameModeStats().getSquad().getSuicides()+
						lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getSuicides()+
						lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getSuicides()+
						lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getSuicides();
				
				MatchPubgLifeStats jugadorLS = new MatchPubgLifeStats(killsLS, maxlongestKillLS, roadKillsLS, armasLS, timeSurvivedLS, dmgDealtLS, vehiculosDestruidosLS, suicidiosLS);
				
				
				request.setAttribute("jugadorLS", jugadorLS);
				request.setAttribute("jugadors", jugadors);
				request.setAttribute("jugadord", jugadord);
				request.setAttribute("jugadorsq", jugadorsq);
				request.setAttribute("jugadorsf", jugadorsf);
				request.setAttribute("jugadordf", jugadordf);
				request.setAttribute("jugadorsqf", jugadorsqf);

				DecimalFormat df2 = new DecimalFormat("#.##");
				request.setAttribute("compis", compis);
				request.setAttribute("modoJSP", modoJSP);
				request.setAttribute("seasonJSP", seasonJSP);
				request.setAttribute("kds", df2.format(kds));
				request.setAttribute("kdd", df2.format(kdd));
				request.setAttribute("kdsq", df2.format(kdsq));
				request.setAttribute("kdsf", df2.format(kdsf));
				request.setAttribute("kddf", df2.format(kddf));
				request.setAttribute("kdsqf", df2.format(kdsqf));

				request.setAttribute("lista", lista);
				request.getRequestDispatcher("/pruebapubg.jsp").forward(request, response);


			} catch (Exception e) {
				e.printStackTrace();
			}
			
			

			
		 
		

	}

	
	
	@SuppressWarnings("deprecation")
	public void doTrustToCertificates() throws Exception {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                }
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }
	 @SuppressWarnings("unchecked")
	  public void addHeader(ClientResource cr, String headerName, String headerValue) {
	    Series<Header> headers = (Series<Header>) cr.getRequest().getAttributes()
	        .get(HeaderConstants.ATTRIBUTE_HEADERS);

	    if (headers == null) {
	      headers = new Series<Header>(Header.class);
	     cr.getRequest().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
	    }
		headers.add(headerName, headerValue);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

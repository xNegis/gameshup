package aiss;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.github.mautini.pubgjava.MatchResponseUtils;
//import com.github.mautini.pubgjava.PlayerUtils;
//import com.github.mautini.pubgjava.SeasonUtils;
//import com.github.mautini.pubgjava.api.PubgClient;
//import com.github.mautini.pubgjava.exception.PubgClientException;
//import com.github.mautini.pubgjava.model.Platform;
//import com.github.mautini.pubgjava.model.PlatformRegion;
//import com.github.mautini.pubgjava.model.generic.response.ResponseDataHolder;
//import com.github.mautini.pubgjava.model.participant.Participant;
//import com.github.mautini.pubgjava.model.participant.ParticipantStats;
//import com.github.mautini.pubgjava.model.player.Player;
//import com.github.mautini.pubgjava.model.playerseason.PlayerSeason;
//import com.github.mautini.pubgjava.model.season.Season;

/**
 * Servlet implementation class pubg
 */
public class pubgcopia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pubgcopia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 PubgClient s = new PubgClient();
//		 Player p;
//		 String user = request.getParameter("name");
//		 String pla = request.getParameter("plataformap");
//		 String regi = request.getParameter("regionp");
//		 PlatformRegion r = null ;
//		 Platform pl = Platform.valueOf(request.getParameter("plataformap"));
//		 if(request.getParameter("plataformap").equals("STEAM")) {
//			 r = PlatformRegion.valueOf("PC_"+request.getParameter("regionp"));
//		 } else if(request.getParameter("plataformap").equals("XBOX")) {
//			 r = PlatformRegion.valueOf("XBOX_"+request.getParameter("regionp"));
//
//		 } else {
//			 
//
//		 }
//		
//		try {
//			ParticipantStats a = null;
//			p = s.getPlayersByNames(pl, request.getParameter("name")).getData().get(0);
//			List<String> part = PlayerUtils.getMatchsIds(p);
//			response.setContentType("text/html");
//		    PrintWriter out = response.getWriter();
//			List<Mathpubg> resp = new ArrayList<Mathpubg>();
//
//			//List<Season> seasonList = s.getSeasons(r).getData();
//			//Season currentSeason = SeasonUtils.getCurrentSeason(seasonList);
//			//ResponseDataHolder<PlayerSeason> playerSeason = s.getPlayerSeason(Platform.valueOf(request.getParameter("plataformap")), p.getId(),currentSeason.getId());
//		     out.println("<strong>Jugador: </strong>" + request.getParameter("name") + "<br>");
//		      
//		       for(int i=0;i<=5;i++) {
//				List<Participant> participantes = MatchResponseUtils.getParticipants(s.getMatch(r, part.get(i)));
//				for(int j=0;i<participantes.size();j++) {
//					  if(request.getParameter("name").equals(participantes.get(j).getParticipantAttributes().getParticipantStats().getName())) {
//						  a = participantes.get(j).getParticipantAttributes().getParticipantStats();
//						  break;
//					  }
//					  
//		       }
//				
//				
//				Mathpubg mm = new Mathpubg(a.getDamageDealt(), a.getKills(), a.getWinPlace(), a.getLongestKill(), a.getWalkDistance(), a.getHeadshotKills());
//				resp.add(mm);
//		    }
//		       request.setAttribute("nombre", user);
//
//		       request.setAttribute("respuesta", resp);
//				request.getRequestDispatcher("/muestrapubg.jsp").forward(request, response);
//		}catch (PubgClientException e) {
//			
//			String mensaje = "<div id=\"errorp\" class=\"w-50 alert alert-danger\" role=\"alert\">\r\n" + 
//					"  EL USUARIO INTRODUCIDO NO EXISTE\r\n" + 
//					"</div>";
//			request.setAttribute("mensaje", mensaje);
//			request.setAttribute("user", user);
//			request.setAttribute("pla", pla);
//			request.setAttribute("region", regi);
//			request.getRequestDispatcher("/pubgbusqueda.jsp").forward(request, response);
//			
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

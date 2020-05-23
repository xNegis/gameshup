package aiss.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.pubgLifeTimeResource;
import aiss.model.resource.pubgMatchResource;
import aiss.model.resource.pubgPlayerResource;
import model.auxiliary.MatchPubgLifeStats;
import model.auxiliary.Matchpubg;
import pubfLifeStats.LifeStats;
import pubgmatch.Datum__;
import pubgmatch.Included;
import pubgmatch.Participants;
import pubgmatch.Stats;
import pubgplayer.PlayerPubg;

/**
 * Servlet implementation class pubggcontroller
 */
public class pubggcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pubggcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String plataforma= request.getParameter("plataformap"); //Datos del form
		
		pubgPlayerResource playerres = new pubgPlayerResource();//Obtengo el jugador que busco
		PlayerPubg player = playerres.getPlayerPubg(name, plataforma);
		String id =  player.getData().get(0).getId();
		List<String> idmatches = new ArrayList<String>();
		
		for(int i=0;i<9;i++) {  //obtengo los id de los partidos
			idmatches.add(player.getData().get(0).getRelationships().getMatches().getData().get(i).getId());
		}
		  
		List<Matchpubg> lista = new ArrayList<Matchpubg>();
		List<List<Matchpubg>> compis = new ArrayList<List<Matchpubg>>();
		
		for(int j=0;j<idmatches.size();j++) {
			List<String> idpla2 = new ArrayList<String>();
			String idpla="";

			pubgMatchResource matchresource = new pubgMatchResource();//obtengo stats de cada partido
			pubgmatch.PubgMatch match = matchresource.getMatchPubg(idmatches.get(j), plataforma);
			String gamemode="";
			 
//			SACAR STATS JUGADOR EN ESE PARTIDO
			
			for(int i=0;i<match.getIncluded().size();i++) {
				 
				if(match.getIncluded().get(i).getType().equals("participant")) {
					if(match.getIncluded().get(i).getAttributes().getStats().getName().equals(request.getParameter("name") )) {
					Stats stats = match.getIncluded().get(i).getAttributes().getStats();
					idpla = match.getIncluded().get(i).getId();
					
					Matchpubg jugador = new Matchpubg(
							match.getData().getAttributes().getMapName(),
							stats.getName(), 
							stats.getKills(), 
							stats.getDamageDealt(), 
							stats.getWinPlace(),
							match.getData().getAttributes().getGameMode(),
							stats.getHeadshotKills(),
							stats.getWalkDistance(),
							stats.getLongestKill());
							gamemode = 	match.getData().getAttributes().getGameMode();

					
					lista.add(jugador);
				}
				}
			}
			
			
//			SACAR COMPIS EN ESE PARTIDO
			
			for(int i=0;i<match.getIncluded().size();i++) {
				int tamequipo=0;
				if(gamemode.equals("duo") || gamemode.equals("duo-fpp")) {
					tamequipo=1;
				}else if(gamemode.equals("squad") || gamemode.equals("squad-fpp")){
					tamequipo=2;
				}
				
//				SACAMOS COMPAÑEROS DEL JUGADOR PASADO COMO PARAMETRO 
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
			
			

//			COGEMOS LAS STATS DEL COMPI
			List<Matchpubg> compis2 = new ArrayList<Matchpubg>();
			for(int i=0;i<match.getIncluded().size();i++) {
				if(match.getIncluded().get(i).getType().equals("participant")) {	
				for(int z=0;z<idpla2.size();z++){
					if(match.getIncluded().get(i).getId().equals(idpla2.get(z))){
						Stats stats = match.getIncluded().get(i).getAttributes().getStats();
						Matchpubg jugador2 = new Matchpubg(
								match.getData().getAttributes().getMapName(),
								stats.getName(), 
								stats.getKills(), 
								stats.getDamageDealt(), 
								stats.getWinPlace(),
								match.getData().getAttributes().getGameMode(),
								stats.getHeadshotKills(),
								stats.getWalkDistance(),
								stats.getLongestKill());

						
						compis2.add(jugador2);
					}//compruebo si la idpla(z) igual al id include i
				}//Recorro lista idpla2
				if(match.getIncluded().get(i).getId().equals(idpla) ) {
					if(compis2.isEmpty() && i==match.getIncluded().size()) {
						Matchpubg jugador2 = new Matchpubg(
								"Null",
								"No hay jugador", 
								0, 
								0.0, 
								0,
								match.getData().getAttributes().getGameMode(),
								0,
								0.0,
								0);
						compis2.add(jugador2);
					}
					compis.add(compis2);
				}
				
				}//compruebo si es participante
			} //fin include i partido

			
				
			}
											
		
		
		pubgLifeTimeResource lifetimeresource = new pubgLifeTimeResource(); //Obtengo las estadisticas de vida del player
		LifeStats lifestats = lifetimeresource.getLifeTimePubg(id, plataforma);
		
//		KILLS TOTALES DE TU VIDA
		Integer killsLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getKills()+
		lifestats.getData().getAttributes().getGameModeStats().getDuo().getKills()+
		lifestats.getData().getAttributes().getGameModeStats().getSquad().getKills()+
		lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getKills()+
		lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getKills()+
		lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getKills();
	
		List<Double> longestKillLS = new ArrayList<Double>();
		
//		KILL MAS LEJANA 
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
		
//		KILLS CARRETERA 
		Integer roadKillsLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getRoadKills()+
		lifestats.getData().getAttributes().getGameModeStats().getDuo().getRoadKills()+
		lifestats.getData().getAttributes().getGameModeStats().getSquad().getRoadKills()+
		lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getRoadKills()+
		lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getRoadKills()+
		lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getRoadKills();
		
		
//		ARMAS RECOGIDAS
		Integer armasLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getWeaponsAcquired()+
				lifestats.getData().getAttributes().getGameModeStats().getDuo().getWeaponsAcquired()+
				lifestats.getData().getAttributes().getGameModeStats().getSquad().getWeaponsAcquired()+
				lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getWeaponsAcquired()+
				lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getWeaponsAcquired()+
				lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getWeaponsAcquired();
		
//		TIEMPO TOTAL SOBREVIVIDO
		Double timeSurvivedLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getTimeSurvived()+
				lifestats.getData().getAttributes().getGameModeStats().getDuo().getTimeSurvived()+
				lifestats.getData().getAttributes().getGameModeStats().getSquad().getTimeSurvived()+
				lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getTimeSurvived()+
				lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getTimeSurvived()+
				lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getTimeSurvived();
		
//		DAÑO TOTAL HECHO
		Double dmgDealtLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getDamageDealt()+
				lifestats.getData().getAttributes().getGameModeStats().getDuo().getDamageDealt()+
				lifestats.getData().getAttributes().getGameModeStats().getSquad().getDamageDealt()+
				lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getDamageDealt()+
				lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getDamageDealt()+
				lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getDamageDealt();
		
//		VEHICULOS DESTRUIDOS
		Integer vehiculosDestruidosLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getVehicleDestroys()+
				lifestats.getData().getAttributes().getGameModeStats().getDuo().getVehicleDestroys()+
				lifestats.getData().getAttributes().getGameModeStats().getSquad().getVehicleDestroys()+
				lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getVehicleDestroys()+
				lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getVehicleDestroys()+
				lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getVehicleDestroys();
		
//		SUICIDIOS
		Integer suicidiosLS = lifestats.getData().getAttributes().getGameModeStats().getSolo().getSuicides()+
				lifestats.getData().getAttributes().getGameModeStats().getDuo().getSuicides()+
				lifestats.getData().getAttributes().getGameModeStats().getSquad().getSuicides()+
		 		lifestats.getData().getAttributes().getGameModeStats().getSoloFpp().getSuicides()+
				lifestats.getData().getAttributes().getGameModeStats().getDuoFpp().getSuicides()+
				lifestats.getData().getAttributes().getGameModeStats().getSquadFpp().getSuicides();
		
		MatchPubgLifeStats jugadorLS = new MatchPubgLifeStats(killsLS, maxlongestKillLS, roadKillsLS, armasLS, timeSurvivedLS, dmgDealtLS, vehiculosDestruidosLS, suicidiosLS);
		request.setAttribute("plataformap", plataforma);
		request.setAttribute("nombre", request.getParameter("name"));
		request.setAttribute("jugadorLS", jugadorLS);
	

		DecimalFormat df2 = new DecimalFormat("#.##");
		request.setAttribute("compis", compis);
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("/muestrapubg.jsp").forward(request, response);


	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

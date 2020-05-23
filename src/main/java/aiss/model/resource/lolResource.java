package aiss.model.resource;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import lolmatch.Match;
import lolmatchsxid.PlayerMatchs;
import lolplayer.Player;
import model.auxiliary.MatchLoL2;;

public class lolResource {
	private static final String LOL_API_KEY = "RGAPI-68413756-87fb-475e-9ba2-8773bb3d5840";  
	private static final Logger log = Logger.getLogger(MatchLoL2.class.getName());

	public Player getPlayer(String region,String name){
		String uri3 = "https://"+region+".api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name + "?api_key="+ LOL_API_KEY;
		ClientResource cr3 = new ClientResource(uri3);
		Player player = cr3.get(Player.class);
		return player;
	}

	public List<lolmatchsxid.Match> getPartidas(String region,String accountid){
		String uri2 = "https://"+region+".api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountid + "?api_key="+ LOL_API_KEY;
		ClientResource cr2 = new ClientResource(uri2);
		PlayerMatchs mm = cr2.get(PlayerMatchs.class);
		List<lolmatchsxid.Match> matches = mm.getMatches();
		return matches;
	}

	public Match getPartida(Long gameId,String region) {
		String uri = "https://"+region+".api.riotgames.com/lol/match/v4/matches/" + gameId.toString() + "?api_key="
				+ LOL_API_KEY;
		ClientResource cr = new ClientResource(uri);
		Match pp = cr.get(Match.class);
		return pp;
	}
}

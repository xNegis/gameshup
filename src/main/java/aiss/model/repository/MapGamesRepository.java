package aiss.model.repository;

import java.util.Collection;


import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.ls.LSOutput;

import aiss.modelapi.LolPlayer;
import aiss.modelapi.MatchLoL;
import aiss.modelapi.Matchpubg;
import aiss.modelapi.PubgPlayer;


public class MapGamesRepository implements GamesRepository{

	Map<String, MatchLoL> MatchLolMap;
	Map<String, Matchpubg> MatchPubgMap;
	Map<String, PubgPlayer> PubgPlayerMap;
	Map<String, LolPlayer> LolPlayerMap;
	private static MapGamesRepository instance=null;
	private int index=0;			// Index to create playlists and songs' identifiers.
	
	
	public static MapGamesRepository getInstance() {
		
		if (instance==null) {
			instance = new MapGamesRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		MatchLolMap = new HashMap<String,MatchLoL>();
		MatchPubgMap = new HashMap<String,Matchpubg>();
		PubgPlayerMap = new HashMap<String,PubgPlayer>();
		LolPlayerMap = new HashMap<String,LolPlayer>();
		
		// Create lolplayers
		LolPlayer lolplayer1=new LolPlayer();
		lolplayer1.setNombre("Susurravientos");
		lolplayer1.setEmail("susurravientos@gmail.com");
		lolplayer1.setnivel(67);
		addLolPlayer(lolplayer1);
		
		LolPlayer lolplayer2=new LolPlayer();
		lolplayer2.setNombre("xNegis");
		lolplayer2.setEmail("xNegis@gmail.com");
		lolplayer2.setnivel(45);
		addLolPlayer(lolplayer2);
		
		LolPlayer lolplayer3=new LolPlayer();
		lolplayer3.setNombre("MigueSnow");
		lolplayer3.setEmail("MigueSnow@gmail.com");
		lolplayer3.setnivel(80);
		addLolPlayer(lolplayer3);
		
		// Create pubgplayers
		PubgPlayer pubgplayer1=new PubgPlayer();
		pubgplayer1.setNombre("Sergiolo");
		pubgplayer1.setEmail("Sergiolo@gmail.com");
		pubgplayer1.setPlataforma("Steam");
		addPubgPlayer(pubgplayer1);
		
		PubgPlayer pubgplayer2=new PubgPlayer();
		pubgplayer2.setNombre("Campuzano");
		pubgplayer2.setEmail("Campuzano@gmail.com");
		pubgplayer2.setPlataforma("XBOX");
		addPubgPlayer(pubgplayer2);
		
		PubgPlayer pubgplayer3=new PubgPlayer();
		pubgplayer3.setNombre("Alvaricoco");
		pubgplayer3.setEmail("Alvaricoco@gmail.com");
		pubgplayer3.setPlataforma("PS4");
		addPubgPlayer(pubgplayer3);
		
		
		
		// Create LolMatchs
		MatchLoL matchlol1=new MatchLoL();
		matchlol1.setPlayer(lolplayer2);
		matchlol1.setName("partida1");
		matchlol1.setChampion("Ashe");
		matchlol1.setDeaths(14);
		matchlol1.setAssists(12);
		matchlol1.setGold(25000);
		matchlol1.setKills(24);
		matchlol1.setMdmg(0);
		matchlol1.setMinions(140);
		matchlol1.setPdmg(24000);
		matchlol1.setTdmg(30000);
		matchlol1.setWin(true);
		addLolMatch(matchlol1);
		
		MatchLoL matchlol2=new MatchLoL();
		matchlol2.setPlayer(lolplayer2);
		matchlol2.setName("partida2");
		matchlol2.setChampion("Annie");
		matchlol2.setDeaths(20);
		matchlol2.setAssists(4);
		matchlol2.setGold(15000);
		matchlol2.setKills(10);
		matchlol2.setMdmg(14000);
		matchlol2.setMinions(120);
		matchlol2.setPdmg(200);
		matchlol2.setTdmg(15000);
		matchlol2.setWin(false);
		addLolMatch(matchlol2);
		
		MatchLoL matchlol3=new MatchLoL();
		matchlol3.setPlayer(lolplayer3);
		matchlol3.setName("partida3");
		matchlol3.setChampion("MastesYi");
		matchlol3.setDeaths(13);
		matchlol3.setAssists(10);
		matchlol3.setGold(24000);
		matchlol3.setKills(15);
		matchlol3.setMdmg(1000);
		matchlol3.setMinions(150);
		matchlol3.setPdmg(18000);
		matchlol3.setTdmg(20000);
		matchlol3.setWin(true);
		addLolMatch(matchlol3);
		
	
		
		// Create LolMatchs
		Matchpubg matchpubg1 = new Matchpubg();
		matchpubg1.setPlayer(pubgplayer1);
		matchpubg1.setDamage(550.);
		matchpubg1.setHeadshotskill(3);
		matchpubg1.setKills(5);
		matchpubg1.setLongestkill(250);
		matchpubg1.setMapa("Erangel");
		matchpubg1.setWalkdistance(2500.);
		matchpubg1.setWinplace(2);
		addPubgMatch(matchpubg1);
		
		Matchpubg matchpubg2 = new Matchpubg();
		matchpubg2.setPlayer(pubgplayer1);
		matchpubg2.setDamage(250.);
		matchpubg2.setHeadshotskill(0);
		matchpubg2.setKills(3);
		matchpubg2.setLongestkill(13);
		matchpubg2.setMapa("Erangel");
		matchpubg2.setWalkdistance(1200.);
		matchpubg2.setWinplace(34);
		addPubgMatch(matchpubg2);
		
		Matchpubg matchpubg3 = new Matchpubg();
		matchpubg3.setPlayer(pubgplayer2);
		matchpubg3.setDamage(150.);
		matchpubg3.setHeadshotskill(1);
		matchpubg3.setKills(2);
		matchpubg3.setLongestkill(132);
		matchpubg3.setMapa("Miramar");
		matchpubg3.setWalkdistance(3500.);
		matchpubg3.setWinplace(24);
		addPubgMatch(matchpubg3);
	}
	
	// Matchs related operations
	@Override
	public void addPubgMatch(Matchpubg p) {
		String id = "p" + index++;	
		p.setId(id);
		MatchPubgMap.put(id,p);
	}
	@Override
	public void addLolMatch(MatchLoL p) {
		String id = "p" + index++;	
		p.setId(id);
		MatchLolMap.put(id,p);
	}
	
	@Override
	public Collection<Matchpubg> getAllPubgMatch() {
			return MatchPubgMap.values();
	}

	@Override
	public Collection<MatchLoL> getAllLolMatch() {
			return MatchLolMap.values();
	}
	@Override
	public MatchLoL getLolMatch(String id) {
		return MatchLolMap.get(id);
	}
	@Override
	public Matchpubg getPubgMatch(String id) {
		return MatchPubgMap.get(id);
	}
	
	@Override
	public void updatePubgMatch(Matchpubg p) {
		MatchPubgMap.put(p.getId(),p);
	}
	@Override
	public void updateLolMatch(MatchLoL p) {
		MatchLolMap.put(p.getId(),p);
	}

	@Override
	public void deletePubgMatch(String id) {	
		MatchPubgMap.remove(id);
	}
	
	@Override
	public void deleteLolMatch(String id) {	
		MatchLolMap.remove(id);
	}
	

	
	// Players related operations
	
	@Override
	public void addLolPlayer(LolPlayer s) {
		String id = "s" + index++;
		s.setId(id);
		LolPlayerMap.put(id, s);
	}
	
	@Override
	public void addPubgPlayer(PubgPlayer s) {
		String id = "s" + index++;
		s.setId(id);
		PubgPlayerMap.put(id, s);
	}
	
	@Override
	public Collection<LolPlayer> getAllLolPlayer() {
			return LolPlayerMap.values();
	}
	@Override
	public Collection<PubgPlayer> getAllPubgPlayer() {
			return PubgPlayerMap.values();
	}

	@Override
	public LolPlayer getLolPlayer(String Id) {
		return LolPlayerMap.get(Id);
	}
	
	@Override
	public PubgPlayer getPubgPlayer(String Id) {
		return PubgPlayerMap.get(Id);
	}
	
	@Override
	public void deleteLolPlayer(String Id) {
		LolPlayerMap.remove(Id);
	}
	
	@Override
	public void deletePubgPlayer(String Id) {
		PubgPlayerMap.remove(Id);
	}
	
	@Override
	public void updateLolPlayer(LolPlayer p) {
		LolPlayerMap.put(p.getId(),p);
	}
	
	@Override
	public void updatePubgPlayer(PubgPlayer p) {
		PubgPlayerMap.put(p.getId(),p);
	}

	
	
}

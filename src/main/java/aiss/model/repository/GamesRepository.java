package aiss.model.repository;

import java.util.Collection;



import aiss.modelapi.LolPlayer;
import aiss.modelapi.MatchLoL;
import aiss.modelapi.Matchpubg;
import aiss.modelapi.PubgPlayer;

public interface GamesRepository {
	
	
	// Songs
	
	public void deletePubgPlayer(String Id);
	public void deleteLolPlayer(String Id);
	public PubgPlayer getPubgPlayer(String Id);
	public LolPlayer getLolPlayer(String Id); 
	public void updateLolPlayer(LolPlayer p);
	public void updatePubgPlayer(PubgPlayer p);
	public Collection<LolPlayer> getAllLolPlayer();
	public Collection<PubgPlayer> getAllPubgPlayer();
	public void addLolPlayer(LolPlayer s);
	public void addPubgPlayer(PubgPlayer s);
	
	// Matchs

	public void addPubgMatch(Matchpubg p);
	public void addLolMatch(MatchLoL p);
	public Collection<Matchpubg> getAllPubgMatch();
	public Collection<MatchLoL> getAllLolMatch();
	public MatchLoL getLolMatch(String id);
	public Matchpubg getPubgMatch(String id);
	public void updatePubgMatch(Matchpubg p);
	public void updateLolMatch(MatchLoL p);
	public void deletePubgMatch(String id);
	public void deleteLolMatch(String id);

	
	

	
	
	
	

}

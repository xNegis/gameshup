package aiss.modelapi;
  
public class Matchpubg {
	PubgPlayer player;
	String name;
	String id;
	String mapa;
	Integer kills;
	Double damage; 
	Integer headshotskill;
	Double walkdistance;
	Integer longestkill;
	Integer winplace;
	
	public Matchpubg(String mapa,Integer kills, Double damage, Integer headshotskill,
			Double walkdistance, Integer longestkill, Integer winplace) {
		super();
		this.mapa = mapa;
		this.kills = kills;
		this.damage = damage;
		this.headshotskill = headshotskill;
		this.walkdistance = walkdistance;
		this.longestkill = longestkill;
		this.winplace = winplace;

	}
	
	
	public Matchpubg() {
		super();

	}

	
	public PubgPlayer getPlayer() {
		return player;
	}


	public void setPlayer(PubgPlayer player) {
		this.player = player;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setId(String id) {
		this.id = id;
	}
	public Double getDamage() {
		return damage;
	}
	public void setDamage(Double damage) {
		this.damage = damage;
	}


	public String getMapa() {
		return mapa;
	}
	public void setMapa(String mapa) {
		this.mapa = mapa;
	}

	public Integer getKills() {
		return kills;
	}
	public void setKills(Integer kills) {
		this.kills = kills;
	}
	public Integer getWinplace() {
		return winplace;
	}
	public void setWinplace(Integer winplace) {
		this.winplace = winplace;
	}
	public Integer getHeadshotskill() {
		return headshotskill;
	}
	public void setHeadshotskill(Integer headshotskill) {
		this.headshotskill = headshotskill;
	}
	public Double getWalkdistance() {
		return walkdistance;
	}
	public void setWalkdistance(Double walkdistance) {
		this.walkdistance = walkdistance;
	}
	public Integer getLongestkill() {
		return longestkill;
	}
	public void setLongestkill(Integer longestkill) {
		this.longestkill = longestkill;
	}
	public Matchpubg(String mapa, String nombre, Integer kills, Double damage,  Integer winplace, Integer headshotskill,
			Double walkdistance, Integer longestkill) {
		super();
		this.mapa = mapa;
		this.kills = kills;
		this.damage = damage;
		this.headshotskill = headshotskill;
		this.walkdistance = walkdistance;
		this.longestkill = longestkill;
		this.winplace = winplace;
;
	}
	public String getId() {
		return id;
	}
	


	
}

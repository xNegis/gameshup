package aiss;
  
public class Matchpubg {
	String mapa;
	String nombre;
	Integer kills;
	Double damage; 
	Integer headshotskill;
	Double walkdistance;
	Integer longestkill;
	
	public Double getDamage() {
		return damage;
	}
	public void setDamage(Double damage) {
		this.damage = damage;
	}
	Integer winplace;
	String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMapa() {
		return mapa;
	}
	public void setMapa(String mapa) {
		this.mapa = mapa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public Matchpubg(String mapa, String nombre, Integer kills, Double damage,  Integer winplace, String type, Integer headshotskill,
			Double walkdistance, Integer longestkill) {
		super();
		this.mapa = mapa;
		this.nombre = nombre;
		this.kills = kills;
		this.damage = damage;
		this.headshotskill = headshotskill;
		this.walkdistance = walkdistance;
		this.longestkill = longestkill;
		this.winplace = winplace;
		this.type = type;
	}
	


	
}

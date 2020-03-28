package aiss;

public class Matchpubg {
	String mapa;
	String nombre;
	Integer kills;
	Integer winplace;
	
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
	public Matchpubg(String mapa, String nombre, Integer kills, Integer winplace) {
		super();
		this.mapa = mapa;
		this.nombre = nombre;
		this.kills = kills;
		this.winplace = winplace;
	}
	
}

package model.auxiliary;

public class MatchLoL2 {

	String name;
	String champion;
	Integer kills;
	Integer deaths;
	Integer assists;

	public MatchLoL2(String name, String champion, Integer kills, Integer deaths, Integer assists) {
		super();
		this.name = name;
		this.champion = champion;
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
	}
	public Integer getKills() {
		return kills;
	}
	public void setKills(Integer kills) {
		this.kills = kills;
	}
	public Integer getDeaths() {
		return deaths;
	}
	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}
	public Integer getAssists() {
		return assists;
	}
	public void setAssists(Integer assists) {
		this.assists = assists;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChampion() {
		return champion;
	}
	public void setChampion(String champion) {
		this.champion = champion;
	}
	
	
	
}

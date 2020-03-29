package aiss;

public class MatchpubgSeason {

	String kd;
	String wins;
	String damage;
	String time;
	String headshot;
	String top10;
	String longestkill;
	
	public String getLongestkill() {
		return longestkill;
	}
	public void setLongestkill(String longestkill) {
		this.longestkill = longestkill;
	}
	public String getKd() {
		return kd;
	}
	public void setKd(String kd) {
		this.kd = kd;
	}
	public String getWins() {
		return wins;
	}
	public void setWins(String wins) {
		this.wins = wins;
	}
	public String getDamage() {
		return damage;
	}
	public void setDamage(String damage) {
		this.damage = damage;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHeadshot() {
		return headshot;
	}
	public void setHeadshot(String headshot) {
		this.headshot = headshot;
	}
	public String getTop10() {
		return top10;
	}
	public void setTop10(String top10) {
		this.top10 = top10;
	}
	
	public MatchpubgSeason(String kd, String wins, String damage, String time, String headshot,
			String top10,String longestkill) {
		super();
		this.kd = kd;
		this.wins = wins;
		this.damage = damage;
		this.time = time;
		this.headshot = headshot;
		this.top10 = top10;
		this.longestkill=longestkill;
	}
	public MatchpubgSeason() {
		// TODO Auto-generated constructor stub
	}
	
	
}

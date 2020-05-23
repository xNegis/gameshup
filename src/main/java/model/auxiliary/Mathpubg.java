package model.auxiliary;

public class Mathpubg {
	
	double damage;
	int kills;
	int rank;
	double longestkill;
	double distancew;
	int headshots;
	
	
	
	public Mathpubg(double damage, int kills, int rank, double longestkill, double distancew, int headshots) {
		super();
		this.damage = damage;
		this.kills = kills;
		this.rank = rank;
		this.longestkill = longestkill;
		this.distancew = distancew;
		this.headshots = headshots;
	}

	public Mathpubg() {
		// TODO Auto-generated constructor stub
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getLongestkill() {
		return longestkill;
	}

	public void setLongestkill(double longestkill) {
		this.longestkill = longestkill;
	}

	public double getDistancew() {
		return distancew;
	}

	public void setDistancew(double distancew) {
		this.distancew = distancew;
	}

	public int getHeadshots() {
		return headshots;
	}

	public void setHeadshots(int headshots) {
		this.headshots = headshots;
	}

	
}

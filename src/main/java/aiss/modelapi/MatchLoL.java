package aiss.modelapi;

public class MatchLoL {
		String name;
		
		LolPlayer player;
		String id;
		String champion;
		Integer minions;
		Integer kills;
		Integer deaths;
		Integer assists;
		Integer tdmg;
		Integer mdmg;
		Integer pdmg;
		boolean win;
		Integer gold;
	
	    
	    
	    
	    public MatchLoL(String champion, Integer minions, Integer kills, Integer deaths, Integer assists, Integer tdmg,
				Integer mdmg, Integer pdmg, boolean win, Integer gold) {
			super();
			this.champion = champion;
			this.minions = minions;
			this.kills = kills;
			this.deaths = deaths;
			this.assists = assists;
			this.tdmg = tdmg;
			this.mdmg = mdmg;
			this.pdmg = pdmg;
			this.win = win;
			this.gold = gold;
		}
	    
	    
		public MatchLoL() {
			super();
			
		}

		
		
		public LolPlayer getPlayer() {
			return player;
		}


		public void setPlayer(LolPlayer player) {
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
		public String getId() {
			return id;
		}

		public String getChampion() {
			return champion;
		}
		public void setChampion(String champion) {
			this.champion = champion;
		}
		public Integer getMinions() {
			return minions;
		}
		public void setMinions(Integer minions) {
			this.minions = minions;
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
		public Integer getTdmg() {
			return tdmg;
		}
		public void setTdmg(Integer dmg) {
			this.tdmg = dmg;
		}
		public Integer getMdmg() {
			return mdmg;
		}
		public void setMdmg(Integer mdmg) {
			this.mdmg = mdmg;
		}
		public Integer getPdmg() {
			return pdmg;
		}
		public void setPdmg(Integer pdmg) {
			this.pdmg = pdmg;
		}
		public boolean isWin() {
			return win;
		}
		public void setWin(boolean win) {
			this.win = win;
		}
		
		public Integer getGold() {
			return gold;
		}
		public void setGold(Integer gold) {
			this.gold = gold;
		}
	
		public MatchLoL(Integer icon,String champion, Integer minions,Integer kills, Integer deaths, Integer assists, Integer tdmg,
				Integer mdmg,Integer pdmg,boolean win, Integer gold) {
			super();
	
			this.champion = champion;
			this.minions = minions;
			this.kills = kills;
			this.deaths = deaths;
			this.assists = assists;
			this.tdmg = tdmg;
			this.mdmg = mdmg;
			this.pdmg = pdmg;
			this.win = win;
			this.gold = gold;

		}
		
		
		
		
		
		
		

	

}

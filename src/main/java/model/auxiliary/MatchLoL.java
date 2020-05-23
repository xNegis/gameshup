package model.auxiliary;

public class MatchLoL {

		public String champion;
		public Integer minions;
		public Integer neutral;
		public Integer kills;
		public Integer deaths;
		public Integer assists;
		public Integer tdmg;
		public Integer mdmg;
		public Integer pdmg;
		public boolean win;
		public Integer spell1;
		public Integer spell2;
		public Integer item0;
		public Integer item1;
		public Integer item2;
		public Integer item3;
		public Integer item4;
		public Integer item5;
		public Integer item6;
		public Integer gold;
		public Integer penta;
		public  Integer icon;
		public  Long tiempo;
	    
		public Long getTiempo() {
			return tiempo;
		}
		public void setTiempo(Long tiempo) {
			this.tiempo = tiempo;
		}
		public Integer getIcon() {
			return icon;
		}
		public void setIcon(Integer icon) {
			this.icon = icon;
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
		public Integer getSpell1() {
			return spell1;
		}
		public void setSpell1(Integer spell1) {
			this.spell1 = spell1;
		}
		public Integer getSpell2() {
			return spell2;
		}
		public void setSpell2(Integer spell2) {
			this.spell2 = spell2;
		}
		public Integer getItem0() {
			return item0;
		}
		public void setItem0(Integer item0) {
			this.item0 = item0;
		}
		public Integer getItem1() {
			return item1;
		}
		public void setItem1(Integer item1) {
			this.item1 = item1;
		}
		public Integer getItem2() {
			return item2;
		}
		public void setItem2(Integer item2) {
			this.item2 = item2;
		}
		public Integer getItem3() {
			return item3;
		}
		public void setItem3(Integer item3) {
			this.item3 = item3;
		}
		public Integer getItem4() {
			return item4;
		}
		public void setItem4(Integer item4) {
			this.item4 = item4;
		}
		public Integer getItem5() {
			return item5;
		}
		public void setItem5(Integer item5) {
			this.item5 = item5;
		}
		public Integer getItem6() {
			return item6;
		}
		public void setItem6(Integer item6) {
			this.item6 = item6;
		}
		public Integer getGold() {
			return gold;
		}
		public void setGold(Integer gold) {
			this.gold = gold;
		}
		public Integer getPenta() {
			return penta;
		}
		public void setPenta(Integer penta) {
			this.penta = penta;
		}
		public Integer getNeutral() {
			return neutral;
		}
		public void setNeutral(Integer neutral) {
			this.neutral = neutral;
		}
		public MatchLoL(Integer icon,String champion, Integer minions, Integer neutral,Integer kills, Integer deaths, Integer assists, Integer tdmg,
				Integer mdmg,Integer pdmg,boolean win, Integer spell1, Integer spell2, Integer item0, Integer item1, Integer item2, Integer item3,
				Integer item4, Integer item5, Integer item6, Integer gold, Long tiempo) {
			super();
			this.icon = icon;
			this.champion = champion;
			this.minions = minions;
			this.kills = kills;
			this.deaths = deaths;
			this.assists = assists;
			this.tdmg = tdmg;
			this.mdmg = mdmg;
			this.pdmg = pdmg;
			this.win = win;
			this.spell1 = spell1;
			this.spell2 = spell2;
			this.item0 = item0;
			this.item1 = item1;
			this.item2 = item2;
			this.item3 = item3;
			this.item4 = item4;
			this.item5 = item5;
			this.item6 = item6;
			this.gold = gold;
			this.tiempo=tiempo;
			this.neutral = neutral;
		}
		
		
		
		
		
		
		

	

}

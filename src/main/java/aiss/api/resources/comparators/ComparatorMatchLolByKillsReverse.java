package aiss.api.resources.comparators;

import java.util.Comparator;


import aiss.modelapi.MatchLoL;


public class ComparatorMatchLolByKillsReverse implements Comparator<MatchLoL> {

	@Override
	public int compare(MatchLoL s1, MatchLoL s2) {
		return s2.getKills().compareTo(s1.getKills());
	}

}

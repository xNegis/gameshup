package aiss.api.resources.comparators;

import java.util.Comparator;


import aiss.modelapi.MatchLoL;


public class ComparatorMatchLolByKills implements Comparator<MatchLoL> {

	@Override
	public int compare(MatchLoL s1, MatchLoL s2) {
		return s1.getKills().compareTo(s2.getKills());
	}

}

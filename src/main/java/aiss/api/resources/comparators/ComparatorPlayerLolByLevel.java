package aiss.api.resources.comparators;

import java.util.Comparator;


import aiss.modelapi.LolPlayer;



public class ComparatorPlayerLolByLevel implements Comparator<LolPlayer> {

	@Override
	public int compare(LolPlayer s1, LolPlayer s2) {
		return s1.getnivel().compareTo(s2.getnivel());
	}

}

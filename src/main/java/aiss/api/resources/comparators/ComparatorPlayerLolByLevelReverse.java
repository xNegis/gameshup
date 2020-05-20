package aiss.api.resources.comparators;

import java.util.Comparator;


import aiss.modelapi.LolPlayer;



public class ComparatorPlayerLolByLevelReverse implements Comparator<LolPlayer> {

	@Override
	public int compare(LolPlayer s1, LolPlayer s2) {
		return s2.getnivel().compareTo(s1.getnivel());
	}

}

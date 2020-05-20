package aiss.api.resources.comparators;

import java.util.Comparator;


import aiss.modelapi.PubgPlayer;



public class ComparatorPlayerPubgByPlataforma implements Comparator<PubgPlayer> {

	@Override
	public int compare(PubgPlayer s1, PubgPlayer s2) {
		return s1.getPlataforma().compareTo(s2.getPlataforma());
	}

}

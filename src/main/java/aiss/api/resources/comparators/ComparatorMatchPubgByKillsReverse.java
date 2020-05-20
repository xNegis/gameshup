package aiss.api.resources.comparators;

import java.util.Comparator;



import aiss.modelapi.Matchpubg;


public class ComparatorMatchPubgByKillsReverse implements Comparator<Matchpubg> {

	@Override
	public int compare(Matchpubg s1, Matchpubg s2) {
		return s2.getKills().compareTo(s1.getKills());
	}

}

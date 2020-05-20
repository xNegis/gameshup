package aiss.api.resources.comparators;

import java.util.Comparator;



import aiss.modelapi.Matchpubg;


public class ComparatorMatchPubgByLongestKill implements Comparator<Matchpubg> {

	@Override
	public int compare(Matchpubg s1, Matchpubg s2) {
		return s2.getLongestkill().compareTo(s1.getLongestkill());
	}

}

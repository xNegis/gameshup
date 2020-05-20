package aiss.api.resources.comparators;

import java.util.Comparator;



import aiss.modelapi.Matchpubg;


public class ComparatorMatchPubgByKills implements Comparator<Matchpubg> {

	@Override
	public int compare(Matchpubg s1, Matchpubg s2) {
		return s1.getKills().compareTo(s2.getKills());
	}

}

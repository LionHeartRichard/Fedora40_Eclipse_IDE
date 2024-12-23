package competition;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class AlternativeCompetition {
	Map<Integer, Integer> sortMap;

	public AlternativeCompetition(int participiantCount) {
		sortMap = new TreeMap<>(Comparator.reverseOrder());
	}

	public void like(int idxParticipiant) {
		int tmp = sortMap.get(idxParticipiant);
		sortMap.put(idxParticipiant, tmp + 1);
	}

	public void dislike(int idxParticipiant) {
		int tmp = sortMap.get(idxParticipiant);
		sortMap.put(idxParticipiant, tmp - 1);
	}

	public Collection<Integer> getBestWorks(int countWorks) {

		return sortMap.values();
	}
}

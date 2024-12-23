package competition;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

public class TestCompetetition {

	@Test
	public void testHeapSortRevers() {
		int[] actual = { 3, 7, 9, 10, 2, 5, 8, 1, 4, 3 };
		Competition competition = new Competition(actual.length);

		int[] expected = { 10, 9, 8, 7, 5, 4, 3, 3, 2, 1 };
		competition.heapReversSort(actual);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testGetBestWorks() {
		int[] array = { 3, 7, 9, 10, 2, 5, 8, 1, 4, 3 };
		Competition competition = new Competition(array.length);
		competition.scores = array;

		int[] expected = { 10, 9, 8 };
		int[] actual = competition.getBestWorks(3);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testGetBestWorksAlternative() {
		AlternativeCompetition alternative = new AlternativeCompetition(5);
		for (int i = 0; i < 3; ++i) {
			alternative.like(0);
		}

		for (int i = 0; i < 5; ++i) {
			alternative.like(i);
		}

		for (int i = 0; i < 5; ++i) {
			alternative.like(3);
		}

		Collection<Integer> collection = alternative.getBestWorks(5);
		collection.forEach(v -> System.out.println(v));
	}
}

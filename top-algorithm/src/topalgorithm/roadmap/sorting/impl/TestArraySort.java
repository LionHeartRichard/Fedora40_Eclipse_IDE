package topalgorithm.roadmap.sorting.impl;

import static org.junit.Assert.assertArrayEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static topalgorithm.setup.GenerateItemsForBigArray.getLengthArray;
import static topalgorithm.setup.GenerateItemsForBigArray.getFileName;

public class TestArraySort {

	private int LENGTH_ARRAY = getLengthArray();
	private String fileName = getFileName();
	private int[] actualArray;
	private HeapSort heapSort;
	private TimSorted timSort;
	private int[] expectedArray;

	@BeforeEach
	public void setUp() throws IOException {
		heapSort = new HeapSort();
		timSort = new TimSorted();
		actualArray = new int[LENGTH_ARRAY];
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String swapStringArray = reader.readLine();
		reader.close();

		String[] swapArrayString = swapStringArray.split(" ");

		for (int i = 0; i < LENGTH_ARRAY; ++i) {
			actualArray[i] = Integer.parseInt(swapArrayString[i]);
		}
		expectedArray = Arrays.copyOf(actualArray, LENGTH_ARRAY);
		Arrays.sort(expectedArray);
	}

	@Test
	public void testSpeedForHeapSort() {
		heapSort.sort(actualArray);

		assertArrayEquals(expectedArray, actualArray);
	}

	@Test
	public void testSpeedForTimSorted() {
		timSort.sort(actualArray);

		assertArrayEquals(expectedArray, actualArray);
	}

}

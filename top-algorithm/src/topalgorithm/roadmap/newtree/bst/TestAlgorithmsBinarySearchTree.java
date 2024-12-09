package topalgorithm.roadmap.newtree.bst;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static topalgorithm.roadmap.newtree.bst.AlgorithmsBinarySearchTree.*;

public class TestAlgorithmsBinarySearchTree {

	private TreeNode actualTree;
	private int[] nums = { -2, 4, 6, 12, 18, 21 };

	@BeforeEach
	public void setUp() {
		Arrays.sort(nums);
		actualTree = getBinarySearchTree(nums);
	}

	@Test
	public void isValidateTreeLeavesWhenValidDataThenReturnTrue() {
		assertTrue(isValidateTreeLeaves(actualTree, 21, -2));
	}

	@Test
	public void isValidateTreeLeavesWhenNotValidDataThenReturnFalse() {
		assertFalse(isValidateTreeLeaves(actualTree, 20, -1));
	}

	@Test
	public void getSortListWhenInputRootThenReturnNewSortList() {
		List<Integer> expected = Arrays.asList(-2, 4, 6, 12, 18, 21);

		List<Integer> actual = getSortList(actualTree);

		for (int i = 0; i < expected.size(); ++i) {
			assertEquals(expected.get(i), actual.get(i));
		}

		assertEquals(expected.size(), actual.size());
	}

	@Test
	public void getMinKElementWhenNormalDataReturn7() {
		int[] newNums = { 2, 5, 7, 10, 12, 15, 20, 50, 100, 150, 200 };
		TreeNode root = getBinarySearchTree(newNums);

		int expected = 7;
		int actual = getMinKElement(root, 3);

		assertEquals(expected, actual);
	}

	@Test
	public void getMaxKElementWhenNormalDataThenReturnSort() {
		int[] newNums = { -9, 2, 5, 7, 10, 12, 15, 20, 50, 100, 150, 200 };
		TreeNode root = getBinarySearchTree(newNums);

		int expected = 100;
		int actual = getMaxKElement(root, 3);

		assertEquals(expected, actual);
	}

	@Test
	public void getReversTraversalWhenNormalDataThenReturnSortReversList() {
		List<Integer> expected = Arrays.asList(21, 18, 12, 6, 4, -2);
		List<Integer> actual = getReversSortList(actualTree);

		for (int i = 0; i < actual.size(); ++i) {
			assertEquals(expected.get(i), actual.get(i));
		}

		assertEquals(expected.size(), actual.size());
	}
}

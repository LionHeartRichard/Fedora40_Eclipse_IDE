package topalgorithm.roadmap.newtree.bst;

import java.util.ArrayList;
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
}

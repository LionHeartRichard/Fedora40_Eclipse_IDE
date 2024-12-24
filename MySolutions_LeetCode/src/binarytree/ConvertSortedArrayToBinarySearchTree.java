package binarytree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ConvertSortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] nums) {
		return builder(nums, 0, nums.length - 1);
	}

	private TreeNode builder(int[] nums, int leftIdx, int rightIdx) {
		if (leftIdx > rightIdx)
			return null;
		int median = (leftIdx + rightIdx) / 2;
		TreeNode root = new TreeNode(nums[median]);
		root.left = builder(nums, leftIdx, median - 1);
		root.right = builder(nums, median + 1, rightIdx);
		return root;
	}

	// ------------------Heap--SORTED----------------------

	public void heapSort(int[] nums) {
		int len = nums.length;

		for (int idx = len / 2 - 1; idx >= 0; --idx) {
			heapify(nums, len, idx);
		}

		for (int idx = len - 1; idx >= 0; --idx) {
			int swapItem = nums[0];
			nums[0] = nums[idx];
			nums[idx] = swapItem;

			heapify(nums, idx, 0);
		}
	}

	private void heapify(int[] nums, int len, int idx) {
		int currentIdx = idx;
		int leftIdx = currentIdx * 2 + 1;
		int rightIdx = leftIdx + 1;

		if (leftIdx < len && nums[leftIdx] > nums[currentIdx])
			currentIdx = leftIdx;
		if (rightIdx < len && nums[rightIdx] > nums[currentIdx])
			currentIdx = rightIdx;

		if (currentIdx != idx) {
			int swapItem = nums[currentIdx];
			nums[currentIdx] = nums[idx];
			nums[idx] = swapItem;

			heapify(nums, len, currentIdx);
		}
	}

	@Test
	public void testHeapSort() {
		int[] actual = { 5, 4, 3, 2, 1 };

		heapSort(actual);
		int[] expected = { 1, 2, 3, 4, 5 };

		assertArrayEquals(expected, actual);
	}

	@Test
	public void case1() {
		int[] nums = { -10, -3, 0, 5, 9 };
		// Output: [0,-3,9,-10,null,5];
		// or [0,-10,5,null,-3,null,9];

		TreeNode root = sortedArrayToBST(nums);

		assertEquals(0, root.val);
	}

	@Test
	public void case2() {
		int[] nums = { 1, 3 };
		// Output: [3,1];
		// or [1,null,3] and [3,1] ;

		TreeNode root = sortedArrayToBST(nums);
		Set<Integer> setRoot = new HashSet<>();
		setRoot.add(3);
		setRoot.add(1);

		assertTrue(setRoot.contains(root.val));
	}

	@Test
	public void case3() {
		int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		TreeNode root = sortedArrayToBST(nums);
		// Output

		Set<Integer> setRoot = new HashSet<>();
		setRoot.add(5);
		setRoot.add(6);

		assertTrue(setRoot.contains(root.val));
	}
}

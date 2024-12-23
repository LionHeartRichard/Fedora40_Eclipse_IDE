package binarytree;

import org.junit.jupiter.api.Test;

public class ConvertSortedArrayToBinarySearchTree {

	private int[] cach;

	public TreeNode sortedArrayToBST(int[] nums) {
		int len = nums.length;
		cach = new int[len];

		if (len == 1)
			return new TreeNode(nums[0]);
		int mid = len / 2 - 1;
		TreeNode root = new TreeNode(nums[mid]);
		cach[mid] = root.val;
		root = heapify(root, nums, mid);
		return root;
	}

	private TreeNode heapify(TreeNode node, int[] nums, int idx) {
		int leftIdx = idx / 2 - 1;
		int rightIdx = idx * 2 - 1;

		if (leftIdx >= 0) {
			if (cach[leftIdx] == 0) {
				cach[leftIdx] = nums[leftIdx];
				node.left = new TreeNode(nums[leftIdx]);
				heapify(node.left, nums, leftIdx);
			}
		}
		if (rightIdx < nums.length) {
			if (cach[rightIdx] == 0) {
				node.right = new TreeNode(nums[rightIdx]);
				heapify(node.right, nums, rightIdx);
			} else {
				return cach[rightIdx];
			}
		}
		return node;
	}

	@Test
	public void case1() {
		int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		TreeNode root = sortedArrayToBST(nums);
		System.out.println(root.val);
	}
}

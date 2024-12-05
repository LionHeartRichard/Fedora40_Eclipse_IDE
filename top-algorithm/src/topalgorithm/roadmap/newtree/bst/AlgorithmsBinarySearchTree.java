package topalgorithm.roadmap.newtree.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlgorithmsBinarySearchTree {

	private AlgorithmsBinarySearchTree() {
	}

	private static int getLeftmostValue(TreeNode node, int minVal) {
		while (node.left != null) {
			node = node.left;
			if (node.val < minVal)
				return node.val;
		}
		return node.val;
	}

	private static int getRightmostValue(TreeNode node, int maxVal) {
		while (node.right != null) {
			node = node.right;
			if (node.val > maxVal)
				return node.val;
		}
		return node.val;
	}

	public static boolean isValidateTreeLeaves(TreeNode root, int maxVal, int minVal) {
		if (root == null) {
			return true;
		}
		int leftmostValue = getLeftmostValue(root, minVal);
		if (leftmostValue < minVal)
			return false;
		int rightmostValue = getRightmostValue(root, maxVal);
		if (rightmostValue > maxVal)
			return false;
		return true;
	}

	private static boolean isValid(TreeNode node, Integer low, Integer high) {
		if (node == null) {
			return true;
		}

		if (low != null && node.val <= low) {
			return false;
		}

		if (high != null && node.val >= high) {
			return false;
		}

		return isValid(node.left, low, node.val) && isValid(node.right, high, node.val);
	}

	public static boolean isBinarySearchTree(TreeNode root) {
		return isValid(root, null, null);
	}

	private static TreeNode buildBinarySearchTree(int[] nums, int leftIdx, int rightIdx) {
		if (leftIdx > rightIdx)
			return null;

		int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

		TreeNode node = new TreeNode(nums[midIdx]);
		node.left = buildBinarySearchTree(nums, leftIdx, midIdx - 1);
		node.right = buildBinarySearchTree(nums, midIdx + 1, rightIdx);
		return node;
	}

	public static TreeNode getBinarySearchTree(int[] nums) {
		return buildBinarySearchTree(nums, 0, nums.length - 1);
	}

	public static List<Integer> getSortList(TreeNode node) {
		if (node == null)
			return null;
		List<Integer> res = new ArrayList<>();
		traversal(res, node, node.val);
		
		return res;
	}

	private static void traversal(List<Integer> res, TreeNode node, int currnetValue) {
		if (node == null) {
			return;
		}
		res.add(node.val);
		traversal(res, node.left, node.val);
		traversal(res, node.right, node.val);
	}

}

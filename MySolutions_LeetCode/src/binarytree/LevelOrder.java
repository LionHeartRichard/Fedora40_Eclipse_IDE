package binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class LevelOrder {

	public List<List<Integer>> levelOrder(TreeNode root) {

		if (root == null)
			return Collections.emptyList();

		List<List<Integer>> ans = new AbstractList<List<Integer>>() {

			List<List<Integer>> result = new ArrayList<>();

			@Override
			public int size() {
				if (result.isEmpty())
					result = getListOrderLevel(root);
				return result.size();
			}

			@Override
			public List<Integer> get(int index) {
				if (result.isEmpty())
					result = getListOrderLevel(root);
				return result.get(index);
			}
		};
		return ans;
	}

	private List<List<Integer>> getListOrderLevel(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();

		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);

		while (!que.isEmpty()) {
			int size = que.size();
			List<Integer> tmp = new ArrayList<>();
			for (int count = 0; count < size; ++count) {
				TreeNode node = que.poll();
				if (node.left != null)
					que.add(node.left);
				if (node.right != null)
					que.add(node.right);
				tmp.add(node.val);
			}
			ans.add(tmp);
		}

		return ans;
	}

	@Test
	public void case1() {
		// [3,9,20,null,null,15,7]
		TreeNode nodeLeft = new TreeNode(15);
		TreeNode nodeRight = new TreeNode(7);
		TreeNode rightParent = new TreeNode(20, nodeLeft, nodeRight);
		TreeNode leftParent = new TreeNode(9);
		TreeNode root = new TreeNode(3, leftParent, rightParent);

		// [[3],[9,20],[15,7]]
		List<List<Integer>> expected = new ArrayList<>();
		List<Integer> levelRoot = new ArrayList<>(Arrays.asList(3));
		expected.add(levelRoot);
		List<Integer> level1 = new ArrayList<>(Arrays.asList(9, 20));
		expected.add(level1);
		List<Integer> level2 = new ArrayList<>(Arrays.asList(15, 7));
		expected.add(level2);

		List<List<Integer>> actual = levelOrder(root);
		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		// root = [1,2,3,4,null,null,5]
		TreeNode nodeRight = new TreeNode(5);
		TreeNode rightParent = new TreeNode(3, null, nodeRight);
		TreeNode nodeLeftLeft = new TreeNode(4);
		TreeNode leftParent = new TreeNode(2, nodeLeftLeft, null);
		TreeNode root = new TreeNode(1, leftParent, rightParent);

		// expected = [[1],[2,3],[4,5]]
		List<List<Integer>> expected = new ArrayList<>();
		List<Integer> levelRoot = new ArrayList<>(Arrays.asList(1));
		expected.add(levelRoot);
		List<Integer> level1 = new ArrayList<>(Arrays.asList(2, 3));
		expected.add(level1);
		List<Integer> level2 = new ArrayList<>(Arrays.asList(4, 5));
		expected.add(level2);

		List<List<Integer>> actual = levelOrder(root);
		assertEquals(expected, actual);
	}
}
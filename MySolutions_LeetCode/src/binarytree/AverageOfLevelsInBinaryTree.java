package binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class AverageOfLevelsInBinaryTree {

	public List<Double> averageOfLevels(TreeNode root) {

		List<Double> res = new AbstractList<Double>() {

			List<Double> result = null;

			@Override
			public int size() {
				if (result == null)
					result = swapFunction(root);
				return result.size();
			}

			@Override
			public Double get(int index) {
				if (result == null)
					result = swapFunction(root);
				return result.get(index);
			}
		};

		return res;
	}

	private List<Double> swapFunction(TreeNode root) {
		List<Double> result = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);

		while (!que.isEmpty()) {
			int size = que.size();
			double sum = 0.0;
			for (int i = 0; i < size; ++i) {
				TreeNode node = que.poll();
				sum += node.val;
				if (node.left != null)
					que.add(node.left);
				if (node.right != null)
					que.add(node.right);
			}
			result.add(sum / size);
		}

		return result;
	}

	@Test
	public void case1() {
		TreeNode newRight = new TreeNode(7);
		TreeNode newLeft = new TreeNode(15);
		TreeNode left = new TreeNode(9, null, null);
		TreeNode right = new TreeNode(20, newLeft, newRight);
		TreeNode root = new TreeNode(3, left, right);

		double[] expected = { 3.00000, 14.50000, 11.00000 };
		List<Double> actual = averageOfLevels(root);

		actual.forEach(v -> System.out.println(v));
		System.out.println("-".repeat(100));

		for (int i = 0; i < expected.length; ++i) {
			assertEquals(expected[i], actual.get(i), 0.0001);
		}
	}

	@Test
	public void case2() {
		TreeNode newRight = new TreeNode(7);
		TreeNode newLeft = new TreeNode(15);
		TreeNode left = new TreeNode(9, newLeft, newRight);
		TreeNode right = new TreeNode(20);
		TreeNode root = new TreeNode(3, left, right);

		double[] expected = { 3.00000, 14.50000, 11.00000 };
		List<Double> actual = averageOfLevels(root);

		actual.forEach(v -> System.out.println(v));
		System.out.println("-".repeat(100));

		for (int i = 0; i < expected.length; ++i) {
			assertEquals(expected[i], actual.get(i), 0.0001);
		}
	}

	@Test
	public void case3() {
		TreeNode left = new TreeNode(1);
		TreeNode root = new TreeNode(1, left, null);

		double[] expected = { 1.00000, 1.00000 };
		List<Double> actual = averageOfLevels(root);

		actual.forEach(v -> System.out.println(v));
		System.out.println("-".repeat(100));

		for (int i = 0; i < expected.length; ++i) {
			assertEquals(expected[i], actual.get(i), 0.00001);
		}
	}

	@Test
	public void case4() {
		TreeNode left = new TreeNode(-1);
		TreeNode root = new TreeNode(0, left, null);

		double[] expected = { 0.00000, -1.00000 };
		List<Double> actual = averageOfLevels(root);

		actual.forEach(v -> System.out.println(v));
		System.out.println("-".repeat(100));

		for (int i = 0; i < expected.length; ++i) {
			assertEquals(expected[i], actual.get(i), 0.00001);
		}
	}

	@Test
	public void case5() {

		// [3,1,5,0,2,4,6]
		TreeNode rightRight = new TreeNode(6);
		TreeNode newRight = new TreeNode(4, null, rightRight);
		TreeNode newLeft = new TreeNode(2);
		TreeNode leftNew = new TreeNode(0);
		TreeNode right = new TreeNode(5, newLeft, newRight);
		TreeNode left = new TreeNode(1, leftNew, null);
		TreeNode root = new TreeNode(3, left, right);

		double[] expected = { 3.0, 3.0, 2.0, 6.0 };
		List<Double> actual = averageOfLevels(root);

		actual.forEach(v -> System.out.println(v));
		System.out.println("-".repeat(100));

		for (int i = 0; i < expected.length; ++i) {
			assertEquals(expected[i], actual.get(i), 0.00001);
		}
	}

}

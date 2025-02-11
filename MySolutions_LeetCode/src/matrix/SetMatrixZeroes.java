package matrix;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		int len = matrix.length;
		boolean firstRowZero = firstRowIsZero(matrix);
		boolean firstColZero = firstColumnIsZero(matrix);

		for (int row = 1; row < len; ++row)
			markZeroFirstElementInColumnsAndRows(matrix, row);

		for (int row = 1; row < len; ++row)
			setMatrixCellsToZeroBasedOnMarkers(matrix, row);

		if (firstRowZero) {
			for (int column = 0; column < matrix[0].length; column++)
				matrix[0][column] = 0;
		}

		if (firstColZero) {
			for (int row = 0; row < len; row++)
				matrix[row][0] = 0;
		}
	}

	private void setMatrixCellsToZeroBasedOnMarkers(int[][] matrix, int row) {
		for (int column = 1; column < matrix[0].length; ++column) {
			if (matrix[0][column] == 0 || matrix[row][0] == 0)
				matrix[row][column] = 0;
		}
	}

	private void markZeroFirstElementInColumnsAndRows(int[][] matrix, int row) {
		for (int column = 1; column < matrix[0].length; ++column) {
			if (matrix[row][column] == 0) {
				matrix[0][column] = 0;
				matrix[column][0] = 0;
			}
		}
	}

	private boolean firstColumnIsZero(int[][] matrix) {
		for (int colun = 0; colun < matrix[0].length; ++colun) {
			if (matrix[0][colun] == 0)
				return true;
		}
		return false;
	}

	private boolean firstRowIsZero(int[][] matrix) {
		for (int row = 0; row < matrix.length; ++row) {
			if (matrix[row][0] == 0)
				return true;
		}
		return false;
	}

	@Test
	public void case1() {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int len = matrix.length;

		int[][] expected = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		setZeroes(matrix);
		for (int idx = 0; idx < len; ++idx)
			assertArrayEquals(expected[idx], matrix[idx]);
	}
}

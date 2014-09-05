import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(";");

			if (lineArray.length > 0) {
				int n = Integer.valueOf(lineArray[0]);

				String[] input = lineArray[1].split(",");

				int[][] sudokuGrid = createGrid(input, n);

				boolean isValid = checkGrid(sudokuGrid, n);

				if (isValid) {
					System.out.println("True");
				}
				else {
					System.out.println("False");
				}
			}
		}
	}

	private static int[][] createGrid(String[] input, int n) {
		int[][] sudokuGrid = new int[n][n];

		int totalCount = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sudokuGrid[i][j] = Integer.valueOf(input[totalCount]);

				totalCount++;
			}
		}

		return sudokuGrid;
	}

	private static boolean checkGrid(int[][] grid, int n) {
		for (int i = 0; i < n; i++) {
			if (!checkRow(grid, i, n) || !checkColumn(grid, i, n)) {
				return false;
			}
		}

		double squareSize = Math.sqrt(n);

		for (int i = 0; i < n; i += squareSize) {
			for (int j = 0; j < n; j += squareSize) {
				if (!checkSquares(grid, i, j, squareSize)) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean checkRow(int[][] grid, int row, int size) {
		boolean[] foundDigit = new boolean[size];

		for (int i = 0; i < size; i++) {
			if (foundDigit[grid[row][i] - 1]) {
				return false;
			}
			else {
				foundDigit[grid[row][i] - 1] = true;
			}
		}

		return true;
	}

	private static boolean checkColumn(int[][] grid, int column, int size) {
		boolean[] foundDigit = new boolean[size];

		for (int i = 0; i < size; i++) {
			if (foundDigit[grid[i][column] - 1]) {
				return false;
			}
			else {
				foundDigit[grid[i][column] - 1] = true;
			}
		}

		return true;
	}

	private static boolean checkSquares(int[][] grid, int row, int column, Double squareSize) {
		boolean[] foundDigit = new boolean[squareSize.intValue() * squareSize.intValue()];

		for (int i = row; i < (row + squareSize); i++) {
			for (int j = column; j < (column + squareSize); j++) {
				if (foundDigit[grid[i][j] - 1]) {
					return false;
				}
				else {
					foundDigit[grid[i][j] - 1] = true;
				}
			}
		}

		return true;
	}
}
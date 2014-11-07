import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		int[][] queryBoard = new int[_queryBoardSize][_queryBoardSize];

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			String operation = lineArray[0];

			if (lineArray.length > 0) {
				if (operation.equals(_queryColumn)) {
					System.out.println(queryColumn(queryBoard, Integer.parseInt(lineArray[1])));
				}
				else if (operation.equals(_queryRow)) {
					System.out.println(queryRow(queryBoard, Integer.parseInt(lineArray[1])));
				}
				else if (operation.equals(_setColumn)) {
					setColumn(queryBoard, Integer.parseInt(lineArray[1]), Integer.parseInt(lineArray[2]));
				}
				else if (operation.equals(_setRow)) {
					setRow(queryBoard, Integer.parseInt(lineArray[1]), Integer.parseInt(lineArray[2]));
				}
				else {
					System.out.println("Unknown operation: " + operation);
				}
			}
		}
	}

	private static int queryColumn(int[][] queryBoard, int column) {
		int totalSumOfRow = 0;

		for (int row = 0; row < _queryBoardSize; row++) {
			totalSumOfRow += queryBoard[row][column];
		}

		return totalSumOfRow;
	}

	private static int queryRow(int[][] queryBoard, int row) {
		int totalSumOfRow = 0;

		for (int column = 0; column < _queryBoardSize; column++) {
			totalSumOfRow += queryBoard[row][column];
		}

		return totalSumOfRow;
	}

	private static int[][] setColumn(int[][] queryBoard, int column, int value) {
		for (int row = 0; row < _queryBoardSize; row++) {
			queryBoard[row][column] = value;
		}

		return queryBoard;
	}

	private static int[][] setRow(int[][] queryBoard, int row, int value) {
		for (int column = 0; column < _queryBoardSize; column++) {
			queryBoard[row][column] = value;
		}

		return queryBoard;
	}

	private static final int _queryBoardSize = 256;

	private static final String _queryColumn = "QueryCol";
	private static final String _queryRow = "QueryRow";
	private static final String _setColumn = "SetCol";
	private static final String _setRow = "SetRow";
}
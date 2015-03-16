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

			int indexOfOpenParenthesis = lineArray[0].indexOf('(');
			int indexOfClosedParenthesis = lineArray[0].indexOf(')');

			String[] circleCoordinates = lineArray[0].substring(indexOfOpenParenthesis + 1, indexOfClosedParenthesis).split(", ");

			String radiusString = lineArray[1].split(": ")[1];

			indexOfOpenParenthesis = lineArray[2].indexOf('(');
			indexOfClosedParenthesis = lineArray[2].indexOf(')');

			String[] pointCoordinates = lineArray[2].substring(indexOfOpenParenthesis + 1, indexOfClosedParenthesis).split(", ");


			double centerX = Double.valueOf(circleCoordinates[0]);
			double centerY = Double.valueOf(circleCoordinates[1]);
			double radius = Double.valueOf(radiusString);
			double x = Double.valueOf(pointCoordinates[0]);
			double y = Double.valueOf(pointCoordinates[1]);

			double calculatedPoint = Math.pow((x - centerX), 2) + Math.pow((y - centerY), 2);

			if (calculatedPoint < Math.pow(radius, 2)) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		}
	}
}
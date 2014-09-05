import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(";");

			if (lineArray.length > 0) {
				List<Integer> distances = new ArrayList<Integer>();

				for (int i = 0; i < lineArray.length; i++) {
					String[] locationAndDistance = lineArray[i].split(",");

					distances.add(Integer.parseInt(locationAndDistance[1]));
				}

				Collections.sort(distances);

				int currentLocation = 0;

				StringBuilder sb = new StringBuilder(distances.size() * 2);

				for (int i = 0; i < distances.size(); i++) {
					int distance = distances.get(i) - currentLocation;

					currentLocation = distances.get(i);

					sb.append(distance);

					if (i != (distances.size() - 1)) {
						sb.append(",");
					}
				}

				System.out.println(sb.toString());
			}
		}
	}
}
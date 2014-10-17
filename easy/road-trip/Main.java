import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main (String[] args) throws IOException {
    	File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(";");

			if (lineArray.length > 0) {
				SortedSet<Integer> distances = new TreeSet<Integer>();

				for (int i = 0; i < lineArray.length; i++) {
					distances.add(Integer.parseInt(lineArray[i].split(",")[1]));
				}

				int currentLocation = 0;

				StringBuilder sb = new StringBuilder(distances.size() * 2);

				Iterator<Integer> iterator = distances.iterator();

				while (iterator.hasNext()) {
					int distanceToNextCity = iterator.next();

					sb.append(distanceToNextCity - currentLocation);

					currentLocation = distanceToNextCity;

					if (iterator.hasNext()) {
						sb.append(",");
					}
				}

				System.out.println(sb.toString());
			}
		}
	}
}
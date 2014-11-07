import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(";");

			if (lineArray.length > 0) {
				Map<String, String> nameAddressMap = new HashMap<String, String>();

				for (String s : lineArray) {
					String[] splitString = s.split("-");

					nameAddressMap.put(splitString[0], splitString[1]);
				}

				List<String> visitedAddress = new ArrayList<String>();

				boolean valid = false;

				String address = nameAddressMap.get("BEGIN");

				if (address.equals("END") && (nameAddressMap.size() == 1)) {
					valid = true;
				}
				else {
					while (address != null) {
						if (visitedAddress.contains(address)) {
							break;
						}

						visitedAddress.add(address);

						address = nameAddressMap.get(address);

						if (address == null) {
							break;
						}

						if (address.equals("END")) {
							if (visitedAddress.size() == (lineArray.length - 1)) {
								valid = true;
							}

							break;
						}
					}
				}

				if (valid) {
					System.out.println("GOOD");
				}
				else {
					System.out.println("BAD");
				}
			}
		}
	}
}
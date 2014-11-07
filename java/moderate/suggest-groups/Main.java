import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		List<String> userNames = new ArrayList<String>();

		Map<String, List<String>> userFriendsMap =
			new HashMap<String, List<String>>();

		Map<String, List<String>> userGroupMap =
			new HashMap<String, List<String>>();

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split(":");

			if (lineArray.length > 0) {
				String userName = lineArray[0];
				userNames.add(userName);

				String[] friends = lineArray[1].split(",");
				userFriendsMap.put(userName, Arrays.asList(friends));

				if (lineArray.length == 3) {
					String[] groups = lineArray[2].split(",");
					userGroupMap.put(userName, Arrays.asList(groups));
				}
			}
		}

		for (String userName : userNames) {
			List<String> friends = userFriendsMap.get(userName);

			double friendsNeeded = friends.size() / 2.0;

			List<String> groups = userGroupMap.get(userName);

			Map<String, Integer> suggestGroupsTally =
				new HashMap<String, Integer>();

			for (String friend : friends) {
				List<String> friendsGroups = userGroupMap.get(friend);

				if (friendsGroups != null) {
					for (String friendsGroup : friendsGroups) {
						if (groups == null || !groups.contains(friendsGroup)) {
							if (suggestGroupsTally.containsKey(friendsGroup)) {
								int tally = suggestGroupsTally.get(friendsGroup);

								suggestGroupsTally.put(friendsGroup, tally + 1);
							}
							else {
								suggestGroupsTally.put(friendsGroup, 1);
							}
						}
					}
				}
			}

			for (Map.Entry<String, Integer> entry : suggestGroupsTally.entrySet()) {
				if (entry.getValue() >= friendsNeeded) {
					System.out.println(entry.getKey());
				}
			}

			System.out.println();
		}
	}
}
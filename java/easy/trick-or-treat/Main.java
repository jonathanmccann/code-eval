import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			List<Integer> inputList = new ArrayList<>();

			Matcher matcher = _DIGIT_PATTERN.matcher(line);

			while (matcher.find()) {
				inputList.add(Integer.valueOf(matcher.group()));
			}

			int numberOfChildren = inputList.get(0) + inputList.get(1) + inputList.get(2);
			int numberOfCandy = inputList.get(3) * ((inputList.get(0) * VAMPIRE) + (inputList.get(1) * ZOMBIE) + (inputList.get(2) * WITCH));

			System.out.println(numberOfCandy / numberOfChildren);
		}
	}

	private static final int VAMPIRE = 3;
	private static final int WITCH = 5;
	private static final int ZOMBIE = 4;

	private static final Pattern _DIGIT_PATTERN = Pattern.compile("\\d+");

}
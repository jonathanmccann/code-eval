import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main (String[] args) throws IOException, ParseException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s+");

			if (lineArray.length > 0) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"HH:mm:ss");

				Date firstDate = simpleDateFormat.parse(lineArray[0]);
				Date secondDate = simpleDateFormat.parse(lineArray[1]);

				long firstDateTime = firstDate.getTime();
				long secondDateTime = secondDate.getTime();

				long differenceTime = firstDateTime - secondDateTime;

				if (differenceTime < 0) {
					differenceTime = differenceTime * -1;
				}

				long hours = TimeUnit.MILLISECONDS.toHours(differenceTime);
				long minutes = TimeUnit.MILLISECONDS.toMinutes(differenceTime) -
					TimeUnit.HOURS.toMinutes(hours);
				long seconds = TimeUnit.MILLISECONDS.toSeconds(differenceTime) -
					TimeUnit.MINUTES.toSeconds(
						TimeUnit.MILLISECONDS.toMinutes(differenceTime));

				String differenceTimeFormatted = String.format(
					"%02d:%02d:%02d", hours, minutes, seconds);

				System.out.println(differenceTimeFormatted);
			}
		}
	}
}
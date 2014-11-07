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
            String[] lineArray = line.split("\\s+");

    		if (lineArray.length > 0) {
				int A = Integer.valueOf(lineArray[0]);
				int B = Integer.valueOf(lineArray[1]);
				int N = Integer.valueOf(lineArray[2]);

				int[] convertedUserInput = {A, B, N};

                for (int i = 1; i <= convertedUserInput[2]; i++) {
					String output = "";

					if (i % convertedUserInput[0] == 0) {
						output += "F";
					}
					if (i % convertedUserInput[1] == 0) {
						output += "B";
					}
					if (output.length() == 0) {
						output = Integer.toString(i);
					}

					if ((i + 1) <= convertedUserInput[2]) {
						output += " ";
					}

					System.out.print(output);
				}

				System.out.println();
            }
        }
    }
}
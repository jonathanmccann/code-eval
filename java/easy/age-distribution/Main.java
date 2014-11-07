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
			int age = Integer.valueOf(line);

			if ((age < 0) || (age > 100)) {
				System.out.println("This program is for humans");
			}
			else if (age <= 2) {
				System.out.println("Still in Mama's arms");
			}
			else if (age <= 4) {
				System.out.println("Preschool Maniac");
			}
			else if (age <= 11) {
				System.out.println("Elementary school");
			}
			else if (age <= 14) {
				System.out.println("Middle school");
			}
			else if (age <= 18) {
				System.out.println("High school");
			}
			else if (age <= 22) {
				System.out.println("College");
			}
			else if (age <= 65) {
				System.out.println("Working for the man");
			}
			else {
				System.out.println("The Golden Years");
			}
		}
	}
}
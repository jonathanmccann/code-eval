public class Main {
    public static void main (String[] args) {
    	boolean isPrime = true;

        for (int i = 1000; i >= 0; i--) {
			for (int j = 2; j <= (i / 2); j++) {
				if (i % j == 0) {
					isPrime = false;
				}
			}

			if (isPrime) {
				String integer = String.valueOf(i);

				StringBuilder sb = new StringBuilder(integer);

				if (sb.reverse().toString().equals(integer)) {
					System.out.println(integer);

					break;
				}
			}

			isPrime = true;
		}
    }
}
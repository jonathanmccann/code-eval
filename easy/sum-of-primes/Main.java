public class Main {
    public static void main (String[] args) {
    	boolean isPrime = true;

		long sumOfPrimes = 2;
		long primeCandidate = 3;
		long counter = 1;

        while (counter < 1000) {
			for (int i = 2; i <= (primeCandidate / 2); i++) {
				if (primeCandidate % i == 0) {
					isPrime = false;
                    
                    break;
				}
			}

			if (isPrime) {
				sumOfPrimes += primeCandidate;

				counter++;
			}

			primeCandidate++;

			isPrime = true;
		}

		System.out.println(sumOfPrimes);
	}
}
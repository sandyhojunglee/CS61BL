public class SieveOfEratosthenes {

	public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You need to enter an argument!" +
                    "\nIn IntelliJ, you can do this by clicking on the button with \n`SieveOfEratosthenes` on it" +
                    " > `Edit Configurations...` " +
                    "and provide a number in the `Program arguments` box.");
            return;
        }
		String upperBound = args[0];
		boolean[] isNotPrime = new boolean[Integer.parseInt(upperBound)];
		for (int i = 0; i < upperBound.length(); i++) {
			if (isNotPrime[i]) {
				continue;
			} else {
				
			}
		}
		for (int i = 0; !(i > upperBound.length()); i++) {
			if (!isNotPrime[i]) {
				System.out.println(i + " is a prime number.");
			}
		}
	}
}

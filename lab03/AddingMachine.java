import java.util.*;

public class AddingMachine {

	private static void helperList(int[] carrier) {
		int ind = 0;
		while (ind < carrier.length) {
			System.out.println(carrier[ind]);
			ind++;
			if (carrier[ind] == 0) {
				break;
			}
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean isPreviousZero = false;
		int total = 0;
		int subtotal = 0;
		int input;
		int MAXIMUM_NUMBER_OF_INPUTS = 100;
		int[] listOfInputs = new int[MAXIMUM_NUMBER_OF_INPUTS];
		int index = 0;

		// TODO Add code anywhere below to complete AddingMachine
		while (true) {
			input = scanner.nextInt();
			if (input == 0) {
				if (isPreviousZero) {
					System.out.println("total " + total);
					helperList(listOfInputs);
					return;
				} else {
					System.out.println("subtotal " + subtotal);
					total += subtotal;
					subtotal = 0;
					isPreviousZero = true;
				}
			}
			subtotal += input;
			if (input != 0) {
				isPreviousZero = false;
				listOfInputs[index] = input;
				index++;
			}

		}
	}
}

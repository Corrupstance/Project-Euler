public class Q0034 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		int finalSum = 0;
		for (int i = 3; i < 1000000; i++) {
			String s = String.valueOf(i);
			int sum = 0;
			for (int j = 0; j < s.length(); j++) {
				int digit = Character.getNumericValue(s.charAt(j));
				sum += factorial(digit);
			}
			if (sum == i) finalSum+=i;
		}
		return finalSum;
	}



}
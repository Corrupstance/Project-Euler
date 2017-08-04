public class Q0052 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static long solve() {
		long i = 0;
		while (true) {
			i++;
			if (isPermutation(String.valueOf(i),String.valueOf(2 * i)) && isPermutation(String.valueOf(i),String.valueOf(3 * i)) && isPermutation(String.valueOf(i),String.valueOf(4 * i)) && isPermutation(String.valueOf(i),String.valueOf(5 * i)) && isPermutation(String.valueOf(i),String.valueOf(6 * i))) {
				return i;
			}
		}
	}


}
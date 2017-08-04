import java.math.BigInteger;

public class Q0063 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		
		/*
		 * Consider expressions of the form i^j.
		 * Note that 1 <= i <= 9, because if i > 9 (e.g. i = 10) then 10^n has n+1 digits, so certainly x^n for x > 9 has 
		 * at least n+1 digits. For j, there always exist a integer s at which i^n has less than n digits. This is because
		 * for 1 <= i <= 9, multiplying i^n by i does not guarantee an extra digit. Additionally, note that
		 * s should increase for increasing values of i, since the 'chance' of getting an extra digit from multiplying by 9 is larger than multiplying by 2. 
		 * We manually check that for 9^n the stopping value s is 22, so we loop j from 1 <= j <= 21.
		 */

		int counter = 0;

		for (int j = 1; j <= 21; j++) {
			for (int i = 1; i <= 9; i++) {
				if (String.valueOf(new BigInteger(String.valueOf(i)).pow(j)).length() == j) counter++;
			}
		}
		return counter;
	}
}
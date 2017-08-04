import java.math.BigInteger;

public class Q0055 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		int counter = 0;
		
		for (int i = 0; i < 10000; i++) {
			String s = String.valueOf(i);
			for (int j = 0; j < 49; j++) {
				String r = reverse(s);
				BigInteger sum = new BigInteger(s).add(new BigInteger(r));
				s = sum.toString();
				if (palindrome(s)) {
					counter++;
					break;
				}
			}
		}
		
		return 10000 - counter;
	}
	
	
	
}
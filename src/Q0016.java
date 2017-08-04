import java.math.BigInteger;

public class Q0016 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static long solve() {
		BigInteger b = new BigInteger("2");
		BigInteger bpow = b.pow(1000);
		long sum = 0;
		String s = String.valueOf(bpow);
		for (int i = 0; i < s.length(); i++) {
			sum += Character.getNumericValue(s.charAt(i));
		}
		return sum;
	}
	
	
	
}
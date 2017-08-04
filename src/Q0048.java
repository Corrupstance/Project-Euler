import java.math.BigInteger;

public class Q0048 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static String solve() {
		BigInteger s = BigInteger.ZERO;
		BigInteger count = BigInteger.ONE;
		BigInteger total = BigInteger.ZERO;

		for (int i = 1; i <= 1000; i++) {
			s = count.pow(i);
			count = count.add(new BigInteger("1"));
			total = total.add(s);
		}
		return total.toString().substring(2991);
	}



}
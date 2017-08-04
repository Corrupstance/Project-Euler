import java.math.BigInteger;

public class Q0025 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static long solve() {
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		long i = 2;
		while (true) {
			i++;
			BigInteger c = a.add(b);
			a = b;
			b = c;
			String s = String.valueOf(c);
			int length = s.length();
			if (length == 1000) return i;
		}
	}




}
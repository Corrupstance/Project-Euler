import java.math.BigInteger;

public class Q0104 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		BigInteger c = BigInteger.ZERO;

		int i = 2749;

		for (int j = 1; j < i; j++) {
			c = a.add(b);
			a = b;
			b = c;
		}

		while (true) {
			i++;
			c = a.add(b);
			a = b;
			b = c;
			if (onePandigitalBig(c.mod(new BigInteger("1000000000")).toString())) {
				String s = c.toString();
				if (onePandigitalBig(s.substring(0, 9))) break;
			}
			
		}

		return i+1;

	}
	
	public static boolean onePandigitalBig(String s) {
		boolean[] arr = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int digit = Integer.valueOf(s.substring(i, i+1));
			if (digit > s.length() || digit == 0) break;
			arr[digit - 1] = true;
		}
		for (int j = 0; j < s.length(); j++) {
			if (!arr[j]) return false;
		}
		return true;

	}





}
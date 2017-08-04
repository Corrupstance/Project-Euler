import java.math.BigInteger;

public class Q0065 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		
		/*
		 * Upon abit of investigation it is easy to note that since
		 * e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...]
		 * 8 = 3*2 + 2;
		 * 11 = 8*1 + 3;
		 * 19 = 11*1 + 8;
		 * 87 = 19*4 + 11;
		 * 106 = 87*1 + 19;
		 * 
		 * so e_k = a_k * e_{k-1} + e_{k-2}, where the sequence a_k = {2,1,1,4,1,1,6,1,...} for k > 2.
		 */
		
		BigInteger a = new BigInteger("2");
		BigInteger b = new BigInteger("3");
		for (int k = 3; k <= 100; k++) {
			BigInteger e = BigInteger.ZERO;
			if (k % 3 == 0) e = b.multiply(new BigInteger(String.valueOf(2 * (k	 / 3)))).add(a);
			else e = b.add(a);
			a = b;
			b = e;
		}
		String s = b.toString();
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += Integer.valueOf(s.substring(i,i+1));
		}
		return sum;
		
	}
	
	
	
}
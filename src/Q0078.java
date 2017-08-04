import java.math.BigInteger;

public class Q0078 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		BigInteger[] arr = new BigInteger[60001];
		arr[0] = BigInteger.ONE;
		
		for (int i = 1; i <= 60000; i++) {
			for (int j = i; j <= 60000; j++) {
				if (arr[j] != null) arr[j] = arr[j].add(arr[j - i]);
				else arr[j] = BigInteger.ZERO.add(arr[j - i]);
			}
			if (arr[i].mod(new BigInteger("1000000")).equals(BigInteger.ZERO)) {
				return i;
			}
		}
		return -1;
	}
}

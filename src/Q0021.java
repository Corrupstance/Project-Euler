import java.math.BigInteger;
import java.util.ArrayList;

public class Q0021 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static BigInteger solve() {
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		list.add(BigInteger.ONE); //Filler for list(0)
		list.add(BigInteger.ONE); //Filler for list(1)
		
		BigInteger sum = BigInteger.ONE;
		for (int i = 2; i < 10000; i++) {
			sum = BigInteger.ONE;
			for (int j = 2; j < Math.floor(Math.sqrt(i)) + 1; j++) {
				if (i % j == 0) {
					sum = sum.add(new BigInteger(String.valueOf(j)));
					sum = sum.add(new BigInteger(String.valueOf(i/j)));
				}		
			}
			list.add(sum);		
		}
		
		BigInteger finalSum = BigInteger.ZERO;
		for (int i = 2; i < 10000; i++) {
			for (int j = 2; j < 10000; j++) {
				if (list.get(i).equals(new BigInteger(String.valueOf(j))) && list.get(j).equals(new BigInteger(String.valueOf(i))) && i != j) {
					finalSum = finalSum.add(new BigInteger(String.valueOf(j)));
				}
			}
		}
		return finalSum;
	}
	
	
	
	
}
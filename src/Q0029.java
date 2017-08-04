import java.math.BigInteger;
import java.util.ArrayList;

public class Q0029 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
			
		  for(int a = 2; a <= 100; a++) {
		      for(int b = 2; b <= 100; b++) {
				BigInteger c = BigInteger.valueOf(a).pow(b);
				if(!list.contains(c)) list.add(c);
			}
		}
		return list.size();
	}



}
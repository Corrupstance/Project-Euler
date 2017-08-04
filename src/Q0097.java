import java.math.BigInteger;

public class Q0097 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static BigInteger solve() {
		BigInteger i = new BigInteger("28433");
		BigInteger j = new BigInteger("2").pow(7830457);
		BigInteger p = i.multiply(j).add(BigInteger.ONE);
		return p.mod(new BigInteger("10000000000"));
	}
	
	
}
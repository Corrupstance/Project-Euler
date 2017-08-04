public class Q0010 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static long solve() {
		long sum = 0;
		int end = 2000000;
		boolean[] prime = primeSieve(end);
		for (int i = 0; i < end; i++) {
			if(prime[i]) sum+=i;
		}
		return sum;
	}
}
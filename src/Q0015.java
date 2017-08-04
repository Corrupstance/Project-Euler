public class Q0015 extends Library {
	
	/*
	 * There are 40 choices of right and down, and we need to choose 20 down/20 right. So we have
	 * 40 choose 20 * 20 choose 20 = 137846528820.
	 */
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static long solve() {
		double fac = 1;
		for (int i = 1; i <= 20; i++) {
			double prod = (double) (i + 20)/i;
			fac *= prod;
		}
		return (long) Math.round(fac);
	}
	
	
}
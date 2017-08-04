public class Q0071 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		int p = 0;
		int q = 1;
		for (int d = 0; d <= 1000000; d++) {
		    int n = (3 * d - 1) / 7;
		    if (n * q > p * d) {
		        p = n;
		        q = d;
		    }
		}
		return p;
	}
	
	
	
	
}
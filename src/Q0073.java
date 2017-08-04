import java.util.HashSet;

public class Q0073 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		HashSet<Double> set = new HashSet<Double>();
		for (int d = 2; d <= 12000; d++) {
			for (int n = 1; n < d; n++) {
				if (2 * n < d && d < 3 * n) set.add(((double) n)/d);
			}
		}
		return set.size();
	}
	
	
}
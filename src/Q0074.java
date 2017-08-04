import java.util.ArrayList;

public class Q0074 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		int total = 0;
		ArrayList<Long> list = new ArrayList<Long>();

		for (int i = 1; i < 1000000; i++) {
			list.clear();
			String s = String.valueOf(i);
			for (int j = 0; j < 60; j++) {
				long sum = 0;
				for (int k = 0; k < s.length(); k++) {
					sum += factorial(Integer.valueOf(s.substring(k,k+1)));
				}
				if (list.contains(sum)) break;
				else {
					list.add(sum);
					s = String.valueOf(sum);
				}
			}
			if (list.size() == 59) total++;
		}
		return total;
	}
	
}
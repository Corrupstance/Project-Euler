import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Q0075 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		/*
		 * Dickson's method. Need to optimize for solution to be under 1 min. A quick check shows that r <= 300000 encompasses
		 * all the solutions for p <= 1500000.
		 */

		int max = 1500000;
		int count = 0;
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		for (long r = 0; r <= 300000; r+=2) {
			long rSq = (r * r)/2;
			ArrayList<Long> div = divisorsL(rSq);
			for (int i = 0; i < div.size()/2; i++) {
				long s = div.get(i);
				long t = div.get(div.size() - i - 1);
				long a = r + s;
				long b = r + t;
				long c = r + s + t;
				long p = a + b + c;
				if (p <= max) {
					if (!map.containsKey(p)) map.put(p, 1);
					else map.put(p, map.get(p) + 1);
				}
			}
			System.out.println(r);
		}

		for (Entry<Long, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) count++;
		}
		return count;
	}



}
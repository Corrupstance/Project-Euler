import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Q0087 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {

		/*
		 * Since sqrt(50000000) < 7072, the largest prime we need is 7071. Only thing worth of note is that
		 * we had to use a set at the end, since the contains method is much slower in ArrayList.
		 */

		boolean[] prime = primeSieve(7071);
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		ArrayList<Long> primeList2 = new ArrayList<Long>();
		ArrayList<Long> primeList3 = new ArrayList<Long>();
		ArrayList<Long> primeList4 = new ArrayList<Long>();

		for (int i = 0; i < prime.length; i++) {
			if (prime[i]) primeList.add(i);
		}

		for (int i = 0; i < primeList.size(); i++) {
			if ((long) primeList.get(i) * primeList.get(i) < 50000000) 
				primeList2.add((long) primeList.get(i) * primeList.get(i));
			if ((long) primeList.get(i) * primeList.get(i) * primeList.get(i) < 50000000) 
				primeList3.add((long) primeList.get(i) * primeList.get(i) * primeList.get(i));
			if ((long) primeList.get(i) * primeList.get(i) * primeList.get(i) * primeList.get(i) < 50000000) 
				primeList4.add((long) primeList.get(i) * primeList.get(i) * primeList.get(i) * primeList.get(i));
		}

		Set<Long> powsumSet = new HashSet<Long>();
		for (int i = 0; i < primeList2.size(); i++) {
			for (int j = 0; j < primeList3.size(); j++) {
				for (int k = 0; k < primeList4.size(); k++) {
					long powsum = primeList2.get(i) + primeList3.get(j) + primeList4.get(k);
					if (powsum > 50000000) break;
					powsumSet.add(powsum);
				}
			}
		}
		return powsumSet.size();
	}

}
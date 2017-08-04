import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Q0062 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static BigInteger solve() {

		/*
		 * Use a HashMap to store:
		 * key k such that k^3 is the cube to check.
		 * val m such that m is the number of permutations that have been iterated.
		 * 
		 * Now all we have to do is to check increasing values of k^3 which are
		 * permutations of the stored keys^3. If they are, increment value 
		 * and when it reaches 5, stop.
		 */

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i = 345;

		while (true) {
			BigInteger cube = new BigInteger(String.valueOf(i)).pow(3);
			map.put(i, 0);
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				int key = entry.getKey();
				int value = entry.getValue();
				BigInteger keycube = new BigInteger(String.valueOf(key)).pow(3);
				if (isPermutation(String.valueOf(cube),String.valueOf(keycube))) map.put(key, map.get(key) + 1);  
				if (value == 5) return new BigInteger(String.valueOf(key)).pow(3);
			}
			i++;
		}
	}


}
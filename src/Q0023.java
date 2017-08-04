import java.math.BigInteger;
import java.util.ArrayList;

public class Q0023 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean[] twoAbundant = new boolean[28124];
		int sum = 0;

		for (int i = 1; i <= 28123; i++) {
			if (sumDivisors(i).compareTo(new BigInteger(String.valueOf(i))) > 0) list.add(i); 
		}

		for (int j = 0; j < list.size(); j++) {
			for (int k = j; k < list.size(); k++) {
				if (list.get(j) + list.get(k) > 28123) break; 
				twoAbundant[list.get(j) + list.get(k)] = true;
			}
		}

		for (int z = 1; z <= 28123; z++) {
			if (!twoAbundant[z]) sum+=z;
		}

		return sum;
	}
}



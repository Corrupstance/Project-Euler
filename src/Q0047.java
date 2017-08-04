import java.util.ArrayList;

public class Q0047 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		boolean[] prime = primeSieve(1000000);
		for (int i = 0; i < 999997; i++) {
			ArrayList<Integer> conseqDiv = new ArrayList<Integer>();
			for (int j = i; j < 4 + i; j++) {
				ArrayList<Integer> div = divisors(j);
				for (int k = 0; k < div.size(); k++) {
					if (prime[div.get(k)]) conseqDiv.add(div.get(k));
				}
			}
			if (conseqDiv.size() == 16) return i;
		}
		return -1;
	}



}
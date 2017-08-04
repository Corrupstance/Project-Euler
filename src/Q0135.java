public class Q0135 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {

		/*
		 * A quick observation is that since x,y,z are in an arithmetic progression,
		 * x = z + 2d, y = z + d
		 * (z + 2d)^2 - (z + d)^2 + z^2 = 2dz + 3d^2 - z^2 = n
		 * 
		 * Notice that 
		 * 3d^2 + 2dz - z^2 = (3d - z)(d + z) = 0 occurs at 3d = z, so we loop d from z/3 + 1 to end.
		 * 
		 * We still need the if (n < 0) break; condition since we will encounter integer overflow.
 		 */

		int end = 1000000;
		int counter = 0;
		int[] arr = new int[end];

		for (int z = 1; z < end; z++) {
			for (int d = z/3 + 1; d < end; d++) {
				int n = 2 * d * z + 3 * d * d - z * z;
				if (n < 0) break;
				if (n < end) arr[n]++;
			}
		}
		for (int i = 1; i < end; i++) {
			if (arr[i] == 10) counter++;
		}
		return counter;
	}




}
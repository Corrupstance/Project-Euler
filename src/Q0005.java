public class Q0005 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static long solve() {
		int i = 20;
		while (true) {
			boolean b = true;
			for (int j = 10; j < 21; j++) {
				if (i % j != 0) {
					b = false;
					break;
				}
			}
			if (b) return i;
			i+=20;
		}
	}


}
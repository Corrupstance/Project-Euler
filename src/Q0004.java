public class Q0004 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		int max = 0;
		for (int i = 1; i <= 999; i++) {
			for (int j = 1; j <= 999; j++) {
				int pal = i * j;
				String s = String.valueOf(pal);
				boolean b = true;
				int length = s.length();
				for (int k = 0; k < length; k++) {
					if (s.charAt(k) != s.charAt(length - k - 1)) b = false;
				}
				if (b && pal > max) max = pal; 
			}
		}
		return max;
	}




}
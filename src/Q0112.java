public class Q0112 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		int n = 0;
		int counter = 0;
		while(true) {
			n++;
			boolean inc = false;
			boolean dec = false;
			String s = String.valueOf(n);
			if (s.length() == 1) continue;
			for (int i = 0; i < s.length() - 1; i++) {
				if (Integer.valueOf(s.substring(i,i+1)) > Integer.valueOf(s.substring(i+1,i+2))) dec = true;
				if (Integer.valueOf(s.substring(i,i+1)) < Integer.valueOf(s.substring(i+1,i+2))) inc = true;
			}
			if (dec && inc) counter++;
			if ((double) counter/n == 0.99) return n;	
		}
	}
	
	
	
	
}
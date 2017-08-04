public class Q0045 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		/*
		 * My first thought was to generate triangle, pentagonal and hexagonal arrays and brute-force the solution.
		 * Unfortunately this took too over a minute, so this solution was abandoned. Instead we find the inverse of
		 * the pentagonal function:
		 * 
		 * P = n(3n-1)/2
		 * 2P = 3n^2 - n
		 * 24P + 1 = 36n^2 - 12n + 1
		 * 24P + 1 = (6n-1)^2
		 * n = [sqrt(24P + 1) + 1]/6 
		 * 
		 * so if n is a natrual number then P is the n^th pentagonal number.
		 * 
		 * The second thing to note is that every hexagonal number is a triangle number, and that every odd triangle
		 * number is a hexagonal number (substitute an odd number into the triangle number formula). So we check all 
		 * odd n after 143 for which hexagonal(n) is also pentagonal.
		 * 
		 */
		
		int n = 145;
		while (true) {
			long hex = hexagonal(n);
			if (isPentagonal(hex) > 0) {
				return n;
			}
			n += 2;
		}

	}



}
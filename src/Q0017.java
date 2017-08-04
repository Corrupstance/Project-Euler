public class Q0017 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		
		/* Need to account for:
		 * 1000 = one thousand (10 extra)
		 * 11 = eleven | ten one (1 extra)
		 * 12 = twelve | ten two (1 extra)
		 * 13 = thirteen | ten three (0 extra)
		 * 14 = fourteen | ten four (1 extra)
		 * 15 = fifteen | ten five (0 extra)
		 * 16 = sixteen | ten six (1 extra)
		 * 17 = seventeen | ten seven (1 extra)
		 * 18 = eighteen | ten eight (1 extra)
		 * 19 = nineteen | ten nine (1 extra)
		 * and repeated for 111, 112, ... , 119. So extra 24 extra characters to add.
		 */

		String[] ones  = {"one","two","three","four","five","six","seven","eight","nine"};
		String[] tens = {"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		int sum = 24; 

		for (int i = 1; i < 1000; i++) {
			if 	(String.valueOf(i).length() == 1) sum += ones[i - 1].length();
			if 	(String.valueOf(i).length() == 2) {
				sum += tens[Integer.valueOf(String.valueOf(i).substring(0,1)) - 1].length();
				if (Integer.valueOf(String.valueOf(i).substring(1,2)) != 0) sum += ones[Integer.valueOf(String.valueOf(i).substring(1,2)) - 1].length();
			}
			if 	(String.valueOf(i).length() == 3) {
				sum += 10;
				sum += ones[Integer.valueOf(String.valueOf(i).substring(0,1)) - 1].length();
				if (Integer.valueOf(String.valueOf(i).substring(1,2)) != 0) sum += tens[Integer.valueOf(String.valueOf(i).substring(1,2)) - 1].length();
				if (Integer.valueOf(String.valueOf(i).substring(2,3)) != 0) sum += ones[Integer.valueOf(String.valueOf(i).substring(2,3)) - 1].length();	
			}
		}
		return sum;

	}

}
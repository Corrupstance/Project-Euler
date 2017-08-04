import java.util.ArrayList;

public class Q0032 extends Library {
	
	/*
	 * This program checks the digits of i, j and i*j to make sure they are all different. Since
	 * we require a 9 digit number, we can only have a * bcde = fghi or ab * cde = fghi; in particular
	 * we can break if i*j >= 10000.
	 */


	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		int sum = 0;
		boolean[] digits = new boolean[10];
		int counter = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i < 10000; i++) {
			for (int j = 1; j < 10000; j++) {
				if (i * j >= 10000) break;
				
				String iStr = String.valueOf(i);
				for (int indexI = 0; indexI < iStr.length(); indexI++) {
					int digit_I = Integer.valueOf(iStr.substring(indexI,indexI+1));
					if (!digits[digit_I] && digit_I != 0) {
						digits[digit_I] = true;
						counter++;
					}
				}		

				String jStr = String.valueOf(j);
				for (int indexJ = 0; indexJ < jStr.length(); indexJ++) {
					int digit_J = Integer.valueOf(jStr.substring(indexJ,indexJ+1));
					if (!digits[digit_J] && digit_J != 0) {
						digits[digit_J] = true;
						counter++;
					}
				}

				String prodStr = String.valueOf(i*j);
				for (int k = 0; k < prodStr.length(); k++) {
					int digit_Prod = Integer.valueOf(prodStr.substring(k,k+1));
					if (!digits[digit_Prod] && digit_Prod != 0) {
						digits[digit_Prod] = true;
						counter++;
					}

				}
				
				if (counter == 9 && !list.contains(i*j)) {
					list.add(i*j);
					sum += i*j;
				}
				
				counter = 0;
				digits = new boolean[10];
			}
		}
		return sum;
	}



}
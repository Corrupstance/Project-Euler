public class Q0091 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {

		int count = 0;
		int maxL = 50;
		
		/*
		 * We can apply Pythagoras's Theorem repeatedly to check 50^4 cases.
		 */

		for(int a = 0; a <= maxL; a++) {
			for (int b = 0; b <= maxL; b++) {
				for (int c = 0; c <= maxL; c++) {
					for (int d = 0; d <= maxL; d++) {
						if ((a != 0 || b != 0) && (c != 0 || d != 0) && (a != c || b != d)) {
							double OP = a * a + b * b;
							double OQ = c * c + d * d;
							double PQ = (c-a)*(c-a) + (d-b)*(d-b);
							double max = max(OP,OQ,PQ);
							if (max == PQ && OP + OQ  == PQ) count++; 
							else if (max == OQ && OP + PQ  == OQ) count++; 
							else if (max == OP && OQ + PQ == OP ) count++;
						}
					}
				}
			}
		}

		return count/2; //Symmetry between P and Q.
	}
	
	public static double max(double i, double j, double k) {
		double max1 = 0;
		double max2 = 0;
		if (i > j) max1 = i;
		else max1 = j;		
		if (max1 > k) max2 = max1;
		else max2 = k;
		return max2;
	}


}
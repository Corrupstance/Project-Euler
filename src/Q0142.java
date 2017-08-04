public class Q0142 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	

	public static long solve() {
		
		/*
		 * x + y = a^2
		 * x - y = b^2 
		 * x + z = c^2
		 * x - z = d^2
		 * y + z = e^2
		 * y - z = f^2
		 * 
		 * (x - y) + (y - z) = x - z => b^2 + f^2 = d^2 => f^2 = d^2 - b^2 = d^2 - c^2 + e^2.
		 * (x + y) - (y + z) = x - z => d^2 + e^2 = a^2 => a^2 = d^2 + e^2
		 * (x + z) - (y + z) = x - y => b^2 + e^2 = c^2 => b^2 = c^2 - e^2
		 * 
		 * x = (a^2 + b^2)/2  
		 * y = (e^2 + f^2)/2
		 * z = (c^2 - d^2)/2
		 * 
		 * Notice that c, d must have the same parity, since z is even. We have found all equations in terms of c,d,e, so 
		 * we loop over c,d,e.
		 * 
		 */

		long end = 10000000;
		for (long c = 0; c < end; c++) {
			long cSq = c * c;
			for (long e = 0; e < c; e++) {
				long eSq = e * e;
				long bSq = cSq - eSq;
				if (isSquare(bSq)) {
					for (long d = c % 2; d < e; d+=2) {
						long dSq = d * d;
						long aSq = dSq + eSq;
						if (!isSquare(aSq)) continue;
						long fSq = aSq - cSq;
						if (!isSquare(fSq)) continue;
						if (bSq > 0 && fSq > 0) {
							long x = (aSq + bSq)/2;
							long y = (eSq + fSq)/2;
							long z = (cSq - dSq)/2;
							return x + y + z;
						}
					}
				}
			}
		}
		return -1;
	}

	public static boolean isSquare(long n) {
		if ((long) Math.sqrt(n) == Math.sqrt(n)) return true;
        return false;
	} 





}
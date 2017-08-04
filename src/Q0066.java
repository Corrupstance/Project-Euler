public class Q0066 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		
		 
		/*
		 * Currently not under 1 min. Need to use another method; I highly doubt there will be a brute force
		 * method that can be optimized to run under 1 min.
		 */

		int maxX = 0;
		int index = 0;

		for (int D = 1; D <= 1000; D++) {
			if (Math.sqrt(D) != Math.floor(Math.sqrt(D))) {
				int x = 1;
				int y = 1;
				while (true) {
					if (x * x - D * y * y == 1) {
						if (x > maxX) {
							maxX = x;
							index = D;
							//System.out.println(x + " : " + y + " : " + D);
							break;
						}
						else break;
					}
					else if (x * x - D * y * y > 1) y++;
					else if (x * x - D * y * y < 1) x++;
					
				}
			}
		}
		return index;
		//long stopTime = System.currentTimeMillis();
	    //long elapsedTime = stopTime - startTime;
	    //System.out.println(elapsedTime);
	}




}
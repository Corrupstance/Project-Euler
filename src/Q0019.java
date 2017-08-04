public class Q0019 extends Library {

	/*
	 * Gauss Algorithm:
	 * https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week
	 */

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		int count = 0;

		/*
		 * Y is the year minus 1 for January or February, and the year for any other month
		 * y is the last 2 digits of Y
		 * c is the first 2 digits of Y
		 * d is the day of the month (1 to 31)
		 * m is the shifted month; March = 1, April = 2
		 * w is the day of the week; Sunday = 0
		 * Note that for the loop counter, we don't need to start from Jan 
		 * as long as we run through every single month of the year.
		 */

		for (int m = 1; m <= 12; m++)	{
			for (int Y = 1901; Y <= 2000; Y++) {
				int d = 1;
				int c = Integer.valueOf(String.valueOf(Y).substring(0, 2));
				int y = Integer.valueOf(String.valueOf(Y).substring(2, 4));
				int w = 0;
				
				if (m == 12 || m == 11) 
					w = (int) ((d + Math.floor(2.6 * m-0.2) + y + Math.floor((y-1)/4) + Math.floor(c/4) - 2 * c) % 7);
				else 
					w = (int) ((d + Math.floor(2.6 * m-0.2) + y + Math.floor(y/4) + Math.floor(c/4) - 2 * c) % 7);
				
				if (w < 0) 
					w += 7;
				if (w == 0) 
					count++;
			}

		}
		return count;
	}
}



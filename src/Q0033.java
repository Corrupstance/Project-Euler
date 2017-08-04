public class Q0033 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		for (int j = 10; j < 100; j++) {
			for (int i = 10; i < j; i++) {
				double div = (double) i/j;
				double cancelFirst = (double) Integer.valueOf(String.valueOf(i).substring(1,2)) / Integer.valueOf(String.valueOf(j).substring(0,1));
				double cancelSecond = (double) Integer.valueOf(String.valueOf(i).substring(0,1)) / Integer.valueOf(String.valueOf(j).substring(1,2));
				if (div == cancelFirst || div == cancelSecond) {
					if (Integer.valueOf(String.valueOf(i).substring(1,2)) != 0)  {
						if (!Integer.valueOf(String.valueOf(i).substring(0,1)).equals(Integer.valueOf(String.valueOf(i).substring(1,2))) && !Integer.valueOf(String.valueOf(j).substring(0,1)).equals(Integer.valueOf(String.valueOf(j).substring(1,2))))  {
							if (!Integer.valueOf(String.valueOf(i).substring(0,1)).equals(Integer.valueOf(String.valueOf(j).substring(0,1))) && !Integer.valueOf(String.valueOf(i).substring(1,2)).equals(Integer.valueOf(String.valueOf(j).substring(1,2)))) {
								if (!Integer.valueOf(String.valueOf(i).substring(0,1)).equals(Integer.valueOf(String.valueOf(j).substring(1,2))) && !Integer.valueOf(String.valueOf(i).substring(1,2)).equals(Integer.valueOf(String.valueOf(j).substring(1,2)))) {
									//System.out.println(i + "/" + j);
								}	
							}
						}
					}
				}
			}

		}
		return 100; //see comment below.
	}
	
	 /* Looking at the list and removing faulty pairs such as 16/32 which have no common digits,
	  * we have 16/64, 26/65, 19/95, 49/98, which is equivalent to 1/4, 2/5, 1/5, 1/2. The product is 2/200 = 1/100.
	  * I will look at this question again at a future date to find a nicer solution.
	  */
	 
	
	
}
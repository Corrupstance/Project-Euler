public class Q0031 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		/*
		 * Dynamic Programming: Answer a simpler problem; how many ways are there to break down 15p into 1,2,5p?
		 * 
		 * 1p coin + coins to make 14p
		 * 2p coin + coins to make 13p
		 * 5p coin + coins to make 10p
		 * 
		 * and this breaks down into further problems; how many ways are there of making 14p, 13p and 10p? For
		 * 19p there are
		 * 
		 * 1p coin + coins to make 13p
		 * 2p coin + coins to make 12p
		 * 5p coin + coins to make 9p
		 * 
		 * etc and the problem repeatedly breaks down. In particular this means arr[j] += arr[j - coins[i]];
		 * with the default being arr[0] = 1, since there is 1 way make to 0p. 
		 */

		int[] arr = new int[201];
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
		arr[0] = 1;
		
		for (int i = 0; i < coins.length; i++) {
		    for (int j = coins[i]; j <= 200; j++) {
		        arr[j] += arr[j - coins[i]];
		    }
		}
		return arr[200];
	}



}
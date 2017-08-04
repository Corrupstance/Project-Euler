public class Q0079 extends Library {
	
	/*
	 * You don't need to program anything for this. Since the password is always asked in order we can easily establish
	 * orderings by searching pairs ab, where 1 <= a,b <= 9. If ab appears on the list then we know that a must
	 * appear before b. Since there are less than 81 one pairs to check we can easily do this by hand, and one
	 * quickly sees that the order follows 7 > 3 > 1 > 6 > 2 > 8 > 9 > 0
	 * so the shortest password is 73162890.
	 */
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		return 73162890;
	}
	
}
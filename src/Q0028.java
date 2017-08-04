public class Q0028 extends Library {

	/*
	 * For an (2n+1) x (2n+1) spiral;
	 * Top right corner:	n^2
	 * Top left corner:		n^2 - n + 1
	 * Bottom left corner:  n^2 - 2n + 2
	 * Bottom right corner: n^2 - 3n + 3	
	 * Sum:	4n^2 - 6n + 6	
	 */	

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		int sum = 1;		//	middle = 1
		for (int i = 3; i <= 1001; i+=2) {
			sum += 4 * i * i - 6 * i + 6;
		}
		return sum;
	}
}
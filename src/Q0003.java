public class Q0003 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static long solve() {
		long max = 0;
        long m = 600851475143L;
        for (long n = 3; n <= m; n += 2) {
            while (m % n == 0) {
                max = n;
                m = m / n;
            }
        }
        return max;
    }
        
}
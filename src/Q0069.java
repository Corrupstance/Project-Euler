public class Q0069 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		
		/*
		 * Note that the totient function can be written as the product of phi(n) = n * prod(p-1/p) for each p such that
		 * p is a prime divisor of n. In particular this means to maximise n/phi(n), we have to maximise
		 * n/phi(n) = n/n * prod(p-1/p) = 1/prod(p-1/p), which is equivalent to minimising prod(p-1/p). Since p-1/p < 1
		 * for every prime p, we have to find the number with the maximum number of prime divisors under 1 million.
		 * In particular this number will be the product of the smallest primes, i.e. since if a,b are primes but b > a
		 * then b-1/b > a-1/a.
		 * 
		 * N.B. I initially tried to brute force the solution by generating phi(n) for n <= 10000000, but the execution time
		 * took far too long (> 5 minutes and I don't think it ever finished).
		 */
		
		boolean[] prime = primeSieve(1000000);
		int prod = 1;
		int i = 1;
		
		while(prod * i	< 1000000) {
			if (prime[i]) prod *= i;	
			i++;
		}
		return prod;
	}
	
	
	
}
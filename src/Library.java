import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.math.BigInteger;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Library {

	static char[] bigalpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	/*
	 * public static int[][] txtTo2DArray(int m, int n, String input) throws FileNotFoundException
	 * FUNCTION: Converts information from txt file to 2D array.
	 * @param int m - number of rows. 
	 * @param int n - number of columns.
	 * @param String input - file path of txt.file 
	 */

	public static int[][] txtTo2DArray(int m, int n, String input) throws FileNotFoundException {

		int[][] arr = new int[m][n];
		Scanner scanner = new Scanner(new BufferedReader(new FileReader(input)));
		int i = 0;

		while(scanner.hasNextLine()) {
			String line = scanner.nextLine(); 
			String[] num = line.split(","); 
			//System.out.println(line);
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(num[j]); 
			}
			i++;
		}
		scanner.close();
		return arr;
	}

	/*
	 * public static int/BigInteger factorial(int n)
	 * USE: Computes n!
	 * INPUTS: int n.
	 */

	public static int factorial(int n) {
		int prod = 1;
		for (int i = 2; i <= n; i++) {
			prod *= i;
		}
		return prod;
	}

	/*
	 * FUNCTION: public static void primeSieve(int n)
	 * USE: Eratosthenes's prime sieve up to n.
	 * INPUTS: n = stopping index.
	 * OUTPUT: Boolean array with true entries where prime.
	 */

	public static boolean[] primeSieve(int n) {
		boolean[] prime = new boolean[n + 1];
		for (int i = 2; i < n; i++) {
			prime[i] = true;
		}

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * 2; i <= n; i += p)
					prime[i] = false;
			}
		}
		return prime;
	}

	public static ArrayList<Integer> primeList(int end) {
		boolean[] prime = primeSieve(end);
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		primeList.add(2);
		for(int i = 3; i < end; i+=2) {
			if (prime[i]) primeList.add(i);
		}
		return primeList;
	}

	/*
	 * FUNCTION: public static Integer[] divisors(int n)
	 * USE: Finds all the PROPER divisors of natural number n.
	 * INPUTS: n = stopping index.
	 */

	public static ArrayList<Integer> divisors(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (i * i != n) {
					list.add(i);
					list.add(n/i);
				}
				else list.add(i);	
			}
		}
		Collections.sort(list);
		return list;
	}

	public static ArrayList<Long> divisorsL(long n) {
		ArrayList<Long> list = new ArrayList<Long>();
		for (long i = 1; i <= Math.sqrt(n); i++) {
			if (i * i != n) {
				list.add(i);
				list.add(n/i);
			}
			else list.add(i);	
		}
		Collections.sort(list);
		return list;
	}

	public static int numDivisors(int n) {
		int counter = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0 & i * i == n) counter++;
			else if (n % i == 0) counter += 2;
		}
		return counter;
	}


	/*
	 * FUNCTION: public static BigInteger sumDivisors(int n)
	 * USE: Sums all the PROPER divisors of n.
	 * INPUTS: n = stopping index.
	 */

	public static BigInteger sumDivisors(int n) {
		BigInteger sum = BigInteger.ONE;
		for (int j = 2; j <= Math.sqrt(n); j++) {
			if (n % j == 0) {
				sum = sum.add(new BigInteger(String.valueOf(j)));
				sum = sum.add(new BigInteger(String.valueOf(n/j)));
			}	
			if (j * j == n) sum = sum.subtract(new BigInteger(String.valueOf(j)));
		}
		return sum;
	}


	/*
	 * FUNCTION: public static String[] rotations(String s)
	 * USE: Rotations string: 179 -> 791 -> 917
	 * INPUTS: s = string to rotate.
	 */

	public static String[] rotations(String s) {
		String[] rot = new String[s.length()];
		String tmp = s;
		for (int i = 0; i < s.length(); i++) {
			rot[i] = tmp;
			char first = tmp.charAt(0);
			tmp = tmp.substring(1) + first;
		}
		return rot;
	}

	/*
	 * FUNCTION: public static boolean palindrome(String s)
	 * USE: Checks if a string s is a palindrome.
	 * INPUTS: s = string to check.
	 */

	public static boolean palindrome(String s) {
		boolean pal = true;
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-i-1)) pal = false;
		}
		return pal;	
	}

	/*
	 * FUNCTION: public static boolean onePandigital(int n)
	 * USE: Checks if a int n is 1 to n.length pandigital. 
	 * INPUTS: n = int to check.
	 */

	public static boolean onePandigital(int n) {
		String s = String.valueOf(n);
		boolean[] arr = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int digit = Integer.valueOf(s.substring(i, i+1));
			if (digit > s.length() || digit == 0) break;
			arr[digit - 1] = true;
		}
		for (int j = 0; j < s.length(); j++) {
			if (!arr[j]) return false;
		}
		return true;

	}

	/*
	 * FUNCTION: public static boolean zeroPandigital(int n)
	 * USE: Checks if a int n is 0 to n.length pandigital. 
	 * INPUTS: s = string to check **NOTE: Use of string because appending 0 is problematic if using String.valueOf();
	 */

	public static boolean zeroPandigital(String s) {
		boolean[] arr = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int digit = Integer.valueOf(s.substring(i, i+1));
			if (digit > s.length()) break;
			arr[digit] = true;
		}
		for (int j = 0; j < s.length(); j++) {
			if (!arr[j]) return false;
		}
		return true;

	}


	/*
	 * FUNCTION: public static BigInteger[] triangle(int n)
	 * USE: Generates nth triangle number.
	 * INPUTS: n = ending index.
	 */

	public static long triangle(int n) {
		return n * (n+1) / 2;
	}

	/*
	 * FUNCTION: public static BigInteger[] pentagonal(int n)
	 * USE: Generates nth pentagonal number.
	 * INPUTS: n = ending index.
	 */

	public static long pentagonal(int n) {
		return n * (3 * n-1) / 2;
	}

	/*
	 * FUNCTION: public static BigInteger[] hexagonal(int n)
	 * USE: Generates nth hexagonal number.
	 * INPUTS: n = ending index.
	 */

	public static long hexagonal(int n) {
		return n * (2 * n - 1);
	}

	/*
	 * FUNCTION: public static boolean isPentagonal(BigInteger p)
	 * USE: Generates hexagonal numbers up to n.
	 * INPUTS: n = ending index.
	 */

	public static int isPentagonal(long p) {
		double n = (Math.sqrt(24 * p + 1) + 1)/6; 
		if (n % 1 == 0) return (int) n;
		return -1;
	}

	/*
	 * FUNCTION: public static boolean isPermutation(String a, String b)
	 * USE: Checks if a string is a permutation of another.
	 * INPUTS: a, b = strings to check. .
	 */

	public static boolean isPermutation(String a, String b) {
		if (a.length() != b.length()) return false;
		else {
			char[] a_arr = a.toCharArray();
			char[] b_arr = b.toCharArray();
			Arrays.sort(a_arr);
			Arrays.sort(b_arr);
			if (Arrays.equals(a_arr, b_arr)) return true;
		}
		return false;
	}

	/*
	 * FUNCTION: public static int[][] binomial(int n)
	 * USE: Generates Pascal's Triangle. Note n begins at 0 instead of 1, i.e pascal[0][0] actually means 1C0.
	 * INPUTS: n = stopping index
	 */

	public static BigInteger[][] binomial(int n) {
		BigInteger[][] pascals = new BigInteger[n + 1][];
		for (int i = 0; i <= n; i++) {
			pascals[i] = new BigInteger[i + 1];
		}
		for (int k = 0; k <= n; k++) {
			for (int r = 0; r <= k; r++) {
				if (r == 0 || r == k) pascals[k][r] = BigInteger.ONE;
				else pascals[k][r] = pascals[k - 1][r - 1].add(pascals[k - 1][r]);
			} 
		}
		return pascals;
	}

	/*
	 * FUNCTION: public String gcd(int a, int b)
	 * USE: Euclid's algorithm to compute the greatest common divisor of integers a and b.
	 * INPUTS: int a, int b.
	 */

	public static int gcd(int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a % b);
	}

	/*
	 * FUNCTION: public String reverse(String s)
	 * USE: Reverses the order of a string.
	 * INPUTS: s = input string.
	 */

	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	/*
	 * FUNCTION: public static ArrayList<Integer> primeDivisors(int n)
	 * USE: Returns set of proper prime divisors.
	 * INPUTS: int n.
	 */

	public static HashSet<Integer> primeDivisors(int n) {
		boolean[] prime = primeSieve(n);
		ArrayList<Integer> div = divisors(n);
		HashSet<Integer> primeDiv = new HashSet<Integer>();
		for (int i = 0; i < div.size(); i++) {
			if (prime[div.get(i)]) primeDiv.add(div.get(i));
		}
		return primeDiv;
	}

	/*
	 * FUNCTION: public int totient(int n)
	 * USE: Euler's totient function (number of relatively numbers < n that are relatively prime to n).
	 * INPUTS: int n.
	 */
	public static int totient(int n) {
		if (n == 0 || n == 1) return 1;
		HashSet<Integer> primeDiv = primeDivisors(n);
		if (primeDiv.size() == 0) return n - 1;
		int prod = n;
		Iterator<Integer> it = primeDiv.iterator();
		while(it.hasNext()){
			int p = it.next();
			prod *= (double) (p - 1)/p;
		}
		return prod;
	}


}

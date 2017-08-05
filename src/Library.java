import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.math.BigInteger;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Library {

	static char[] bigalpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	/*
	 * Converts a txt file into 2d array. The txt file should include integers
	 * sepearted by commas, with each line having n integers. In total there should be
	 * m rows.
	 * 
	 * @param   m 		number of rows. 
	 * @param   n 		number of columns.
	 * @param   input 	file path of txt.file 
	 * @return 		2d array of dimensions m x n.
	 */

	public static int[][] txtTo2DArray(int m, int n, String input) throws FileNotFoundException {

		int[][] arr = new int[m][n];
		Scanner scanner = new Scanner(new BufferedReader(new FileReader(input)));
		int i = 0;

		while(scanner.hasNextLine()) {
			String line = scanner.nextLine(); 
			String[] num = line.split(","); 
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(num[j]); 
			}
			i++;
		}
		scanner.close();
		return arr;
	}

	/*
	 * Computes n!
	 * 
	 * @param   n	ending index.
	 * @return  n!
	 */

	public static int factorial(int n) {
		int prod = 1;
		for (int i = 2; i <= n; i++) {
			prod *= i;
		}
		return prod;
	}

	/*
	 * Eratosthenes's prime sieve up to n.
	 * 
	 * @param  n 	stopping index.
	 * @return 	boolean array with true entries where prime.
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
	
	/*
	 * Eratosthenes's prime sieve up to n.
	 * 
	 * @param  end  stopping index.
	 * @return 	ArrayList containing only primes.
	 */

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
	 * Finds all the divisors of natural number n.
	 * 
	 * @param   n	number to find divisors of
	 * @return  n   ArrayList of ints which divide n.
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
	
	/*
	 * Finds all the divisors of natural number n.
	 * 
	 * @param   n	number to find divisors of
	 * @return      ArrayList of longs which divide n.
	 */

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
	
	/*
	 * Computes the number of divisors of n.
	 * 
	 * @param   n	number to find divisors of
	 * @return      number of divisors of n.
	 */
	

	public static int numDivisors(int n) {
		int counter = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0 && i * i == n) counter++;
			else if (n % i == 0) counter += 2;
		}
		return counter;
	}


	/*
	 * Sums the divisors of n.
	 * 
	 * @param   n	ending index.
	 * @return  n   sum of divisors of n.
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
	 * Finds all the rotations of a string. For example, 179 -> 791 -> 917.
	 * 
	 * @param   s	input string
	 * @return  	array of all rotations of s.
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
	 * Reverses the order of a string.
	 *
	 * @param   s 	input string.
	 * @return  	reversed s.
	 */

	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}


	/*
	 * Checks if a string is a palindrome.
	 * 
	 * @param   s	input string.
	 * @return	if s is palindrome then true, false otherwise. 
	 */

	public static boolean palindrome(String s) {
		boolean pal = true;
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-i-1)) pal = false;
		}
		return pal;	
	}

	/*
	 * Checks if a int n is 1 to n.length pandigital. Taking n = 9 gives 1 to 9 pandigital. 
	 * 
     	 * @param   n  integer to check.
     	 * @return     true if 1 to n.length pandigital, false otherwise.
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
	 * Checks if a int n is 0 to s.length pandigital. Taking s.length = 9 gives 0 to 9 pandigital. 
	 * 
         * @param  s    string to check.
         * @return	true if 0 to s.length pandigital, false otherwise.
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
	 * Checks if a string is a permutation of another.
	 * 
	 * @param  a	first string.
	 * @param  b	second string.
	 * @return	true if a is a permutation of b, false otherwise.
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
	 * Generates Pascal's Triangle. Note n begins at 0 instead of 1, i.e pascal[0][0] actually means 1C0.
	 * 
	 * @param  n	stopping index
	 * @return	generates (n-1)th row of Pascal's Triangle.
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





}

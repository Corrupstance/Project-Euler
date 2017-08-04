public class Q0024 extends Library {
	
	/*
	 * Consider the case where we fix the first digit. Then the number is in the form
	 * 0abcdefghi, where a,b,c,d,e,f,g,h,i is in {1,2,3,4,5,6,7,8,9}. There are exactly 9! choices for a,b,c,d,e,f,g,h,i, 
	 * so the 0th to 9! = 362880th permutation are of the above form. 
	 * Similarly, the 362881th to 2*9! = 725760th permutation are of the form 1abcdefghi 
	 * where a,b,c,d,e,f,g,h,i is in {0,2,3,4,5,6,7,8,9}. Since 725761 < 1000000 < 3*9!, we can deduce that the first digit is 2.
	 * Notice that we are essentially finding the largest multiple of 9! does not exceed 1000000. 
	 * Repeating this process by lowering the factorial power gives the desired result:
	 * 
	 * 0 + 2 * 9! + 1 = 725761			1st digit: 2 
	 * 725760 + 6 * 8! = 967681			2nd digit: 7 (since 2 taken, count from 0,1,3,4,5,6,7; notice that we took 6+1 instead of just 6) 
	 * 967680 + 6 * 7! = 997921			3rd digit: 8
	 * 997920 + 2 * 6! = 999361			4th digit: 3
	 * 999360 + 5 * 5! = 999961			5th digit: 9
	 * 999960 + 1 * 4! = 999985			6th digit: 1
	 * 999984 + 2 * 3! = 999997			7th digit: 5
	 * 999996 + 1 * 2! = 999999			8th digit: 4
	 * 999999 + 1 * 1! = 1000000		9th digit: 6
	 * which implies 					10th digit: 0;
	 * giving us 2783915460 as the final answer.
	 */
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static long solve() {
		return 2783915460L;
	}
	
}
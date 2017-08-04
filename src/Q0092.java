public class Q0092 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {

		int counter = 0;

		for (long i = 2; i < 10000000L; i++) {	
			long tmp = 0;
			long tmpI = i;
			while (true) {
				String s = String.valueOf(tmpI);
				for (int j = 0; j < s.length(); j++) {
					tmp += (int) Math.pow(Integer.valueOf(s.substring(j,j+1)),2);
				}
				if (tmp != 1 && tmp != 89) {
					tmpI = tmp;
					tmp = 0;
				}
				else if(tmp == 89) {
					counter++;
					break;
				}
				else break;
			}
		}
		return counter;
	}
}
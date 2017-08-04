import java.util.ArrayList;

public class Q0007 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		int count = 1;
		while (list.size() < 10001) {
			int p = 3 + 2 * count;
			count++;
			boolean b = true;
			for (int i = 0; i < list.size(); i++) {
				if (p % list.get(i) == 0) {
					b = false;
					break;
				}
			}
			if (b) list.add(p);
		}
		return list.get(10000);
	}


}
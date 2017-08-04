public class Q0206 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static long solve() {
		for (int a = 0; a <= 9; a++) {
			for (int b = 0; b <= 9; b++) {
				for (int c = 0; c <= 9; c++) {
					for (int d = 0; d <= 9; d++) {
						for (int e = 0; e <= 9; e++) {
							for (int f = 0; f <= 9; f++) {
								for (int g = 0; g <= 9; g++) {
									for (int h = 0; h <= 9; h++) {
										for (int i = 0; i <= 9; i++) {
											String num = "1"+a+"2"+b+"3"+c+"4"+d+"5"+e+"6"+f+"7"+g+"8"+h+"9"+i+"0";
											long lnum = Long.parseLong(num);
											if ((long) Math.sqrt(lnum) * (long) Math.sqrt(lnum) == lnum) {
												return (long) Math.sqrt(lnum);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return -1;
	}
}
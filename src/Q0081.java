import java.io.FileNotFoundException;

public class Q0081 extends Library {
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(solve());
	}

	public static int solve() throws FileNotFoundException {
		
		/*
		 * Use dynamic programming; if we begin on the bottom row 
		 * or rightmost column all we can do is move right/down respectively.
		 * Take the bottom row. The further away we are from the bottom right the more we have
		 * to travel, so we add the distances starting from the rightmost tile of the bottom row
		 * to the left most tile. This is the 
		 * 
		 * if (i == size - 1 || j == size - 1) {
		 *			if (i == size - 1 && j == size - 1) continue;
		 *			else if (i == size - 1 && j != size - 1) arr[i][j] += arr[i][j + 1];
		 *			else arr[i][j] += arr[i + 1][j];
		 *		}
		 *
		 * part of the loop. Otherwise we use the principle of Q0018 and add the minimum of the tile
		 * above and the tile directly to the left of the concerned tile.
		 */

		int size = 80;
		int[][] arr = txtTo2DArray(size,size,"./txt/Q0081.txt");

		for (int i = size - 1; i >= 0; i--) {
			for (int j = size - 1; j >= 0; j--) {
				if (i == size - 1 || j == size - 1) {
					if (i == size - 1 && j == size - 1) continue;
					else if (i == size - 1 && j != size - 1) arr[i][j] += arr[i][j + 1];
					else arr[i][j] += arr[i + 1][j];
				}
				else {
					if (arr[i + 1][j] > arr[i][j + 1]) arr[i][j] += arr[i][j + 1];
					else arr[i][j] += arr[i + 1][j];
				}
			}
		}
		return arr[0][0];
	}



}
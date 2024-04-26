/* MatrixAdd.java */
package chapter6.practice2;
public abstract class MatrixAdd {
	public static void main(String[] args) {
		int[][] X = { { 12, 7, 3 }, { 4, 5, 6 } };
		int[][] Y = { { 5, 8, 1 }, { 6, 7,3 } };	
		int[][] result = new int [2][3];              
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				result[i][j] = X[i][j] + Y[i][j];
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}

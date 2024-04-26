/* Test.java */
package chapter6.practice1;
public class Test {
	public static void main(String[] args) {
		int[] array = { 52, 12, 51, 13, 19, 83, 8, 2 };
		int k; 
		int total = 0;
		for (k = 0; k < array.length; k++) {
			if(array[k] % 2 == 1) 
				break;
			total += array[k];
		}
		System.out.println(total);
	}
}

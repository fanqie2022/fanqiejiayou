/* Separate.java */
package chapter6.practice3_2;
public abstract class Separate {
	public static void main(String[] args) {
		String str = "1a2b3c";
		char[] c = str.toCharArray();
		for(int i = 0; i < c.length; i++) {
			if(c[i] >= '0' && c[i] <= '9')
				System.out.print(c[i] + " ");
		}
		System.out.println("");
		for(int i = 0; i < c.length; i++) {
			if((c[i] >= 'A' && c[i] <= 'Z') || (c[i] >= 'a' && c[i] <= 'z'))
				System.out.print(c[i] + " ");
		}
	}
}

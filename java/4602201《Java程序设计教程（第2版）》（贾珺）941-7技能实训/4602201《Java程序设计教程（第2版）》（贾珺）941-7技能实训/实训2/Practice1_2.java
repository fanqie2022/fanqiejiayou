/* Practice1_2.java */
public class Practice1_2 {
	final static int A = 1, B = 2;
	final static double C = 3;
	public static void main(String[] args) {
		double x = (A + C) * B / C;
		System.out.println("x��ֵΪ��" + x);
		boolean y = A > B | B > C & C > A;
		System.out.println("y��ֵΪ��" + y);
		int a = A + B;
		int b = ++a;
		int c = a++;
		System.out.println("b��ֵΪ��" + b +'\t' + "c��ֵΪ��" + c);
	}
}

/* Practice2.java */
import java.util.Scanner;
public class Practice2 {
	public static void main(String[] args) {
		System.out.println("������һ����λ������");	
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int a = num / 1000;
		int b = (num % 1000) / 100;
		int c = (num % 100) / 10;
		int d = num % 10;            
		System.out.println("ǧλ��Ϊ" + a);
		System.out.println("��λ��Ϊ" + b);
		System.out.println("ʮλ��Ϊ" + c);
		System.out.println("��λ��Ϊ" + d);
		scan.close();
	}
}

/* Practice2.java */
import java.util.Scanner;
public class Practice2 {
	public static void main(String[] args) {
		System.out.println("请输入一个四位整数：");	
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int a = num / 1000;
		int b = (num % 1000) / 100;
		int c = (num % 100) / 10;
		int d = num % 10;            
		System.out.println("千位数为" + a);
		System.out.println("百位数为" + b);
		System.out.println("十位数为" + c);
		System.out.println("个位数为" + d);
		scan.close();
	}
}

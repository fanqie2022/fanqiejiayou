/* Practice2_1.java */
import java.util.Scanner;
public class Practice2_1 {
	public static void main(String[] args) {
		int result = 1;
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入一个整数（1～20）：");
		int num = scan.nextInt();
		for (int i = 2; i <= num; i++) {
			result *= i;
		}
		System.out.println(num + "的阶乘为：" + result);
		scan.close();
	}
}

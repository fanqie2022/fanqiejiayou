/* Practice2_1.java */
import java.util.Scanner;
public class Practice2_1 {
	public static void main(String[] args) {
		int result = 1;
		Scanner scan = new Scanner(System.in);
		System.out.print("������һ��������1��20����");
		int num = scan.nextInt();
		for (int i = 2; i <= num; i++) {
			result *= i;
		}
		System.out.println(num + "�Ľ׳�Ϊ��" + result);
		scan.close();
	}
}

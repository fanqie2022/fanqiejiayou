/* Account.java */
package chapter8.practice1;
import java.util.Scanner;
public class Account {
	public static void main(String[] args) {
		double leftMoney = 1023.79;
		Scanner scan = new Scanner(System.in);
		System.out.print("������ȡ���");
		try {
			int drawMoney = scan.nextInt();
			double result = leftMoney - drawMoney;               
			if(result >= 0) {
				System.out.println("���˻�����" 
						+ (float)result + "Ԫ");
			} else {
				System.out.println("���˻������㣡");               
			}
		}
		catch (Exception e) {
			System.out.println("�������ȡ�����������");               
		} finally {
			scan.close();
		}		
	}
}

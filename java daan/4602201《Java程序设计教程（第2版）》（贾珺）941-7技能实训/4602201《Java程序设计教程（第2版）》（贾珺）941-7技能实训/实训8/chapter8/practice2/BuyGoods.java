/* BuyGoods.java */
package chapter8.practice2;
import java.util.*;
class OverloadException extends Exception {
	public OverloadException(double weight) {
		System.out.println("�쳣��ʾ����Ʒ������Ϊ" + weight 
				+ "�����3���ˣ������ˣ�����");
	}
}
public class BuyGoods {
	public static void pay(double weight) throws OverloadException {
		if (weight > 3.0) {
			throw new OverloadException(weight);
		}
		float money = (float) (weight * 3.98);
		System.out.println("Ӧ���" + money + "Ԫ");
	}
	public static void main(String[] args) {
		System.out.print("��������Ʒ������(��)��");
		Scanner scan = new Scanner(System.in);
		double weight = scan.nextDouble();
		try {
			pay(weight);
		} catch (OverloadException e) {
		} finally {
			scan.close();
		}
	}
}

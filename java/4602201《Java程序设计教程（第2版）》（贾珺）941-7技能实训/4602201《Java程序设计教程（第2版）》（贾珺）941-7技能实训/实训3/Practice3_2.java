/* Practice3_2.java */
import java.util.Scanner;
public class Practice3_2 {
	public static void main(String[] args) {
		double weight, price;					//�������������ͼ۸����
		Scanner scan = new Scanner(System.in);	
		System.out.print("�������������������");
		weight = scan.nextDouble();				//ɨ��Ϊdouble�����ݲ���ֵ��n
		if (weight < 0) {
			System.out.print("���������������");
		}
		else if (weight <= 20) {
			System.out.print("����������������");
		}
		else if (weight <= 30) {
			price = (weight - 20) * 5;
			System.out.print("�������˷���Ϊ" + price + "Ԫ��");
		}
		else if (weight <= 40) {
			price = (30 - 20) * 5 + (weight - 30) * 10;
			System.out.print("�������˷���Ϊ" + price + "Ԫ��");
		}
		else if(weight<=50) {
			price = (30 - 20) * 5 + (40 - 30) * 10 + (weight - 40) * 15;
			System.out.print("�������˷���Ϊ" + price + "Ԫ��");
		}
		else {
			System.out.print("�����˵��������������ޣ����������ˣ�");
		}
		scan.close();
	}
}

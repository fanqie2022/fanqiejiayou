/* Weight.java */
package chapter8.practice3_3;
import java.util.*;
class HeightException extends Exception {}
public class Weight {
	public static void main(String[] args) {
		System.out.println("��������ߣ�");		// �����ʾ
		Scanner scan = new Scanner(System.in);
		try {
			float height = scan.nextFloat();
			if (height < 0.3 || height > 2.5)		// ���heightС��30�����250
				throw new HeightException();	// �׳�HeightException�쳣
			System.out.println("���������أ�");	// �����ʾ
			float weight = scan.nextFloat();
			double BMI = weight/Math.pow(height, 2);			// ����BMIָ��
			// ���BMIС��18.5����������ݡ�
			if (BMI < 18.5)	
				System.out.println("����");
			// ���BMIС��24�Ҵ��ڵ���18.5�������������
			else if (BMI < 24)
				System.out.println("����");
			// ���BMIС��28�Ҵ��ڵ���24����������ء�
			else if (BMI < 28)
				System.out.println("����");
			else		// ���BMI���ڵ���28����������֡�
				System.out.println("����");
		} catch(InputMismatchException e) {				// �����������������쳣
			System.out.println("�����쳣�������븡������������");
		} catch(HeightException e) {						// ����������ֵ�쳣
			System.out.println("��������������");
		} finally {
			scan.close();								// �ر�ɨ����
		}
	}
}

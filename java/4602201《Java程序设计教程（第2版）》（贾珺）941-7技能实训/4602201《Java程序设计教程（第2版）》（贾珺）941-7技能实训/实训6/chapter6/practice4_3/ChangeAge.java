/* ChangeAge.java */
package chapter6.practice4_3;
import java.util.Scanner;		//����Scanner��
public class ChangeAge {
	public static void main(String[] args) {
		// ����ɨ��������ʵ�ֿ���̨����
		Scanner scan = new Scanner(System.in);
		// ��ʾ��Ϣ
		System.out.print("�û�����");
		// ���տ���̨������û���
		String userName = scan.next();
		int userAge = 25;
		System.out.println("���䣺" + userAge);
		boolean flag = true;
		while (flag) {
			System.out.println("======ѡ������======");
			// ����̨���ѡ����Ϣ
			System.out.println("1.ȷ��	 2.����");
			// ��ʾ��Ϣ
			System.out.print("��ѡ��");
			// ���տ���̨���������
			int choiceNum = scan.nextInt();
			// ����һ���вεġ��ַ����пɱ���ַ�������
			StringBuffer sbf = new StringBuffer("�û�" + userName + "��������" 
					+ userAge);
			// �Կ���̨���������Ϊ�����Ķ��֧���
			switch (choiceNum) {
			case 1:// ����̨����1ʱ
				// ��ʾ��Ϣ
				System.out.println("======ȷ����Ϣ======");
				// ����̨����ַ�������
				System.out.println(sbf);
				flag = false;
				break;
			case 2:// ����̨����2ʱ
				// ��ʾ��Ϣ
				System.out.println("======������Ϣ======");
				// ��ʾ��Ϣ
				System.out.print("���䣺");
				// ���տ���̨���������
				userAge = scan.nextInt();
				break;
			}
		}
		// �رտ���̨����
		scan.close();
	}
}

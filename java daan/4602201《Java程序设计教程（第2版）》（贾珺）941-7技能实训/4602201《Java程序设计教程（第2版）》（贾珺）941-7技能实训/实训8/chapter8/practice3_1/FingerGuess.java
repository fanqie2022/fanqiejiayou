/* FingerGuess.java */
package chapter8.practice3_1;
import java.util.Scanner;
public class FingerGuess {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true)
			try {
				System.out.print("���û�1���룺0(����)  1(ʯͷ)  2(��)��");
				int player1 = scan.nextInt();// ��ȡ�û�1�������Ϣ����ֵ
				System.out.print("���û�2���룺0(����)  1(ʯͷ)  2(��)��");
				int player2 = scan.nextInt();// ��ȡ�û�2�������Ϣ����ֵ
				// ����play1��play2������0,1��2����������׳��쳣
				assert (player1 >= 0 && player1 < 3) && (player2 >= 0 && player2 < 3) 
					: ("play1��play2������0,1��2");
				// �û�1�����ܻ�ʤ���ж�����
				if (((player1 == 0) && (player2 == 2)) ||
						((player1 == 1) && (player2 == 0)) ||
						((player1 == 2) && (player2 == 1)))
					System.out.println("�û�1���ʤ��");// ������û�1���ʤ����
				else if (player1 == player2)		// �û�1�������û�2��ͬʱ
					System.out.println("ƽ�֣�����һ��");// �����ƽ�֣�����һ�֡�
				else 							// �û�2��ʤ
					System.out.println("�û�2���ʤ��");// ������û�2���ʤ����
				break;							//����ѭ��
			} catch(AssertionError e) {
				System.out.println("�쳣��Ϣ��" + e.getMessage());
			}
		scan.close();
	}
}

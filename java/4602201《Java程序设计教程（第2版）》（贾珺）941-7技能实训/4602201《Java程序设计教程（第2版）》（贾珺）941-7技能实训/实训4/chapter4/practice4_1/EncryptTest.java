/* EncryptTest.java */
package chapter4.practice4_1;
import java.util.Scanner;
class Encrypt {
	int code;
	Encrypt(int code) {
		this.code = code;
	}
	int encryptCode() {
		int qw = code / 1000;						// ȡǧλ��
		int bw = (code - qw *1000) / 100;				// ȡ��λ��
		int sw = (code - qw *1000 - bw * 100) / 10;		// ȡʮλ��
		int gw = code % 10;						// ȡ��λ��
		qw = (qw + 5) % 10;						// ǧλ����5����10
		bw = (bw + 5) % 10;						// ��λ����5����10
		sw = (sw + 5) % 10;						// ʮλ����5����10
		gw = (gw + 5) % 10;						// ��λ����5����10
		int temp;									// �����м���
		// ��һλ�͵���λ����
		temp = qw;
		qw = gw;
		gw = temp;
		// �ڶ�λ�͵���λ����
		temp = bw;
		bw = sw;
		sw = temp;
		// ���ؼ��ܺ����λ����
		return qw * 1000 + bw * 100 + sw * 10 + gw;
	}
}
public class EncryptTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������һ����λ������");
		int code = scan.nextInt();		// ɨ��Ϊint�����ݲ���ֵ��code
		Encrypt c = new Encrypt(code);	// ����Encrypt��Ķ���
		System.out.println("���ܺ����λ����Ϊ��" + c.encryptCode());
		scan.close();					// �ر�ɨ����
	}
}

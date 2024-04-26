/* GetAddress.java */
package chapter12.practice1;
import java.net.*;
public class GetAddress {
	public static void main(String args[]) {
		InetAddress ip = null;
		try {
			// ��ȡָ��������InetAddress����
			ip = InetAddress.getByName("www.163.com");
			// ��ȡ�����������
			System.out.println("��������" + ip.getHostName());
			// ��ȡ����IP��ַ�����
			System.out.println("����IP��ַ��" + ip.getHostAddress());
			//��ȡ���������������
			System.out.println("����������:" 
					+ InetAddress.getLocalHost().getHostName());
			// ��ȡ��������IP��ַ
			System.out.println("����IP��ַ��" 
					+ InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

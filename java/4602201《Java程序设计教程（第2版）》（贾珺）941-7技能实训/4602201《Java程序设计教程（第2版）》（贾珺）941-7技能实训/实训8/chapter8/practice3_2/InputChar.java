/* InputChar.java */
package chapter8.practice3_2;
import java.util.Scanner;
public class InputChar {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	// ����Scanner����scan
		while (true) {							// ѭ��
			try {
				System.out.print("������һ��Сд�ַ���");
				String s = scan.nextLine();
				if (s.length() == 1) {			// ����ַ����ĳ��ȵ���1
					char c = s.charAt(0);		// ��ȡs�ĵ�1���ַ���������c
					if ('a'<= c && c<='z') {		// ���c��Сд��ĸ
						System.out.println(c);	// ���c
						break;				// �˳�ѭ��
					}
					else
						// ���c����Сд��ĸ���׳��쳣���������쳣��Ϣ
						throw new Exception("������ַ�ӦΪСд�ַ�");
				}
				else
					// ����ַ����ĳ��Ȳ�����1���׳��쳣���������쳣��Ϣ
					throw new Exception("ֻ������һ���ַ�");
			} catch(Exception e) {						// �����쳣
				System.out.println(e.getMessage());		// ����쳣��Ϣ
			}
		}
		scan.close();									// �ر�ɨ����
	}
}

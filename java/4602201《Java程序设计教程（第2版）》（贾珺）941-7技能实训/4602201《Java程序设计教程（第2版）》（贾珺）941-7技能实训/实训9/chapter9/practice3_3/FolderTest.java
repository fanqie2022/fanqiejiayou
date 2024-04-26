/* FolderTest.java */
package chapter9.practice3_3;
import java.io.File;
public class FolderTest {
	public static void main(String[] args) {
		String path = "D:/Test";			// �����ļ���Test���ڵ�Ŀ¼
		for (int i = 1; i <= 10; i++) {		// ѭ�����iֵ������i�����µ��ļ���
			File folder = new File(path + "/" + i); // �����µ�Ŀ¼����File����
			if (!folder.exists()) {		// �ļ��в�����
				folder.mkdirs();		// �����µ��ļ���(���������ڵĸ��ļ���)
			}
		}
		System.out.println("�ļ��д����ɹ������D�̲鿴��"
				+ "\n\nD���ļ����ļ����б����£�");
		File file = new File("D:/");		// ����·��������File����
		File[] files = file.listFiles();		// ���D�̵������ļ����ļ���
		for (File folder : files) {			// ����files����
			if (folder.isFile())			// �ж��Ƿ�Ϊ�ļ�
				// ���D���������ļ�������
				System.out.println(folder.getName() + " �ļ�");
			else if (folder.isDirectory()) // �ж��Ƿ�Ϊ�ļ���
				// ���D���������ļ��е�����
				System.out.println(folder.getName() + " �ļ���");
		}
	}
}

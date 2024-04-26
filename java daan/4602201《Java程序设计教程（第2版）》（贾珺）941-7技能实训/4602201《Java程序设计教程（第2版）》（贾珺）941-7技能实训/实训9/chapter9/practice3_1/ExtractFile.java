/* ExtractFile.java */
package chapter9.practice3_1;
import java.io.*;
public class ExtractFile {
	public static void main(String[] args) {
		InputStreamReader filein = null;
		BufferedReader bufin = null;
		FileWriter fileout = null;
		BufferedWriter bufout = null;
		String originalText = "";
		File file = new File("԰����.txt");			// �����ļ�����file
		try {
			// ʹ��InputStreamReader���������������ñ���ΪUTF-8
			filein = new InputStreamReader(new FileInputStream(file), "UTF-8");
			bufin = new BufferedReader(filein);	// ��������������
			String s = null;
			// ��ȡ�ļ������ж϶�ȡ���ַ�����Ϊ��
			while ((s = bufin.readLine()) != null) {	
				// �ж϶�ȡ��һ���Ƿ�Ϊԭ�ģ�����������ӵ�originalText
				if (s.startsWith("��ԭ�ġ�")) 
					originalText += s + "\n";
			}
			bufin.close();
			filein.close();
		} catch (IOException e) {
			System.out.println(e);
		} 
		file = new File("԰��_ԭ��.txt");			// �����ļ�����file
		try {
			fileout = new FileWriter(file);			// �����ļ��ַ�������
			bufout = new BufferedWriter(fileout);	// ���������ַ���
			bufout.write(originalText);			// ��originalTextд���ļ�
			bufout.close();
			fileout.close();	
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

/* FileInput.java */
package chapter9.practice1;
import java.io.*;
import java.util.Scanner;
public class FileInput {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������Ҫд����ļ����� ");
		String fileName = scan.nextLine();
		String[] content = { "�ԾƵ���", "��������", "Ʃ�糯¶", 
				"ȥ�տ��", "���Ե���", "��˼����", "���Խ���", 
				"Ψ�жſ�" };
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName, true);                   
			for (int i = 0; i < content.length; i++) {
				fw.write(content[i] + "\n");                   
			}
			fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		scan.close();
	}
}

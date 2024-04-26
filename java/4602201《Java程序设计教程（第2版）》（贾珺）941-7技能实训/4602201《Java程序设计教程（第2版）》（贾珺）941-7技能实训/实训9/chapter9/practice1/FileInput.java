/* FileInput.java */
package chapter9.practice1;
import java.io.*;
import java.util.Scanner;
public class FileInput {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要写入的文件名： ");
		String fileName = scan.nextLine();
		String[] content = { "对酒当歌", "人生几何", "譬如朝露", 
				"去日苦多", "慨以当康", "忧思难忘", "何以解忧", 
				"唯有杜康" };
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

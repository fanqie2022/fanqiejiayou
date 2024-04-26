/* FileInput.java */
package chapter9.practice2;
import java.io.*;
public class FileInput {
	public static void main(String[] args) throws IOException {
		File f = new File("test.txt");
		FileOutputStream fos = new FileOutputStream(f, true);
		for (int i = 1; i <= 5; i++) {
			String str = "µÚ" + i + "ÐÐ\n";
			fos.write(str.getBytes());
		}
		fos.flush();
		fos.close();
	}
}

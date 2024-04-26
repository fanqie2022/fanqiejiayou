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
		File file = new File("园丁集.txt");			// 创建文件对象file
		try {
			// 使用InputStreamReader创建输入流，设置编码为UTF-8
			filein = new InputStreamReader(new FileInputStream(file), "UTF-8");
			bufin = new BufferedReader(filein);	// 创建缓冲输入流
			String s = null;
			// 读取文件，并判断读取的字符串不为空
			while ((s = bufin.readLine()) != null) {	
				// 判断读取的一行是否为原文，如果是则连接到originalText
				if (s.startsWith("【原文】")) 
					originalText += s + "\n";
			}
			bufin.close();
			filein.close();
		} catch (IOException e) {
			System.out.println(e);
		} 
		file = new File("园丁_原文.txt");			// 创建文件对象file
		try {
			fileout = new FileWriter(file);			// 创建文件字符输入流
			bufout = new BufferedWriter(fileout);	// 创建缓冲字符流
			bufout.write(originalText);			// 将originalText写入文件
			bufout.close();
			fileout.close();	
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

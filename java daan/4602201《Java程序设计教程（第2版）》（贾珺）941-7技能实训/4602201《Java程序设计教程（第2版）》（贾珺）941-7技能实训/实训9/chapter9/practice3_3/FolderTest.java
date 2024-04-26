/* FolderTest.java */
package chapter9.practice3_3;
import java.io.File;
public class FolderTest {
	public static void main(String[] args) {
		String path = "D:/Test";			// 声明文件夹Test所在的目录
		for (int i = 1; i <= 10; i++) {		// 循环获得i值，并用i命名新的文件夹
			File folder = new File(path + "/" + i); // 根据新的目录创建File对象
			if (!folder.exists()) {		// 文件夹不存在
				folder.mkdirs();		// 创建新的文件夹(包括不存在的父文件夹)
			}
		}
		System.out.println("文件夹创建成功，请打开D盘查看！"
				+ "\n\nD盘文件及文件夹列表如下：");
		File file = new File("D:/");		// 根据路径名创建File对象
		File[] files = file.listFiles();		// 获得D盘的所有文件和文件夹
		for (File folder : files) {			// 遍历files数组
			if (folder.isFile())			// 判断是否为文件
				// 输出D盘下所有文件的名称
				System.out.println(folder.getName() + " 文件");
			else if (folder.isDirectory()) // 判断是否为文件夹
				// 输出D盘下所有文件夹的名称
				System.out.println(folder.getName() + " 文件夹");
		}
	}
}

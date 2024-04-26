/* InputChar.java */
package chapter8.practice3_2;
import java.util.Scanner;
public class InputChar {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	// 创建Scanner对象scan
		while (true) {							// 循环
			try {
				System.out.print("请输入一个小写字符：");
				String s = scan.nextLine();
				if (s.length() == 1) {			// 如果字符串的长度等于1
					char c = s.charAt(0);		// 获取s的第1个字符，并赋给c
					if ('a'<= c && c<='z') {		// 如果c是小写字母
						System.out.println(c);	// 输出c
						break;				// 退出循环
					}
					else
						// 如果c不是小写字母，抛出异常，并设置异常信息
						throw new Exception("输入的字符应为小写字符");
				}
				else
					// 如果字符串的长度不等于1，抛出异常，并设置异常信息
					throw new Exception("只需输入一个字符");
			} catch(Exception e) {						// 捕获异常
				System.out.println(e.getMessage());		// 输出异常信息
			}
		}
		scan.close();									// 关闭扫描器
	}
}

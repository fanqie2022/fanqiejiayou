/* ChangeAge.java */
package chapter6.practice4_3;
import java.util.Scanner;		//导入Scanner类
public class ChangeAge {
	public static void main(String[] args) {
		// 创建扫描器对象，实现控制台输入
		Scanner scan = new Scanner(System.in);
		// 提示信息
		System.out.print("用户名：");
		// 接收控制台输入的用户名
		String userName = scan.next();
		int userAge = 25;
		System.out.println("年龄：" + userAge);
		boolean flag = true;
		while (flag) {
			System.out.println("======选项条件======");
			// 控制台输出选项信息
			System.out.println("1.确认	 2.更改");
			// 提示信息
			System.out.print("请选择：");
			// 接收控制台输入的数字
			int choiceNum = scan.nextInt();
			// 创建一个有参的、字符序列可变的字符串对象
			StringBuffer sbf = new StringBuffer("用户" + userName + "的年龄是" 
					+ userAge);
			// 以控制台输入的数字为参数的多分支语句
			switch (choiceNum) {
			case 1:// 控制台输入1时
				// 提示信息
				System.out.println("======确认信息======");
				// 控制台输出字符串对象
				System.out.println(sbf);
				flag = false;
				break;
			case 2:// 控制台输入2时
				// 提示信息
				System.out.println("======更改信息======");
				// 提示信息
				System.out.print("年龄：");
				// 接收控制台输入的年龄
				userAge = scan.nextInt();
				break;
			}
		}
		// 关闭控制台输入
		scan.close();
	}
}

/* FingerGuess.java */
package chapter8.practice3_1;
import java.util.Scanner;
public class FingerGuess {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true)
			try {
				System.out.print("请用户1输入：0(剪刀)  1(石头)  2(布)：");
				int player1 = scan.nextInt();// 获取用户1输入的信息并赋值
				System.out.print("请用户2输入：0(剪刀)  1(石头)  2(布)：");
				int player2 = scan.nextInt();// 获取用户2输入的信息并赋值
				// 断言play1和play2必须是0,1或2，如果不是抛出异常
				assert (player1 >= 0 && player1 < 3) && (player2 >= 0 && player2 < 3) 
					: ("play1和play2必须是0,1或2");
				// 用户1所有能获胜的判断条件
				if (((player1 == 0) && (player2 == 2)) ||
						((player1 == 1) && (player2 == 0)) ||
						((player1 == 2) && (player2 == 1)))
					System.out.println("用户1获得胜利");// 输出“用户1获得胜利”
				else if (player1 == player2)		// 用户1输入与用户2相同时
					System.out.println("平局，再来一局");// 输出“平局，再来一局”
				else 							// 用户2获胜
					System.out.println("用户2获得胜利");// 输出“用户2获得胜利”
				break;							//跳出循环
			} catch(AssertionError e) {
				System.out.println("异常信息：" + e.getMessage());
			}
		scan.close();
	}
}

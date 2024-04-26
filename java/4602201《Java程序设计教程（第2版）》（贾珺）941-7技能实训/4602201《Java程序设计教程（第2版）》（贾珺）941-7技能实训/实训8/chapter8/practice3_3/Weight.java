/* Weight.java */
package chapter8.practice3_3;
import java.util.*;
class HeightException extends Exception {}
public class Weight {
	public static void main(String[] args) {
		System.out.println("请输入身高：");		// 输出提示
		Scanner scan = new Scanner(System.in);
		try {
			float height = scan.nextFloat();
			if (height < 0.3 || height > 2.5)		// 如果height小于30或大于250
				throw new HeightException();	// 抛出HeightException异常
			System.out.println("请输入体重：");	// 输出提示
			float weight = scan.nextFloat();
			double BMI = weight/Math.pow(height, 2);			// 计算BMI指数
			// 如果BMI小于18.5，输出“消瘦”
			if (BMI < 18.5)	
				System.out.println("消瘦");
			// 如果BMI小于24且大于等于18.5，输出“正常”
			else if (BMI < 24)
				System.out.println("正常");
			// 如果BMI小于28且大于等于24，输出“超重”
			else if (BMI < 28)
				System.out.println("正常");
			else		// 如果BMI大于等于28，输出“肥胖”
				System.out.println("肥胖");
		} catch(InputMismatchException e) {				// 捕获输入数据类型异常
			System.out.println("输入异常，请输入浮点数或整数！");
		} catch(HeightException e) {						// 捕获输入数值异常
			System.out.println("您输入的身高有误！");
		} finally {
			scan.close();								// 关闭扫描器
		}
	}
}

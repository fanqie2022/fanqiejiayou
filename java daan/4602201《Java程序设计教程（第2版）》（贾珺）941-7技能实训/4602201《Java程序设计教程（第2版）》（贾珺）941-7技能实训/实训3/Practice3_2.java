/* Practice3_2.java */
import java.util.Scanner;
public class Practice3_2 {
	public static void main(String[] args) {
		double weight, price;					//定义重量变量和价格变量
		Scanner scan = new Scanner(System.in);	
		System.out.print("请您输入行李的重量：");
		weight = scan.nextDouble();				//扫描为double型数据并赋值给n
		if (weight < 0) {
			System.out.print("您输入的数据有误！");
		}
		else if (weight <= 20) {
			System.out.print("您可以免费托运行李！");
		}
		else if (weight <= 30) {
			price = (weight - 20) * 5;
			System.out.print("您的托运费用为" + price + "元！");
		}
		else if (weight <= 40) {
			price = (30 - 20) * 5 + (weight - 30) * 10;
			System.out.print("您的托运费用为" + price + "元！");
		}
		else if(weight<=50) {
			price = (30 - 20) * 5 + (40 - 30) * 10 + (weight - 40) * 15;
			System.out.print("您的托运费用为" + price + "元！");
		}
		else {
			System.out.print("您托运的行李超出了最高上限，不允许托运！");
		}
		scan.close();
	}
}

/* Practice3_2.java */
import java.util.Scanner;
public class Practice3_2 {
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);		//创建Scanner对象
		System.out.println("请输入一个整数：");
		int num=scan.nextInt();				//扫描为int型数据
		String check=(num%2!=0)?"您输入的整数是奇数":"您输入的整数是偶数";
		System.out.println(check);			//输出奇偶判断结果
		scan.close();
	}
}

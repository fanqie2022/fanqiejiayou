/* BuyGoods.java */
package chapter8.practice2;
import java.util.*;
class OverloadException extends Exception {
	public OverloadException(double weight) {
		System.out.println("异常提示：商品的重量为" + weight 
				+ "斤，超过3斤了，超重了！！！");
	}
}
public class BuyGoods {
	public static void pay(double weight) throws OverloadException {
		if (weight > 3.0) {
			throw new OverloadException(weight);
		}
		float money = (float) (weight * 3.98);
		System.out.println("应付款：" + money + "元");
	}
	public static void main(String[] args) {
		System.out.print("请输入商品的重量(斤)：");
		Scanner scan = new Scanner(System.in);
		double weight = scan.nextDouble();
		try {
			pay(weight);
		} catch (OverloadException e) {
		} finally {
			scan.close();
		}
	}
}

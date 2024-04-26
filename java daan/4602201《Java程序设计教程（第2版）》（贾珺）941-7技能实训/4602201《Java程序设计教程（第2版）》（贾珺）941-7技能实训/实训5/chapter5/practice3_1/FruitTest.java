/* FruitTest.java */
package chapter5.practice3_1;
public class FruitTest {
	public static void main(String[] args) {
		Fruit f1 = new Fruit();			// 创建水果类对象f1
		f1.setName("苹果");			// 调用setName()方法，给name赋值
		f1.setArea("山东烟台");			// 调用setArea()方法，给area赋值
		f1.setPrice(5.99f);				// 调用setPrice()方法，给price赋值
		// 输出f1的name、area和price
		System.out.println(f1.getName() + " " + f1.getArea() + " " + f1.getPrice() + "元/斤");
		Fruit f2 = new Fruit();			// 创建水果类对象f2
		f2.setName("爱媛果冻橙");		// 调用setName()方法，给name赋值
		f2.setArea("四川眉山");			// 调用setArea()方法，给area赋值
		f2.setPrice(7.99f);				// 调用setPrice()方法，给price赋值
		// 输出f2的name、area和price
		System.out.println(f2.getName() + " " + f2.getArea() + " " + f2.getPrice() + "元/斤");
		Fruit f3 = new Fruit();			// 创建水果类对象f3
		f3.setName("车厘子");			// 调用setName()方法，给name赋值
		f3.setArea("智利进口");			// 调用setArea()方法，给area赋值
		f3.setPrice(39.99f);				// 调用setPrice()方法，给price赋值
		// 输出f3的name、area和price
		System.out.println(f3.getName() + " " + f3.getArea() + " " + f3.getPrice() + "元/斤");
	}
}

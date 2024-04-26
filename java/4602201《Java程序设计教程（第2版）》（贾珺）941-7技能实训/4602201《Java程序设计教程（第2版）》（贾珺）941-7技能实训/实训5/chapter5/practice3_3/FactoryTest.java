/* FactoryTest */
package chapter5.practice3_3;
public class FactoryTest {
	public static void main(String[] args) {
		// 定义PhonePlant类对象
		PhonePlant phonePlant = new PhonePlant("手机");
		phonePlant.setName("手机厂");		// 设置工厂名
		// 输出产品
		System.out.println(phonePlant.getName() + "生产的是" 
				+ phonePlant.productsName);
		// 定义ClothsFactory类对象
		ClothsFactory clothsFactory = new ClothsFactory("衣服");
		clothsFactory.setName("服饰厂");		// 设置工厂名
		// 输出产品
		System.out.println(clothsFactory.getName() + "生产的是" 
				+ clothsFactory.productsName);
	}
}

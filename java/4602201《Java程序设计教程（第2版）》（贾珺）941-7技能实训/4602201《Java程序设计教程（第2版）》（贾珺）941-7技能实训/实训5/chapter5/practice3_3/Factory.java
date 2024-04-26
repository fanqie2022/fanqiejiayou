/* Factory.java */
package chapter5.practice3_3;
public abstract class Factory {
	String name;							// 定义工厂名name
	public String getName() {				// 设置工厂名
		return name;
	}
	public void setName(String name) {		// 获取工厂名
		this.name = name;
	}
	public abstract String produce();			// 定义抽象方法，返回产品名
}
class PhonePlant extends Factory {			// 定义PhonePlant类，继承Factory类
	String productsName;					// 定义产品名productsName
	
	public PhonePlant(String productsName) {	// 定义有参构造方法，传递产品名
		this.productsName = productsName;
	}
	@Override
	public String produce() {				// 重写produce()方法
		return this.productsName;
	}
}
class ClothsFactory extends Factory {			// 定义ClothsFactory类，继承Factory类
	String productsName;					// 定义产品名productsName
	
	public ClothsFactory(String productsName) {// 定义有参构造方法，传递产品名
		this.productsName = productsName;
	}
	@Override
	public String produce() {				// 重写produce()方法
		return this.productsName;
	}
}

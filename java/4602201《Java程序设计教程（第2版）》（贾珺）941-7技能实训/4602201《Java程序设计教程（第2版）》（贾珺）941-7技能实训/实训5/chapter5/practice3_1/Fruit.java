/* Fruit.java */
package chapter5.practice3_1;
public class Fruit {
	private String name;				// 定义水果名name
	private String area;					// 定义水果产地area
	private float price;					// 定义水果单价price
	void setName(String name) {			//给name赋值
		this.name = name;
	}
	String getName() {					//获取name
		return name;
	}
	void setArea(String area) {			//给area赋值
		this.area = area;
	}
	String getArea() {					//获取area
		return area;
	}
	void setPrice(float price) {			//给price赋值
		this.price = price;
	}
	float getPrice() {					//获取price
		return price;
	}
}

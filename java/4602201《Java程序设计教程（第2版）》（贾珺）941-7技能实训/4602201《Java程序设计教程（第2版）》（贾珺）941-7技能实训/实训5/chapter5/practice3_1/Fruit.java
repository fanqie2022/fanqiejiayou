/* Fruit.java */
package chapter5.practice3_1;
public class Fruit {
	private String name;				// ����ˮ����name
	private String area;					// ����ˮ������area
	private float price;					// ����ˮ������price
	void setName(String name) {			//��name��ֵ
		this.name = name;
	}
	String getName() {					//��ȡname
		return name;
	}
	void setArea(String area) {			//��area��ֵ
		this.area = area;
	}
	String getArea() {					//��ȡarea
		return area;
	}
	void setPrice(float price) {			//��price��ֵ
		this.price = price;
	}
	float getPrice() {					//��ȡprice
		return price;
	}
}

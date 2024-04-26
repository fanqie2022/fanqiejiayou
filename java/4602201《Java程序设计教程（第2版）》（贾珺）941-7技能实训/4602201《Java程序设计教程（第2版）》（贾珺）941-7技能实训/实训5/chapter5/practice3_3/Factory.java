/* Factory.java */
package chapter5.practice3_3;
public abstract class Factory {
	String name;							// ���幤����name
	public String getName() {				// ���ù�����
		return name;
	}
	public void setName(String name) {		// ��ȡ������
		this.name = name;
	}
	public abstract String produce();			// ������󷽷������ز�Ʒ��
}
class PhonePlant extends Factory {			// ����PhonePlant�࣬�̳�Factory��
	String productsName;					// �����Ʒ��productsName
	
	public PhonePlant(String productsName) {	// �����вι��췽�������ݲ�Ʒ��
		this.productsName = productsName;
	}
	@Override
	public String produce() {				// ��дproduce()����
		return this.productsName;
	}
}
class ClothsFactory extends Factory {			// ����ClothsFactory�࣬�̳�Factory��
	String productsName;					// �����Ʒ��productsName
	
	public ClothsFactory(String productsName) {// �����вι��췽�������ݲ�Ʒ��
		this.productsName = productsName;
	}
	@Override
	public String produce() {				// ��дproduce()����
		return this.productsName;
	}
}

/* FactoryTest */
package chapter5.practice3_3;
public class FactoryTest {
	public static void main(String[] args) {
		// ����PhonePlant�����
		PhonePlant phonePlant = new PhonePlant("�ֻ�");
		phonePlant.setName("�ֻ���");		// ���ù�����
		// �����Ʒ
		System.out.println(phonePlant.getName() + "��������" 
				+ phonePlant.productsName);
		// ����ClothsFactory�����
		ClothsFactory clothsFactory = new ClothsFactory("�·�");
		clothsFactory.setName("���γ�");		// ���ù�����
		// �����Ʒ
		System.out.println(clothsFactory.getName() + "��������" 
				+ clothsFactory.productsName);
	}
}

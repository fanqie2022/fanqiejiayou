/* FruitTest.java */
package chapter5.practice3_1;
public class FruitTest {
	public static void main(String[] args) {
		Fruit f1 = new Fruit();			// ����ˮ�������f1
		f1.setName("ƻ��");			// ����setName()��������name��ֵ
		f1.setArea("ɽ����̨");			// ����setArea()��������area��ֵ
		f1.setPrice(5.99f);				// ����setPrice()��������price��ֵ
		// ���f1��name��area��price
		System.out.println(f1.getName() + " " + f1.getArea() + " " + f1.getPrice() + "Ԫ/��");
		Fruit f2 = new Fruit();			// ����ˮ�������f2
		f2.setName("���¹�����");		// ����setName()��������name��ֵ
		f2.setArea("�Ĵ�üɽ");			// ����setArea()��������area��ֵ
		f2.setPrice(7.99f);				// ����setPrice()��������price��ֵ
		// ���f2��name��area��price
		System.out.println(f2.getName() + " " + f2.getArea() + " " + f2.getPrice() + "Ԫ/��");
		Fruit f3 = new Fruit();			// ����ˮ�������f3
		f3.setName("������");			// ����setName()��������name��ֵ
		f3.setArea("��������");			// ����setArea()��������area��ֵ
		f3.setPrice(39.99f);				// ����setPrice()��������price��ֵ
		// ���f3��name��area��price
		System.out.println(f3.getName() + " " + f3.getArea() + " " + f3.getPrice() + "Ԫ/��");
	}
}

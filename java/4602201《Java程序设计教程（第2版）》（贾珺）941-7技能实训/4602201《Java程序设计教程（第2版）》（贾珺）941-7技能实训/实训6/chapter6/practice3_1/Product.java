/* Product.java */
package chapter6.practice3_1;
public abstract class Product {
	public static void main(String[] args) {
		String[] product= new String[] { "��Ϊ�ֻ�", "�����ֻ�", 
			"�����յ�", "С�׵���", "��Ϊ����", "����������", 
			"��Ϊ·����", "��������ˮ��", "��Ϊ������֬��" };
		int sum = 0;
		for (int i = 0; i < product.length; i++) {
			String name = product[i];
			if (name.startsWith("��Ϊ")) {
				sum++;
			}
		}
		System.out.println("��ΪƷ�Ƶĵ�������" + sum + "��");
	}
}

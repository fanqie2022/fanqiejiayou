/* Practice1_3.java */
public class Practice1_3 {
	public static void main(String[] args) {
		double height = 1.72;					// ��ߣ���λΪm
		int weight = 70;							// ���أ���λΪkg
		// BMI���㹫ʽ
		double exponent = weight / (height * height);
		System.out.println("�������Ϊ��" + height);
		System.out.println("��������Ϊ��" + weight);
		System.out.println("����BMIָ��Ϊ��" + exponent);
	}
}

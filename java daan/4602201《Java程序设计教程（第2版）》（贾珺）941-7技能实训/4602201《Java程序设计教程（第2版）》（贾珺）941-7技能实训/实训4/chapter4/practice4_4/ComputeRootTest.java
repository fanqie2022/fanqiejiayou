/* ComputeRootTest.java*/
package chapter4.practice4_4;
public class ComputeRootTest {
	public static void main(String[] args) {
		ComputeRoot y1, y2;				// ��������
		y1 = new ComputeRoot(1, 5, 10);		// ʹ���вι��췽����������
		y1.showRoot();					// ����showRoot����
		y2 = new ComputeRoot(1, 10, 9);
		y2.showRoot();

	}

}
class ComputeRoot {
	double x1, x2;
	private double a, b, c;
	// ���������췽����ʼ����Ա����
	public ComputeRoot(double a, double b, double c) {		
		this.a = a;
		this.b = b;
		this.c = c;
	}
// ���㷽��ʵ���ķ���
	void real_root(double delt) {
		x1 = (-b + Math.sqrt(delt)) / (2 * a);
		x2 = (-b - Math.sqrt(delt)) / (2 * a);
		System.out.println("delt>=0�����̵�ʵ��Ϊ\nx1=" + x1);	// ������̵�ʵ��
		System.out.println("x2=" + x2);
	}
	// ���㷽������ķ���
	void imag_root(double delt) {
		double real, imag;
		real = (-b) / (2 * a);
		imag = Math.sqrt(-delt) / (2 * a);
		System.out.println("delt<0�����̵����Ϊ\nx1=" + real + "+" + imag + "i");
		System.out.println("x2=" + real + "-" + imag + "i");
	}
	// �����б�ʽdelt��ֵ��ѡ����õķ���
	void showRoot() {
		double delt = b * b - 4 * a * c;
		if (delt >= 0)
			real_root(delt);
		else
			imag_root(delt);
	}
}

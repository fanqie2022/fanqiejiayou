/*ComputeMaxMin.java*/
package chapter4.practice4_2.math;
public class ComputeMaxMin {
	double num1, num2, num3, num4, num5;
	// �����вι��췽��������ʼ����Ա����
	public ComputeMaxMin(double num1, double num2, double num3, double num4, double num5) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
	}
	public double max() {			// ���巽���������ֵ
		double max;
		max = Math.max(num1, num2);// ����Math����max���������������Ľϴ�ֵ
		max = Math.max(max, num3);
		max = Math.max(max, num4);
		max = Math.max(max, num5);	
		return max;					// �������ֵ
	}
	public double min() {				// ���巽��������Сֵ
		double min;
		min = Math.min(num1, num2);// ����Math���е�min���������������Ľ�Сֵ
		min = Math.min(min, num3);
		min = Math.min(min, num4);
		min = Math.min(min, num5);	
		return min;					// ������Сֵ
	}
}

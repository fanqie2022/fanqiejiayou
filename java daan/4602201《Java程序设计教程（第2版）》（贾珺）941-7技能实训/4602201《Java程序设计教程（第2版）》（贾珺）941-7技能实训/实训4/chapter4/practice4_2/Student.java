/* Student.java */
package chapter4.practice4_2;
//����chapter4.practice4_2.math.ComputeMaxMin��
//import chapter4.practice4_2.math.ComputeMaxMin; //���ѵ����3��ȡ��ע��

public class Student {
	String sNo;
	String sName;
	char sSex;
	int sAge;
	double sJava;
	// �����вι��췽������ʼ����Ա����
	Student(String sNo, String sName, char sSex, int sAge, double sJava) {
		this.sNo = sNo;
		this.sName = sName;
		this.sSex = sSex;
		this.sAge = sAge;
		this.sJava = sJava;
	}
	String getNo( ) {				// ��ȡѧ��
		return sNo;
	}
	String getName( ) {				// ��ȡ����
		return sName;
	}
	char getSex( ) {				// ��ȡ�Ա�
		return sSex;
	}
	int getAge( ) {					// ��ȡ����
		return sAge;
	}
	double getJava( ) {				// ��ȡJava�γ̳ɼ�
		return sJava;
	}
	// ��ʾѧ����Ϣ
	public void display() {
		System.out.println("ѧ�ţ�" + sNo + " " + "������" + sName + " " + "�Ա�" + sSex + " " + "���䣺" + sAge + " " + "Java�γ̳ɼ���" + sJava);
	}
	public static void main(String[] args) {
		// �������󲢳�ʼ������
		Student s1 = new Student("001", "��һ", '��', 18, 80);
		Student s2 = new Student("002", "���", 'Ů', 19, 75.5);
		Student s3 = new Student("003", "����", 'Ů', 20, 90);
		Student s4 = new Student("004", "����", '��', 18, 88);
		Student s5 = new Student("005", "Ǯ��", '��', 20, 70);
		s1.display();				// ����display����
		s2.display();
		s3.display();
		s4.display();
		s5.display();
		// ����ComputeMaxMin����󲢳�ʼ�����󣬱��ѵ����3��ȡ������ע��
		/*ComputeMaxMin c= new ComputeMaxMin(s1.sJava, s2.sJava, s3.sJava, s4.sJava, s5.sJava);
		System.out.println("Java�γ̳ɼ����ֵ��" + c.max());// ����max���������Java�γ̳ɼ����ֵ
		System.out.println("Java�γ̳ɼ���Сֵ��" + c.min());// ����min���������Java�γ̳ɼ���Сֵ*/

	}
}

/* StudentManage.java */
package chapter7.practice3_2;
import java.util.*;
class Student {
	String name;						// ��������name
	char sex;							// �����Ա�sex
	int age;							// ��������age
	// �����вι��췽������ʼ��stuName��stuSex��stuAge
	public Student(String name, char sex, int age) {
		this.name = name;
		this.sex = sex;
		this. age = age;
	}
}
public class StudentManage {
	public static void main(String[] args) {
		// ��������ΪStudent���ArrayList����stuList1
		List<Student> stuList1 = new ArrayList<Student>();
		// ��stuList1�����3��Student����
		stuList1.add(new Student("������", '��', 7));
		stuList1.add(new Student("���", '��', 9));
		stuList1.add(new Student("����", 'Ů', 8));
		// ����stuList1
		for (int i = 0; i < stuList1.size(); i++) {
			Student s = stuList1.get(i);
			// ����get()������ȡstuList1�е�Ԫ�ز����
			System.out.println(s.name + "\t" + s.sex + "\t" + s.age + "\t");
		}
	}
}

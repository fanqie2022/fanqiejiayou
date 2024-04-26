/* StudentManage.java */
package chapter7.practice3_3;
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
		// ��������ΪStudent���ArrayList����stuList1��stuList2��stuList3
		List<Student> stuList1 = new ArrayList<Student>();
		List<Student> stuList2 = new ArrayList<Student>();
		List<Student> stuList3 = new ArrayList<Student>();
		// ������ΪString�ͣ�ֵΪList���͵�Map����stuGrade
		Map<String, List<Student>> stuGrade = new HashMap<String, List<Student>>();
		// ��stuList1�����3��Student����
		stuList1.add(new Student("������", '��', 7));
		stuList1.add(new Student("���", '��', 9));
		stuList1.add(new Student("����", 'Ů', 8));
		// ��stuList2�����3��Student����
		stuList2.add(new Student("����", '��', 10));
		stuList2.add(new Student("�ŷ�", '��', 8));
		stuList2.add(new Student("�����", '��', 9));
		// ��stuList3�����3��Student����
		stuList3.add(new Student("����", '��', 11));
		stuList3.add(new Student("����", '��', 12));
		stuList3.add(new Student("����", '��', 10));
		// ��stuGrade�����3����-ֵ��
		stuGrade.put("���꼶һ��", stuList1);
		stuGrade.put("���꼶����", stuList2);
		stuGrade.put("���꼶һ��", stuList3);
		Scanner scan = new Scanner(System.in);
		System.out.print("������༶���ƣ�");
		String inputClass = scan.nextLine();
		System.out.println(inputClass + "��ѧ���б�");
		// ʹ��get������ȡ�������Ӧ��ֵ��������stulist
		List<Student> stulist = stuGrade.get(inputClass);
		// ����stulist
		for (int i = 0; i < stulist.size(); i++) {
			Student s = stulist.get(i);
			// ����get()������ȡstulist�е�Ԫ�ز����
			System.out.println(s.name + "\t" + s.sex + "\t" + s.age + "\t");
		}
		scan.close();							// �ر�ɨ����
	}
}

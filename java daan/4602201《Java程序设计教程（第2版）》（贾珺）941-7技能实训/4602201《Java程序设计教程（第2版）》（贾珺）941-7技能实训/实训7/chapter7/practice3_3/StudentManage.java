/* StudentManage.java */
package chapter7.practice3_3;
import java.util.*;
class Student {
	String name;						// 定义姓名name
	char sex;							// 定义性别sex
	int age;							// 定义年龄age
	// 定义有参构造方法，初始化stuName、stuSex和stuAge
	public Student(String name, char sex, int age) {
		this.name = name;
		this.sex = sex;
		this. age = age;
	}
}
public class StudentManage {
	public static void main(String[] args) {
		// 创建类型为Student类的ArrayList对象stuList1、stuList2和stuList3
		List<Student> stuList1 = new ArrayList<Student>();
		List<Student> stuList2 = new ArrayList<Student>();
		List<Student> stuList3 = new ArrayList<Student>();
		// 创建键为String型，值为List类型的Map对象stuGrade
		Map<String, List<Student>> stuGrade = new HashMap<String, List<Student>>();
		// 向stuList1中添加3个Student对象
		stuList1.add(new Student("张三丰", '男', 7));
		stuList1.add(new Student("杨过", '男', 9));
		stuList1.add(new Student("郭靖", '女', 8));
		// 向stuList2中添加3个Student对象
		stuList2.add(new Student("刘备", '男', 10));
		stuList2.add(new Student("张飞", '男', 8));
		stuList2.add(new Student("诸葛亮", '男', 9));
		// 向stuList3中添加3个Student对象
		stuList3.add(new Student("许嵩", '男', 11));
		stuList3.add(new Student("刘能", '男', 12));
		stuList3.add(new Student("马三", '男', 10));
		// 向stuGrade中添加3个键-值对
		stuGrade.put("三年级一班", stuList1);
		stuGrade.put("三年级二班", stuList2);
		stuGrade.put("四年级一班", stuList3);
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入班级名称：");
		String inputClass = scan.nextLine();
		System.out.println(inputClass + "的学生列表：");
		// 使用get方法获取输入键对应的值，并赋给stulist
		List<Student> stulist = stuGrade.get(inputClass);
		// 遍历stulist
		for (int i = 0; i < stulist.size(); i++) {
			Student s = stulist.get(i);
			// 调用get()方法获取stulist中的元素并输出
			System.out.println(s.name + "\t" + s.sex + "\t" + s.age + "\t");
		}
		scan.close();							// 关闭扫描器
	}
}

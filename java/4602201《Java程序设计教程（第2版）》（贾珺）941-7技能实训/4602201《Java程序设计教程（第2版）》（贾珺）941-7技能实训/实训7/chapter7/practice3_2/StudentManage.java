/* StudentManage.java */
package chapter7.practice3_2;
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
		// 创建类型为Student类的ArrayList对象stuList1
		List<Student> stuList1 = new ArrayList<Student>();
		// 向stuList1中添加3个Student对象
		stuList1.add(new Student("张三丰", '男', 7));
		stuList1.add(new Student("杨过", '男', 9));
		stuList1.add(new Student("郭靖", '女', 8));
		// 遍历stuList1
		for (int i = 0; i < stuList1.size(); i++) {
			Student s = stuList1.get(i);
			// 调用get()方法获取stuList1中的元素并输出
			System.out.println(s.name + "\t" + s.sex + "\t" + s.age + "\t");
		}
	}
}

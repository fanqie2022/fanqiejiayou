/* Move.java */
package chapter5.practice1;
public interface Move {
	public void work();
	public void talk();
}
class Student implements Move {
	public String name;
	public Student(String name) {
		this.name = name;
	}
	@Override
	public void work() {
		System.out.println(name + "����ʼ�Ǳʼ�");
	}
	@Override
	public void talk() {
		System.out.println(name + "����ʦ��");
	}
}
class Teacher implements Move {
	public String name;
	public Teacher(String name) {
		this.name = name;
	}
	@Override
	public void work() {
		System.out.println(name + "����ʼ�Ͽ�");
	}
	@Override
	public void talk() {
		System.out.println(name + "��ͬѧ�Ǻ�");
	}
}

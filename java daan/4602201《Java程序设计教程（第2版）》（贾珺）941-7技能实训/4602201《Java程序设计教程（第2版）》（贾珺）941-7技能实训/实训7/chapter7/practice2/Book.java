/* Book.java */
package chapter7.practice2;
import java.util.*;
public class Book {
	public static void main(String[] args) {
		List<String> shelf = new ArrayList<>();
		shelf.add("���������塷");
		shelf.add("��ɯʿ����ʫѡ��");
		shelf.add("����¥�Ρ�");
		System.out.println("����ϵ��鼮��" + shelf); 
		List<String> desk = new ArrayList<>();
		desk.add("�����μǡ�");
		desk.add("��ˮ䰴���");
		System.out.println("�����ϵ��鼮��" + desk);
		shelf.add(0, desk.get(1));
		shelf.set(2, desk.get(0));                  
		System.out.print("�й����Ĵ������ֱ��ǣ�"); 
		for (int i = 0; i < shelf.size(); i++) {
			System.out.print(shelf.get(i) + " ");
		}
	}
}

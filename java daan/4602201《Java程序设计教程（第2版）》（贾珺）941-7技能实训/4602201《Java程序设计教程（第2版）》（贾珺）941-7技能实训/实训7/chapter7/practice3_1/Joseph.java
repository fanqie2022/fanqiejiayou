/* Joseph.java */
package chapter7.practice3_1;
import java.util.LinkedList;
public class Joseph {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();	// ����int��List����list
		for(int i=0;i<500;i++) {						// ѭ��500��
			list.add(i);						// ʹ��add()������i��ӵ�list��
		}
		int index=0;							// ����index������Ϊ0
		int count=0;							// ����count������Ϊ0
		while(list.size()>1) {					// ѭ��
			count++;							// count��1
			if(count%3==0) {					// ���count�ܱ�3����
				list.remove(index);				// ɾ��list������Ϊindex��Ԫ��
				index--;						// index��1
			}
			index ++;							// index��1
			if(index ==list.size()) {				// ���index����list�ĳ���
				index =0;						// index��Ϊ0
			}
		}
		System.out.println(list);					// ���list
	}
}


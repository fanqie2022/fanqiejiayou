/* Joseph.java */
package chapter7.practice3_1;
import java.util.LinkedList;
public class Joseph {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();	// 创建int型List对象list
		for(int i=0;i<500;i++) {						// 循环500次
			list.add(i);						// 使用add()方法将i添加到list中
		}
		int index=0;							// 定义index，并赋为0
		int count=0;							// 定义count，并赋为0
		while(list.size()>1) {					// 循环
			count++;							// count加1
			if(count%3==0) {					// 如果count能被3整除
				list.remove(index);				// 删除list中索引为index的元素
				index--;						// index减1
			}
			index ++;							// index加1
			if(index ==list.size()) {				// 如果index等于list的长度
				index =0;						// index赋为0
			}
		}
		System.out.println(list);					// 输出list
	}
}


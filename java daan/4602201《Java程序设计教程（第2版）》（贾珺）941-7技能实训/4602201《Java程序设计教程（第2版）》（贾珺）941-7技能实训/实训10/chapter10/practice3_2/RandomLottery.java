/* RandomLottery.java */
package chapter10.practice3_2;
import java.util.Random;
class RandomNunm extends Thread{
	String name;
	RandomNunm(String name) {				// �вι��췽��������Ϊ�߳���
		this.name = name;
	}
	int[] array = new int[3];						// ���峤��Ϊ3������
	public void run( ) {
		Random random = new Random(); 		// �������������random
		for (int i = 0; i< 3; i++) {
			array[i] = random.nextInt(10) + 1;		// ����1��10�������
			try {
				sleep(100);					// �߳�����0.1s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "��" + array[0] + " " + array[1] + " " + array[2] + " ");
	}
}
public class RandomLottery {
	public static void main(String[] args) {
		RandomNunm[] t = new RandomNunm[10];		// �����߳����飬����Ϊ10
		// ѭ������RandomNunm�����ͨ���вι��췽�������̣߳��������߳�
		for (int i = 0; i < t.length; i++) {
			t[i] = new RandomNunm("�߳�" + String.valueOf(i + 1));
			t[i].start();
		}
	}
}

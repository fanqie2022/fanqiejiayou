/* Race.java */
package chapter10.practice3_1;
class Rabbit implements Runnable {			// ���������ܲ��߳���Rabbit
	@Override
	public void run() {
		// �����ڹ��ܲ��̶߳���
		Tortoise runTortoise = new Tortoise();
		Thread tortoise = new Thread(runTortoise);
		tortoise.start();						// �����ڹ��ܲ��߳�
		for (int i = 1; i <= 10; i++) {			// ѭ��10��ģ�����ܵĹ���
			try {
				Thread.sleep(100);			// �߳�����0.1�룬ģ���������ܲ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("��������" + i * 10 + "��");	// ��ʾ���ӵ��ܲ�����
			if (i == 8) {
				System.out.println("������˯��");		// ������80��ʱ��ʼ˯��
				try {
					tortoise.join();						// Tortoise�̼߳���
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println( "���ӵ����յ�");				// ��ʾ���ӵ������յ�
	}
}
class Tortoise implements Runnable {					// �����ڹ��ܲ��߳���Tortoise
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(500);				// �߳�����0.5�룬ģ���ڹ����ܲ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�ڹ�����" + i * 10 + "��");	// ��ʾ���ӵ��ܲ�����
		}
		System.out.println("�ڹ굽���յ�");
	}
}
public class Race {
	public static void main(String[] args) {
		// �����ڹ��ܲ��̶߳���
		Runnable runRabbit = new Rabbit();	
		Thread rabbit = new Thread(runRabbit);
		rabbit.start();									// ���������ܲ��߳�
	}
}

/* Children.java */
package chapter10.practice3_3;
class WatchingTV extends Thread {
	int minutes = 0;
	@Override
	public void run() {
		while (true) {
			try {
				sleep(60000);		// �߳�����1����
				System.out.println("С���ѿ�����ʱ����" + (++minutes) + "����");
				if (minutes == 20) {
					interrupt();			// �߳��ж�
				}
			} catch (InterruptedException e) {
				System.out.println("��������ȥд��ҵ��С���ѹص�����ȥд��ҵ");
				break;					// �˳�ѭ��
			}
		}
	}
}
public class Children {
	public static void main(String[] args) {
		new WatchingTV().start();			// ����WatchingTV����󣬲������߳�
	}
}

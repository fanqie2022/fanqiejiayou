/* Children.java */
package chapter10.practice3_3;
class WatchingTV extends Thread {
	int minutes = 0;
	@Override
	public void run() {
		while (true) {
			try {
				sleep(60000);		// 线程休眠1分钟
				System.out.println("小朋友看电视时长：" + (++minutes) + "分钟");
				if (minutes == 20) {
					interrupt();			// 线程中断
				}
			} catch (InterruptedException e) {
				System.out.println("妈妈让他去写作业，小朋友关掉电视去写作业");
				break;					// 退出循环
			}
		}
	}
}
public class Children {
	public static void main(String[] args) {
		new WatchingTV().start();			// 创建WatchingTV类对象，并启动线程
	}
}

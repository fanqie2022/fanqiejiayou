/* Race.java */
package chapter10.practice3_1;
class Rabbit implements Runnable {			// 创建兔子跑步线程类Rabbit
	@Override
	public void run() {
		// 创建乌龟跑步线程对象
		Tortoise runTortoise = new Tortoise();
		Thread tortoise = new Thread(runTortoise);
		tortoise.start();						// 启动乌龟跑步线程
		for (int i = 1; i <= 10; i++) {			// 循环10次模拟赛跑的过程
			try {
				Thread.sleep(100);			// 线程休眠0.1秒，模拟兔子在跑步
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("兔子跑了" + i * 10 + "米");	// 显示兔子的跑步距离
			if (i == 8) {
				System.out.println("兔子在睡觉");		// 当跑了80米时开始睡觉
				try {
					tortoise.join();						// Tortoise线程加入
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println( "兔子到达终点");				// 显示兔子到达了终点
	}
}
class Tortoise implements Runnable {					// 创建乌龟跑步线程类Tortoise
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(500);				// 线程休眠0.5秒，模拟乌龟在跑步
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("乌龟跑了" + i * 10 + "米");	// 显示兔子的跑步距离
		}
		System.out.println("乌龟到达终点");
	}
}
public class Race {
	public static void main(String[] args) {
		// 创建乌龟跑步线程对象
		Runnable runRabbit = new Rabbit();	
		Thread rabbit = new Thread(runRabbit);
		rabbit.start();									// 启动兔子跑步线程
	}
}

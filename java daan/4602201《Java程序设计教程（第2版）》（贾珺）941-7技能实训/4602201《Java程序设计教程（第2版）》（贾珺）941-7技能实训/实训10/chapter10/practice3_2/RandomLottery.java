/* RandomLottery.java */
package chapter10.practice3_2;
import java.util.Random;
class RandomNunm extends Thread{
	String name;
	RandomNunm(String name) {				// 有参构造方法，参数为线程名
		this.name = name;
	}
	int[] array = new int[3];						// 定义长度为3的数组
	public void run( ) {
		Random random = new Random(); 		// 创建随机数对象random
		for (int i = 0; i< 3; i++) {
			array[i] = random.nextInt(10) + 1;		// 生成1～10的随机数
			try {
				sleep(100);					// 线程休眠0.1s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "：" + array[0] + " " + array[1] + " " + array[2] + " ");
	}
}
public class RandomLottery {
	public static void main(String[] args) {
		RandomNunm[] t = new RandomNunm[10];		// 定义线程数组，长度为10
		// 循环创建RandomNunm类对象，通过有参构造方法命名线程，并启动线程
		for (int i = 0; i < t.length; i++) {
			t[i] = new RandomNunm("线程" + String.valueOf(i + 1));
			t[i].start();
		}
	}
}

/* Subtraction.java */
package chapter10.practice2;
public class Subtraction implements Runnable {
	int num = 10;	
	public synchronized void subtraction() {
		if (num > 0) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() 
					+ "说：num的值为" + num--);
		}
	}
	public void run() {
		for (int i = 0; i < 10; i++)
			subtraction();
	}
	public static void main(String[] args) {
		Subtraction t = new Subtraction();
		Thread t1 = new Thread(t, "t1");
		Thread t2 = new Thread(t, "t2");
		t1.start();
		t2.start();
	}
}

/* NumOutput.java */
package chapter10.practice1;
public class NumOutput extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Êý×Ö" + i);
			try {
				sleep(500);              
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		NumOutput t = new NumOutput();
		t.start();                
	}
}

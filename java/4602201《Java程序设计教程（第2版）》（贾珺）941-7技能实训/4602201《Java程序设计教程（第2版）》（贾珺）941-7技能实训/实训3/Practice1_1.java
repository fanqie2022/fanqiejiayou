/* Practice1_1.java */
import java.util.Scanner;
public class Practice1_1 {
	public static void main(String[] args) {
		float x, y;
		Scanner scan = new Scanner(System.in);
		System.out.print("«Î ‰»Îx£∫");
		x = scan.nextFloat();
		if (x <= 0.0)
			y = 0.0f;
		else if (x < 10.0)
			y = 1.0f / x;
		else
			y = 1.0f;
		System.out.println("y = " + y);
		scan.close();
	}
}

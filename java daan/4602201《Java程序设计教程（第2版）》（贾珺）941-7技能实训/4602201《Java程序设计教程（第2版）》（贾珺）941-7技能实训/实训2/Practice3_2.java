/* Practice3_2.java */
import java.util.Scanner;
public class Practice3_2 {
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);		//����Scanner����
		System.out.println("������һ��������");
		int num=scan.nextInt();				//ɨ��Ϊint������
		String check=(num%2!=0)?"�����������������":"�������������ż��";
		System.out.println(check);			//�����ż�жϽ��
		scan.close();
	}
}

package shushangshixun.shixun3;

import java.util.Scanner;

public class sd1_c1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("������һ������ (1~20)��");
        int num = scan.nextInt();
        System.out.println(num + "�Ľ׳�Ϊ��" + factorial(num));
    }
    public static long factorial(int n) {
       if (n == 1) {
            return 1;
       }
       return n * factorial(n - 1);
    }
}

package shushangshixun.shixun3;

import java.util.Scanner;

public class sd1_s {
    public static void main(String[] args){
        long result = 1;
        Scanner scan = new Scanner(System.in);
        System.out.println("������һ������ (1~20)��");
        int num = scan.nextInt();
        for(int i = 1;i <= num;i++){
            result *= i;
        }
        System.out.println(num + "�Ľ׳�Ϊ��" + result);
        scan.close();
    }
}

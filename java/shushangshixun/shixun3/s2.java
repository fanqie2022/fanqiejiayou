package shushangshixun.shixun3;

import java.util.Scanner;

public class s2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("�������������ѽ�");
        int money = scan.nextInt();
        switch (money / 200){
            case 0:
                System.out.println("�������ѣ�" + money + "Ԫ����δ����200Ԫ�밴��СƱ�۸�֧��ȫ���" + money +"Ԫ");
                break;
            case 1:
            case 2:
                System.out.println("�������ѣ�" + money + "Ԫ��������200Ԫ����δ����600Ԫ��ȫ�������ѽ�����8.5���Żݣ���" + (money * 0.85) +"Ԫ");
                break;
            case 3:
            case 4:
                System.out.println("�������ѣ�" + money + "Ԫ��������600Ԫ����δ����1000Ԫ��ȫ�������ѽ�����7���Żݣ���" + (money * 0.7) +"Ԫ");
                break;
            default:
                System.out.println("�������ѣ�" + money + "Ԫ��������1000Ԫ��ȫ�������ѽ�����6���Żݣ���" + (money * 0.6) +"Ԫ");
                break;
        }
        scan.close();
    }
}

package shushangshixun.shixun8;

import java.util.*;

public class s1 {
    public static void main(String[] args){
        double l = 1023.79;
        Scanner s = new Scanner(System.in);
        System.out.println("������ȡ����");
        try {
            int d = s.nextInt();
            double r = l - d;
            if(r >= 0){
                System.out.println("���˻�����" + r + "Ԫ");
            }else{
                System.out.println("���˻������㣡");
            }
        }
        catch(Exception e){
            System.out.println("�������ȡ�����������");
        }finally{
            s.close();
        }
    }
}

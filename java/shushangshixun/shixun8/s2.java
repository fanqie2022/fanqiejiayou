package shushangshixun.shixun8;

import java.util.*;

class OverflowException extends Exception{
    public OverflowException(double w){
        System.out.println("�쳣��ʾ����Ʒ������Ϊ" + w + "�����3���ˣ������ˣ�����");
    }
}
public class s2 {
    public static void pay(double w) throws OverflowException {
        if (w > 30){
            throw new OverflowException(w);
        }
        double m = w * 3.98;
        System.out.println(m);
    }
    public static void main(String[] args){
        System.out.println("��������Ʒ�����������");
        Scanner s = new Scanner(System.in);
        double w = s.nextDouble();
        try {
            pay(w);
        }catch(OverflowException e) {

        }finally{
            s.close();
        }
    }
}

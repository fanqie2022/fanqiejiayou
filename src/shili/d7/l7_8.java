package shili.d7;

import java.util.*;

public class l7_8 {
    public static void main(String[] args){
        //����
        HashMap<String,Integer> m = new HashMap<String,Integer>();
        //����put
        m.put("a",20000);
        m.put("b",99999999);
        m.put("c",20097700);
        m.put("awwwww",2003300);
        m.put("bjhsjhscjhcs",99999);
        //�������
        Scanner s = new Scanner(System.in);
        //�������
        String jx;
        while (true) {
            //���
            System.out.println("=====��ѡ���ȡ��=====");
            System.out.println("1.���         2.ȡ��");
            System.out.println("��ѡ��");
            //����
            int see = s.nextInt();
            //���ȡ
            if (see == 1) {
                System.out.println("�������˻����ʹ����(�ð�Ƕ��Ÿ���)");
            } else if (see == 2) {
                System.out.println("�������˻�����ȡ����(�ð�Ƕ��Ÿ���)");
            }
            //����
            String acc = s.next();
            String[] sAcc = acc.split(",");
            if (m.containsKey(sAcc[0])){
                Integer mo = m.get(sAcc[0]);
                if (see == 1){
                    mo += Integer.parseInt(sAcc[1]);
                } else if (see == 2) {
                    mo -= Integer.parseInt(sAcc[1]);
                }
                System.out.println(sAcc[0] + "�˻����Ϊ" + mo + "Ԫ");
                System.out.println("����Ҫ����ȡ���𣿣���y����n��");//T or F
                jx = s.next();
            } else {
                System.out.println("���˻������ڣ�");
                break;
            }
            if (jx == "n"){
                break;
            }
        }
        s.close();
    }
}
package shili.d7;

import java.util.*;

public class l7_3 {
    public static void main(String[] args) {
        System.out.println("���� ǩ��ʱ��");
        ArrayList<String> listEmployee = new ArrayList<String>();
        listEmployee.add("��� 8��25");
        listEmployee.add("��ƽ 8��29");
        listEmployee.add("��� 8��35");
        listEmployee.add("���� 8��31");
        listEmployee.add("���� 9��00");
        for (int i = 0;i < listEmployee.size();i++){
            System.out.println(listEmployee.get(i));
        }
    }
}

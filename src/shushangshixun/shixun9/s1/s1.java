package shushangshixun.shixun9.s1;
import java.io.*;
import java.util.*;
public class s1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("������Ҫд����ļ����� ");
        String f  =s.nextLine();
        String[] c = { "�ԾƵ���", "��������", "Ʃ�糯¶", "ȥ�տ��", "���Ե���", "��˼����", "���Խ���", "Ψ�жſ�" };
        FileWriter fw = null;
        try {
            fw = new FileWriter(f,true);
            for (int i = 0;i < c.length;i++){
                fw.write(c[i] + "\n");
            }
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        s.close();
    }
}

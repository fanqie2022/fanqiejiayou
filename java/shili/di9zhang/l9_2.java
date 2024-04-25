package shili.di9zhang;

import java.io.*;

public class l9_2 {
    public static void main(String[] args) {
        try {
            FileOutputStream fos;
            fos = new FileOutputStream("FileStreamTest.txt");
            String data = "���ǳ�����׼���Ľ׶������˷�ʱ�䣬\n" + "ֻ�е������������٣����Լ�û���������յ�ʱ��\n" + "���ܾ����Լ�ƽʱû��׼�������˷���ʱ�䡣\n" + "��������.����";
            byte[] outData = data.getBytes();
            fos.write(outData);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fis;
            fis = new FileInputStream("FileStreamTest.txt");
            byte[] inData = new byte[1024];
            int len = fis.read(inData);
            String outString = new String(inData, 0, len);
            System.out.println(outString);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
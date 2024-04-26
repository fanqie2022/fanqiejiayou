/* StudentSystem.java */
package chapter9.practice3_2;
import java.io.*;
import java.util.*;
public class StudentSystem {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<HashMap<String, String>> stuInfos = new ArrayList<>();
	
	// ���������Ϣ
	public static void printMenu() {
		System.out.println("********ѧ������ϵͳ********");
		System.out.println("1.���ѧ����Ϣ");
		System.out.println("2.ɾ��ѧ����Ϣ");
		System.out.println("3.��ʾ����ѧ����Ϣ");
		System.out.println("4.��������");
		System.out.println("5.�ָ�����");
		System.out.println("0.�˳�ϵͳ");
		System.out.println("============================");
	}
	// �Ӽ���������ѧ����ѧ�š��������Ա�
	// ��ÿ��ѧ������Ϣ��ӵ�Map�У�Ȼ��Map��ӵ�List��
	public static void addStuInfo() {
		HashMap<String, String> newInfo = new HashMap<>();
		System.out.print("��������ѧ����ѧ�ţ�");
		newInfo.put("num", scan.next());
		System.out.print("��������ѧ����������");
		newInfo.put("name", scan.next());
		System.out.print("��������ѧ�����Ա���/Ů����");
		newInfo.put("sex", scan.next());
		stuInfos.add(newInfo);
	}
	// ���������ѧ�Ż�ȡ���б��е�������Ȼ��ɾ����ѧ����Ϣ
	public static void delStuInfo() {
		if (stuInfos.size() > 0) {
			System.out.print("������Ҫɾ����ѧ����ѧ�ţ�");
			String num = scan.next();
			for (int i = 0; i < stuInfos.size(); i++) {
				if (stuInfos.get(i).containsValue(num)) {
					stuInfos.remove(i);
					break;
				}
			}
		} else
			System.out.println("û�и�ѧ����Ϣ��");
		
	}
	// ��ʾ����ѧ������Ϣ
	public static void showStuInfo() {
		System.out.println("���\tѧ��\t����\t�Ա�");
		for (int i = 0; i < stuInfos.size(); i++) {
			System.out.println((i+1) + "\t" + stuInfos.get(i).get("num") + "\t" 
					+ stuInfos.get(i).get("name") + "\t" + stuInfos.get(i).get("sex"));
		}
	}
	// ��ѧ����Ϣ���浽�ļ���
	public static void saveStuInfo() {
		try {
			// ʹ��OutputStreamWriter�����ļ�������������ñ���ΪUTF-8
			OutputStreamWriter fw;
			fw = new OutputStreamWriter(new FileOutputStream("StudentInfo.txt"), "UTF-8");
			//fw = new FileWriter("StudentInfo.txt", true);
			for (int i = 0; i < stuInfos.size(); i++) { 
				fw.write((i+1) + "\t" + stuInfos.get(i).get("num") + "\t" 
						+ stuInfos.get(i).get("name") + "\t" 
						+ stuInfos.get(i).get("sex") + "\n");
			}
			fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	// ���ļ��ж�ȡѧ����Ϣ
	// ��ÿ��ѧ������Ϣ�洢��Map�У�Ȼ��Map�洢��List��
	public static void recoverStuInfo() {
		try {
			// ʹ��InputStreamReader�����ļ��������������ñ���ΪUTF-8
			InputStreamReader fr;
			fr = new InputStreamReader(new FileInputStream("StudentInfo.txt"), "UTF-8");
			char[] cBuff = new char[1024];
			int len = fr.read(cBuff);			// ��ȡ���ݣ����������ַ�����cBuff��
			String[] sBuff = new String(cBuff, 0, len).split("\n");
			String[] s;
			System.out.println("���\tѧ��\t����\t�Ա�");
			for (int i = 0; i< sBuff.length; i++) {
				HashMap<String, String> newInfo = new HashMap<>();
				System.out.println(sBuff[i]);
				s = sBuff[i].split("\t");
				newInfo.put("num", s[1]);
				newInfo.put("name", s[2]);
				newInfo.put("sex", s[3]);
				stuInfos.add(newInfo);
			}
			fr.close();
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}
	public static void main(String[] args) {
		// ѭ����������������֣����ò�ͬ�ķ���ʵ�ֲ�ͬ�Ĺ���
		while (true) {
			printMenu();
			System.out.print("�����빦�ܶ�Ӧ�����֣�");
			String key = scan.next();
			if (key.equals("0"))
				break;
			else if (key.equals("1"))
				 addStuInfo();
			else if (key.equals("2"))
				delStuInfo();
			else if (key.equals("3"))
				showStuInfo();
			else if (key.equals("4"))
				saveStuInfo();
			else if (key.equals("5"))
				recoverStuInfo();
			else
				System.out.println("Error!");
		}
	}
}

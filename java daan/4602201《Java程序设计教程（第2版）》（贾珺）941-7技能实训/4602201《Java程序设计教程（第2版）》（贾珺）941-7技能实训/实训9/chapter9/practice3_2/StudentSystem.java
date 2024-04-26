/* StudentSystem.java */
package chapter9.practice3_2;
import java.io.*;
import java.util.*;
public class StudentSystem {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<HashMap<String, String>> stuInfos = new ArrayList<>();
	
	// 输出功能信息
	public static void printMenu() {
		System.out.println("********学生管理系统********");
		System.out.println("1.添加学生信息");
		System.out.println("2.删除学生信息");
		System.out.println("3.显示所有学生信息");
		System.out.println("4.保存数据");
		System.out.println("5.恢复数据");
		System.out.println("0.退出系统");
		System.out.println("============================");
	}
	// 从键盘输入新学生的学号、姓名和性别
	// 将每个学生的信息添加到Map中，然后将Map添加到List中
	public static void addStuInfo() {
		HashMap<String, String> newInfo = new HashMap<>();
		System.out.print("请输入新学生的学号：");
		newInfo.put("num", scan.next());
		System.out.print("请输入新学生的姓名：");
		newInfo.put("name", scan.next());
		System.out.print("请输入新学生的性别（男/女）：");
		newInfo.put("sex", scan.next());
		stuInfos.add(newInfo);
	}
	// 根据输入的学号获取在列表中的索引，然后删除此学生信息
	public static void delStuInfo() {
		if (stuInfos.size() > 0) {
			System.out.print("请输入要删除的学生的学号：");
			String num = scan.next();
			for (int i = 0; i < stuInfos.size(); i++) {
				if (stuInfos.get(i).containsValue(num)) {
					stuInfos.remove(i);
					break;
				}
			}
		} else
			System.out.println("没有该学生信息！");
		
	}
	// 显示所有学生的信息
	public static void showStuInfo() {
		System.out.println("序号\t学号\t姓名\t性别");
		for (int i = 0; i < stuInfos.size(); i++) {
			System.out.println((i+1) + "\t" + stuInfos.get(i).get("num") + "\t" 
					+ stuInfos.get(i).get("name") + "\t" + stuInfos.get(i).get("sex"));
		}
	}
	// 将学生信息保存到文件中
	public static void saveStuInfo() {
		try {
			// 使用OutputStreamWriter创建文件输出流，并设置编码为UTF-8
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
	// 从文件中读取学生信息
	// 将每个学生的信息存储到Map中，然后将Map存储到List中
	public static void recoverStuInfo() {
		try {
			// 使用InputStreamReader创建文件输入流，并设置编码为UTF-8
			InputStreamReader fr;
			fr = new InputStreamReader(new FileInputStream("StudentInfo.txt"), "UTF-8");
			char[] cBuff = new char[1024];
			int len = fr.read(cBuff);			// 读取数据，并保存在字符数组cBuff中
			String[] sBuff = new String(cBuff, 0, len).split("\n");
			String[] s;
			System.out.println("序号\t学号\t姓名\t性别");
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
		// 循环，根据输入的数字，调用不同的方法实现不同的功能
		while (true) {
			printMenu();
			System.out.print("请输入功能对应的数字：");
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

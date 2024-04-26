/* GetAddress.java */
package chapter12.practice1;
import java.net.*;
public class GetAddress {
	public static void main(String args[]) {
		InetAddress ip = null;
		try {
			// 获取指定主机的InetAddress对象
			ip = InetAddress.getByName("www.163.com");
			// 获取主机名并输出
			System.out.println("主机名：" + ip.getHostName());
			// 获取主机IP地址并输出
			System.out.println("主机IP地址：" + ip.getHostAddress());
			//获取本地主机名并输出
			System.out.println("本地主机名:" 
					+ InetAddress.getLocalHost().getHostName());
			// 获取本地主机IP地址
			System.out.println("本机IP地址：" 
					+ InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

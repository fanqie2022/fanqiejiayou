/* SendBroadcasts.java */
package chapter12.practice3;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
public class SendBroadcasts extends JFrame {
	DatagramSocket socket = null;				// 声明DatagramSocket对象socket
	JTextField tf;								// 声明文本框tf
	JTextArea taSend;							// 声明文本区taSend
	int[] ports = { 2556, 2560, 2564, 2568 };		// 声明端口数组ports
	public SendBroadcasts() throws SocketException {
		super("发送广播");						// 设置标题
		setBounds(500, 400, 400, 300);			// 设置窗体位置和大小
		// 创建面板panel，设置为网格布局，并添加文本框和发送按钮
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		tf = new JTextField(20);
		panel.add(tf);
		JButton btnSend = new JButton("发送");
		panel.add(btnSend);
		// 将文本区添加到滚动面板scrollPane中
		taSend = new JTextArea();
		taSend.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(taSend);
		// 设置窗体为边界布局，将panel和scrollPane添加到窗体中
		setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		// 为发送按钮注册事件侦听器
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sendPacket();				// 调用sendPacket()方法
				} catch (SocketException e1) {
					e1.printStackTrace();
				}
			}
		});
		socket = new DatagramSocket();			// 创建DatagramSocket对象
		setVisible(true);						// 设置窗体可见
	}
	public void sendPacket() throws SocketException {
		try {
			// 获取本地地址，并赋值给address
			InetAddress address=InetAddress.getByName("localhost");
			String broadcast = tf.getText();			// 从文本框获取发送的广播
			byte[] buf = broadcast.getBytes();			// 把字符串转换成字节数组
			// 创建DatagramPacket类对象packet
			// 同时指定发送的目标地址（address）和端口号（2556）
			for (int i = 0; i < ports.length; i++) {
				DatagramPacket packet = new DatagramPacket(buf, buf.length,
						address, ports[i]);
				socket.send(packet);				// 服务器发送数据报
			}
			taSend.append(broadcast + "\n");			// 在文本区显示广播
		} catch (IOException e) {
			e.printStackTrace();
			socket.close();							// 关闭socket
		} 
	}
	public static void main(String[] args) throws SocketException { 
		SendBroadcasts frame = new SendBroadcasts();
	}
}

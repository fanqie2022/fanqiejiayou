/* RecvBroadcasts.java */
package chapter12.practice3;
import java.io.IOException;
import java.net.*;
import javax.swing.*;
public class RecvBroadcasts extends JFrame{
	JTextArea taRecv;						// 声明文本区taRecv
	public RecvBroadcasts() {
		super("接收广播");						// 设置窗体标题
		setBounds(1000, 400, 400, 300);			// 设置窗体位置和大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 设置默认关闭方法
		// 将taRecv添加到滚动面板scrollPane中		
		taRecv = new JTextArea();
		taRecv.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(taRecv);
		getContentPane().add(scrollPane);			// 将scrollPane添加到窗体中
		setVisible(true);						// 设置窗体可见
	}
	public void recvPacket() throws SocketException {
		// 创建DatagramSocket对象，同时指定发送的端口号
		DatagramSocket socket = new DatagramSocket(2560);	
		byte[] buf = new byte[256];
		// 创建接收数据报的DatagramPacket对象
		while (true) {
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			try {
				socket.receive(packet);				// 客户端接收数据报
				// 将接收的数据报转换为字符串
				String received = new String(packet.getData());
				taRecv.append(received + "\n");		// 将received显示在taRecv中
			} catch (IOException e) {
				e.printStackTrace();
				socket.close();						// 关闭socket
				break;							// 退出循环
			}
		}
	}
	public static void main(String[] args) throws SocketException {
		RecvBroadcasts frame = new RecvBroadcasts();
		frame.recvPacket();							// 调用recvPacket()方法
	}
}

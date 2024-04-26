/* SendBroadcasts.java */
package chapter12.practice3;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
public class SendBroadcasts extends JFrame {
	DatagramSocket socket = null;				// ����DatagramSocket����socket
	JTextField tf;								// �����ı���tf
	JTextArea taSend;							// �����ı���taSend
	int[] ports = { 2556, 2560, 2564, 2568 };		// �����˿�����ports
	public SendBroadcasts() throws SocketException {
		super("���͹㲥");						// ���ñ���
		setBounds(500, 400, 400, 300);			// ���ô���λ�úʹ�С
		// �������panel������Ϊ���񲼾֣�������ı���ͷ��Ͱ�ť
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		tf = new JTextField(20);
		panel.add(tf);
		JButton btnSend = new JButton("����");
		panel.add(btnSend);
		// ���ı�����ӵ��������scrollPane��
		taSend = new JTextArea();
		taSend.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(taSend);
		// ���ô���Ϊ�߽粼�֣���panel��scrollPane��ӵ�������
		setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		// Ϊ���Ͱ�ťע���¼�������
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sendPacket();				// ����sendPacket()����
				} catch (SocketException e1) {
					e1.printStackTrace();
				}
			}
		});
		socket = new DatagramSocket();			// ����DatagramSocket����
		setVisible(true);						// ���ô���ɼ�
	}
	public void sendPacket() throws SocketException {
		try {
			// ��ȡ���ص�ַ������ֵ��address
			InetAddress address=InetAddress.getByName("localhost");
			String broadcast = tf.getText();			// ���ı����ȡ���͵Ĺ㲥
			byte[] buf = broadcast.getBytes();			// ���ַ���ת�����ֽ�����
			// ����DatagramPacket�����packet
			// ͬʱָ�����͵�Ŀ���ַ��address���Ͷ˿ںţ�2556��
			for (int i = 0; i < ports.length; i++) {
				DatagramPacket packet = new DatagramPacket(buf, buf.length,
						address, ports[i]);
				socket.send(packet);				// �������������ݱ�
			}
			taSend.append(broadcast + "\n");			// ���ı�����ʾ�㲥
		} catch (IOException e) {
			e.printStackTrace();
			socket.close();							// �ر�socket
		} 
	}
	public static void main(String[] args) throws SocketException { 
		SendBroadcasts frame = new SendBroadcasts();
	}
}

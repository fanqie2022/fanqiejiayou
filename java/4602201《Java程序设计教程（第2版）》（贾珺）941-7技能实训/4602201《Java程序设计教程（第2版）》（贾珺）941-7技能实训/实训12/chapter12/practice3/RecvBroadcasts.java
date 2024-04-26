/* RecvBroadcasts.java */
package chapter12.practice3;
import java.io.IOException;
import java.net.*;
import javax.swing.*;
public class RecvBroadcasts extends JFrame{
	JTextArea taRecv;						// �����ı���taRecv
	public RecvBroadcasts() {
		super("���չ㲥");						// ���ô������
		setBounds(1000, 400, 400, 300);			// ���ô���λ�úʹ�С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// ����Ĭ�Ϲرշ���
		// ��taRecv��ӵ��������scrollPane��		
		taRecv = new JTextArea();
		taRecv.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(taRecv);
		getContentPane().add(scrollPane);			// ��scrollPane��ӵ�������
		setVisible(true);						// ���ô���ɼ�
	}
	public void recvPacket() throws SocketException {
		// ����DatagramSocket����ͬʱָ�����͵Ķ˿ں�
		DatagramSocket socket = new DatagramSocket(2560);	
		byte[] buf = new byte[256];
		// �����������ݱ���DatagramPacket����
		while (true) {
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			try {
				socket.receive(packet);				// �ͻ��˽������ݱ�
				// �����յ����ݱ�ת��Ϊ�ַ���
				String received = new String(packet.getData());
				taRecv.append(received + "\n");		// ��received��ʾ��taRecv��
			} catch (IOException e) {
				e.printStackTrace();
				socket.close();						// �ر�socket
				break;							// �˳�ѭ��
			}
		}
	}
	public static void main(String[] args) throws SocketException {
		RecvBroadcasts frame = new RecvBroadcasts();
		frame.recvPacket();							// ����recvPacket()����
	}
}

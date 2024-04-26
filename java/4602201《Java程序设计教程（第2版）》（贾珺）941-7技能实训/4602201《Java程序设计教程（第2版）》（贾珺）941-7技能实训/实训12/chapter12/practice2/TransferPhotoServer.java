/* TransferPhotoServer.java */
package chapter12.practice2;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class TransferPhotoServer extends JFrame {
	private Image sendImg = null;			// �������͵�ͼ�����sendImg
	private Image receiveImg = null;			// �������յ�ͼ�����receiveImg
	// �������͵�ͼ��������sendImagePanel
	private SendImagePanel sendImagePanel = null;
	// ��������ͼ��������receiveImagePanel
	private ReceiveImagePanel receiveImagePanel = null;
	private File imgFile = null;				// ����ѡ��ͼƬ��File����
	private JTextField tf_path;				// ����·���ı���tf_path
	private DataOutputStream out = null;		// ���������ֽ����������out
	private DataInputStream in = null;			// ���������ֽ�����������in
	private ServerSocket server;				// ����ServerSocket����server
	private Socket socket;					// ����Socket����socket
	private long lengths = -1;				// ����ͼƬ�ļ��Ĵ�Сlengths
	public void getServer() {
		try {
			server = new ServerSocket(1978);	// ʵ����Socket����
			while (true) {					// ����׽���������״̬
				socket = server.accept();		// ʵ����Socket����
				out = new DataOutputStream(socket.getOutputStream());	// ���out
				in = new DataInputStream(socket.getInputStream());		// ���in
				getClientInfo();			// ����getClientInfo()����
			}
		} catch (Exception e) {
			e.printStackTrace();				// ����쳣��Ϣ
		}
	}
	
	private void getClientInfo() {
		while (true) {		
			try {
				long lengths = in.readLong();	// ��ȡͼƬ�ļ��ĳ���
				byte[] bt = new byte[(int) lengths];	// �����ֽ�����
				for (int i = 0; i < bt.length; i++) {
					bt[i] = in.readByte();		// ��ȡ�ֽ���Ϣ���洢���ֽ�����
				}
				receiveImg = new ImageIcon(bt).getImage();	// ����ͼ�����
				receiveImagePanel.repaint();					// ���»���ͼ��
			} catch (Exception e) {
			} 
		}
	}
	
	public static void main(String[] args) {
		// ����TransferPhotoServer�����
		TransferPhotoServer frame = new TransferPhotoServer();
		frame.getServer();									// ���÷���
	}
	
	public TransferPhotoServer() {
		super("������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, 400, 300);
		// �������panel�����·����ǩ���ı���ѡ��ͼƬ��ť�����Ͱ�ť
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		final JLabel label = new JLabel("·����");
		panel.add(label);
		tf_path = new JTextField(10);
		panel.add(tf_path);
		sendImagePanel = new SendImagePanel();
		receiveImagePanel = new ReceiveImagePanel();
		final JButton btnSelect = new JButton("ѡ��ͼƬ");
		// Ϊѡ��ͼƬ��ťע���¼�������
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();	// �����ļ�ѡ����
				int flag = fileChooser.showOpenDialog(null);	// ��ʾ�򿪶Ի���
				if (flag == JFileChooser.APPROVE_OPTION) {
					// ��ȡѡ��ͼƬ��File����
					imgFile = fileChooser.getSelectedFile();
				}
				if (imgFile != null) {
					tf_path.setText(imgFile.getAbsolutePath());	// ͼƬ����·��
					try {
						sendImg = ImageIO.read(imgFile);// ����BufferedImage����
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				sendImagePanel.repaint();				// ����paint()����
			}
		});
		panel.add(btnSelect);
		final JButton btnSend = new JButton("��  ��");
		// Ϊ���Ͱ�ťע���¼�������
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				try {
					DataInputStream inStream = null;		// ������������������
					if (imgFile != null) {
						lengths = imgFile.length();		// ���ѡ��ͼƬ�Ĵ�С
						// ��������������
						inStream=new DataInputStream(new FileInputStream(imgFile));
					} else {
						JOptionPane.showMessageDialog(null, "��û��ѡ��ͼƬ�ļ�");
						return;
					}
					out.writeLong(lengths);			// ���ļ��Ĵ�Сд�������
					byte[] bt = new byte[(int) lengths];// �����ֽ�����
					int len = -1;
					// ��ͼƬ�ļ���ȡ���ֽ�����
					while ((len = inStream.read(bt)) != -1) {
						out.write(bt);// ���ֽ�����д�������
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnSend);
		// ������ʾͼƬ���
		final JPanel showPanel= new JPanel();
		showPanel.setLayout(new GridLayout(1, 0));
		getContentPane().add(showPanel, BorderLayout.CENTER);
		final JPanel sendPanel = new JPanel();
		sendPanel.setLayout(new BorderLayout());

		final JLabel sendLabel = new JLabel("������ѡ���Ҫ���͵�ͼƬ");
		sendPanel.add(sendLabel, BorderLayout.NORTH);
		sendPanel.add(sendImagePanel, BorderLayout.CENTER);
		final JPanel recvPanel = new JPanel();
		recvPanel.setLayout(new BorderLayout());

		final JLabel recvLabel = new JLabel("���յ��ͻ��˷��͵�ͼƬ");
		recvPanel.add(recvLabel, BorderLayout.NORTH);
		recvPanel.add(receiveImagePanel, BorderLayout.CENTER);
		showPanel.add(sendPanel);
		showPanel.add(recvPanel);
	
		setVisible(true);
	}
	
	// ��������࣬���Ʒ��͵�ͼƬ
	class SendImagePanel extends JPanel {
		public void paint(Graphics g) {
			if (sendImg != null) {
				// �����ͼ�����ĵ�����
				g.clearRect(0, 0, this.getWidth(), this.getHeight());
				// ����ָ����С��ͼƬ
				g.drawImage(sendImg, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		}
	}
	
	// ��������࣬���ƽ��յ�ͼƬ
	class ReceiveImagePanel extends JPanel {
		public void paint(Graphics g) {
			if (receiveImg != null) {
				// �����ͼ�����ĵ�����
				g.clearRect(0, 0, this.getWidth(), this.getHeight());
				// ����ָ����С��ͼƬ
				g.drawImage(receiveImg, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		}
	}
}

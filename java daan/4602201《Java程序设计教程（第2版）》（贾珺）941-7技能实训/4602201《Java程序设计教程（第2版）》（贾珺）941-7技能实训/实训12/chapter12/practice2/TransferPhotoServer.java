/* TransferPhotoServer.java */
package chapter12.practice2;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class TransferPhotoServer extends JFrame {
	private Image sendImg = null;			// 声明发送的图像对象sendImg
	private Image receiveImg = null;			// 声明接收的图像对象receiveImg
	// 声明发送的图像面板对象sendImagePanel
	private SendImagePanel sendImagePanel = null;
	// 声明接收图像面板对象receiveImagePanel
	private ReceiveImagePanel receiveImagePanel = null;
	private File imgFile = null;				// 声明选择图片的File对象
	private JTextField tf_path;				// 声明路径文本框tf_path
	private DataOutputStream out = null;		// 声明数据字节输出流对象out
	private DataInputStream in = null;			// 创建数据字节输入流对象in
	private ServerSocket server;				// 声明ServerSocket对象server
	private Socket socket;					// 声明Socket对象socket
	private long lengths = -1;				// 声明图片文件的大小lengths
	public void getServer() {
		try {
			server = new ServerSocket(1978);	// 实例化Socket对象
			while (true) {					// 如果套接字是连接状态
				socket = server.accept();		// 实例化Socket对象
				out = new DataOutputStream(socket.getOutputStream());	// 获得out
				in = new DataInputStream(socket.getInputStream());		// 获得in
				getClientInfo();			// 调用getClientInfo()方法
			}
		} catch (Exception e) {
			e.printStackTrace();				// 输出异常信息
		}
	}
	
	private void getClientInfo() {
		while (true) {		
			try {
				long lengths = in.readLong();	// 读取图片文件的长度
				byte[] bt = new byte[(int) lengths];	// 创建字节数组
				for (int i = 0; i < bt.length; i++) {
					bt[i] = in.readByte();		// 读取字节信息并存储到字节数组
				}
				receiveImg = new ImageIcon(bt).getImage();	// 创建图像对象
				receiveImagePanel.repaint();					// 重新绘制图像
			} catch (Exception e) {
			} 
		}
	}
	
	public static void main(String[] args) {
		// 创建TransferPhotoServer类对象
		TransferPhotoServer frame = new TransferPhotoServer();
		frame.getServer();									// 调用方法
	}
	
	public TransferPhotoServer() {
		super("服务器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, 400, 300);
		// 创建面板panel，添加路径标签和文本框、选择图片按钮、发送按钮
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		final JLabel label = new JLabel("路径：");
		panel.add(label);
		tf_path = new JTextField(10);
		panel.add(tf_path);
		sendImagePanel = new SendImagePanel();
		receiveImagePanel = new ReceiveImagePanel();
		final JButton btnSelect = new JButton("选择图片");
		// 为选择图片按钮注册事件侦听器
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();	// 创建文件选择器
				int flag = fileChooser.showOpenDialog(null);	// 显示打开对话框
				if (flag == JFileChooser.APPROVE_OPTION) {
					// 获取选中图片的File对象
					imgFile = fileChooser.getSelectedFile();
				}
				if (imgFile != null) {
					tf_path.setText(imgFile.getAbsolutePath());	// 图片完整路径
					try {
						sendImg = ImageIO.read(imgFile);// 构造BufferedImage对象
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				sendImagePanel.repaint();				// 调用paint()方法
			}
		});
		panel.add(btnSelect);
		final JButton btnSend = new JButton("发  送");
		// 为发送按钮注册事件侦听器
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				try {
					DataInputStream inStream = null;		// 定义数据输入流对象
					if (imgFile != null) {
						lengths = imgFile.length();		// 获得选择图片的大小
						// 创建输入流对象
						inStream=new DataInputStream(new FileInputStream(imgFile));
					} else {
						JOptionPane.showMessageDialog(null, "还没有选择图片文件");
						return;
					}
					out.writeLong(lengths);			// 将文件的大小写入输出流
					byte[] bt = new byte[(int) lengths];// 创建字节数组
					int len = -1;
					// 将图片文件读取到字节数组
					while ((len = inStream.read(bt)) != -1) {
						out.write(bt);// 将字节数组写入输出流
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnSend);
		// 创建显示图片面板
		final JPanel showPanel= new JPanel();
		showPanel.setLayout(new GridLayout(1, 0));
		getContentPane().add(showPanel, BorderLayout.CENTER);
		final JPanel sendPanel = new JPanel();
		sendPanel.setLayout(new BorderLayout());

		final JLabel sendLabel = new JLabel("服务器选择的要发送的图片");
		sendPanel.add(sendLabel, BorderLayout.NORTH);
		sendPanel.add(sendImagePanel, BorderLayout.CENTER);
		final JPanel recvPanel = new JPanel();
		recvPanel.setLayout(new BorderLayout());

		final JLabel recvLabel = new JLabel("接收到客户端发送的图片");
		recvPanel.add(recvLabel, BorderLayout.NORTH);
		recvPanel.add(receiveImagePanel, BorderLayout.CENTER);
		showPanel.add(sendPanel);
		showPanel.add(recvPanel);
	
		setVisible(true);
	}
	
	// 创建面板类，绘制发送的图片
	class SendImagePanel extends JPanel {
		public void paint(Graphics g) {
			if (sendImg != null) {
				// 清除绘图上下文的内容
				g.clearRect(0, 0, this.getWidth(), this.getHeight());
				// 绘制指定大小的图片
				g.drawImage(sendImg, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		}
	}
	
	// 创建面板类，绘制接收的图片
	class ReceiveImagePanel extends JPanel {
		public void paint(Graphics g) {
			if (receiveImg != null) {
				// 清除绘图上下文的内容
				g.clearRect(0, 0, this.getWidth(), this.getHeight());
				// 绘制指定大小的图片
				g.drawImage(receiveImg, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		}
	}
}

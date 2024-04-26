/* LuckyViewer.java */
package chapter11.practice3;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class LuckyViewer extends JFrame {
	// 声明窗体上的组件
	private JLabel inputLabel;
	private JLabel resultLabel;
	private JTextField nameField;
	private JTextArea nameArea;
	private JTextArea resultArea;
	private JButton btnExtract;
	public static void main(String[] args) {
		LuckyViewer frame = new LuckyViewer();
		frame.setVisible(true);
	}
	public LuckyViewer() {
		// 设置窗体的标签、大小和关闭
		setTitle("抽取幸运观众");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(498, 300);
		// 创建Container类对象c，并取消布局管理器
		Container c = getContentPane();
		c.setLayout(null);
		// 创建面板namePanel，添加到c中
		// 设置面板的位置和大小，取消布局管理器
		JPanel namePanel = new JPanel();
		namePanel.setBounds(10, 10, 174, 242);
		c.add(namePanel);
		namePanel.setLayout(null);
		// 创建输入提示标签，添加到namePanel中，并设置位置和大小
		inputLabel = new JLabel("输入在场观众姓名并按回车");
		inputLabel.setBounds(0, 0, 170, 15);
		namePanel.add(inputLabel);
		// 创建输入姓名文本框，添加到namePanel中
		// 设置位置和大小，以及添加按键事件侦听器
		nameField = new JTextField();
		nameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textField_keyPressed(e);
			}
		});
		nameField.setBounds(0, 20, 170, 20);
		namePanel.add(nameField);
		// 创建姓名列表文本区，添加到滚动面板scrollPane1中
		// 将scrollPane1添加到c中，并设置scrollPane1的位置和大小
		nameArea = new JTextArea();
		nameArea.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(nameArea);
		scrollPane1.setBounds(0, 45, 170, 200);
		namePanel.add(scrollPane1); 
		// 创建面板resultPanel，添加到c中，设置位置和大小，以及设置为边界布局
		JPanel resultPanel = new JPanel();
		resultPanel.setBounds(183, 10, 219, 242);
		c.add(resultPanel);
		resultPanel.setLayout(new BorderLayout(0, 0));
		// 创建抽取的幸运观众提示标签，添加到resultPanel的North区域   
		resultLabel = new JLabel("抽取的幸运观众");
		resultPanel.add(resultLabel, BorderLayout.NORTH);
		// 创建抽奖信息文本区，添加到滚动面板scrollPane2中
		// 将scrollPane2添加到c中
		resultArea = new JTextArea();
		resultArea.setEditable(false);
		JScrollPane scrollPane2 = new JScrollPane(resultArea);
		resultPanel.add(scrollPane2);
		// 创建抽取按钮，添加到c中，并设置位置和大小，以及添加动作事件侦听器
		btnExtract = new JButton("抽取");
		btnExtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExtract_actionPerformed(e);
			}
		});
		btnExtract.setBounds(407, 215, 63, 25);
		c.add(btnExtract);
		//设置窗体在屏幕上居中放置，并不能改变大小
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	protected void textField_keyPressed(KeyEvent e) {
		if (e.getKeyChar() != '\n')		// 不是回车字符不做处理
			return;
		String name = nameField.getText();
		if (name.isEmpty())				// 如果文本框没有字符串不做处理
			return;
		nameArea.append(name + "\n");	// 把输入的姓名与回车符添加到姓名列表
		nameField.selectAll();			// 选择文本框所有字符
	}
	
	protected void btnExtract_actionPerformed(ActionEvent e) {
		String perstring = nameArea.getText();			// 获取姓名列表文本
		String[] personnelArray = perstring.split("\n");	// 获取姓名数组
		int index = (int) (Math.random() * personnelArray.length);	// 生成随机数组索引
		// 定义包含格式参数的中奖信息
		String formatArg = "本次抽取的幸运观众：\n\t %1$s\n我们将颁发奖品：\n\t牛奶一箱\n\t鸡蛋一盒";
		// 为中奖信息添加人员参数
		String info = String.format(formatArg, personnelArray[index]);
		resultArea.setText(info);						// 在文本区显示中间信息
	}
}

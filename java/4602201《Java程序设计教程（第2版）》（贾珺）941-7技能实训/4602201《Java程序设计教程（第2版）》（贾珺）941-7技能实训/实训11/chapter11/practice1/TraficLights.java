/* TraficLights.java */
package chapter11.practice1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TraficLights extends JFrame {		// 创建一个“交通灯”类，并继承JFrame
	public static void main(String[] args) {
		TraficLights frame = new TraficLights();		// 创建TraficLights对象frame
		frame.setLocationRelativeTo(null);			// 在屏幕中居中显示
		frame.setVisible(true);						// 设置frame可见
	}
	// 创建JFrame窗体
	public TraficLights() {							// TraficLights的构造方法
		setResizable(false);							// 设置窗体不可改变大小
		setTitle("交通灯");							// 设置窗体题目
		setSize(220, 300);							// 设置窗体大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置默认关闭方法

		Container c = getContentPane();				// 创建Container类对象c
		c.setLayout(new GridLayout(1, 0, 0, 0));		// 设置窗体布局为网格布局
		// 创建面板ImagePanel置于c中，设置ImagePanel的背景色、边界布局
		JPanel ImagePanel = new JPanel();
		ImagePanel.setBackground(Color.WHITE);
		c.add(ImagePanel);
		ImagePanel.setLayout(new BorderLayout(0, 0));
		// 创建标签lblImage置于ImagePanel的中间，设置标签的背景色、图标
		JLabel lblImage = new JLabel("");
		lblImage.setBackground(Color.WHITE);
		lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("green.png")));
		ImagePanel.add(lblImage, BorderLayout.CENTER);
		// 创建面板btnPanel置于c中，取消btnPanel的布局
		JPanel btnPanel = new JPanel();
		c.add(btnPanel);
		btnPanel.setLayout(null);
		// 创建单选按钮rbtnRed置于btnPanel中，设置单选按钮的文本、大小
		// 添加动作监听事件，发生操作时，标签设置为红灯图标
		JRadioButton rbtnRed = new JRadioButton("红灯");
		rbtnRed.addActionListener(new ActionListener() { // 添加动作监听的事件
			public void actionPerformed(ActionEvent e) { // 发生操作时
				// 标签中添加图片
				lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("red.png")));
			}
		});
		rbtnRed.setBounds(20, 51, 60, 20);
		btnPanel.add(rbtnRed);
		// 创建单选按钮rbtnYellow置于btnPanel中，设置单选按钮的文本、大小
		// 添加动作监听事件，发生操作时，标签设置为黄灯图标
		JRadioButton rbtnYellow = new JRadioButton("黄灯");
		rbtnYellow.addActionListener(new ActionListener() {	// 添加动作监听的事件
			public void actionPerformed(ActionEvent e) {	// 发生操作时
				// 标签中添加图片
				lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("yellow.png"))); 
			}
		});
		rbtnYellow.setBounds(20, 117, 60, 20);
		btnPanel.add(rbtnYellow);
		// 创建单选按钮rbtnGreen置于btnPanel中，设置单选按钮的文本、大小
		// 添加动作监听事件，发生操作时，标签设置为绿灯图标
		JRadioButton rbtnGreen = new JRadioButton("绿灯");
		rbtnGreen.setSelected(true); // 设置按钮rbtnGreen为默认的单选按钮
		rbtnGreen.addActionListener(new ActionListener() {	// 添加动作监听的事件
			public void actionPerformed(ActionEvent e) {	// 发生操作时
				// 标签中添加图片
				lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("green.png")));
			}
		});
		rbtnGreen.setBounds(20, 182, 60, 20);
		btnPanel.add(rbtnGreen);
		// 创建ButtonGroup对象group
		// 把单选按钮rbtnRed、rbtnYellow、rbtnGreen放进group中
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnRed);
		group.add(rbtnYellow);
		group.add(rbtnGreen);

	}
}

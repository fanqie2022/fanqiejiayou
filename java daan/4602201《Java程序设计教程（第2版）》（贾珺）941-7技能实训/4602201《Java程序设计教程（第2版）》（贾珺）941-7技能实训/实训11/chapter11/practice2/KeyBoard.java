/* KeyBoard.java */
package chapter11.practice2;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;
public class KeyBoard extends Frame {				// 创建“键盘”类继承Frame
	// 声明窗体中的成员组件
	private TextField textField;
	private Button btnQ;
	private Button btnW;
	private Button btnE;
	private Button btnR;
	private Button btnT;
	private Button btnY;
	private Button btnU;
	private Button btnI;
	private Button btnO;
	private Button btnP;
	private Button btnA;
	private Button btnS;
	private Button btnD;
	private Button btnF;
	private Button btnG;
	private Button btnH;
	private Button btnJ;
	private Button btnK;
	private Button btnL;
	private Button btnZ;
	private Button btnX;
	private Button btnC;
	private Button btnV;
	private Button btnB;
	private Button btnN;
	private Button btnM;
	private Panel panel;
	Color red = Color.RED;		// 定义Color对象，表示按下键的颜色，设置为红色
	// 定义Color对象，用来表示释放键的颜色，设置为浅灰色
	Color gray = Color.LIGHT_GRAY;
	// 定义Font对象，表示字体，设置字体、样式和大小
	Font font = new Font("Times New Roman", Font.PLAIN, 16);
	// 定义列表btns，实现存储所有的按键ID
	ArrayList<Button> btns=new ArrayList<Button>();
	// 自定义方法，实现将容器中的所有Button组件添加到列表中
	private void addButtons(){
		for(Component cmp : panel.getComponents()){	// 遍历面板中的所有组件
			if(cmp instanceof Button){				// 如果组件为Button类型
				btns.add((Button)cmp);				// 将Button组件添加到列表中
			}
		}
	}
	public static void main(String[] args) {
		KeyBoard frame = new KeyBoard();			// 创建KeyBoard对象
		frame.setLocationRelativeTo(null);			// 在屏幕中居中显示
		frame.setVisible(true);						// 使frame可见
		frame.addButtons();						// 初始化存储所有按键的集合
	}
	// 创建Frame窗体
	public KeyBoard() {							// KeyBoard的构造方法
		setTitle("虚拟键盘（模拟键盘的按下与释放）"); // 设置窗体标题
		setResizable(false); //不可改变窗体宽高
		setSize(556, 280); //设置窗体的宽高
		// 为关闭按钮添加关闭窗口侦听事件
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
			System.exit(0);
			}
		});
		// 设置窗体的背景色，并设置为边界布局
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		// 为关闭按钮添加窗口侦听器，关闭窗口
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// 创建面板panel，添加到窗体中
		// 放置在Center位置，并取消面板的布局管理器
		panel = new Panel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		// 创建按钮btnA～btnZ，添加到panel中
		// 设置按钮的背景色、位置、宽高以及按钮中文字的字体
		btnQ = new Button("Q");
		btnQ.setBackground(gray);
		btnQ.setFont(font);
		btnQ.setBounds(0, 20, 47, 45);
		panel.add(btnQ);

		btnW = new Button("W");
		btnW.setBackground(gray);
		btnW.setFont(font);
		btnW.setBounds(55, 20, 49, 45);
		panel.add(btnW);

		btnE = new Button("E");
		btnE.setBackground(gray);
		btnE.setFont(font);
		btnE.setBounds(110, 20, 45, 45);
		panel.add(btnE);

		btnR = new Button("R");
		btnR.setBackground(gray);
		btnR.setFont(font);
		btnR.setBounds(165, 20, 45, 45);
		panel.add(btnR);
		
		btnT = new Button("T");
		btnT.setFont(font);
		btnT.setBackground(gray);
		btnT.setBounds(220, 20, 45, 45);
		panel.add(btnT);
		
		btnY = new Button("Y");
		btnY.setFont(font);
		btnY.setBackground(gray);
		btnY.setBounds(275, 20, 45, 45);
		panel.add(btnY);
		
		btnU = new Button("U");
		btnU.setFont(font);
		btnU.setBackground(gray);
		btnU.setBounds(330, 20, 45, 45);
		panel.add(btnU);
		
		btnI = new Button("I");
		btnI.setFont(font);
		btnI.setBackground(gray);
		btnI.setBounds(385, 20, 45, 45);
		panel.add(btnI);
		
		btnO = new Button("O");
		btnO.setFont(font);
		btnO.setBackground(gray);
		btnO.setBounds(440, 20, 46, 45);
		panel.add(btnO);
		
		btnP = new Button("P");
		btnP.setFont(font);
		btnP.setBackground(gray);
		btnP.setBounds(495, 20, 45, 45);
		panel.add(btnP);
		
		btnA = new Button("A");
		btnA.setFont(font);
		btnA.setBackground(gray);
		btnA.setBounds(23, 85, 45, 45);
		panel.add(btnA);
		
		btnS = new Button("S");
		btnS.setFont(font);
		btnS.setBackground(gray);
		btnS.setBounds(82, 85, 45, 45);
		panel.add(btnS);
		
		btnD = new Button("D");
		btnD.setBackground(gray);
		btnD.setFont(font);
		btnD.setBounds(137, 85, 45, 45);
		panel.add(btnD);

		btnF = new Button("F");
		btnF.setBackground(gray);
		btnF.setFont(font);
		btnF.setBounds(195, 85, 45, 45);
		panel.add(btnF);
		
		btnG = new Button("G");
		btnG.setFont(font);
		btnG.setBackground(gray);
		btnG.setBounds(251, 85, 45, 45);
		panel.add(btnG);
		
		btnH = new Button("H");
		btnH.setFont(font);
		btnH.setBackground(gray);
		btnH.setBounds(306, 85, 45, 45);
		panel.add(btnH);
		
		btnJ = new Button("J");
		btnJ.setFont(font);
		btnJ.setBackground(gray);
		btnJ.setBounds(361, 85, 45, 45);
		panel.add(btnJ);
		
		btnK = new Button("K");
		btnK.setFont(font);
		btnK.setBackground(gray);
		btnK.setBounds(416, 85, 47, 45);
		panel.add(btnK);
		
		btnL = new Button("L");
		btnL.setFont(font);
		btnL.setBackground(gray);
		btnL.setBounds(471, 85, 45, 45);
		panel.add(btnL);
		
		btnZ = new Button("Z");
		btnZ.setFont(font);
		btnZ.setBackground(gray);
		btnZ.setBounds(39, 150, 45, 45);
		panel.add(btnZ);
		
		btnX = new Button("X");
		btnX.setFont(font);
		btnX.setBackground(gray);
		btnX.setBounds(107, 150, 45, 45);
		panel.add(btnX);
		
		btnC = new Button("C");
		btnC.setFont(font);
		btnC.setBackground(gray);
		btnC.setBounds(178, 150, 45, 45);
		panel.add(btnC);
		
		btnV = new Button("V");
		btnV.setFont(font);
		btnV.setBackground(gray);
		btnV.setBounds(250, 150, 45, 45);
		panel.add(btnV);
		
		btnB = new Button("B");
		btnB.setFont(font);
		btnB.setBackground(gray);
		btnB.setBounds(315, 150, 45, 45);
		panel.add(btnB);
		
		btnN = new Button("N");
		btnN.setFont(font);
		btnN.setBackground(gray);
		btnN.setBounds(382, 150, 47, 45);
		panel.add(btnN);
		
		btnM = new Button("M");
		btnM.setFont(font);
		btnM.setBackground(gray);
		btnM.setBounds(449, 150, 48, 45);
		panel.add(btnM);
		// 创建文本框textField，添加到panel中，并放置在窗体的North区域
		textField = new TextField();
		add(textField, BorderLayout.NORTH);
		
		textField.addKeyListener(new KeyAdapter() {	// 文本框添加键盘事件的监听
			char word;
			@Override
			public void keyPressed(KeyEvent e) {		// 按键被按下时被触发
				word=e.getKeyChar();				// 获取按下键表示的字符
				for(int i=0;i<btns.size();i++){			// 遍历存储按钮ID的ArrayList
					//判断按键是否与遍历到的按钮的文本相同
					if(String.valueOf(word).equalsIgnoreCase(btns.get(i).getLabel())){
						btns.get(i).setBackground(red);//将指定按钮颜色设置为红色
					}
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {		// 按键被释放时被触发
				word=e.getKeyChar();				// 获取释放键表示的字符
				for(int i=0;i<btns.size();i++){	// 遍历存储按键ID的ArrayList集合
					// 判断按键是否与遍历到的按钮的文本相同
					if(String.valueOf(word).equalsIgnoreCase(btns.get(i).getLabel())){
						// 将指定按钮颜色设置为浅灰色
						btns.get(i).setBackground(gray);
					}
				}
			}
		});
	}
}

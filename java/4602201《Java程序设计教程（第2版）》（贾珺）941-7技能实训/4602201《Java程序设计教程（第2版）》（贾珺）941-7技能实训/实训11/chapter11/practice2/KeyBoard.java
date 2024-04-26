/* KeyBoard.java */
package chapter11.practice2;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;
public class KeyBoard extends Frame {				// ���������̡���̳�Frame
	// ���������еĳ�Ա���
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
	Color red = Color.RED;		// ����Color���󣬱�ʾ���¼�����ɫ������Ϊ��ɫ
	// ����Color����������ʾ�ͷż�����ɫ������Ϊǳ��ɫ
	Color gray = Color.LIGHT_GRAY;
	// ����Font���󣬱�ʾ���壬�������塢��ʽ�ʹ�С
	Font font = new Font("Times New Roman", Font.PLAIN, 16);
	// �����б�btns��ʵ�ִ洢���еİ���ID
	ArrayList<Button> btns=new ArrayList<Button>();
	// �Զ��巽����ʵ�ֽ������е�����Button�����ӵ��б���
	private void addButtons(){
		for(Component cmp : panel.getComponents()){	// ��������е��������
			if(cmp instanceof Button){				// ������ΪButton����
				btns.add((Button)cmp);				// ��Button�����ӵ��б���
			}
		}
	}
	public static void main(String[] args) {
		KeyBoard frame = new KeyBoard();			// ����KeyBoard����
		frame.setLocationRelativeTo(null);			// ����Ļ�о�����ʾ
		frame.setVisible(true);						// ʹframe�ɼ�
		frame.addButtons();						// ��ʼ���洢���а����ļ���
	}
	// ����Frame����
	public KeyBoard() {							// KeyBoard�Ĺ��췽��
		setTitle("������̣�ģ����̵İ������ͷţ�"); // ���ô������
		setResizable(false); //���ɸı䴰����
		setSize(556, 280); //���ô���Ŀ��
		// Ϊ�رհ�ť��ӹرմ��������¼�
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
			System.exit(0);
			}
		});
		// ���ô���ı���ɫ��������Ϊ�߽粼��
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		// Ϊ�رհ�ť��Ӵ������������رմ���
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// �������panel����ӵ�������
		// ������Centerλ�ã���ȡ�����Ĳ��ֹ�����
		panel = new Panel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		// ������ťbtnA��btnZ����ӵ�panel��
		// ���ð�ť�ı���ɫ��λ�á�����Լ���ť�����ֵ�����
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
		// �����ı���textField����ӵ�panel�У��������ڴ����North����
		textField = new TextField();
		add(textField, BorderLayout.NORTH);
		
		textField.addKeyListener(new KeyAdapter() {	// �ı�����Ӽ����¼��ļ���
			char word;
			@Override
			public void keyPressed(KeyEvent e) {		// ����������ʱ������
				word=e.getKeyChar();				// ��ȡ���¼���ʾ���ַ�
				for(int i=0;i<btns.size();i++){			// �����洢��ťID��ArrayList
					//�жϰ����Ƿ���������İ�ť���ı���ͬ
					if(String.valueOf(word).equalsIgnoreCase(btns.get(i).getLabel())){
						btns.get(i).setBackground(red);//��ָ����ť��ɫ����Ϊ��ɫ
					}
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {		// �������ͷ�ʱ������
				word=e.getKeyChar();				// ��ȡ�ͷż���ʾ���ַ�
				for(int i=0;i<btns.size();i++){	// �����洢����ID��ArrayList����
					// �жϰ����Ƿ���������İ�ť���ı���ͬ
					if(String.valueOf(word).equalsIgnoreCase(btns.get(i).getLabel())){
						// ��ָ����ť��ɫ����Ϊǳ��ɫ
						btns.get(i).setBackground(gray);
					}
				}
			}
		});
	}
}

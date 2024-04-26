/* TraficLights.java */
package chapter11.practice1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TraficLights extends JFrame {		// ����һ������ͨ�ơ��࣬���̳�JFrame
	public static void main(String[] args) {
		TraficLights frame = new TraficLights();		// ����TraficLights����frame
		frame.setLocationRelativeTo(null);			// ����Ļ�о�����ʾ
		frame.setVisible(true);						// ����frame�ɼ�
	}
	// ����JFrame����
	public TraficLights() {							// TraficLights�Ĺ��췽��
		setResizable(false);							// ���ô��岻�ɸı��С
		setTitle("��ͨ��");							// ���ô�����Ŀ
		setSize(220, 300);							// ���ô����С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ����Ĭ�Ϲرշ���

		Container c = getContentPane();				// ����Container�����c
		c.setLayout(new GridLayout(1, 0, 0, 0));		// ���ô��岼��Ϊ���񲼾�
		// �������ImagePanel����c�У�����ImagePanel�ı���ɫ���߽粼��
		JPanel ImagePanel = new JPanel();
		ImagePanel.setBackground(Color.WHITE);
		c.add(ImagePanel);
		ImagePanel.setLayout(new BorderLayout(0, 0));
		// ������ǩlblImage����ImagePanel���м䣬���ñ�ǩ�ı���ɫ��ͼ��
		JLabel lblImage = new JLabel("");
		lblImage.setBackground(Color.WHITE);
		lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("green.png")));
		ImagePanel.add(lblImage, BorderLayout.CENTER);
		// �������btnPanel����c�У�ȡ��btnPanel�Ĳ���
		JPanel btnPanel = new JPanel();
		c.add(btnPanel);
		btnPanel.setLayout(null);
		// ������ѡ��ťrbtnRed����btnPanel�У����õ�ѡ��ť���ı�����С
		// ��Ӷ��������¼�����������ʱ����ǩ����Ϊ���ͼ��
		JRadioButton rbtnRed = new JRadioButton("���");
		rbtnRed.addActionListener(new ActionListener() { // ��Ӷ����������¼�
			public void actionPerformed(ActionEvent e) { // ��������ʱ
				// ��ǩ�����ͼƬ
				lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("red.png")));
			}
		});
		rbtnRed.setBounds(20, 51, 60, 20);
		btnPanel.add(rbtnRed);
		// ������ѡ��ťrbtnYellow����btnPanel�У����õ�ѡ��ť���ı�����С
		// ��Ӷ��������¼�����������ʱ����ǩ����Ϊ�Ƶ�ͼ��
		JRadioButton rbtnYellow = new JRadioButton("�Ƶ�");
		rbtnYellow.addActionListener(new ActionListener() {	// ��Ӷ����������¼�
			public void actionPerformed(ActionEvent e) {	// ��������ʱ
				// ��ǩ�����ͼƬ
				lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("yellow.png"))); 
			}
		});
		rbtnYellow.setBounds(20, 117, 60, 20);
		btnPanel.add(rbtnYellow);
		// ������ѡ��ťrbtnGreen����btnPanel�У����õ�ѡ��ť���ı�����С
		// ��Ӷ��������¼�����������ʱ����ǩ����Ϊ�̵�ͼ��
		JRadioButton rbtnGreen = new JRadioButton("�̵�");
		rbtnGreen.setSelected(true); // ���ð�ťrbtnGreenΪĬ�ϵĵ�ѡ��ť
		rbtnGreen.addActionListener(new ActionListener() {	// ��Ӷ����������¼�
			public void actionPerformed(ActionEvent e) {	// ��������ʱ
				// ��ǩ�����ͼƬ
				lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("green.png")));
			}
		});
		rbtnGreen.setBounds(20, 182, 60, 20);
		btnPanel.add(rbtnGreen);
		// ����ButtonGroup����group
		// �ѵ�ѡ��ťrbtnRed��rbtnYellow��rbtnGreen�Ž�group��
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnRed);
		group.add(rbtnYellow);
		group.add(rbtnGreen);

	}
}

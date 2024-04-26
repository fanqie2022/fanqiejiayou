/* LuckyViewer.java */
package chapter11.practice3;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class LuckyViewer extends JFrame {
	// ���������ϵ����
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
		// ���ô���ı�ǩ����С�͹ر�
		setTitle("��ȡ���˹���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(498, 300);
		// ����Container�����c����ȡ�����ֹ�����
		Container c = getContentPane();
		c.setLayout(null);
		// �������namePanel����ӵ�c��
		// ��������λ�úʹ�С��ȡ�����ֹ�����
		JPanel namePanel = new JPanel();
		namePanel.setBounds(10, 10, 174, 242);
		c.add(namePanel);
		namePanel.setLayout(null);
		// ����������ʾ��ǩ����ӵ�namePanel�У�������λ�úʹ�С
		inputLabel = new JLabel("�����ڳ��������������س�");
		inputLabel.setBounds(0, 0, 170, 15);
		namePanel.add(inputLabel);
		// �������������ı�����ӵ�namePanel��
		// ����λ�úʹ�С���Լ���Ӱ����¼�������
		nameField = new JTextField();
		nameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textField_keyPressed(e);
			}
		});
		nameField.setBounds(0, 20, 170, 20);
		namePanel.add(nameField);
		// ���������б��ı�������ӵ��������scrollPane1��
		// ��scrollPane1��ӵ�c�У�������scrollPane1��λ�úʹ�С
		nameArea = new JTextArea();
		nameArea.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(nameArea);
		scrollPane1.setBounds(0, 45, 170, 200);
		namePanel.add(scrollPane1); 
		// �������resultPanel����ӵ�c�У�����λ�úʹ�С���Լ�����Ϊ�߽粼��
		JPanel resultPanel = new JPanel();
		resultPanel.setBounds(183, 10, 219, 242);
		c.add(resultPanel);
		resultPanel.setLayout(new BorderLayout(0, 0));
		// ������ȡ�����˹�����ʾ��ǩ����ӵ�resultPanel��North����   
		resultLabel = new JLabel("��ȡ�����˹���");
		resultPanel.add(resultLabel, BorderLayout.NORTH);
		// �����齱��Ϣ�ı�������ӵ��������scrollPane2��
		// ��scrollPane2��ӵ�c��
		resultArea = new JTextArea();
		resultArea.setEditable(false);
		JScrollPane scrollPane2 = new JScrollPane(resultArea);
		resultPanel.add(scrollPane2);
		// ������ȡ��ť����ӵ�c�У�������λ�úʹ�С���Լ���Ӷ����¼�������
		btnExtract = new JButton("��ȡ");
		btnExtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExtract_actionPerformed(e);
			}
		});
		btnExtract.setBounds(407, 215, 63, 25);
		c.add(btnExtract);
		//���ô�������Ļ�Ͼ��з��ã������ܸı��С
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	protected void textField_keyPressed(KeyEvent e) {
		if (e.getKeyChar() != '\n')		// ���ǻس��ַ���������
			return;
		String name = nameField.getText();
		if (name.isEmpty())				// ����ı���û���ַ�����������
			return;
		nameArea.append(name + "\n");	// �������������س�����ӵ������б�
		nameField.selectAll();			// ѡ���ı��������ַ�
	}
	
	protected void btnExtract_actionPerformed(ActionEvent e) {
		String perstring = nameArea.getText();			// ��ȡ�����б��ı�
		String[] personnelArray = perstring.split("\n");	// ��ȡ��������
		int index = (int) (Math.random() * personnelArray.length);	// ���������������
		// ���������ʽ�������н���Ϣ
		String formatArg = "���γ�ȡ�����˹��ڣ�\n\t %1$s\n���ǽ��䷢��Ʒ��\n\tţ��һ��\n\t����һ��";
		// Ϊ�н���Ϣ�����Ա����
		String info = String.format(formatArg, personnelArray[index]);
		resultArea.setText(info);						// ���ı�����ʾ�м���Ϣ
	}
}

/* UpdatePassword.java */
package chapter13.practice;
import java.awt.*;					
import java.awt.event.*;
import javax.swing.*;		
public class UpdatePassword extends JFrame {
	JLabel newPassword = new JLabel("������������");
	JLabel confirmPass = new JLabel("�ٴ�ȷ��������");
	JPasswordField text_1 = new JPasswordField();
	JPasswordField text_2 = new JPasswordField();
	JButton confirmBtn = new JButton("ȷ��");
	JButton cancelBtn = new JButton("ȡ��");
	public UpdatePassword() {
		setLayout(null);		
		setTitle("�޸�����");		
		setSize(300, 170);
		newPassword.setBounds(30, 20, 90, 30);	
		text_1.setBounds(125, 23, 120, 20);
		confirmPass.setBounds(30, 50, 90, 30);		
		text_2.setBounds(125, 53, 120, 20);
		confirmBtn.setBounds(70, 90, 70, 25); 	// ȷ����ť
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmButtonPerformed(e);
			}
		});
		cancelBtn.setBounds(160, 90, 70, 25); // �رհ�ť
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 				// �ͷŴ�����Դ
			}
		});
		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				dispose(); 				// �ͷŴ�����Դ
			}
		});
		Container c = getContentPane();
		c.add(newPassword);		c.add(confirmPass);		c.add(text_1);
		c.add(text_2);			c.add(confirmBtn);		c.add(cancelBtn);
		setLocationRelativeTo(null); 		// ʹ��������Ļ�Ͼ��з���
		setVisible(true); 					// ʹ����ɼ�
	}
	private void confirmButtonPerformed(ActionEvent e) {
		String pass1 = String.valueOf(text_1.getPassword());
		String pass2 = String.valueOf(text_2.getPassword());
		// ��������������������һ��Ϊ�գ�����ʾ������ʾ��Ϣ������
		if (pass1.equals("") || pass1.equals("")) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ����������룡");
			return;
		}
		// ��������������������������ݲ�һ�£�����ʾ������ʾ��Ϣ������
		if (!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(null, "������������벻һ�£����������룡");
			text_1.setText("");
			text_2.setText("");
			return;
		}
		String sql = "update tb_user set password='" + pass1
				+ "' where username='" + GlobalVar.login_user + "'";
		int i = DbOp.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "�޸�����ɹ���");
		} else
			JOptionPane.showMessageDialog(null, "�û����ݿ�����򲻴��ڣ��޸�����ʧ�ܣ�");
	}
	// ����main()��������ҪΪ�˵��Գ������
	public static void main(String[] args) {
		new UpdatePassword();
	}
}


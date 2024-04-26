/* Login.java */
package chapter13.practice;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {
	JTextField text_user;
	JPasswordField text_pass;
	public Login() {
		setTitle("��¼");
		setLayout(null);
		setSize(260, 180);
		/* ��ӱ�ǩ���ı��� */
		JLabel lbUser = new JLabel("�û�����");
		JLabel lbPass = new JLabel("��    �룺");
		JButton btn_ok = new JButton("ȷ��");
		JButton btn_cancel = new JButton("ȡ��");
		text_pass = new JPasswordField();
		text_user = new JTextField();
		lbUser.setBounds(35, 20, 60, 20);
		lbPass.setBounds(35, 60, 60, 20);
		text_user.setBounds(85, 20, 120, 20);
		text_pass.setBounds(85, 60, 120, 20);
		btn_ok.setBounds(35, 100, 80, 25); // ȷ����ť
		btn_ok.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_okActionPerformed(e);
			}
		}));
		btn_cancel.setBounds(125, 100, 80, 25); // ȡ����ť
		btn_cancel.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DbOp.Close(); 		// �ر����ݿ�
				System.exit(0);
			}
		}));
		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				//DbOp.Close(); // �ر����ݿ�
				System.exit(0);
			}
		});
		Container c = getContentPane();
		c.add(lbUser);
		c.add(lbPass);
		c.add(text_user);
		c.add(text_pass);
		c.add(btn_ok);
		c.add(btn_cancel);
		setLocationRelativeTo(null); 	// ʹ��������Ļ�Ͼ��з���
		setVisible(true); 			// ʹ����ɼ�
	}
	public void btn_okActionPerformed(ActionEvent e) {
		String user = text_user.getText();
		String pass = String.valueOf(text_pass.getPassword());
		String is_admin;
		// ����û�����������һΪ�գ�����ֹ��������
		if (user.equals("")||pass.equals("")) {
			JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ�գ�");
			return;
		}
		try {
			// �˶��û���������
			String sql = "select * from tb_user where username=" + "'" + user
					+ "'and password=" + "'" + pass + "'";
			ResultSet rs = DbOp.executeQuery(sql);
			// ������û����ڣ����¼��״̬���񣺲��ǹ���Ա���ǣ��ǹ���Ա��
			if (rs.next()) {
				is_admin = rs.getString("is_admin");
			} else {
				JOptionPane.showMessageDialog(null, "�û��������벻��ȷ��");
				return;
			}
			GlobalVar.login_user = user; 		// ��¼��¼���û���
			ShowMain show = new ShowMain(); 	// ����������
			// ֻ�й���Ա����ʹ��"��������"�˵�
			show.setRights(is_admin);
			// �ͷŴ��弰��ȫ���������Ļ��Դ����ʹ�ͷŵ�¼����
			dispose(); 						// �ͷŵ�ǰ����
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "�û����ݿ�����");
		}
	}
	public static void main(String[] args) {
		new Login();
	}
}


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
		setTitle("登录");
		setLayout(null);
		setSize(260, 180);
		/* 添加标签与文本框 */
		JLabel lbUser = new JLabel("用户名：");
		JLabel lbPass = new JLabel("密    码：");
		JButton btn_ok = new JButton("确定");
		JButton btn_cancel = new JButton("取消");
		text_pass = new JPasswordField();
		text_user = new JTextField();
		lbUser.setBounds(35, 20, 60, 20);
		lbPass.setBounds(35, 60, 60, 20);
		text_user.setBounds(85, 20, 120, 20);
		text_pass.setBounds(85, 60, 120, 20);
		btn_ok.setBounds(35, 100, 80, 25); // 确定按钮
		btn_ok.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_okActionPerformed(e);
			}
		}));
		btn_cancel.setBounds(125, 100, 80, 25); // 取消按钮
		btn_cancel.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DbOp.Close(); 		// 关闭数据库
				System.exit(0);
			}
		}));
		/* 关闭窗口 */
		this.addWindowListener(new WindowAdapter() {
			// 重写windowClosing()方法
			public void windowClosing(WindowEvent e) {
				//DbOp.Close(); // 关闭数据库
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
		setLocationRelativeTo(null); 	// 使窗体在屏幕上居中放置
		setVisible(true); 			// 使窗体可见
	}
	public void btn_okActionPerformed(ActionEvent e) {
		String user = text_user.getText();
		String pass = String.valueOf(text_pass.getPassword());
		String is_admin;
		// 如果用户名或密码任一为空，则终止后续操作
		if (user.equals("")||pass.equals("")) {
			JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");
			return;
		}
		try {
			// 核对用户名和密码
			String sql = "select * from tb_user where username=" + "'" + user
					+ "'and password=" + "'" + pass + "'";
			ResultSet rs = DbOp.executeQuery(sql);
			// 如果此用户存在，则记录其状态（否：不是管理员，是：是管理员）
			if (rs.next()) {
				is_admin = rs.getString("is_admin");
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码不正确！");
				return;
			}
			GlobalVar.login_user = user; 		// 记录登录的用户名
			ShowMain show = new ShowMain(); 	// 调用主程序
			// 只有管理员才能使用"基础管理"菜单
			show.setRights(is_admin);
			// 释放窗体及其全部组件的屏幕资源，即使释放登录窗体
			dispose(); 						// 释放当前窗体
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "用户数据库有误！");
		}
	}
	public static void main(String[] args) {
		new Login();
	}
}


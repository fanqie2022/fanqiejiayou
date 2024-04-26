/* UpdatePassword.java */
package chapter13.practice;
import java.awt.*;					
import java.awt.event.*;
import javax.swing.*;		
public class UpdatePassword extends JFrame {
	JLabel newPassword = new JLabel("请输入新密码");
	JLabel confirmPass = new JLabel("再次确认新密码");
	JPasswordField text_1 = new JPasswordField();
	JPasswordField text_2 = new JPasswordField();
	JButton confirmBtn = new JButton("确定");
	JButton cancelBtn = new JButton("取消");
	public UpdatePassword() {
		setLayout(null);		
		setTitle("修改密码");		
		setSize(300, 170);
		newPassword.setBounds(30, 20, 90, 30);	
		text_1.setBounds(125, 23, 120, 20);
		confirmPass.setBounds(30, 50, 90, 30);		
		text_2.setBounds(125, 53, 120, 20);
		confirmBtn.setBounds(70, 90, 70, 25); 	// 确定按钮
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmButtonPerformed(e);
			}
		});
		cancelBtn.setBounds(160, 90, 70, 25); // 关闭按钮
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 				// 释放窗体资源
			}
		});
		/* 关闭窗口 */
		this.addWindowListener(new WindowAdapter() {
			// 重写windowClosing()方法
			public void windowClosing(WindowEvent e) {
				dispose(); 				// 释放窗体资源
			}
		});
		Container c = getContentPane();
		c.add(newPassword);		c.add(confirmPass);		c.add(text_1);
		c.add(text_2);			c.add(confirmBtn);		c.add(cancelBtn);
		setLocationRelativeTo(null); 		// 使窗体在屏幕上居中放置
		setVisible(true); 					// 使窗体可见
	}
	private void confirmButtonPerformed(ActionEvent e) {
		String pass1 = String.valueOf(text_1.getPassword());
		String pass2 = String.valueOf(text_2.getPassword());
		// 如果两个密码输入框中有一个为空，则显示错误提示信息并返回
		if (pass1.equals("") || pass1.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空，请重新输入！");
			return;
		}
		// 如果两个密码输入框中输入的内容不一致，则显示错误提示信息并返回
		if (!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(null, "两次输入的密码不一致，请重新输入！");
			text_1.setText("");
			text_2.setText("");
			return;
		}
		String sql = "update tb_user set password='" + pass1
				+ "' where username='" + GlobalVar.login_user + "'";
		int i = DbOp.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "修改密码成功！");
		} else
			JOptionPane.showMessageDialog(null, "用户数据库有误或不存在，修改密码失败！");
	}
	// 增加main()方法，主要为了调试程序界面
	public static void main(String[] args) {
		new UpdatePassword();
	}
}


/* ReaderOperate.java */
package chapter13.practice;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class ReaderOperate extends JFrame {
	JLabel lbreaderid = new JLabel("读者编号");
	JLabel lbreaderid_1 = new JLabel("读者编号");
	JLabel lbreadername = new JLabel("读者姓名");
	JLabel lbreadertype = new JLabel("读者类别");
	JLabel lbsex = new JLabel("性别");
	JLabel lbmax_num = new JLabel("可借数量");
	JLabel lbdays_num = new JLabel("可借天数");
	JTextField tf_readerid = new JTextField();
	JTextField tf_readername = new JTextField();	
	JTextField tf_max_num = new JTextField();
	JTextField tf_days_num = new JTextField();	
	JTextField tf_readerid1 = new JTextField();
	JComboBox<String> tf_readertype = new JComboBox<String>();		
	JComboBox<String> tf_sex = new JComboBox<String>();
	JButton queryBtn = new JButton("查询");	
	JButton btn = new JButton();
	JButton closeBtn = new JButton("关闭");	
	String title;
	public ReaderOperate(String title) {
		setLayout(null);
		setTitle(title);
		setSize(430, 240);
		this.title = title;
		
		if (title == "删除读者") {
			tf_readerid.setEditable(false);
			btn.setText("删除");
		}
		else if ( title == "更新读者") {
			tf_readerid.setEditable(false);
			btn.setText("保存");
		}
		else if (title == "添加读者") {
			lbreaderid_1.setVisible(false);
			tf_readerid1.setVisible(false);
			queryBtn.setVisible(false);
			btn.setText("保存");
		}
		
		lbreaderid_1.setBounds(80, 20, 50, 20); 	// 读者编号
		tf_readerid1.setBounds(140, 20, 100, 20);
		queryBtn.setBounds(270, 20, 80, 20); 		// 查询按钮
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		lbreaderid.setBounds(30, 60, 50, 20); 		// 读者编号
		tf_readerid.setBounds(90, 60, 100, 20);
		lbreadername.setBounds(220, 60, 50, 20); 	// 读者姓名
		tf_readername.setBounds(280, 60, 100, 20);
		lbreadertype.setBounds(30, 90, 50, 20); 	// 读者类别
		tf_readertype.setBounds(90, 90, 100, 20);
		tf_readertype.addItem("教师");
		tf_readertype.addItem("学生");
		tf_readertype.addItem("职工");
		lbsex.setBounds(220, 90, 50, 20); 		// 性别
		tf_sex.setBounds(280, 90, 100, 20);
		tf_sex.addItem("男");
		tf_sex.addItem("女");
		lbmax_num.setBounds(30, 120, 50, 20); 	// 最大可借数
		tf_max_num.setBounds(90, 120, 100, 20);
		lbdays_num.setBounds(220, 120, 50, 20); 	// 最大可借天数
		tf_days_num.setBounds(280, 120, 100, 20);
		btn.setBounds(100, 160, 80, 25); 		// 删除按钮
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (title == "删除读者")
					btn_delActionPerformed(e);
				else if (title == "添加读者" || title == "更新读者")
					btn_saveActionPerformed(e);
			}
		});
		closeBtn.setBounds(240, 160, 80, 25); // 关闭按钮
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 					// 释放当前窗体
			}
		});
		/* 关闭窗口 */
		this.addWindowListener(new WindowAdapter() {
			// 重写windowClosing()方法
			public void windowClosing(WindowEvent e) {
				dispose(); 					// 释放当前窗体
			}
		});
		Container c = getContentPane();
		c.add(lbreaderid); 						// 将各组件添加到窗体中
		c.add(lbreaderid_1);		c.add(lbreadername);		c.add(lbreadertype);
		c.add(lbsex);			c.add(lbmax_num);		c.add(lbdays_num);
		c.add(tf_readerid);		c.add(tf_readername);	c.add(tf_max_num);
		c.add(tf_days_num);		c.add(tf_readerid1);		c.add(tf_readertype);
		c.add(tf_sex);			c.add(btn);			c.add(closeBtn);
		c.add(queryBtn);
		setLocationRelativeTo(null); // 使窗体在屏幕上居中放置
		setVisible(true); // 使窗体可见
	}
	private void btn_delActionPerformed(ActionEvent e) {
		String id = tf_readerid.getText();
		// 如果读者编号为空，则终止删除操作
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "读者编号不能为空！");
			return;
		}
		String sql = "delete from tb_reader where id='" + id + "'";
		int i = DbOp.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "读者信息删除成功！");
			// 清空全部文本框
			clearAllTextfield();
		} else
			JOptionPane.showMessageDialog(null, "读者编号有误，查无此人！");
	}
	private void btn_queryActionPerformed(ActionEvent e) {
		String id = tf_readerid1.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "读者编号不能为空！");
			return;
		}
		// 按编号查询读者，结果存入reader对象中
		Reader reader = ReaderSelect.selectReaderById(id);
		// 如果查询到结果，将其显示在各文本框中
		if (reader != null) {
			tf_readerid.setText(reader.getId());
			tf_readerid.setEditable(false);
			tf_readername.setText(reader.getReadername());
			// 将Choice的选定项设置为其名称等于指定字符串的项
			tf_readertype.setSelectedItem(reader.getReadertype());
			tf_sex.setSelectedItem(reader.getSex());
			tf_max_num.setText(String.valueOf(reader.getMax_num()));
			tf_days_num.setText(String.valueOf(reader.getDays_num()));
		} else
			JOptionPane.showMessageDialog(null, "读者编号有误，查无此人！");
	}
	private void btn_saveActionPerformed(ActionEvent e) {
		String id = tf_readerid.getText();
		String name = tf_readername.getText();
		String type = tf_readertype.getSelectedItem().toString();
		String sex = tf_sex.getSelectedItem().toString();
		// 如果读者编号为空，则终止保存记录操作
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "读者编号不能为空！");
			return;
		}
		// 如果读者编号重复，则记录无效，需修改读者编号
		if (title == "添加读者" & IfReaderIdExit(id)) {
			JOptionPane.showMessageDialog(null, "读者编号重复！");
			return;
		}
		try {
			int max_num = Integer.parseInt(tf_max_num.getText());
			int days_num = Integer.parseInt(tf_days_num.getText());
			String sql = "";
			if (title == "添加读者") {
				sql = "insert into tb_reader values('" + id + "','" + name + "','"
					+ type + "','" + sex + "','" + max_num + "','" + days_num
					+ "')";
			} else if (title == "更新读者") {
				sql = "update tb_reader set readername='" + name
						+ "',readertype='" + type + "',days_num='" + days_num
						+ "',sex='" + sex + "',max_num='" + max_num
						+ "' where id='" + id + "'";
			}
			int i = DbOp.executeUpdate(sql);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "读者添加成功！");
				// 清空全部文本框
				clearAllTextfield();
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "最大可借数或"
					+ "最大可借天数错误，应为整数！");
		}
	}
	// 判断Reader表中是否存在指定编号的读者，如果存在，返回true，否则，返回false
	private boolean IfReaderIdExit(String id) {
		String sql = "select * from tb_reader where id='" + id + "'";
		ResultSet rs = DbOp.executeQuery(sql);
		try {
			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "无法正常读取数据库！");
		}
		return false;
	}
	// 清空全部文本框
	private void clearAllTextfield() {
		tf_readerid1.setText("");		tf_readerid.setText("");
		tf_readername.setText("");	tf_max_num.setText("");
		tf_days_num.setText("");
	}
	// 增加main()方法，主要为了调试程序界面
	public static void main(String[] args) {
		new ReaderOperate("更新读者");
	}
}


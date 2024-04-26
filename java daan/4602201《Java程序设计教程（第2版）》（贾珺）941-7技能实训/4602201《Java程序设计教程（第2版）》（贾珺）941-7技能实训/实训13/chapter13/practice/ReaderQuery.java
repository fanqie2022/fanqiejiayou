/* ReaderQuery.java */
package chapter13.practice;
import java.awt.*;	
import java.awt.event.*;
import java.sql.*;		
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ReaderQuery extends JFrame {
	JLabel lbreadername = new JLabel("读者姓名");
	JLabel lbreadertype = new JLabel("读者类别");
	JTextField tf_readername = new JTextField("");
	JTextField tf_readertype = new JTextField("");
	JButton queryBtn = new JButton("查询");
	JButton closeBtn = new JButton("关闭");
	JTable table;// 定义表格table
	DefaultTableModel model;// 定义DefaultTableModel类对象model
	// 构造方法
	public ReaderQuery() {
		setTitle("读者查询"); 					// 设置窗体标题
		setSize(600, 500);	 					// 设置窗体尺寸
		setLayout(null); 						// 取消窗体布局
		lbreadername.setBounds(70, 20, 50, 20); 	// 读者姓名
		tf_readername.setBounds(130, 20, 160, 20);
		lbreadertype.setBounds(310, 20, 50, 20); 	// 读者类别
		tf_readertype.setBounds(370, 20, 160, 20);
		queryBtn.setBounds(200, 60, 80, 25); // 查询按钮
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		closeBtn.setBounds(320, 60, 80, 25); // 关闭按钮
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 			// 释放当前窗体
			}
		});
		/* 关闭窗口 */
		this.addWindowListener(new WindowAdapter() {
			// 重写windowClosing()方法
			public void windowClosing(WindowEvent e) {
				dispose(); 			// 释放当前窗体
			}
		});
		
		String[] heads = { "读者编号", "读者姓名", "读者类型", "读者性别",
				 "最大可借数", "可借天数" };
		
		// 创建DefaultTableModel类对象model
		model = new DefaultTableModel(heads, 0);
		// 创建JTable类对象table，并使用model保存table数据
		table = new JTable(model);
		// 创建JScrollPane类对象scrollPane，将table添加到scrollPane中
		JScrollPane scrollPane = new JScrollPane(table);
		// 设置JScrollPane的位置和尺寸
		scrollPane.setBounds(10, 120, 560, 300);
		Container c = getContentPane();
		c.add(scrollPane);
		
		c.add(lbreadername); 			// 将各组件添加到窗体中
		c.add(tf_readername);		c.add(lbreadertype);
		c.add(tf_readertype);		c.add(queryBtn);
		c.add(closeBtn);
		setLocationRelativeTo(null); 	// 使窗体在屏幕上居中放置
		setVisible(true); 				// 使窗体可见
	}
	private void btn_queryActionPerformed(ActionEvent e) {
		// 清空表格和查询文本框
		int rowCount = model.getRowCount();
		for (int i = 1; i <= rowCount; i++) {
			model.removeRow(0);
		}
		try {
			String readername, readertype;
			String sql, sql1, sql2, sql3;
			readername = tf_readername.getText();
			readertype = tf_readertype.getText();
			// 创建一条基本的SQL语句，表示选出表中全部记录
			sql = "select * from tb_reader ";
			// 如果读者姓名不空，生成sql1字句
			if (readername.equals(""))
				sql1 = "";
			else
				sql1 = " readername like '" + readername + "%' ";
			// 如果作者不空，生成sql2字句
			if (readertype.equals(""))
				sql2 = "";
			else {
				sql2 = " readertype like '" + readertype + "%' ";
				if (!readername.equals("")) // 如果书名不为空
					sql2 = " and " + sql2;
			}
			sql3 = sql1 + sql2;
			// 如果已设置任意一项条件，则修改SQL语句
			if (!sql3.equals("")) {
				sql = sql + " where " + sql3;
			}
			// 执行查询
			ResultSet rs = DbOp.executeQuery(sql);
			while (rs.next()) {
				String[] readerInfo = { rs.getString("id"), rs.getString("readername"), 
						rs.getString("readertype"), rs.getString("sex"), 
						rs.getString("max_num"), rs.getString("days_num")};

				model.addRow(readerInfo);// 将信息添加到model中
			}
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "数据库不存在，或存在错误！");
		}
	}
	// 增加main()方法，主要为了调试程序界面
	public static void main(String[] args) {
		new ReaderQuery();
	}
}


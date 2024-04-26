/* BookQuery.java */
package chapter13.practice;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookQuery extends JFrame {
	JScrollPane scrollPane;
	JLabel lbbookname = new JLabel("图书名称");
	JLabel lbauthor = new JLabel("作        者");
	JLabel lbpublisher = new JLabel("出  版  社");
	JLabel lbpublish_time = new JLabel("出版时间");
	JLabel lbnotes = new JLabel("（年-月-日）");
	JTextField tf_bookname = new JTextField("");
	JTextField tf_author = new JTextField("");
	JTextField tf_publisher = new JTextField("");
	JTextField tf_publish_time = new JTextField("");
	JButton queryBtn = new JButton("查询");
	JButton closeBtn = new JButton("关闭");
	JTable table;// 定义表格table
	DefaultTableModel model;// 定义DefaultTableModel类对象model

	// 构造方法
	public BookQuery() {
		setTitle("图书查询"); 					// 设置窗体标题
		setSize(800, 500);			 			// 设置窗体尺寸
		setLayout(null); 						// 取消窗体布局
		lbbookname.setBounds(170, 20, 50, 20); 	// 书名
		tf_bookname.setBounds(230, 20, 160, 20);
		lbauthor.setBounds(410, 20, 50, 20); 		// 作者
		tf_author.setBounds(470, 20, 160, 20);
		lbpublisher.setBounds(170, 50, 50, 20); 	// 出版社
		tf_publisher.setBounds(230, 50, 160, 20);
		lbpublish_time.setBounds(410, 40, 50, 20); 	// 出版时间
		lbnotes.setBounds(400, 60, 70, 20);
		tf_publish_time.setBounds(470, 50, 160, 20);
		queryBtn.setBounds(300, 90, 80, 25); 		// 查询按钮
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		closeBtn.setBounds(420, 90, 80, 25);// 关闭按钮
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
		String[] heads = { "图书编号", "图书名称", "图书类别", "作者", "译者",
				 "出版社", "出版日期", "定价",	"库存数量" };
		
		// 创建DefaultTableModel类对象model
		model = new DefaultTableModel(heads, 0);
		// 创建JTable类对象table，并使用model保存table数据
		table = new JTable(model);
		// 创建JScrollPane类对象scrollPane，
		// 将table添加到scrollPane中
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 140, 760, 300);
		Container c = getContentPane();
		c.add(lbbookname); 	// 将各组件添加到窗体中
		c.add(tf_bookname);		c.add(lbauthor);			c.add(tf_author);
		c.add(lbpublisher);		c.add(tf_publisher);		c.add(lbpublish_time);
		c.add(lbnotes);			c.add(tf_publish_time);		c.add(queryBtn);
		c.add(closeBtn);		c.add(scrollPane);
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
			String bookname, author, publisher, publishtime;
			String sql, sql1, sql2, sql3, sql4, sql5;
			String pubyear, pubmonth;
			bookname = tf_bookname.getText();
			author = tf_author.getText();
			publisher = tf_publisher.getText();
			publishtime = tf_publish_time.getText();
			// 创建一条基本的SQL语句，表示选出表中全部记录
			sql = "select * from tb_book ";
			// 如果书名不空，生成sql1字句
			if (bookname.equals(""))
				sql1 = "";
			else
				sql1 = " bookname like '" + bookname + "%' ";
			// 如果作者不空，生成sql2字句
			if (author.equals(""))
				sql2 = "";
			else {
				sql2 = " author like '" + author + "%' ";
				if (!bookname.equals("")) // 如果书名不为空
					sql2 = " and " + sql2;
			}
			// 如果出版社不空，生成sql3字句
			if (publisher.equals(""))
				sql3 = "";
			else {
				sql3 = "publisher like '" + publisher + "%' ";
				// 如果书名和作者有一项不为空
				if (!(bookname.equals("") && author.equals("")))
					sql3 = " and " + sql3;
			}
			// 如果出版日期不空，生成sql4字句
			if (publishtime.equals("")) {
				sql4 = "";
			} else {
				// 创建一个简单日期格式对象，注意：MM一定要用大写
				// 这是用户输入日期的格式：年-月，如2010-7、2009-10等
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				// 创建一个Calendar对象
				Calendar cal = new GregorianCalendar();
				// 将字符串转换为日期
				Date pubtime = sdf.parse(tf_publish_time.getText());
				// 使用给定日期设置cal的时间
				cal.setTime(pubtime);
				// 获取年
				pubyear = String.valueOf(cal.get(Calendar.YEAR));
				// 获取月
				pubmonth = String.valueOf(cal.get(Calendar.MONTH) + 1);
				sql4 = " year(publish_time)=" + pubyear + " and ";
				sql4 = sql4 + "month(publish_time)=" + pubmonth;
				// 如果书名、作者或出版社有一项不为空
				if (!(bookname.equals("") && author.equals("") && publisher
						.equals("")))
					sql4 = " and " + sql4;
			}
			sql5 = sql1 + sql2 + sql3 + sql4;
			// 如果已设置任意一项条件，则修改SQL语句
			if (!sql5.equals("")) {
				sql = sql + " where " + sql5;
			}
			// 执行查询
			ResultSet rs = DbOp.executeQuery(sql);
			while (rs.next()) { 
				String[] bookInfo = { rs.getString("id"), rs.getString("bookname"), 
						rs.getString("booktype"), rs.getString("author"), 
						rs.getString("translator"), rs.getString("publisher"), 
						rs.getString("publish_time"), rs.getString("price"), 
						rs.getString("stock")};
				model.addRow(bookInfo);// 将信息添加到model中
			}
			
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "出版时间格式错误（年-月-日）！");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "数据库不存在，或存在错误！");
		}
	}
	// 增加main()方法，主要为了调试程序界面
	public static void main(String[] args) {
		new BookQuery();
	}
}


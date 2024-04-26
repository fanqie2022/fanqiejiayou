/* BookOperate.java */
package chapter13.practice;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import javax.swing.*;
public class BookOperate extends JFrame {
	JLabel lbbookid_1 = new JLabel("图书编号");
	JLabel lbbookid = new JLabel("图书编号");
	JLabel lbbookname = new JLabel("图书名称");
	JLabel lbbooktype = new JLabel("图书类别");
	JLabel lbauthor = new JLabel("作者"); 	
	JLabel lbtranslator = new JLabel("译者");
	JLabel lbpublisher = new JLabel("出版社");
	JLabel lbpublish_time = new JLabel("出版时间");
	JLabel lbprice = new JLabel("定价");		
	JLabel lbstock = new JLabel("库存数量");
	JButton btn = new JButton(); 
	JButton closeBtn = new JButton("关闭");
	JButton queryBtn = new JButton("查询");	
	JTextField tf_bookid = new JTextField();
	JTextField tf_bookname = new JTextField();	
	JTextField tf_author = new JTextField();
	JTextField tf_translator = new JTextField();	
	JTextField tf_publisher = new JTextField();
	JTextField tf_publish_time = new JTextField();
	JTextField tf_price = new JTextField();
	JTextField tf_stock = new JTextField();		
	JTextField tf_bookid1 = new JTextField();
	JComboBox<String> tf_booktype = new JComboBox<String>();
	String title;
	public BookOperate(String title) {
		setLayout(null);
		setTitle(title);
		setSize(440, 310);
		this.title = title;
		
		if (title == "删除图书") {
			tf_bookid.setEditable(false);
			btn.setText("删除");
		}
		else if ( title == "更新图书") {
			tf_bookid.setEditable(false);
			btn.setText("保存");
		}
		else if (title == "添加图书") {
			lbbookid_1.setVisible(false);
			tf_bookid1.setVisible(false);
			queryBtn.setVisible(false);
			btn.setText("保存");
		}
		
		lbbookid_1.setBounds(80, 20, 50, 20);// 图书编号
		tf_bookid1.setBounds(140, 20, 100, 20);
		queryBtn.setBounds(260, 20, 80, 20); // 查询按钮
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		lbbookid.setBounds(30, 60, 50, 20); // 图书编号
		tf_bookid.setBounds(90, 60, 100, 20);
		lbbookname.setBounds(220, 60, 50, 20); // 图书名称
		tf_bookname.setBounds(280, 60, 100, 20);
		lbbooktype.setBounds(30, 90, 50, 20); // 图书类别
		tf_booktype.setBounds(90, 90, 100, 20);
		tf_booktype.addItem("科技");
		tf_booktype.addItem("文学");
		tf_booktype.addItem("社科");
		tf_booktype.addItem("其他");
		lbauthor.setBounds(220, 90, 50, 20); // 作者
		tf_author.setBounds(280, 90, 100, 20);
		lbtranslator.setBounds(30, 120, 50, 20); // 译者
		tf_translator.setBounds(90, 120, 100, 20);
		lbpublisher.setBounds(220, 120, 50, 20); 	// 出版社
		tf_publisher.setBounds(280, 120, 100, 20);
		lbpublish_time.setBounds(30, 150, 50, 20); 	// 出版时间
		tf_publish_time.setBounds(90, 150, 100, 20);
		lbprice.setBounds(220, 150, 50, 20); // 价格
		tf_price.setBounds(280, 150, 100, 20);
		lbstock.setBounds(30, 180, 50, 20);		// 库存数量
		tf_stock.setBounds(90, 180, 100, 20);
		btn.setBounds(100,220, 80, 25); 		// 删除按钮
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (title == "删除图书")
					btn_delActionPerformed(e);
				else if (title == "添加图书" || title == "更新图书") {
					btn_saveActionPerformed(e);
				}			
			}
		});
		closeBtn.setBounds(250, 220, 80, 25); 		// 关闭按钮
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 					// 释放当前窗体
			}
		});
		/* 关闭窗口 */
		addWindowListener(new WindowAdapter() {
			// 重写windowClosing()方法
			public void windowClosing(WindowEvent e) {
				dispose(); 					// 释放当前窗体
			}
		});
		Container c = getContentPane();
		c.add(lbbookid); 						// 将各组件增加到窗体中
		c.add(lbbookid_1);		c.add(lbbookname);		c.add(lbbooktype);
		c.add(lbauthor);		c.add(lbtranslator);	c.add(lbpublisher);
		c.add(lbpublish_time);	c.add(lbprice);			c.add(lbstock);
		c.add(btn);			c.add(closeBtn);		c.add(queryBtn);
		c.add(tf_bookid);		c.add(tf_bookname);		c.add(tf_author);
		c.add(tf_translator);	c.add(tf_publisher);	c.add(tf_publish_time);
		c.add(tf_price);		c.add(tf_stock);		c.add(tf_bookid1);
		c.add(tf_booktype);
		setLocationRelativeTo(null); 			// 使窗体在屏幕上居中放置
		setVisible(true); 						// 使窗体可见
	}
	private void btn_delActionPerformed(ActionEvent e) {
		String id = tf_bookid.getText();
		// 如果图书编号为空，则删除操作终止
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "图书编号不能为空！");
			return;
		}
		String sql = "delete from tb_book where id='" + id + "'";
		int i = DbOp.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "图书信息删除成功!");
			// 清空全部文本框
			clearAllTextfield();
		} else
			JOptionPane.showMessageDialog(null, "图书信息删除失败！");
	}
	private void btn_queryActionPerformed(ActionEvent e) {
		String id = tf_bookid1.getText();
		// 如果图书编号为空，则查询操作终止
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "图书编号不能为空！");
			return;
		}
		// 按编号查询图书，结果存入book对象中
		Book book = BookSelect.SelectBookById(id);
		// 如果查询到结果，将其显示在各文本框中
		if (book != null) {
			tf_bookid.setText(book.getId());
			tf_bookid.setEditable(false);
			tf_bookname.setText(book.getBookname());
			// 将Choice的选定项设置为其名称等于指定字符串的项
			tf_booktype.setSelectedItem(book.getBooktype());
			tf_author.setText(book.getAuthor());
			tf_translator.setText(book.getTranslator());
			tf_publisher.setText(book.getPublisher());
			tf_publish_time.setText(book.getPublish_time().toString());
			tf_price.setText(String.valueOf((book.getPrice())));
			tf_stock.setText(String.valueOf(book.getStock()));
		} else
			JOptionPane.showMessageDialog(null, "图书编号有误，查无此书！");
	}
	// 保存添加或更新的记录
	private void btn_saveActionPerformed(ActionEvent e) {
		String id = tf_bookid.getText();
		String bookname = tf_bookname.getText();
		String booktype = tf_booktype.getSelectedItem().toString();
		String author = tf_author.getText();
		String translator = tf_translator.getText();
		String publisher = tf_publisher.getText();
		String publish_time = tf_publish_time.getText();
		// 如果图书编号为空，则终止保存记录操作
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "图书编号不能为空！");
			return;
		}
		if (title == "添加图书" & IfBookIdExit(id)) {
			JOptionPane.showMessageDialog(null, "图书编号重复！");
			return;
		}
		try {
			// -------------------------------------------------
			// 以下程序用于检查日期是否有效。如果日期无效，则会
			// 产生ParseException异常
			// 创建一个简单日期格式对象，注意：MM一定要用大写
			// 这是用户输入日期的格式：年-月，如2010-7、2009-10等
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			// 将字符串转换为日期
			sdf.parse(tf_publish_time.getText());
			// -------------------------------------------------
			float price = Float.parseFloat(tf_price.getText());
			int stock = Integer.parseInt(tf_stock.getText());
			// 将记录保存到tb_book表中
			String sql = "";
			if (title == "添加图书") {
				sql = "insert into tb_book values('" + id
					+ "','" + bookname + "','" + booktype + "','" + author
					+ "','" + translator + "','" + publisher + "','"
					+ publish_time + "','" + price + "','" + stock + "')";
			} if (title == "更新图书") {
				sql = "update tb_book set bookname='" + bookname
					+ "',booktype='" + booktype + "',author='" + author
					+ "',translator='" + translator + "',publisher='"
					+ publisher + "',publish_time='" + publish_time
					+ "',price='" + price + "',stock='" + stock
					+ "' where id='" + id + "'";
			}
			int i = DbOp.executeUpdate(sql);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "图书信息保存成功！");
				// 清空全部文本框
				clearAllTextfield();
			} else
			JOptionPane.showMessageDialog(null, "数据有误，图书信息保存失败！");
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "出版时间格式错误（年-月-日）！");
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "价格或库存数量错误，应为数字！");
		}
	}
	// 判断Book表中是否存在指定编号的图书，如果存在，返回true，否则，返回false
	private boolean IfBookIdExit(String id) {
		String sql = "select * from tb_book where id='" + id + "'";
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
		tf_bookid1.setText("");	tf_bookid.setText("");		tf_bookname.setText("");
		tf_author.setText("");	tf_translator.setText("");		tf_publisher.setText("");
		tf_publish_time.setText("");	tf_price.setText("");	tf_stock.setText("");
	}
	// 增加main()方法，主要为了调试程序界面
	public static void main(String[] args) {
		new BookOperate("添加图书");
	}
}


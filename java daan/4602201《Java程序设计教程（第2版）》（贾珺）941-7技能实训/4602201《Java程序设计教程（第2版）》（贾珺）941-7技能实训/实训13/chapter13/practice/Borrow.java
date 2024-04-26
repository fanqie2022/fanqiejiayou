/* Borrow.java */
package chapter13.practice;
import java.awt.*;					
import java.awt.event.*;
import java.sql.*;					
import java.text.SimpleDateFormat;
import java.util.Date;				
import javax.swing.*;

public class Borrow extends JFrame {
	String SepLine = "-------------------------------------------------";
	JLabel lbbookid = new JLabel("图书编号");
	JLabel lbreaderid = new JLabel("读者编号");
	JTextField tf_bookid = new JTextField();	  
	JTextField tf_readerid = new JTextField();
	JButton queryBtn = new JButton("查询");
	JLabel lbbookinfo = new JLabel(SepLine + "图书信息" + SepLine);
	JLabel lbbookname = new JLabel("图书名称：");
	JLabel tf_bookname = new JLabel("xx");
	JLabel lbauthor = new JLabel("作者：");	
	JLabel tf_author = new JLabel("xx");
	JLabel lbpublisher = new JLabel("出版社：");
	JLabel tf_publisher = new JLabel("xx");
	JLabel lbpublish_time = new JLabel("出版时间：");
	JLabel tf_publish_time = new JLabel("xx");
	JLabel lbprice = new JLabel("定价：");
	JLabel tf_price = new JLabel("xx");
	JLabel lbstock = new JLabel("库存数量：");
	JLabel tf_stock = new JLabel("xx");
	JLabel lbreaderinfo = new JLabel(SepLine + "读者信息" + SepLine);
	JLabel lbreadername = new JLabel("读者姓名：");
	JLabel tf_readername = new JLabel("xx");
	JLabel lbreadertype = new JLabel("读者类型：");
	JLabel tf_readertype = new JLabel("xx");
	JLabel lbmax_num = new JLabel("最大可借数：");
	JLabel tf_max_num = new JLabel("xx");
	JLabel lbdays_num = new JLabel("最大可借天数：");
	JLabel tf_days_num = new JLabel("xx");
	JLabel lbborrowinfo = new JLabel(SepLine + "借阅信息" + SepLine);
	JLabel lbborrowednum = new JLabel("该读者已借图书数量：");
	JLabel tf_borrowednum = new JLabel("xx");
	JLabel lbif_borrow = new JLabel("该读者是否可借所选图书：");
	JLabel tf_if_borrow = new JLabel("xx");
	JLabel lbborrow_date = new JLabel("借阅日期：");
	JLabel tf_borrow_date = new JLabel("xx");
	JButton borrowBtn = new JButton("借书");
	JButton closeBtn = new JButton("关闭");
	public Borrow() {
		setLayout(null);
		setTitle("借书管理");
		setSize(500, 420);
		lbbookid.setBounds(30, 20, 50, 25);	 	// 图书编号
		tf_bookid.setBounds(90, 20, 90, 20);
		lbreaderid.setBounds(200, 20, 50, 25); 			// 读者编号
		tf_readerid.setBounds(260, 20, 90, 20);
		queryBtn.setBounds(370, 20, 80, 25); 			// 查询按钮
		lbbookinfo.setBounds(30, 50, 440, 25); 		// 图书信息提示条
		lbbookname.setBounds(30, 80, 60, 25); 		// 图书名称
		tf_bookname.setBounds(90, 80, 200, 25);
		lbauthor.setBounds(310, 80, 60, 25); 			// 作者
		tf_author.setBounds(370, 80, 90, 25);
		lbpublisher.setBounds(30, 105, 60, 25); 		// 出版社
		tf_publisher.setBounds(90, 105, 200, 25);
		lbpublish_time.setBounds(310, 105, 60, 25); 	// 出版时间
		tf_publish_time.setBounds(370, 105, 90, 25);
		lbprice.setBounds(30, 130, 60, 25); 			// 定价
		tf_price.setBounds(90, 130, 200, 25);
		lbstock.setBounds(310, 130, 60, 25); 			// 库存数量
		tf_stock.setBounds(370, 130, 90, 25);
		lbreaderinfo.setBounds(30, 160, 440, 25); 		// 读者信息提示条
		lbreadername.setBounds(30, 185, 60, 25); 		// 读者姓名
		tf_readername.setBounds(90, 185, 90, 25);
		lbreadertype.setBounds(310, 185, 60, 25); 		// 读者类型
		tf_readertype.setBounds(370, 185, 90, 25);
		lbmax_num.setBounds(30, 210, 75, 25); 		// 最大可借数
		tf_max_num.setBounds(105, 210, 90, 25);
		lbdays_num.setBounds(310, 210, 85, 25); 		// 最大可借天数
		tf_days_num.setBounds(395, 210, 70, 25);
		lbborrowinfo.setBounds(30, 240, 440, 25); 		// 借阅信息提示条
		lbborrowednum.setBounds(30, 265, 120, 25);	// 已借图书数量
		tf_borrowednum.setBounds(150, 265, 50, 25);
		lbif_borrow.setBounds(30, 290, 145, 25); 		// 是否可借
		tf_if_borrow.setBounds(175, 290, 50, 25);
		lbborrow_date.setBounds(30, 315, 60, 25);		// 借书日期
		tf_borrow_date.setBounds(90, 315, 100, 25);
		borrowBtn.setBounds(160, 345, 80, 25);		// 借出按钮
		borrowBtn.setEnabled(false); 				// 开始时禁用借出按钮
		closeBtn.setBounds(260, 345, 80, 25);			// 关闭按钮
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_querywActionPerformed(e);
			}
		});
		borrowBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_borrowActionPerformed(e);
			}
		});
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 						// 关闭窗体
			}
		});
		/* 关闭窗口 */
		this.addWindowListener(new WindowAdapter() {
			// 重写windowClosing()方法
			public void windowClosing(WindowEvent e) {
				dispose(); // 关闭窗体
			}
		});
		Container c = getContentPane();
		c.add(lbbookid);			c.add(lbreaderid);		c.add(queryBtn);
		c.add(lbbookinfo);		c.add(lbbookname);		c.add(lbauthor);
		c.add(lbpublisher);		c.add(lbpublish_time);	c.add(lbprice);
		c.add(lbstock);			c.add(lbreaderinfo);		c.add(lbreadername);
		c.add(lbreadertype);		c.add(lbmax_num);		c.add(lbdays_num);
		c.add(lbborrowinfo);		c.add(lbborrowednum);	c.add(lbif_borrow);
		c.add(lbborrow_date);	c.add(borrowBtn);		c.add(closeBtn);
		setLocationRelativeTo(null); 		// 使窗体在屏幕上居中放置
		setVisible(true); 					// 使窗体可见
		c.setBackground(Color.white);
		c.add(tf_bookid);		c.add(tf_readerid);		c.add(tf_bookname);
		c.add(tf_author);		c.add(tf_publisher);		c.add(tf_publish_time);
		c.add(tf_price);			c.add(tf_stock);			c.add(tf_readername);
		c.add(tf_readertype);		c.add(tf_max_num);		c.add(tf_days_num);
		c.add(tf_borrowednum);	c.add(tf_if_borrow);		c.add(tf_borrow_date);
	}
	// 图书和读者查询
	private void btn_querywActionPerformed(ActionEvent e) {
		String bookid = tf_bookid.getText();
		String readerid = tf_readerid.getText();
		// 如果图书编号或读者编号两者均为空，或者有一个为空，则返回
		if (bookid.equals("") || readerid.equals("")) {
		JOptionPane.showMessageDialog(null, "图书编号和读者编号均不能为空！");
			init(); // 重新初始化各参数并禁止借出按钮
			return;
		}
		// 按编号查询图书，结果存入book对象中
		Book book = BookSelect.SelectBookById(bookid);
		// 如果查询到结果，将其显示在各文本框中
		if (book != null) {
			tf_bookname.setText(book.getBookname());
			tf_author.setText(book.getAuthor());
			tf_publisher.setText(book.getPublisher());
			tf_publish_time.setText(book.getPublish_time().toString());
			tf_price.setText(String.valueOf((book.getPrice())));
			tf_stock.setText(String.valueOf(book.getStock()));
		} else {
			JOptionPane.showMessageDialog(null, "图书编号有误，查无此书！");
			init(); // 重新初始化各参数并禁止借出按钮
			return;
		}
		if (book.getStock() == 0) {
			JOptionPane.showMessageDialog(null, "图书已无库存，无法借阅！");
			init(); // 重新初始化各参数并禁止借出按钮
			return;
		}
		// 按编号查询读者，结果存入reader对象中
		Reader reader = ReaderSelect.selectReaderById(readerid);
		// 如果查询到结果，将其显示在各文本框中
		if (reader != null) {
			tf_readername.setText(reader.getReadername());
			tf_readertype.setText(reader.getReadertype());
			tf_max_num.setText(String.valueOf(reader.getMax_num()));
			tf_days_num.setText(String.valueOf(reader.getDays_num()));
		} else {
			JOptionPane.showMessageDialog(null, "读者编号有误，查无此人！");
			init(); // 重新初始化各参数并禁止借出按钮
			return;
		}
		// 查询指定读者是否已借过指定图书且未归还
		if (IfBorrowBack.findbook(bookid, readerid)) {
		JOptionPane.showMessageDialog(null, "该读者已借阅所选图书，且未归还！");
			init(); // 重新初始化各参数并禁止借出按钮
			return;
		}
		// 统计读者所借图书数量
		int borrowednum = statborrowednum(readerid);
		tf_borrowednum.setText(String.valueOf(borrowednum));
		// 如果读者已借图书尚未超出其允许最大借书量，则允许其继续借阅所选图书
		if (borrowednum < reader.getMax_num()) {
			tf_if_borrow.setText("是");
			// 创建一个简单日期格式对象，注意：MM一定要用大写
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 创建日期变量，其内容为当前日期
			Date currentdate = new Date();
			// 将日期按指定格式输出
			String borrowdate = sdf.format(currentdate);
			tf_borrow_date.setText(borrowdate);
			borrowBtn.setEnabled(true); // 使借出按钮有效
		} else {
		JOptionPane.showMessageDialog(null, "该读者借书过多，无法继续借阅！");
			init(); // 重新初始化各参数并禁止借出按钮
			return;
		}
	}
	// 填写借出图书记录
	private void btn_borrowActionPerformed(ActionEvent e) {
		String sql;
		String bookid = tf_bookid.getText();
		String readerid = tf_readerid.getText();
		String borrowdate = tf_borrow_date.getText();
		// 为borrow表增加借书记录
		sql = "insert into tb_borrow (book_id,reader_id,"
				+ "borrow_date,if_back) values('" + bookid + "','" + readerid
				+ "','" + borrowdate + "','否')";
		DbOp.executeUpdate(sql);
		// 将该读者所借图书数量加1
		int iborrowednum = Integer.parseInt(tf_borrowednum.getText()) + 1;
		String cborrowednum = String.valueOf(iborrowednum);
		tf_borrowednum.setText(cborrowednum);
		// 将图书库存数量减1
		int istock = Integer.parseInt(tf_stock.getText()) - 1;
		String cstock = String.valueOf(istock);
		// 更新画面中的图书库存数量
		tf_stock.setText(cstock);
		// 更新数据库中的图书库存数量
		sql = "update tb_book set stock='" + cstock;
		sql = sql + "' where id='" + bookid + "'";
		DbOp.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "借书成功！");
		init(); // 重新初始化各参数并禁止借出按钮
	}
	// 统计某个读者当前已借图书且未归还的数量
	private int statborrowednum(String readerid) {
		int borrowednum = 0;
		String reader_id, if_back;
		// 读取数据库中记录
		String sql = "select * from tb_borrow";
		ResultSet rs = DbOp.executeQuery(sql);
		// 执行查询统计操作
		try {
			while (rs.next()) {
				reader_id = rs.getString("reader_id");
				if_back = rs.getString("if_back");
				if (reader_id.equals(readerid) && if_back.equals("否")) {
					borrowednum++;
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库统计失败！");
		}
		return borrowednum;
	}
	// 初始化各参数项并禁止借出按钮
	private void init() {
		tf_bookname.setText("xx");		tf_author.setText("xx");
		tf_publisher.setText("xx");		tf_publish_time.setText("xx");
		tf_price.setText("xx");			tf_stock.setText("xx");
		tf_readername.setText("xx");		tf_readertype.setText("xx");
		tf_max_num.setText("xx");		tf_days_num.setText("xx");
		tf_borrowednum.setText("xx");	tf_if_borrow.setText("xx");
		tf_borrow_date.setText("xx");
		borrowBtn.setEnabled(false); 		// 禁止借出按钮
	}
	// 增加main()方法，主要为了调试程序界面
	public static void main(String[] args) {
		new Borrow();
	}
}



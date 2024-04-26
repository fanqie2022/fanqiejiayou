/* PublicModule.java */
package chapter13.practice;
import java.sql.*;
import javax.swing.JOptionPane;
class DbOp {
	// 数据库url路径
	private static String url = "jdbc:mysql://127.0.0.1:3306/db_book";
	private static Connection con = null;
	// 构造方法。如果数据库未打开，则通过创建连接打开数据库
	private DbOp () {
		try {
			// 如果当前未创建连接，则加载JDBC驱动程序，然后创建连接
			if (con == null) {
				con = DriverManager.getConnection(url, "root", "123456");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库未能打开！");
		}
	}
	// 执行数据库查询工作。如果出现异常，返回null
	public static ResultSet executeQuery(String sql) {
		try {
			// 如果未创建数据库连接，则创建连接
			if (con == null)
				new DbOp();
			// 返回查询结果
			return con.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库不存在，或存在错误！");
			return null;
		}
	}
	// 执行数据库更新操作。如果有问题，则返回-1
	public static int executeUpdate(String sql) {
		try {
			// 如果未创建数据库连接，则创建连接
			if (con == null)
				new DbOp();
			// 返回操作结果
			return con.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "数据有误，记录无法正常保存或更新！");
			return -1;
		}
	}
	// 关闭数据库
	public static void Close() {
		try {
			// 如果数据库已打开，则关闭之
			if (con != null)
				con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库未打开！");
		}
	}
}
class Book {
	private String id;			private String bookname;	private String booktype;
	private String author;		private String translator;		private String publisher;
	private Date publish_time;	private int stock;			private float price;
	public String getId() {	return id;	}
	public void setId(String id) {	this.id = id;	}
	public String getBookname() {return bookname;}
	public void setBookname(String name) {	this.bookname = name;	}
	public String getBooktype() {return booktype;	}
	public void setBooktype(String type) {this.booktype = type;}
	public String getAuthor() {return author;	}
	public void setAuthor(String author) {this.author = author;	}
	public String getTranslator() {return translator;	}
	public void setTranslator(String translator) {this.translator = translator;}
	public String getPublisher() {return publisher;}
	public void setPublisher(String publisher) {this.publisher = publisher;	}
	public Date getPublish_time() {return publish_time;	}
	public void setPublish_time(Date publish_time) {this.publish_time = publish_time;}
	public int getStock() {return stock;}
	public void setStock(int stock) {this.stock = stock;}
	public float getPrice() {return price;}
	public void setPrice(float price) {this.price = price;}
}
class Reader {
	private String id;			private String readername;	private String readertype;
	private String sex;			private int max_num;		private int days_num;
	public String getId() {	return id;	}
	public void setId(String id) {	this.id = id;	}
	public String getReadername() {	return readername;}
	public void setReadername(String name) {this.readername = name;}
	public String getReadertype() {return readertype;}
	public void setReadertype(String type) {	this.readertype = type;}
	public String getSex() {return sex;	}
	public void setSex(String sex) {this.sex = sex;	}
	public int getMax_num() {return max_num;}
	public void setMax_num(int max_num) {this.max_num = max_num;}
	public int getDays_num() {return days_num;}
	public void setDays_num(int days_num) {this.days_num = days_num;}
}
class BookSelect {
	// 按图书编号查询，查询结果保存在Book类的对象中
	public static Book SelectBookById(String id) {
		String sql = "select * from tb_book where id='" + id + "'";
		ResultSet rs = DbOp.executeQuery(sql);
		Book book = null;
		try {
			if (rs.next()) {
				book = new Book();
				book.setId(rs.getString("id"));
				book.setBooktype(rs.getString("booktype"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setTranslator(rs.getString("translator"));
				book.setPublisher(rs.getString("publisher"));
				book.setPublish_time(rs.getDate("publish_time"));
				book.setPrice(rs.getFloat("price"));
				book.setStock(rs.getInt("stock"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "无法正常读取数据库！");
		}
		return book;
	}
}
class ReaderSelect {
	// 按读者编号查询，结果保存在Reader类的对象中
	public static Reader selectReaderById(String id) {
		String sql = "select * from tb_reader where id='" + id + "'";
		ResultSet rs = DbOp.executeQuery(sql);
		Reader reader = null;
		try {
			if (rs.next()) {
				reader = new Reader();
				reader.setId(rs.getString("id"));
				reader.setReadername(rs.getString("readername"));
				reader.setReadertype(rs.getString("readertype"));
				reader.setSex(rs.getString("sex"));
				reader.setMax_num(rs.getInt("max_num"));
				reader.setDays_num(rs.getInt("days_num"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "无法正常读取数据库！");
		}
		return reader;
	}
}

class IfBorrowBack {
	// 查指定读者是否借过指定图书且未归还
	public static boolean findbook(String bookid, String readerid) {
		String sql;
		sql = "select * from tb_borrow where book_id='";
		sql = sql + bookid + "' and reader_id='" + readerid + "' and ";
		sql = sql + "if_back='否'";
		ResultSet rs = DbOp.executeQuery(sql);
		try {
			// 如果指定读者借阅了指定图书，且未归还，返回true，否则返回false
			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库查询失败！");
		}
		return true;
	}
}
class GlobalVar {
	// 该变量用来保存登录用户名
	public static String login_user;
}

/* ShowMain.java */
package chapter13.practice;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ShowMain extends JFrame {
	JMenuBar menuBar1;
	JMenu menu1, menu2, menu3, menu4, menu5, menu6, menu7;
	JMenuItem mi_book_add, mi_book_update, mi_book_delete, mi_reader_add,
			mi_reader_update, mi_reader_delete, mi_borrow, mi_back,
			mi_query_book, mi_query_reader, mi_update_pass, mi_exit;
	public void setRights(String rights) {
		// 如果不是管理员，则禁止用户维护图书信息和读者信息
		// 以及禁止进行借阅管理，即只能查询
		if (rights.equals("否")) {
			menu5.setEnabled(false);
		}
	}
	public ShowMain() {
		setTitle("图书管理系统");
		setLayout(new BorderLayout());
		setSize(400, 300);
		menuBar1 = new JMenuBar();
		menu5 = new JMenu("数据管理");				// 基础维护菜单
		menu6 = new JMenu("图书管理");				// 图书维护菜单
		mi_book_add = new JMenuItem("添加图书");		// 添加图书菜单
		mi_book_update = new JMenuItem("更新图书");		// 修改图书菜单
		mi_book_delete = new JMenuItem("删除图书");		// 删除图书菜单
		menu7 = new JMenu("读者管理");// 读者维护菜单
		mi_reader_add = new JMenuItem("添加读者");	// 添加读者菜单
		mi_reader_update = new JMenuItem("更新读者");
		mi_reader_delete = new JMenuItem("删除读者");
		menu1 = new JMenu("借阅管理");
		mi_borrow = new JMenuItem("借书管理");
		mi_back = new JMenuItem("还书管理");
		menu2 = new JMenu("查询管理");
		mi_query_book = new JMenuItem("图书查询");
		mi_query_reader = new JMenuItem("读者查询");
		menu3 = new JMenu("系统管理");
		mi_update_pass = new JMenuItem("修改密码");
		mi_exit = new JMenuItem("退出系统");
		// 添加图书菜单
		mi_book_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookOperate("添加图书");
			}
		});
		mi_book_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookOperate("更新图书");
			}
		});
		mi_book_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookOperate("删除图书");
			}
		});
		mi_reader_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderOperate("添加读者");
			}
		});
		mi_reader_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderOperate("更新读者");
			}
		});
		mi_reader_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderOperate("删除读者");
			}
		});
		mi_borrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Borrow();
			}
		});
		mi_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Back();
			}
		});
		mi_query_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookQuery();
			}
		});
		mi_query_reader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderQuery();
			}
		});
		mi_update_pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdatePassword();
			}
		});
		mi_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbOp.Close(); 				// 关闭数据库
				System.exit(0);
			}
		});
		/* 关闭窗口 */
		this.addWindowListener(new WindowAdapter() {
			// 重写windowClosing()方法
			public void windowClosing(WindowEvent e) {
				DbOp.Close(); 			// 关闭数据库
				System.exit(0);
			}
		});
		menu5.add(menu6);				menu6.add(mi_book_add);
		menu6.add(mi_book_update);		menu6.add(mi_book_delete);
		menu5.add(menu7);				menu7.add(mi_reader_add);
		menu7.add(mi_reader_update);	menu7.add(mi_reader_delete);
		menu5.add(menu1);				menu1.add(mi_borrow);
		menu1.add(mi_back);				menu5.add(menu2);
		menu2.add(mi_query_book);		menu2.add(mi_query_reader);
		menu5.add(menu3);				menu3.add(mi_update_pass);
		menu3.add(mi_exit);				menuBar1.add(menu5);
		menuBar1.add(menu1);			menuBar1.add(menu2);
		menuBar1.add(menu3);				
		setJMenuBar(menuBar1);
		setLocationRelativeTo(null); 		// 使窗体在屏幕上居中放置
		setVisible(true); 					// 使窗体可见
	}
	// 增加main()方法，主要为了调试程序界面
	public static void main(String[] args) {
		new ShowMain();
	}
}


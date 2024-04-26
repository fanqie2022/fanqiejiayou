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
	JLabel lbbookid = new JLabel("ͼ����");
	JLabel lbreaderid = new JLabel("���߱��");
	JTextField tf_bookid = new JTextField();	  
	JTextField tf_readerid = new JTextField();
	JButton queryBtn = new JButton("��ѯ");
	JLabel lbbookinfo = new JLabel(SepLine + "ͼ����Ϣ" + SepLine);
	JLabel lbbookname = new JLabel("ͼ�����ƣ�");
	JLabel tf_bookname = new JLabel("xx");
	JLabel lbauthor = new JLabel("���ߣ�");	
	JLabel tf_author = new JLabel("xx");
	JLabel lbpublisher = new JLabel("�����磺");
	JLabel tf_publisher = new JLabel("xx");
	JLabel lbpublish_time = new JLabel("����ʱ�䣺");
	JLabel tf_publish_time = new JLabel("xx");
	JLabel lbprice = new JLabel("���ۣ�");
	JLabel tf_price = new JLabel("xx");
	JLabel lbstock = new JLabel("���������");
	JLabel tf_stock = new JLabel("xx");
	JLabel lbreaderinfo = new JLabel(SepLine + "������Ϣ" + SepLine);
	JLabel lbreadername = new JLabel("����������");
	JLabel tf_readername = new JLabel("xx");
	JLabel lbreadertype = new JLabel("�������ͣ�");
	JLabel tf_readertype = new JLabel("xx");
	JLabel lbmax_num = new JLabel("���ɽ�����");
	JLabel tf_max_num = new JLabel("xx");
	JLabel lbdays_num = new JLabel("���ɽ�������");
	JLabel tf_days_num = new JLabel("xx");
	JLabel lbborrowinfo = new JLabel(SepLine + "������Ϣ" + SepLine);
	JLabel lbborrowednum = new JLabel("�ö����ѽ�ͼ��������");
	JLabel tf_borrowednum = new JLabel("xx");
	JLabel lbif_borrow = new JLabel("�ö����Ƿ�ɽ���ѡͼ�飺");
	JLabel tf_if_borrow = new JLabel("xx");
	JLabel lbborrow_date = new JLabel("�������ڣ�");
	JLabel tf_borrow_date = new JLabel("xx");
	JButton borrowBtn = new JButton("����");
	JButton closeBtn = new JButton("�ر�");
	public Borrow() {
		setLayout(null);
		setTitle("�������");
		setSize(500, 420);
		lbbookid.setBounds(30, 20, 50, 25);	 	// ͼ����
		tf_bookid.setBounds(90, 20, 90, 20);
		lbreaderid.setBounds(200, 20, 50, 25); 			// ���߱��
		tf_readerid.setBounds(260, 20, 90, 20);
		queryBtn.setBounds(370, 20, 80, 25); 			// ��ѯ��ť
		lbbookinfo.setBounds(30, 50, 440, 25); 		// ͼ����Ϣ��ʾ��
		lbbookname.setBounds(30, 80, 60, 25); 		// ͼ������
		tf_bookname.setBounds(90, 80, 200, 25);
		lbauthor.setBounds(310, 80, 60, 25); 			// ����
		tf_author.setBounds(370, 80, 90, 25);
		lbpublisher.setBounds(30, 105, 60, 25); 		// ������
		tf_publisher.setBounds(90, 105, 200, 25);
		lbpublish_time.setBounds(310, 105, 60, 25); 	// ����ʱ��
		tf_publish_time.setBounds(370, 105, 90, 25);
		lbprice.setBounds(30, 130, 60, 25); 			// ����
		tf_price.setBounds(90, 130, 200, 25);
		lbstock.setBounds(310, 130, 60, 25); 			// �������
		tf_stock.setBounds(370, 130, 90, 25);
		lbreaderinfo.setBounds(30, 160, 440, 25); 		// ������Ϣ��ʾ��
		lbreadername.setBounds(30, 185, 60, 25); 		// ��������
		tf_readername.setBounds(90, 185, 90, 25);
		lbreadertype.setBounds(310, 185, 60, 25); 		// ��������
		tf_readertype.setBounds(370, 185, 90, 25);
		lbmax_num.setBounds(30, 210, 75, 25); 		// ���ɽ���
		tf_max_num.setBounds(105, 210, 90, 25);
		lbdays_num.setBounds(310, 210, 85, 25); 		// ���ɽ�����
		tf_days_num.setBounds(395, 210, 70, 25);
		lbborrowinfo.setBounds(30, 240, 440, 25); 		// ������Ϣ��ʾ��
		lbborrowednum.setBounds(30, 265, 120, 25);	// �ѽ�ͼ������
		tf_borrowednum.setBounds(150, 265, 50, 25);
		lbif_borrow.setBounds(30, 290, 145, 25); 		// �Ƿ�ɽ�
		tf_if_borrow.setBounds(175, 290, 50, 25);
		lbborrow_date.setBounds(30, 315, 60, 25);		// ��������
		tf_borrow_date.setBounds(90, 315, 100, 25);
		borrowBtn.setBounds(160, 345, 80, 25);		// �����ť
		borrowBtn.setEnabled(false); 				// ��ʼʱ���ý����ť
		closeBtn.setBounds(260, 345, 80, 25);			// �رհ�ť
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
				dispose(); 						// �رմ���
			}
		});
		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				dispose(); // �رմ���
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
		setLocationRelativeTo(null); 		// ʹ��������Ļ�Ͼ��з���
		setVisible(true); 					// ʹ����ɼ�
		c.setBackground(Color.white);
		c.add(tf_bookid);		c.add(tf_readerid);		c.add(tf_bookname);
		c.add(tf_author);		c.add(tf_publisher);		c.add(tf_publish_time);
		c.add(tf_price);			c.add(tf_stock);			c.add(tf_readername);
		c.add(tf_readertype);		c.add(tf_max_num);		c.add(tf_days_num);
		c.add(tf_borrowednum);	c.add(tf_if_borrow);		c.add(tf_borrow_date);
	}
	// ͼ��Ͷ��߲�ѯ
	private void btn_querywActionPerformed(ActionEvent e) {
		String bookid = tf_bookid.getText();
		String readerid = tf_readerid.getText();
		// ���ͼ���Ż���߱�����߾�Ϊ�գ�������һ��Ϊ�գ��򷵻�
		if (bookid.equals("") || readerid.equals("")) {
		JOptionPane.showMessageDialog(null, "ͼ���źͶ��߱�ž�����Ϊ�գ�");
			init(); // ���³�ʼ������������ֹ�����ť
			return;
		}
		// ����Ų�ѯͼ�飬�������book������
		Book book = BookSelect.SelectBookById(bookid);
		// �����ѯ�������������ʾ�ڸ��ı�����
		if (book != null) {
			tf_bookname.setText(book.getBookname());
			tf_author.setText(book.getAuthor());
			tf_publisher.setText(book.getPublisher());
			tf_publish_time.setText(book.getPublish_time().toString());
			tf_price.setText(String.valueOf((book.getPrice())));
			tf_stock.setText(String.valueOf(book.getStock()));
		} else {
			JOptionPane.showMessageDialog(null, "ͼ�������󣬲��޴��飡");
			init(); // ���³�ʼ������������ֹ�����ť
			return;
		}
		if (book.getStock() == 0) {
			JOptionPane.showMessageDialog(null, "ͼ�����޿�棬�޷����ģ�");
			init(); // ���³�ʼ������������ֹ�����ť
			return;
		}
		// ����Ų�ѯ���ߣ��������reader������
		Reader reader = ReaderSelect.selectReaderById(readerid);
		// �����ѯ�������������ʾ�ڸ��ı�����
		if (reader != null) {
			tf_readername.setText(reader.getReadername());
			tf_readertype.setText(reader.getReadertype());
			tf_max_num.setText(String.valueOf(reader.getMax_num()));
			tf_days_num.setText(String.valueOf(reader.getDays_num()));
		} else {
			JOptionPane.showMessageDialog(null, "���߱�����󣬲��޴��ˣ�");
			init(); // ���³�ʼ������������ֹ�����ť
			return;
		}
		// ��ѯָ�������Ƿ��ѽ��ָ��ͼ����δ�黹
		if (IfBorrowBack.findbook(bookid, readerid)) {
		JOptionPane.showMessageDialog(null, "�ö����ѽ�����ѡͼ�飬��δ�黹��");
			init(); // ���³�ʼ������������ֹ�����ť
			return;
		}
		// ͳ�ƶ�������ͼ������
		int borrowednum = statborrowednum(readerid);
		tf_borrowednum.setText(String.valueOf(borrowednum));
		// ��������ѽ�ͼ����δ�������������������������������������ѡͼ��
		if (borrowednum < reader.getMax_num()) {
			tf_if_borrow.setText("��");
			// ����һ�������ڸ�ʽ����ע�⣺MMһ��Ҫ�ô�д
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// �������ڱ�����������Ϊ��ǰ����
			Date currentdate = new Date();
			// �����ڰ�ָ����ʽ���
			String borrowdate = sdf.format(currentdate);
			tf_borrow_date.setText(borrowdate);
			borrowBtn.setEnabled(true); // ʹ�����ť��Ч
		} else {
		JOptionPane.showMessageDialog(null, "�ö��߽�����࣬�޷��������ģ�");
			init(); // ���³�ʼ������������ֹ�����ť
			return;
		}
	}
	// ��д���ͼ���¼
	private void btn_borrowActionPerformed(ActionEvent e) {
		String sql;
		String bookid = tf_bookid.getText();
		String readerid = tf_readerid.getText();
		String borrowdate = tf_borrow_date.getText();
		// Ϊborrow�����ӽ����¼
		sql = "insert into tb_borrow (book_id,reader_id,"
				+ "borrow_date,if_back) values('" + bookid + "','" + readerid
				+ "','" + borrowdate + "','��')";
		DbOp.executeUpdate(sql);
		// ���ö�������ͼ��������1
		int iborrowednum = Integer.parseInt(tf_borrowednum.getText()) + 1;
		String cborrowednum = String.valueOf(iborrowednum);
		tf_borrowednum.setText(cborrowednum);
		// ��ͼ����������1
		int istock = Integer.parseInt(tf_stock.getText()) - 1;
		String cstock = String.valueOf(istock);
		// ���»����е�ͼ��������
		tf_stock.setText(cstock);
		// �������ݿ��е�ͼ��������
		sql = "update tb_book set stock='" + cstock;
		sql = sql + "' where id='" + bookid + "'";
		DbOp.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "����ɹ���");
		init(); // ���³�ʼ������������ֹ�����ť
	}
	// ͳ��ĳ�����ߵ�ǰ�ѽ�ͼ����δ�黹������
	private int statborrowednum(String readerid) {
		int borrowednum = 0;
		String reader_id, if_back;
		// ��ȡ���ݿ��м�¼
		String sql = "select * from tb_borrow";
		ResultSet rs = DbOp.executeQuery(sql);
		// ִ�в�ѯͳ�Ʋ���
		try {
			while (rs.next()) {
				reader_id = rs.getString("reader_id");
				if_back = rs.getString("if_back");
				if (reader_id.equals(readerid) && if_back.equals("��")) {
					borrowednum++;
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݿ�ͳ��ʧ�ܣ�");
		}
		return borrowednum;
	}
	// ��ʼ�����������ֹ�����ť
	private void init() {
		tf_bookname.setText("xx");		tf_author.setText("xx");
		tf_publisher.setText("xx");		tf_publish_time.setText("xx");
		tf_price.setText("xx");			tf_stock.setText("xx");
		tf_readername.setText("xx");		tf_readertype.setText("xx");
		tf_max_num.setText("xx");		tf_days_num.setText("xx");
		tf_borrowednum.setText("xx");	tf_if_borrow.setText("xx");
		tf_borrow_date.setText("xx");
		borrowBtn.setEnabled(false); 		// ��ֹ�����ť
	}
	// ����main()��������ҪΪ�˵��Գ������
	public static void main(String[] args) {
		new Borrow();
	}
}



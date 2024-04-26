/* Back.java */
package chapter13.practice;
import java.awt.*;				
import java.awt.event.*;
import java.text.SimpleDateFormat;	
import java.util.Date;
import javax.swing.*;		
public class Back extends JFrame {
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
	JLabel lbprice = new JLabel("���ۣ�");			JLabel tf_price = new JLabel("xx");
	JLabel lbstock = new JLabel("���������");		JLabel tf_stock = new JLabel("xx");
	JLabel lbreaderinfo = new JLabel(SepLine + "������Ϣ" + SepLine);
	JLabel lbreadername = new JLabel("����������");
	JLabel tf_readername = new JLabel("xx");
	JLabel lbreadertype = new JLabel("�������ͣ�");
	JLabel tf_readertype = new JLabel("xx");
	JLabel lbmax_num = new JLabel("���ɽ�����");
	JLabel tf_max_num = new JLabel("xx");
	JLabel lbdays_num = new JLabel("���ɽ�������");
	JLabel tf_days_num = new JLabel("xx");
	JLabel lbbackinfo = new JLabel(SepLine + "������Ϣ" + SepLine);
	JLabel lbback_date = new JLabel("�������ڣ�");
	JLabel tf_back_date = new JLabel("xx");
	JButton backBtn = new JButton("����");
	JButton closeBtn = new JButton("�ر�");
	public Back() {
		setLayout(null);
		setTitle("�������");
		setSize(500, 350);
		this.setForeground(Color.BLACK); 		// ����ǰ��ɫΪ��ɫ
		lbbookid.setBounds(30, 40, 50, 20);		// ͼ����
		tf_bookid.setBounds(90, 40, 90, 20);
		lbreaderid.setBounds(200, 40, 50, 20);		// ���߱��
		tf_readerid.setBounds(260, 40, 90, 20);
		queryBtn.setBounds(370, 40, 80, 20); 		// ��ѯ��ť
		lbbookinfo.setBounds(30, 70, 440, 20); 	// ͼ����Ϣ��ʾ��
		lbbookname.setBounds(30, 90, 60, 20); 	// ͼ������
		tf_bookname.setBounds(90, 90, 200, 20);
		lbauthor.setBounds(310, 90, 60, 20); 		// ����
		tf_author.setBounds(370, 90, 90, 20);
		lbpublisher.setBounds(30, 110, 60, 20);		// ������
		tf_publisher.setBounds(90, 110, 200, 20);
		lbpublish_time.setBounds(310, 110, 60, 20);	// ����ʱ��
		tf_publish_time.setBounds(370, 110, 90, 20);
		lbprice.setBounds(30, 130, 60, 20); 		// ����
		tf_price.setBounds(90, 130, 200, 20);
		lbstock.setBounds(310, 130, 60, 20); 		// �������
		tf_stock.setBounds(370, 130, 90, 20);
		lbreaderinfo.setBounds(30, 150, 440, 20); 	// ������Ϣ��ʾ��
		lbreadername.setBounds(30, 170, 60, 20); 	// ��������
		tf_readername.setBounds(90, 170, 90, 20);
		lbreadertype.setBounds(310, 170, 60, 20); 	// ��������
		tf_readertype.setBounds(370, 170, 90, 20);
		lbmax_num.setBounds(30, 190, 75, 20); 	// ���ɽ���
		tf_max_num.setBounds(105, 190, 90, 20);
		lbdays_num.setBounds(310, 190, 85, 20); 	// ���ɽ�����
		tf_days_num.setBounds(395, 190, 70, 20);
		lbbackinfo.setBounds(30, 210, 440, 20); 	// ������Ϣ��ʾ��
		lbback_date.setBounds(30, 230, 60, 20);	// ��������
		tf_back_date.setBounds(90, 230, 100, 20);
		backBtn.setBounds(160, 260, 80, 25);		// ���鰴ť
		backBtn.setEnabled(false); 				// ��ʼʱ���û��鰴ť
		closeBtn.setBounds(260, 260, 80, 25);		// �رհ�ť
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_querywActionPerformed(e);
			}
		});
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_backActionPerformed(e);
			}
		});
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setForeground(Color.BLACK); // ����ǰ��ɫΪ��ɫ
				dispose(); // �رմ���
			}
		});
		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				setForeground(Color.BLACK); // ����ǰ��ɫΪ��ɫ
				dispose(); // �رմ���
			}
		});
		Container c = getContentPane();
		c.add(lbbookid);		c.add(lbreaderid);		c.add(queryBtn);
		c.add(lbbookinfo);	c.add(lbbookname);		c.add(lbauthor);
		c.add(lbpublisher);	c.add(lbpublish_time);	c.add(lbprice);
		c.add(lbstock);		c.add(lbreaderinfo);		c.add(lbreadername);
		c.add(lbreadertype);	c.add(lbmax_num);		c.add(lbdays_num);
		c.add(lbbackinfo);	c.add(lbback_date);		c.add(backBtn);
		c.add(closeBtn);
		setLocationRelativeTo(null); 	// ʹ��������Ļ�Ͼ��з���
		setVisible(true); 				// ʹ����ɼ�
		c.setBackground(Color.white); 		// ����ǰ��ɫΪ��ɫ
		c.add(tf_bookid);	c.add(tf_readerid);		c.add(tf_bookname);
		c.add(tf_author);	c.add(tf_publisher);		c.add(tf_publish_time);
		c.add(tf_price);		c.add(tf_stock);			c.add(tf_readername);
		c.add(tf_readertype);	c.add(tf_max_num);		c.add(tf_days_num);
		c.add(tf_back_date);
	}
	// ͼ��Ͷ��߲�ѯ
	private void btn_querywActionPerformed(ActionEvent e) {
		String bookid = tf_bookid.getText();
		String readerid = tf_readerid.getText();
		// ���ͼ���Ż���߱�����߾�Ϊ�գ�������һ��Ϊ�գ��򷵻�
		if (bookid.equals("") || readerid.equals("")) {
		JOptionPane.showMessageDialog(null, "ͼ���źͶ��߱�ž�����Ϊ�գ�");
			init(); // ���³�ʼ������������ֹ���鰴ť
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
			init(); // ���³�ʼ������������ֹ���鰴ť
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
			init(); // ���³�ʼ������������ֹ���鰴ť
			return;
		}
		// ��ѯָ�������Ƿ���Ĺ�ָ��ͼ�飬��δ�黹
		if (!IfBorrowBack.findbook(bookid,readerid)){
			JOptionPane.showMessageDialog(null, "�ö���û�н������ͼ�飡");
			init(); // ���³�ʼ������������ֹ���鰴ť
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// �������ڱ�����������Ϊ��ǰ����
		Date currentdate = new Date();
		// �����ڰ�ָ����ʽ���
		String borrowdate = sdf.format(currentdate);
		tf_back_date.setText(borrowdate);
		backBtn.setEnabled(true); // ʹ���鰴ť��Ч
	}
	// ��д�����¼
	private void btn_backActionPerformed(ActionEvent e) {
		String sql;
		String bookid = tf_bookid.getText();
		String readerid = tf_readerid.getText();
		String backdate = tf_back_date.getText();
		// ����borrow���¼
		sql = "update tb_borrow set if_back='��',back_date='";
		sql = sql + backdate + "' where ";
		sql = sql + " book_id='" + bookid + "' and ";
		sql = sql + "reader_id='" + readerid + "' and ";
		sql = sql + "if_back='��'";
		DbOp.executeUpdate(sql);
		// ��ͼ����������1
		int istock = Integer.parseInt(tf_stock.getText()) + 1;
		String cstock = String.valueOf(istock);
		// ���»����е�ͼ��������
		tf_stock.setText(cstock);
		// �������ݿ��е�ͼ��������
		sql = "update tb_book set stock='" + cstock;
		sql = sql + "' where id='" + bookid + "'";
		DbOp.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "����ɹ���");
		init(); // ���³�ʼ������������ֹ���鰴ť
	}
	// ��ʼ�����������ֹ���鰴ť
	private void init() {
		tf_bookname.setText("xx");		tf_author.setText("xx");
		tf_publisher.setText("xx");		tf_publish_time.setText("xx");
		tf_price.setText("xx");			tf_stock.setText("xx");
		tf_readername.setText("xx");		tf_readertype.setText("xx");
		tf_max_num.setText("xx");		tf_days_num.setText("xx");
		tf_back_date.setText("xx");
		backBtn.setEnabled(false); 		// ��ֹ���鰴ť
	}
	// ����main()��������ҪΪ�˵��Գ������
	public static void main(String[] args) {
		new Back();
	}
}


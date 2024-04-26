/* BookOperate.java */
package chapter13.practice;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import javax.swing.*;
public class BookOperate extends JFrame {
	JLabel lbbookid_1 = new JLabel("ͼ����");
	JLabel lbbookid = new JLabel("ͼ����");
	JLabel lbbookname = new JLabel("ͼ������");
	JLabel lbbooktype = new JLabel("ͼ�����");
	JLabel lbauthor = new JLabel("����"); 	
	JLabel lbtranslator = new JLabel("����");
	JLabel lbpublisher = new JLabel("������");
	JLabel lbpublish_time = new JLabel("����ʱ��");
	JLabel lbprice = new JLabel("����");		
	JLabel lbstock = new JLabel("�������");
	JButton btn = new JButton(); 
	JButton closeBtn = new JButton("�ر�");
	JButton queryBtn = new JButton("��ѯ");	
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
		
		if (title == "ɾ��ͼ��") {
			tf_bookid.setEditable(false);
			btn.setText("ɾ��");
		}
		else if ( title == "����ͼ��") {
			tf_bookid.setEditable(false);
			btn.setText("����");
		}
		else if (title == "���ͼ��") {
			lbbookid_1.setVisible(false);
			tf_bookid1.setVisible(false);
			queryBtn.setVisible(false);
			btn.setText("����");
		}
		
		lbbookid_1.setBounds(80, 20, 50, 20);// ͼ����
		tf_bookid1.setBounds(140, 20, 100, 20);
		queryBtn.setBounds(260, 20, 80, 20); // ��ѯ��ť
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		lbbookid.setBounds(30, 60, 50, 20); // ͼ����
		tf_bookid.setBounds(90, 60, 100, 20);
		lbbookname.setBounds(220, 60, 50, 20); // ͼ������
		tf_bookname.setBounds(280, 60, 100, 20);
		lbbooktype.setBounds(30, 90, 50, 20); // ͼ�����
		tf_booktype.setBounds(90, 90, 100, 20);
		tf_booktype.addItem("�Ƽ�");
		tf_booktype.addItem("��ѧ");
		tf_booktype.addItem("���");
		tf_booktype.addItem("����");
		lbauthor.setBounds(220, 90, 50, 20); // ����
		tf_author.setBounds(280, 90, 100, 20);
		lbtranslator.setBounds(30, 120, 50, 20); // ����
		tf_translator.setBounds(90, 120, 100, 20);
		lbpublisher.setBounds(220, 120, 50, 20); 	// ������
		tf_publisher.setBounds(280, 120, 100, 20);
		lbpublish_time.setBounds(30, 150, 50, 20); 	// ����ʱ��
		tf_publish_time.setBounds(90, 150, 100, 20);
		lbprice.setBounds(220, 150, 50, 20); // �۸�
		tf_price.setBounds(280, 150, 100, 20);
		lbstock.setBounds(30, 180, 50, 20);		// �������
		tf_stock.setBounds(90, 180, 100, 20);
		btn.setBounds(100,220, 80, 25); 		// ɾ����ť
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (title == "ɾ��ͼ��")
					btn_delActionPerformed(e);
				else if (title == "���ͼ��" || title == "����ͼ��") {
					btn_saveActionPerformed(e);
				}			
			}
		});
		closeBtn.setBounds(250, 220, 80, 25); 		// �رհ�ť
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 					// �ͷŵ�ǰ����
			}
		});
		/* �رմ��� */
		addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				dispose(); 					// �ͷŵ�ǰ����
			}
		});
		Container c = getContentPane();
		c.add(lbbookid); 						// ����������ӵ�������
		c.add(lbbookid_1);		c.add(lbbookname);		c.add(lbbooktype);
		c.add(lbauthor);		c.add(lbtranslator);	c.add(lbpublisher);
		c.add(lbpublish_time);	c.add(lbprice);			c.add(lbstock);
		c.add(btn);			c.add(closeBtn);		c.add(queryBtn);
		c.add(tf_bookid);		c.add(tf_bookname);		c.add(tf_author);
		c.add(tf_translator);	c.add(tf_publisher);	c.add(tf_publish_time);
		c.add(tf_price);		c.add(tf_stock);		c.add(tf_bookid1);
		c.add(tf_booktype);
		setLocationRelativeTo(null); 			// ʹ��������Ļ�Ͼ��з���
		setVisible(true); 						// ʹ����ɼ�
	}
	private void btn_delActionPerformed(ActionEvent e) {
		String id = tf_bookid.getText();
		// ���ͼ����Ϊ�գ���ɾ��������ֹ
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "ͼ���Ų���Ϊ�գ�");
			return;
		}
		String sql = "delete from tb_book where id='" + id + "'";
		int i = DbOp.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "ͼ����Ϣɾ���ɹ�!");
			// ���ȫ���ı���
			clearAllTextfield();
		} else
			JOptionPane.showMessageDialog(null, "ͼ����Ϣɾ��ʧ�ܣ�");
	}
	private void btn_queryActionPerformed(ActionEvent e) {
		String id = tf_bookid1.getText();
		// ���ͼ����Ϊ�գ����ѯ������ֹ
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "ͼ���Ų���Ϊ�գ�");
			return;
		}
		// ����Ų�ѯͼ�飬�������book������
		Book book = BookSelect.SelectBookById(id);
		// �����ѯ�������������ʾ�ڸ��ı�����
		if (book != null) {
			tf_bookid.setText(book.getId());
			tf_bookid.setEditable(false);
			tf_bookname.setText(book.getBookname());
			// ��Choice��ѡ��������Ϊ�����Ƶ���ָ���ַ�������
			tf_booktype.setSelectedItem(book.getBooktype());
			tf_author.setText(book.getAuthor());
			tf_translator.setText(book.getTranslator());
			tf_publisher.setText(book.getPublisher());
			tf_publish_time.setText(book.getPublish_time().toString());
			tf_price.setText(String.valueOf((book.getPrice())));
			tf_stock.setText(String.valueOf(book.getStock()));
		} else
			JOptionPane.showMessageDialog(null, "ͼ�������󣬲��޴��飡");
	}
	// ������ӻ���µļ�¼
	private void btn_saveActionPerformed(ActionEvent e) {
		String id = tf_bookid.getText();
		String bookname = tf_bookname.getText();
		String booktype = tf_booktype.getSelectedItem().toString();
		String author = tf_author.getText();
		String translator = tf_translator.getText();
		String publisher = tf_publisher.getText();
		String publish_time = tf_publish_time.getText();
		// ���ͼ����Ϊ�գ�����ֹ�����¼����
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "ͼ���Ų���Ϊ�գ�");
			return;
		}
		if (title == "���ͼ��" & IfBookIdExit(id)) {
			JOptionPane.showMessageDialog(null, "ͼ�����ظ���");
			return;
		}
		try {
			// -------------------------------------------------
			// ���³������ڼ�������Ƿ���Ч�����������Ч�����
			// ����ParseException�쳣
			// ����һ�������ڸ�ʽ����ע�⣺MMһ��Ҫ�ô�д
			// �����û��������ڵĸ�ʽ����-�£���2010-7��2009-10��
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			// ���ַ���ת��Ϊ����
			sdf.parse(tf_publish_time.getText());
			// -------------------------------------------------
			float price = Float.parseFloat(tf_price.getText());
			int stock = Integer.parseInt(tf_stock.getText());
			// ����¼���浽tb_book����
			String sql = "";
			if (title == "���ͼ��") {
				sql = "insert into tb_book values('" + id
					+ "','" + bookname + "','" + booktype + "','" + author
					+ "','" + translator + "','" + publisher + "','"
					+ publish_time + "','" + price + "','" + stock + "')";
			} if (title == "����ͼ��") {
				sql = "update tb_book set bookname='" + bookname
					+ "',booktype='" + booktype + "',author='" + author
					+ "',translator='" + translator + "',publisher='"
					+ publisher + "',publish_time='" + publish_time
					+ "',price='" + price + "',stock='" + stock
					+ "' where id='" + id + "'";
			}
			int i = DbOp.executeUpdate(sql);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "ͼ����Ϣ����ɹ���");
				// ���ȫ���ı���
				clearAllTextfield();
			} else
			JOptionPane.showMessageDialog(null, "��������ͼ����Ϣ����ʧ�ܣ�");
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "����ʱ���ʽ������-��-�գ���");
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "�۸������������ӦΪ���֣�");
		}
	}
	// �ж�Book�����Ƿ����ָ����ŵ�ͼ�飬������ڣ�����true�����򣬷���false
	private boolean IfBookIdExit(String id) {
		String sql = "select * from tb_book where id='" + id + "'";
		ResultSet rs = DbOp.executeQuery(sql);
		try {
			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�޷�������ȡ���ݿ⣡");
		}
		return false;
	}
	// ���ȫ���ı���
	private void clearAllTextfield() {
		tf_bookid1.setText("");	tf_bookid.setText("");		tf_bookname.setText("");
		tf_author.setText("");	tf_translator.setText("");		tf_publisher.setText("");
		tf_publish_time.setText("");	tf_price.setText("");	tf_stock.setText("");
	}
	// ����main()��������ҪΪ�˵��Գ������
	public static void main(String[] args) {
		new BookOperate("���ͼ��");
	}
}


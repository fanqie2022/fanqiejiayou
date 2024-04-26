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
	JLabel lbbookname = new JLabel("ͼ������");
	JLabel lbauthor = new JLabel("��        ��");
	JLabel lbpublisher = new JLabel("��  ��  ��");
	JLabel lbpublish_time = new JLabel("����ʱ��");
	JLabel lbnotes = new JLabel("����-��-�գ�");
	JTextField tf_bookname = new JTextField("");
	JTextField tf_author = new JTextField("");
	JTextField tf_publisher = new JTextField("");
	JTextField tf_publish_time = new JTextField("");
	JButton queryBtn = new JButton("��ѯ");
	JButton closeBtn = new JButton("�ر�");
	JTable table;// ������table
	DefaultTableModel model;// ����DefaultTableModel�����model

	// ���췽��
	public BookQuery() {
		setTitle("ͼ���ѯ"); 					// ���ô������
		setSize(800, 500);			 			// ���ô���ߴ�
		setLayout(null); 						// ȡ�����岼��
		lbbookname.setBounds(170, 20, 50, 20); 	// ����
		tf_bookname.setBounds(230, 20, 160, 20);
		lbauthor.setBounds(410, 20, 50, 20); 		// ����
		tf_author.setBounds(470, 20, 160, 20);
		lbpublisher.setBounds(170, 50, 50, 20); 	// ������
		tf_publisher.setBounds(230, 50, 160, 20);
		lbpublish_time.setBounds(410, 40, 50, 20); 	// ����ʱ��
		lbnotes.setBounds(400, 60, 70, 20);
		tf_publish_time.setBounds(470, 50, 160, 20);
		queryBtn.setBounds(300, 90, 80, 25); 		// ��ѯ��ť
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		closeBtn.setBounds(420, 90, 80, 25);// �رհ�ť
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 			// �ͷŵ�ǰ����
			}
		});
		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				dispose(); 			// �ͷŵ�ǰ����
			}
		});
		String[] heads = { "ͼ����", "ͼ������", "ͼ�����", "����", "����",
				 "������", "��������", "����",	"�������" };
		
		// ����DefaultTableModel�����model
		model = new DefaultTableModel(heads, 0);
		// ����JTable�����table����ʹ��model����table����
		table = new JTable(model);
		// ����JScrollPane�����scrollPane��
		// ��table��ӵ�scrollPane��
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 140, 760, 300);
		Container c = getContentPane();
		c.add(lbbookname); 	// ���������ӵ�������
		c.add(tf_bookname);		c.add(lbauthor);			c.add(tf_author);
		c.add(lbpublisher);		c.add(tf_publisher);		c.add(lbpublish_time);
		c.add(lbnotes);			c.add(tf_publish_time);		c.add(queryBtn);
		c.add(closeBtn);		c.add(scrollPane);
		setLocationRelativeTo(null); 	// ʹ��������Ļ�Ͼ��з���
		setVisible(true); 				// ʹ����ɼ�
	}
	private void btn_queryActionPerformed(ActionEvent e) {
		// ��ձ��Ͳ�ѯ�ı���
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
			// ����һ��������SQL��䣬��ʾѡ������ȫ����¼
			sql = "select * from tb_book ";
			// ����������գ�����sql1�־�
			if (bookname.equals(""))
				sql1 = "";
			else
				sql1 = " bookname like '" + bookname + "%' ";
			// ������߲��գ�����sql2�־�
			if (author.equals(""))
				sql2 = "";
			else {
				sql2 = " author like '" + author + "%' ";
				if (!bookname.equals("")) // ���������Ϊ��
					sql2 = " and " + sql2;
			}
			// ��������粻�գ�����sql3�־�
			if (publisher.equals(""))
				sql3 = "";
			else {
				sql3 = "publisher like '" + publisher + "%' ";
				// ���������������һ�Ϊ��
				if (!(bookname.equals("") && author.equals("")))
					sql3 = " and " + sql3;
			}
			// ����������ڲ��գ�����sql4�־�
			if (publishtime.equals("")) {
				sql4 = "";
			} else {
				// ����һ�������ڸ�ʽ����ע�⣺MMһ��Ҫ�ô�д
				// �����û��������ڵĸ�ʽ����-�£���2010-7��2009-10��
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				// ����һ��Calendar����
				Calendar cal = new GregorianCalendar();
				// ���ַ���ת��Ϊ����
				Date pubtime = sdf.parse(tf_publish_time.getText());
				// ʹ�ø�����������cal��ʱ��
				cal.setTime(pubtime);
				// ��ȡ��
				pubyear = String.valueOf(cal.get(Calendar.YEAR));
				// ��ȡ��
				pubmonth = String.valueOf(cal.get(Calendar.MONTH) + 1);
				sql4 = " year(publish_time)=" + pubyear + " and ";
				sql4 = sql4 + "month(publish_time)=" + pubmonth;
				// ������������߻��������һ�Ϊ��
				if (!(bookname.equals("") && author.equals("") && publisher
						.equals("")))
					sql4 = " and " + sql4;
			}
			sql5 = sql1 + sql2 + sql3 + sql4;
			// �������������һ�����������޸�SQL���
			if (!sql5.equals("")) {
				sql = sql + " where " + sql5;
			}
			// ִ�в�ѯ
			ResultSet rs = DbOp.executeQuery(sql);
			while (rs.next()) { 
				String[] bookInfo = { rs.getString("id"), rs.getString("bookname"), 
						rs.getString("booktype"), rs.getString("author"), 
						rs.getString("translator"), rs.getString("publisher"), 
						rs.getString("publish_time"), rs.getString("price"), 
						rs.getString("stock")};
				model.addRow(bookInfo);// ����Ϣ��ӵ�model��
			}
			
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, "����ʱ���ʽ������-��-�գ���");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "���ݿⲻ���ڣ�����ڴ���");
		}
	}
	// ����main()��������ҪΪ�˵��Գ������
	public static void main(String[] args) {
		new BookQuery();
	}
}


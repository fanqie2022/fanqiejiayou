/* ReaderQuery.java */
package chapter13.practice;
import java.awt.*;	
import java.awt.event.*;
import java.sql.*;		
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ReaderQuery extends JFrame {
	JLabel lbreadername = new JLabel("��������");
	JLabel lbreadertype = new JLabel("�������");
	JTextField tf_readername = new JTextField("");
	JTextField tf_readertype = new JTextField("");
	JButton queryBtn = new JButton("��ѯ");
	JButton closeBtn = new JButton("�ر�");
	JTable table;// ������table
	DefaultTableModel model;// ����DefaultTableModel�����model
	// ���췽��
	public ReaderQuery() {
		setTitle("���߲�ѯ"); 					// ���ô������
		setSize(600, 500);	 					// ���ô���ߴ�
		setLayout(null); 						// ȡ�����岼��
		lbreadername.setBounds(70, 20, 50, 20); 	// ��������
		tf_readername.setBounds(130, 20, 160, 20);
		lbreadertype.setBounds(310, 20, 50, 20); 	// �������
		tf_readertype.setBounds(370, 20, 160, 20);
		queryBtn.setBounds(200, 60, 80, 25); // ��ѯ��ť
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		closeBtn.setBounds(320, 60, 80, 25); // �رհ�ť
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
		
		String[] heads = { "���߱��", "��������", "��������", "�����Ա�",
				 "���ɽ���", "�ɽ�����" };
		
		// ����DefaultTableModel�����model
		model = new DefaultTableModel(heads, 0);
		// ����JTable�����table����ʹ��model����table����
		table = new JTable(model);
		// ����JScrollPane�����scrollPane����table��ӵ�scrollPane��
		JScrollPane scrollPane = new JScrollPane(table);
		// ����JScrollPane��λ�úͳߴ�
		scrollPane.setBounds(10, 120, 560, 300);
		Container c = getContentPane();
		c.add(scrollPane);
		
		c.add(lbreadername); 			// ���������ӵ�������
		c.add(tf_readername);		c.add(lbreadertype);
		c.add(tf_readertype);		c.add(queryBtn);
		c.add(closeBtn);
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
			String readername, readertype;
			String sql, sql1, sql2, sql3;
			readername = tf_readername.getText();
			readertype = tf_readertype.getText();
			// ����һ��������SQL��䣬��ʾѡ������ȫ����¼
			sql = "select * from tb_reader ";
			// ��������������գ�����sql1�־�
			if (readername.equals(""))
				sql1 = "";
			else
				sql1 = " readername like '" + readername + "%' ";
			// ������߲��գ�����sql2�־�
			if (readertype.equals(""))
				sql2 = "";
			else {
				sql2 = " readertype like '" + readertype + "%' ";
				if (!readername.equals("")) // ���������Ϊ��
					sql2 = " and " + sql2;
			}
			sql3 = sql1 + sql2;
			// �������������һ�����������޸�SQL���
			if (!sql3.equals("")) {
				sql = sql + " where " + sql3;
			}
			// ִ�в�ѯ
			ResultSet rs = DbOp.executeQuery(sql);
			while (rs.next()) {
				String[] readerInfo = { rs.getString("id"), rs.getString("readername"), 
						rs.getString("readertype"), rs.getString("sex"), 
						rs.getString("max_num"), rs.getString("days_num")};

				model.addRow(readerInfo);// ����Ϣ��ӵ�model��
			}
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "���ݿⲻ���ڣ�����ڴ���");
		}
	}
	// ����main()��������ҪΪ�˵��Գ������
	public static void main(String[] args) {
		new ReaderQuery();
	}
}


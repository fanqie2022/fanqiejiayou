/* ReaderOperate.java */
package chapter13.practice;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class ReaderOperate extends JFrame {
	JLabel lbreaderid = new JLabel("���߱��");
	JLabel lbreaderid_1 = new JLabel("���߱��");
	JLabel lbreadername = new JLabel("��������");
	JLabel lbreadertype = new JLabel("�������");
	JLabel lbsex = new JLabel("�Ա�");
	JLabel lbmax_num = new JLabel("�ɽ�����");
	JLabel lbdays_num = new JLabel("�ɽ�����");
	JTextField tf_readerid = new JTextField();
	JTextField tf_readername = new JTextField();	
	JTextField tf_max_num = new JTextField();
	JTextField tf_days_num = new JTextField();	
	JTextField tf_readerid1 = new JTextField();
	JComboBox<String> tf_readertype = new JComboBox<String>();		
	JComboBox<String> tf_sex = new JComboBox<String>();
	JButton queryBtn = new JButton("��ѯ");	
	JButton btn = new JButton();
	JButton closeBtn = new JButton("�ر�");	
	String title;
	public ReaderOperate(String title) {
		setLayout(null);
		setTitle(title);
		setSize(430, 240);
		this.title = title;
		
		if (title == "ɾ������") {
			tf_readerid.setEditable(false);
			btn.setText("ɾ��");
		}
		else if ( title == "���¶���") {
			tf_readerid.setEditable(false);
			btn.setText("����");
		}
		else if (title == "��Ӷ���") {
			lbreaderid_1.setVisible(false);
			tf_readerid1.setVisible(false);
			queryBtn.setVisible(false);
			btn.setText("����");
		}
		
		lbreaderid_1.setBounds(80, 20, 50, 20); 	// ���߱��
		tf_readerid1.setBounds(140, 20, 100, 20);
		queryBtn.setBounds(270, 20, 80, 20); 		// ��ѯ��ť
		queryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		lbreaderid.setBounds(30, 60, 50, 20); 		// ���߱��
		tf_readerid.setBounds(90, 60, 100, 20);
		lbreadername.setBounds(220, 60, 50, 20); 	// ��������
		tf_readername.setBounds(280, 60, 100, 20);
		lbreadertype.setBounds(30, 90, 50, 20); 	// �������
		tf_readertype.setBounds(90, 90, 100, 20);
		tf_readertype.addItem("��ʦ");
		tf_readertype.addItem("ѧ��");
		tf_readertype.addItem("ְ��");
		lbsex.setBounds(220, 90, 50, 20); 		// �Ա�
		tf_sex.setBounds(280, 90, 100, 20);
		tf_sex.addItem("��");
		tf_sex.addItem("Ů");
		lbmax_num.setBounds(30, 120, 50, 20); 	// ���ɽ���
		tf_max_num.setBounds(90, 120, 100, 20);
		lbdays_num.setBounds(220, 120, 50, 20); 	// ���ɽ�����
		tf_days_num.setBounds(280, 120, 100, 20);
		btn.setBounds(100, 160, 80, 25); 		// ɾ����ť
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (title == "ɾ������")
					btn_delActionPerformed(e);
				else if (title == "��Ӷ���" || title == "���¶���")
					btn_saveActionPerformed(e);
			}
		});
		closeBtn.setBounds(240, 160, 80, 25); // �رհ�ť
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 					// �ͷŵ�ǰ����
			}
		});
		/* �رմ��� */
		this.addWindowListener(new WindowAdapter() {
			// ��дwindowClosing()����
			public void windowClosing(WindowEvent e) {
				dispose(); 					// �ͷŵ�ǰ����
			}
		});
		Container c = getContentPane();
		c.add(lbreaderid); 						// ���������ӵ�������
		c.add(lbreaderid_1);		c.add(lbreadername);		c.add(lbreadertype);
		c.add(lbsex);			c.add(lbmax_num);		c.add(lbdays_num);
		c.add(tf_readerid);		c.add(tf_readername);	c.add(tf_max_num);
		c.add(tf_days_num);		c.add(tf_readerid1);		c.add(tf_readertype);
		c.add(tf_sex);			c.add(btn);			c.add(closeBtn);
		c.add(queryBtn);
		setLocationRelativeTo(null); // ʹ��������Ļ�Ͼ��з���
		setVisible(true); // ʹ����ɼ�
	}
	private void btn_delActionPerformed(ActionEvent e) {
		String id = tf_readerid.getText();
		// ������߱��Ϊ�գ�����ֹɾ������
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "���߱�Ų���Ϊ�գ�");
			return;
		}
		String sql = "delete from tb_reader where id='" + id + "'";
		int i = DbOp.executeUpdate(sql);
		if (i == 1) {
			JOptionPane.showMessageDialog(null, "������Ϣɾ���ɹ���");
			// ���ȫ���ı���
			clearAllTextfield();
		} else
			JOptionPane.showMessageDialog(null, "���߱�����󣬲��޴��ˣ�");
	}
	private void btn_queryActionPerformed(ActionEvent e) {
		String id = tf_readerid1.getText();
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "���߱�Ų���Ϊ�գ�");
			return;
		}
		// ����Ų�ѯ���ߣ��������reader������
		Reader reader = ReaderSelect.selectReaderById(id);
		// �����ѯ�������������ʾ�ڸ��ı�����
		if (reader != null) {
			tf_readerid.setText(reader.getId());
			tf_readerid.setEditable(false);
			tf_readername.setText(reader.getReadername());
			// ��Choice��ѡ��������Ϊ�����Ƶ���ָ���ַ�������
			tf_readertype.setSelectedItem(reader.getReadertype());
			tf_sex.setSelectedItem(reader.getSex());
			tf_max_num.setText(String.valueOf(reader.getMax_num()));
			tf_days_num.setText(String.valueOf(reader.getDays_num()));
		} else
			JOptionPane.showMessageDialog(null, "���߱�����󣬲��޴��ˣ�");
	}
	private void btn_saveActionPerformed(ActionEvent e) {
		String id = tf_readerid.getText();
		String name = tf_readername.getText();
		String type = tf_readertype.getSelectedItem().toString();
		String sex = tf_sex.getSelectedItem().toString();
		// ������߱��Ϊ�գ�����ֹ�����¼����
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "���߱�Ų���Ϊ�գ�");
			return;
		}
		// ������߱���ظ������¼��Ч�����޸Ķ��߱��
		if (title == "��Ӷ���" & IfReaderIdExit(id)) {
			JOptionPane.showMessageDialog(null, "���߱���ظ���");
			return;
		}
		try {
			int max_num = Integer.parseInt(tf_max_num.getText());
			int days_num = Integer.parseInt(tf_days_num.getText());
			String sql = "";
			if (title == "��Ӷ���") {
				sql = "insert into tb_reader values('" + id + "','" + name + "','"
					+ type + "','" + sex + "','" + max_num + "','" + days_num
					+ "')";
			} else if (title == "���¶���") {
				sql = "update tb_reader set readername='" + name
						+ "',readertype='" + type + "',days_num='" + days_num
						+ "',sex='" + sex + "',max_num='" + max_num
						+ "' where id='" + id + "'";
			}
			int i = DbOp.executeUpdate(sql);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "������ӳɹ���");
				// ���ȫ���ı���
				clearAllTextfield();
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "���ɽ�����"
					+ "���ɽ���������ӦΪ������");
		}
	}
	// �ж�Reader�����Ƿ����ָ����ŵĶ��ߣ�������ڣ�����true�����򣬷���false
	private boolean IfReaderIdExit(String id) {
		String sql = "select * from tb_reader where id='" + id + "'";
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
		tf_readerid1.setText("");		tf_readerid.setText("");
		tf_readername.setText("");	tf_max_num.setText("");
		tf_days_num.setText("");
	}
	// ����main()��������ҪΪ�˵��Գ������
	public static void main(String[] args) {
		new ReaderOperate("���¶���");
	}
}


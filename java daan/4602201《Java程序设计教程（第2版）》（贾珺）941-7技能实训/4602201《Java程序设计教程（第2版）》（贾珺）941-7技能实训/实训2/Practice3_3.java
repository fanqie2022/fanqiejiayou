/* Practice3_3.java */
public class Practice3_3 {
	public static void main(String[] args) {
		int password = 596384;						//ԭ����
		int key = 7;								//���ܲ���
		System.out.println("ԭ���룺" + password);		//���ԭ����
		password = password << key;					//��ԭ�������ƣ�����������
		System.out.println("��������������ܺ�Ľ����" + password);//���������
		password = password >> key;				//�����������ƣ���ԭ��ԭ��������
		System.out.println("�����������㻹ԭ�Ľ����" + password);	//���ԭ����
	}
}

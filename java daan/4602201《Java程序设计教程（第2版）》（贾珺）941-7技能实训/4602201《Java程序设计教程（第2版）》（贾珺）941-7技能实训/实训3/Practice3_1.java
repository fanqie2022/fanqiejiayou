/* Practice3_1.java */
public class Practice3_1 {
	public static void main(String[] args) {
		int count = 0;						//�����������count������ֵΪ0
		for (int i = 2; i< 1000; i++) {			//ѭ������i���ڵ���1000ʱ����ѭ��
			int b = i / 100;					//�����λ��
			int s = (i - 100 * b) / 10;			//����ʮλ��
			int g = i % 10;					//�����λ��
			if (i == g*g*g + s*s*s + b*b*b) { //�ж����ֵ��������Ƿ���ڸ�������
				//����ǣ�������������1�����������
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println();				//����
		System.out.println("ˮ�ɻ����ܹ���"+count+"��");	//���ˮ�ɻ��ܸ���
	}
}

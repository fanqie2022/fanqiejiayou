/* Practice3_5.java */
public class Practice3_5 {
	public static void main(String[] args) {
		int x=	17;		//����ţ��������x�������������11ͷţ
						//�ҹ�����6�����ӣ��ʸ���ֵΪ17
		while (true)		//ѭ��
		{
			//�ж�ţ�����Ƿ�ͬʱ���㱻4��5��6��7��8��9����
			if(x%4==0&&x%5==0&&x%6==0&&x%7==0&&x%8==0&&x%9==0)
				//�ж����ʣ�µ�ţͷ���Ƿ����11
				if(x - x / 4 - x / 5 - x / 6 - x / 7 - x / 8 - x / 9 == 11) {
					System.out.println(x);		//����ǣ����x
					break;					//�˳�ѭ��
				}
			x++;								//x����1
		}
	}
}

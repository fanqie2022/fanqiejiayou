package shushangshixun.shixun6;
public abstract class s3 {
	public static void main(String[] args) {
		String[] product= new String[] { "��Ϊ�ֻ�", "�����ֻ�",
				"�����յ�", "С�׵���", "��Ϊ����", "����������",
				"��Ϊ·����", "��������ˮ��", "��Ϊ������֬��" };
		int sum = 0;
		for (int i = 0; i < product.length; i++) {
			String name = product[i];
			if (name.startsWith("��Ϊ")) {
				sum++;
			}
		}
		System.out.println("��ΪƷ�Ƶĵ�������" + sum + "��");
	}
}

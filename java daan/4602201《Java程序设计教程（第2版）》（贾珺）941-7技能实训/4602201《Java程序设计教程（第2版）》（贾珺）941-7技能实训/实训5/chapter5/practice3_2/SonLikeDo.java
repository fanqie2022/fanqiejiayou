/* SonLikeDo.java */
package chapter5.practice3_2;
interface DadLikeDo {						// ���塰�ְ�ϲ�������¡��ӿ�
	void ride();							// �ﳵ�ķ���
	void basketball();						// ������ķ���
}
interface MomLikeDo {						// ���塰����ϲ�������¡��ӿ�
	void sing();							// ����ķ���
	void dance();							// ����ķ���
}
// �̳�DadLikeDo�ӿں�MomLikeDo�ӿ�
public class SonLikeDo implements DadLikeDo, MomLikeDo {
	public void ride() {						// ʵ��ride()����
		System.out.println("�ﳵ");
	}
	public void basketball() {				// ʵ��basketball()����
		System.out.println("������");
	}
	public void sing() {						// ʵ��sing()����
		System.out.println("����");
	}
	public void dance() {					// ʵ��dance()����
		System.out.println("����");
	}
	public static void main(String[] args) {
		SonLikeDo son = new SonLikeDo();	// ͨ�����ഴ���ӿڶ���
		System.out.println("����ϲ���������У�");
		// ����������DadLikeDo��MomLikeDo�����ӿڱ�ʵ�ֵ����з���
		son.ride();
		son.basketball();
		son.sing();
		son.dance();
	}
}

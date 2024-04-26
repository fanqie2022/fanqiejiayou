/* SonLikeDo.java */
package chapter5.practice3_2;
interface DadLikeDo {						// 定义“爸爸喜欢做的事”接口
	void ride();							// 骑车的方法
	void basketball();						// 打篮球的方法
}
interface MomLikeDo {						// 定义“妈妈喜欢做的事”接口
	void sing();							// 唱歌的方法
	void dance();							// 跳舞的方法
}
// 继承DadLikeDo接口和MomLikeDo接口
public class SonLikeDo implements DadLikeDo, MomLikeDo {
	public void ride() {						// 实现ride()方法
		System.out.println("骑车");
	}
	public void basketball() {				// 实现basketball()方法
		System.out.println("打篮球");
	}
	public void sing() {						// 实现sing()方法
		System.out.println("唱歌");
	}
	public void dance() {					// 实现dance()方法
		System.out.println("跳舞");
	}
	public static void main(String[] args) {
		SonLikeDo son = new SonLikeDo();	// 通过子类创建接口对象
		System.out.println("儿子喜欢做的事有：");
		// 子类对象调用DadLikeDo和MomLikeDo两个接口被实现的所有方法
		son.ride();
		son.basketball();
		son.sing();
		son.dance();
	}
}

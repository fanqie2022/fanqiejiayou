/* Practice3_3.java */
public class Practice3_3 {
	public static void main(String[] args) {
		int password = 596384;						//原密码
		int key = 7;								//加密参数
		System.out.println("原密码：" + password);		//输出原密码
		password = password << key;					//将原密码左移，生成新密码
		System.out.println("经过左移运算加密后的结果：" + password);//输出新密码
		password = password >> key;				//将新密码右移，还原回原来的密码
		System.out.println("经过右移运算还原的结果：" + password);	//输出原密码
	}
}

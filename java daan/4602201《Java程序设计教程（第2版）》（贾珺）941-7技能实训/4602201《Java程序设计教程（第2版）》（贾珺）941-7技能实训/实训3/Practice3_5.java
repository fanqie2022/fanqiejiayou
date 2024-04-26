/* Practice3_5.java */
public class Practice3_5 {
	public static void main(String[] args) {
		int x=	17;		//定义牛总数变量x，由于最后生下11头牛
						//且国王有6个儿子，故赋初值为17
		while (true)		//循环
		{
			//判断牛总数是否同时满足被4、5、6、7、8、9整除
			if(x%4==0&&x%5==0&&x%6==0&&x%7==0&&x%8==0&&x%9==0)
				//判断最后剩下的牛头数是否等于11
				if(x - x / 4 - x / 5 - x / 6 - x / 7 - x / 8 - x / 9 == 11) {
					System.out.println(x);		//如果是，输出x
					break;					//退出循环
				}
			x++;								//x增加1
		}
	}
}

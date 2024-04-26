/* Practice3_1.java */
public class Practice3_1 {
	public static void main(String[] args) {
		int count = 0;						//定义计数变量count，并赋值为0
		for (int i = 2; i< 1000; i++) {			//循环，当i大于等于1000时结束循环
			int b = i / 100;					//计算百位数
			int s = (i - 100 * b) / 10;			//计算十位数
			int g = i % 10;					//计算个位数
			if (i == g*g*g + s*s*s + b*b*b) { //判断数字的立方和是否等于该数本身
				//如果是，计数变量增加1，并输出该数
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println();				//换行
		System.out.println("水仙花数总共有"+count+"个");	//输出水仙花总个数
	}
}

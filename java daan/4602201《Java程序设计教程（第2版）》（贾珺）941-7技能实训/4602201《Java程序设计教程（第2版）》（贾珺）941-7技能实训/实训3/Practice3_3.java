/* Practice3_3.java */
public class Practice3_3 {
	public static void main(String[] args) {
		int i, j, k;	
		int n = 0;								//定义情况数
		//i表示大马数，由于大马驮3担，所以它的取值小于100/3=33
		for (i = 1; i < 33; i++)
			//j表示中马数，由于大马驮2担，所以它的取值小于100/2=50
			for (j = 1; j < 50; j++) {
				k = 100 - i - j;					//k表示小马数，计算小马数
				//判断总担数量是否为100
				//由于两匹小马驮一担，所以必须同时满足k为偶数
				if ((i * 3 + j * 2 + k / 2 == 100) && (k % 2 == 0)) {
					n++;						//情况数增加1
					//输出每种马匹数
					System.out.println("大马"+i+"匹,中马"+j+"匹,小马"+k+"匹");
				}		
			}
		System.out.print("一共有" + n + "种情况");	//输出情况数
	}
}

/* Practice1_3.java */
public class Practice1_3 {
	public static void main(String[] args) {
		double height = 1.72;					// 身高，单位为m
		int weight = 70;							// 体重，单位为kg
		// BMI计算公式
		double exponent = weight / (height * height);
		System.out.println("您的身高为：" + height);
		System.out.println("您的体重为：" + weight);
		System.out.println("您的BMI指数为：" + exponent);
	}
}

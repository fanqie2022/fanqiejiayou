package shushangshixun.shixun5.s2;
public class GoShopping {
	public static void main(String[] args) {
		Market market = new WuMeiMarket("����", "����");
		market.shop();
		market = new JDMarket("����", "�ֻ�");
		market.shop();
	}
}
/* DuotoneBall.java */
package chapter6.practice4_1;
public class DuotoneBall {
	public static void main(String[] args) {
		int[] nums = new int[7];					// 初始化一个int类型的数组
		for (int j = 0; j < 6; j++) {				// 产生6个红球
			// 给数组中的前6个元素赋值（1-33之间的随机数）
			nums[j] = (int) (Math.random() * 33) + 1;
			// 比较每个数组中的元素是否相等；如果相等，就要跳出，重复生成
			for (int k = 0; k < j; k++) {
				if (nums[j] == nums[k] && j != 0) {// 判断“元素是否相等”的条件
					j--;
					break;
				}
			}
		}
		// 产生1个蓝球，给数组中的后1两个元素赋值（1-16之间的随机数）
		nums[6] = (int) (Math.random() * 16) + 1;
		System.out.println("机选双色球的号码：");		// 提示信息
		for (int j = 0; j < nums.length; j++) {				// 遍历数组
			System.out.print(nums[j] + " ");				// 显示数组中的每个元素
		}
	}
}

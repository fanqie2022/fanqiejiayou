/* NumberManager.java */
package chapter6.practice4_2;
public class NumberManager {
	/* 统计每个数字（0，1，…，8，9）出现的频率 */
	public static int[] countNumbers(String numbers) {
		int[] numberArray = new int[10];
		for (int i = 0; i < numbers.length(); i++) {
			/*numbers[i].charAt(index)方法返回索引位置处的字符，
			它与字符'0'的差值为对应数字符的数值。
			例如，'1'-'0'=1，'5'-'0'=5等。因此，如果字符为'5'，
			则相当于numberArray[5]加1，其他字符与此类似。
			*/
			numberArray[numbers.charAt(i) - '0']++;
		}
		return numberArray;
	}
	/*打印整型数组*/
	private static void printArray(int[] numArr) {
		for (int i = 0; i < numArr.length; i++) {
			System.out.printf(i + ":" + numArr[i] + ",");
		}
		System.out.println();
	}
	/*替换数字*/
	public static String replaceNumbers(String numbers, int[] numberCounts) {
		String results;
		int replaceNum = getMaxNumber(numberCounts);	// 得到最大数的索引下标
		char c = (char)(replaceNum + '0');					// 将索引转化为字符
		results = numbers.replace(c, '8');
		return results;
	}
	/*得到出现频率最高数字的下标*/
	private static int getMaxNumber(int[] numberCounts) {
		int currenMaxNumber = -1;
		int index = -1;
		//获取numberCounts数组中的最大数
		for (int i = 0; i < numberCounts.length; i++) {
			if (numberCounts[i] > currenMaxNumber) {		// 记录当前最大数
				currenMaxNumber = numberCounts[i];		// 记录最大数的下标
				index = i;
			}
		}
		return index;
	}
	public static void main(String[] args) {
		String numbers = "13701192543";
		System.out.println("原始电话号码：" + numbers);
		// 统计各数字串中数字字符'0'、'1'...'9'出现的频率
		int[] numArr = countNumbers(numbers); 
		System.out.println("各数字在电话号码中出现的频率：");
		// 打印数字字符'0'、'1'...'9'出现的频率
		printArray(numArr);
		// 将数字串中高频数字符与字符'8'互换
		String newArr = replaceNumbers(numbers, numArr); 
		System.out.println("高频数字与8互换后的电话号码: " + newArr);
	}
}

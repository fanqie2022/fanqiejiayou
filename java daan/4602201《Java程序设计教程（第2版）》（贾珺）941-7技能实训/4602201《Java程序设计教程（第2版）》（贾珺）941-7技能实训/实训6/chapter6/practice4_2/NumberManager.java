/* NumberManager.java */
package chapter6.practice4_2;
public class NumberManager {
	/* ͳ��ÿ�����֣�0��1������8��9�����ֵ�Ƶ�� */
	public static int[] countNumbers(String numbers) {
		int[] numberArray = new int[10];
		for (int i = 0; i < numbers.length(); i++) {
			/*numbers[i].charAt(index)������������λ�ô����ַ���
			�����ַ�'0'�Ĳ�ֵΪ��Ӧ���ַ�����ֵ��
			���磬'1'-'0'=1��'5'-'0'=5�ȡ���ˣ�����ַ�Ϊ'5'��
			���൱��numberArray[5]��1�������ַ�������ơ�
			*/
			numberArray[numbers.charAt(i) - '0']++;
		}
		return numberArray;
	}
	/*��ӡ��������*/
	private static void printArray(int[] numArr) {
		for (int i = 0; i < numArr.length; i++) {
			System.out.printf(i + ":" + numArr[i] + ",");
		}
		System.out.println();
	}
	/*�滻����*/
	public static String replaceNumbers(String numbers, int[] numberCounts) {
		String results;
		int replaceNum = getMaxNumber(numberCounts);	// �õ�������������±�
		char c = (char)(replaceNum + '0');					// ������ת��Ϊ�ַ�
		results = numbers.replace(c, '8');
		return results;
	}
	/*�õ�����Ƶ��������ֵ��±�*/
	private static int getMaxNumber(int[] numberCounts) {
		int currenMaxNumber = -1;
		int index = -1;
		//��ȡnumberCounts�����е������
		for (int i = 0; i < numberCounts.length; i++) {
			if (numberCounts[i] > currenMaxNumber) {		// ��¼��ǰ�����
				currenMaxNumber = numberCounts[i];		// ��¼��������±�
				index = i;
			}
		}
		return index;
	}
	public static void main(String[] args) {
		String numbers = "13701192543";
		System.out.println("ԭʼ�绰���룺" + numbers);
		// ͳ�Ƹ����ִ��������ַ�'0'��'1'...'9'���ֵ�Ƶ��
		int[] numArr = countNumbers(numbers); 
		System.out.println("�������ڵ绰�����г��ֵ�Ƶ�ʣ�");
		// ��ӡ�����ַ�'0'��'1'...'9'���ֵ�Ƶ��
		printArray(numArr);
		// �����ִ��и�Ƶ���ַ����ַ�'8'����
		String newArr = replaceNumbers(numbers, numArr); 
		System.out.println("��Ƶ������8������ĵ绰����: " + newArr);
	}
}

/* DuotoneBall.java */
package chapter6.practice4_1;
public class DuotoneBall {
	public static void main(String[] args) {
		int[] nums = new int[7];					// ��ʼ��һ��int���͵�����
		for (int j = 0; j < 6; j++) {				// ����6������
			// �������е�ǰ6��Ԫ�ظ�ֵ��1-33֮����������
			nums[j] = (int) (Math.random() * 33) + 1;
			// �Ƚ�ÿ�������е�Ԫ���Ƿ���ȣ������ȣ���Ҫ�������ظ�����
			for (int k = 0; k < j; k++) {
				if (nums[j] == nums[k] && j != 0) {// �жϡ�Ԫ���Ƿ���ȡ�������
					j--;
					break;
				}
			}
		}
		// ����1�����򣬸������еĺ�1����Ԫ�ظ�ֵ��1-16֮����������
		nums[6] = (int) (Math.random() * 16) + 1;
		System.out.println("��ѡ˫ɫ��ĺ��룺");		// ��ʾ��Ϣ
		for (int j = 0; j < nums.length; j++) {				// ��������
			System.out.print(nums[j] + " ");				// ��ʾ�����е�ÿ��Ԫ��
		}
	}
}

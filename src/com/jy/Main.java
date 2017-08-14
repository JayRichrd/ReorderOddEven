package com.jy;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		IJudge judge = new IJudge() {

			@Override
			public boolean rule(int n) {
				// 自定义判定规则
				// 这里用来判定是否为奇数
				if ((n & 0x1) == 1) // 与1作与运算
					return true;
				return false;
			}
		};
		System.out.println("调整之前：" + Arrays.toString(array));

		reorderOddEven(array, judge);

		System.out.println("调整之后：" + Arrays.toString(array));
	}

	/**
	 * 将数组的奇数调整至数组前面，偶数调整至数组后面
	 * 
	 * @param array
	 *            待调整的数组
	 * @param judgeImpl
	 *            调整规则
	 */
	public static void reorderOddEven(int[] array, IJudge judgeImpl) {
		// 一头一尾开始扫描
		int begin = 0;
		int end = array.length - 1;
		while (begin < end) {
			// 从头往后开始查找偶数
			while (begin < end && judgeImpl.rule(array[begin]))
				begin++;
			// 从后往前开始查找奇数
			while (begin < end && !judgeImpl.rule(array[end]))
				end--;
			// 交换
			if (begin < end) {
				int temp = array[begin];
				array[begin] = array[end];
				array[end] = temp;
			}
		}
	}

}

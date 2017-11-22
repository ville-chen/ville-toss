package com.sum;

/**
 * Created by ville on 2017/8/15.
 * 最大自序列和
 */
public class MaxSubSequenceSum {
    public static void main(String[] args) {
        int[] source = new int[]{-2, 11 -4, 13, -5, -2};
        System.out.println(getMaxSumN(source));

    }

    /**
     * O(N^3)解法
     */
    private static int getMaxSumN3(int[] source) {
        int maxSum = 0, temp, j, k, q, len;
        //j = 子序列种类 & j = 子序列长度-1   确定长度
        for (j = 0, len = source.length; j < len; j++) {
            //k = 子序列left => 循环不变式 : left + sonSequence.length - 1 < source.length  确定右边界
            for (k = 0; k + j < len; k++) {
                //最后一个值坐标 = left + sonSequence.length - 1     求和
                temp = source[k];
                for (q = k + 1; q <= k + j; q++) {
                    temp += source[q];
                }
                maxSum = maxSum < temp ? temp : maxSum;
            }
        }
        return maxSum;
    }

    /**
     * O(N^2)解法
     */
    private static int getMaxSumN2(int[] source) {
        int maxSum = 0, temp, j, k, len;
        //j = 左边界
        for (j = 0, len = source.length; j < len; j++) {
            //k = 右边界
            temp = 0;
            for (k = j; k < len; k++) {
                temp += source[k];
                if (temp > maxSum) {
                    maxSum = temp;
                }
            }
        }
        return maxSum;
    }

    /**
     * O(NLogN)解法：分治递归
     */
    private static int getMaxSumNLogN(int[] source, int left , int right) {
        int maxLeftSum, maxRightSum, maxLeftBorderSum, maxRightBorderSum, leftBorderSum, rightBorderSum, center, i;

        if (left == right) {
            if (source[left] > 0) {
                return source[left];
            } else {
                return 0;
            }
        }

        center = (left + right) / 2;
        maxLeftSum = getMaxSumNLogN(source, left, center);
        maxRightSum = getMaxSumNLogN(source, center + 1, right);

        maxLeftBorderSum = 0;
        leftBorderSum = 0;
        for (i = center; i >= left; i--) {
            leftBorderSum += source[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        maxRightBorderSum = 0;
        rightBorderSum = 0;
        for (i = center + 1; i <= right; i++) {
            rightBorderSum += source[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);
    }

    /**
     * O(N)解法：on-line algorithm
     */
    private static int getMaxSumN(int[] source) {
        int sum = 0, temp = 0;
        for (int data : source) {
            temp += data;
            if (temp > sum) {
                sum = temp;
            } else if (temp < 0) {
                temp = 0;
            }
        }
        return sum;
    }
}

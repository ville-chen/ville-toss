package com.selction;

import com.commom.Utils;

/**
 * Created by admin on 2017/8/14.
 * 选择第N个最值
 */
public class Test {
    public static void main(String[] args) {
        Integer[] source = new Integer[]{7,2,5,3,9};
        for (int i = 1; i <= source.length; i++) {
            System.out.println("第" + i + "个最大值: " + getSpecifyMaxValue(source, i));
        }
    }

    /**
     * @param thMax 第几个最大值
     */
    private static int getSpecifyMaxValue(Integer[] source, int thMax) {
        Integer[] resultArr = new Integer[thMax];
        //已有元素个数
        int size = 0;
        for (int value : source) {
            //填充元素
            if (size < thMax) {
                resultArr[size] = value;
                if (thMax == ++size) {
                    //排序
                    Utils.bubbleSortDesc(resultArr, true);
                }
                continue;
            }
            //是否替换元素
            if (value > resultArr[thMax - 1]) {
                insertElement(resultArr, value);
            }
        }
        return resultArr[thMax - 1];
    }

    /**
     * 插入元素
     */
    private static void insertElement(Integer[] source, int value) {
        if (1 == source.length) {
            source[0] = value;
            return;
        }

        for (int i = 0; i < source.length; i++) {
            if (value <= source[i] && value >= source[i+1]) {
                while (i < source.length - 1) {
                    value = value ^ source[i + 1];
                    source[i + 1] = value ^ source[i + 1];
                    value = value ^ source[++i];
                }
                break;
            } else if (value > source[i]) {
                value = value ^ source[i];
                source[i] = value ^ source[i];
                value = value ^ source[i--];
            }
        }
    }

}

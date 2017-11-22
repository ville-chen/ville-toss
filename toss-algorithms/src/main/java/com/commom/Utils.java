package com.commom;

/**
 * Created by ville on 2017/8/14.
 * 通用工具类
 */
public class Utils {

    /**
     * general bubble sort for data
     * @param source data source
     * @param isDesc in descending order
     */
    @SuppressWarnings("unchecked")
    public static <M extends Comparable> void bubbleSortDesc(M[] source, boolean isDesc) {
        M temp;
        for (int j = source.length - 1; j > 0; j--) {
            for (int k = 0; k < j; k++) {
                if (source[k].compareTo(source[k + 1]) > 0 ^ isDesc) {
                    temp = source[k];
                    source[k] = source[k + 1];
                    source[k + 1] = temp;
                }
            }
        }
    }

    /**
     * asc bubble sort for data
     * @param source data source
     */
    public static <M extends Comparable> void bubbleSort(M[] source) {
        bubbleSortDesc(source, false);
    }

}

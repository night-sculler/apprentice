package com.night.sculler.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序器
 *
 * @author houlongjie
 * @version 1.0
 * @date 2021/9/15
 */
public class BubbleSort {

    /**
     * 对int数组排序 从大到小
     *
     * @param intArray intArray
     */
    public static void sortIntArrayDesc(int[] intArray) {
        int length = intArray.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (intArray[i] < intArray[j]) {
                    Swapper.swapIntArrayElement(intArray, i, j);
                }
            }
        }
    }

    /**
     * 对int数组排序 从小到大
     *
     * @param intArray intArray
     */
    public static void sortIntArrayAsc(int[] intArray) {
        int length = intArray.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (intArray[i] > intArray[j]) {
                    Swapper.swapIntArrayElement(intArray, i, j);
                }
            }
        }
    }

    /**
     * 对int数组排序 从大到小 (优化了，当本身就是大到小有序的，就不用走外层循环了)
     *
     * @param intArray intArray
     */
    public static void sortIntArrayDescOpt(int[] intArray) {
        int length = intArray.length;
        boolean flag = true;
        for (int i = 0; i < length && flag; i++) {
            flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (intArray[j] < intArray[j + 1]) {
                    Swapper.swapIntArrayElement(intArray, j, j + 1);
                    flag = true;
                }
            }
        }
    }

    /**
     * 对int数组排序 从小到大 (优化了，当本身就是小到大有序的，就不用走外层循环了)
     *
     * @param intArray intArray
     */
    public static void sortIntArrayAscOpt(int[] intArray) {
        int length = intArray.length;
        boolean flag = true;
        for (int i = 0; i < length && flag; i++) {
            flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    Swapper.swapIntArrayElement(intArray, j, j + 1);
                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] intArrayDesc = {3, 4, 7, 8, 6, 5, 1, 0, 2, 9};
        sortIntArrayDesc(intArrayDesc);
        System.out.println(Arrays.toString(intArrayDesc));

        int[] intArrayAsc = {3, 4, 7, 8, 6, 5, 1, 0, 2, 9};
        sortIntArrayAsc(intArrayAsc);
        System.out.println(Arrays.toString(intArrayAsc));


        int[] intArrayDescOpt = {3, 4, 7, 8, 6, 5, 1, 0, 2, 9};
        sortIntArrayDescOpt(intArrayDescOpt);
        System.out.println(Arrays.toString(intArrayDescOpt));

        int[] intArrayAscOpt = {3, 4, 7, 8, 6, 5, 1, 0, 2, 9};
        sortIntArrayAscOpt(intArrayAscOpt);
        System.out.println(Arrays.toString(intArrayAscOpt));
    }
}

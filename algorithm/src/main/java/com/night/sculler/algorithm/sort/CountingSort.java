package com.night.sculler.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author houlongjie
 * @version 1.0
 * @date 2021/10/8
 */
public class CountingSort {
    /**
     * 对int数组做升序排序
     *
     * @param intArr int数组
     */
    private static void sortIntArrayAsc(int[] intArr) {
        int length = intArr.length;
        if (length <= 1) {
            return;
        }
        //首先求出数组的最大最小值
        int min = intArr[0];
        int max = intArr[0];
        for (int element : intArr) {
            if (element < min) {
                min = element;
            }
            if (element > max) {
                max = element;
            }
        }
        //计数数组，下标范围为（min - min）~（max - min ）
        //其含义为：一个连续的且覆盖住原始数组所有元素的集合，经过偏移后就是计数数组的下标；
        //计数数组的下标加上偏移量后，和原始数组中的元素形成对应关系。计数数组的元素就是其下标对应的原始数组中的元素的个数
        //其中min为偏移量，为了减少空间、兼容负数、兼容较大的数据集合
        int[] countNumArr = new int[max - min + 1];
        for (int element : intArr) {
            countNumArr[element - min]++;
        }
        //前缀和数组，每个元素的值是计数数组对应值和该对应值前面所有值相加
        //其含义就为：前缀和数组下标在有序的情况下，原始数组对应元素在第几个
        for (int i = 1; i < countNumArr.length; i++) {
            countNumArr[i] = countNumArr[i] + countNumArr[i - 1];
        }
        //零时有序数组，从后往前用原始数组的元素减去偏移量作为下标，到前缀和数组中取值，该值就是原始数组元素在有序数组中的位置
        int[] tmpSortArr = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            int element = intArr[i];
            int tempSortIndex = countNumArr[element - min] - 1;
            tmpSortArr[tempSortIndex] = element;
        }
        System.arraycopy(tmpSortArr,0,intArr,0,length);
    }

    public static void main(String[] args) {
        int[] source = {5, 20, 4, 3, 1};
        sortIntArrayAsc(source);
        System.out.println(Arrays.toString(source));
    }
}

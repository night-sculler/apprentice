package com.night.sculler.algorithm;

import java.util.Arrays;

import static com.night.sculler.algorithm.SortOrderEnum.ASC;
import static com.night.sculler.algorithm.SortOrderEnum.DESC;

/**
 * 希尔排序
 *
 * @author houlongjie
 * @version 1.0
 * @date 2021/9/22
 */
public class ShellSort {
    /**
     * 对int数组按照降序排序
     *
     * @param intArray intArray
     */
    public static void sortIntArrayDesc(int[] intArray) {
        sortIntArray(intArray, DESC);
    }

    /**
     * 对int数组按照升序排序
     *
     * @param intArray intArray
     */
    public static void sortIntArrayAsc(int[] intArray) {
        sortIntArray(intArray, ASC);
    }

    /**
     * 对int数组按照指定的顺序排序
     *
     * @param intArray  intArray
     * @param sortOrder sortOrder
     */
    public static void sortIntArray(int[] intArray, SortOrderEnum sortOrder) {
        int length = intArray.length;
        int increment = length;
        while (increment > 1) {
            increment = increment / 2;
            for (int i = 0; i < increment; i++) {
                for (int j = i + increment; j < length; j += increment) {
                    int firstElementInUnSortedArea = intArray[j];
                    int k;
                    for (k = j - increment; k >= 0; k -= increment) {
                        if (intArraySwapConditionMatch(sortOrder, intArray[k], firstElementInUnSortedArea)) {
                            intArray[k + increment] = intArray[k];
                            continue;
                        }
                        break;
                    }
                    intArray[k + increment] = firstElementInUnSortedArea;
                }
            }
        }
    }


    /**
     * int 数组满足了交换条件
     *
     * @param sortOrder                  排序顺序
     * @param sortedElement              有序区间的一个元素
     * @param firstElementInUnSortedArea 无序区间的第一个元素
     * @return 是否满足
     */
    private static boolean intArraySwapConditionMatch(SortOrderEnum sortOrder, int sortedElement, int firstElementInUnSortedArea) {
        boolean ascSortOrderSwapMatch = ASC.equals(sortOrder) && sortedElement > firstElementInUnSortedArea;
        boolean descSortOrderSwapMatch = DESC.equals(sortOrder) && sortedElement < firstElementInUnSortedArea;
        return ascSortOrderSwapMatch || descSortOrderSwapMatch;
    }

    public static void main(String[] args) {
        int[] intArrayDesc = {3, 4, 7, 8, 6, 5, 1, 0, 2, 9};
        sortIntArrayDesc(intArrayDesc);
        System.out.println(Arrays.toString(intArrayDesc));

        int[] intArrayAsc = {3, 4, 7, 8, 6, 5, 1, 0, 2, 9};
        sortIntArrayAsc(intArrayAsc);
        System.out.println(Arrays.toString(intArrayAsc));
    }
}

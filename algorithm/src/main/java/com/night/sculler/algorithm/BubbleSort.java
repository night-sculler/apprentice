package com.night.sculler.algorithm;

import java.util.Arrays;

import static com.night.sculler.algorithm.SortOrderEnum.ASC;
import static com.night.sculler.algorithm.SortOrderEnum.DESC;

/**
 * 冒泡排序器
 *
 * @author houlongjie
 * @version 1.0
 * @date 2021/9/15
 */
public class BubbleSort {

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
        if (null == sortOrder) {
            throw new RuntimeException("请输入正确的排序顺序枚举");
        }
        int length = intArray.length;
        //数组不是按照 sortOrder 排序的 默认为true
        //使得能够进行排序，进入后设为false，期望是最少循环能有序
        //只要发生交换，就不是有序的，设置为true，需要再循环
        boolean unSorted = true;
        for (int i = 0; i < length - 1 && unSorted; i++) {
            unSorted = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (intArraySwapConditionMatch(sortOrder, intArray[j], intArray[j + 1])) {
                    Swapper.swapIntArrayElement(intArray, j, j + 1);
                    unSorted = true;
                }
            }
        }
    }

    /**
     * int 数组满足了交换条件
     *
     * @param sortOrder 排序顺序
     * @param first     第一个元素
     * @param second    第二个原素
     * @return 是否满足
     */
    private static boolean intArraySwapConditionMatch(SortOrderEnum sortOrder, int first, int second) {
        boolean ascSortOrderSwapMatch = ASC.equals(sortOrder) && first > second;
        boolean descSortOrderSwapMatch = DESC.equals(sortOrder) && first < second;
        return ascSortOrderSwapMatch || descSortOrderSwapMatch;
    }

    public static void main(String[] args) {
        int[] intArrayDesc = {3, 4, 7, 8, 6, 5, 1, 0, 2, 9,-1,5};
        sortIntArrayDesc(intArrayDesc);
        System.out.println(Arrays.toString(intArrayDesc));

        int[] intArrayAsc = {3, 4, 7, 8, 6, 5, 1, 0, 2, 9,-1,5};
        sortIntArrayAsc(intArrayAsc);
        System.out.println(Arrays.toString(intArrayAsc));
    }
}

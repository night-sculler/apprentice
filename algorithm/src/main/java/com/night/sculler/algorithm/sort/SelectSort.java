package com.night.sculler.algorithm.sort;

import java.util.Arrays;

import static com.night.sculler.algorithm.sort.SortOrderEnum.ASC;
import static com.night.sculler.algorithm.sort.SortOrderEnum.DESC;

/**
 * 选择排序器
 *
 * @author houlongjie
 * @version 1.0
 * @date 2021/9/18
 */
public class SelectSort {

    /**
     * 对int数组排序 从大到小
     *
     * @param intArray intArray
     */
    public static void sortIntArrayDesc(int[] intArray) {
        sortIntArray(intArray, DESC);
    }

    /**
     * 对int数组排序 从小到大
     *
     * @param intArray intArray
     */
    public static void sortIntArrayAsc(int[] intArray) {
        sortIntArray(intArray, ASC);
    }

    /**
     * 按照指定顺序对int数组排序
     *
     * @param intArray  int数组
     * @param sortOrder 指定排序顺序
     */
    public static void sortIntArray(int[] intArray, SortOrderEnum sortOrder) {
        if (null == sortOrder) {
            throw new RuntimeException("请输入正确的排序顺序枚举");
        }
        int length = intArray.length;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (intArraySwapConditionMatch(sortOrder, intArray[minIndex], intArray[j])) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {

                Swapper.swapIntArrayElement(intArray, i, minIndex);
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
        int[] intArrayDesc = {3, 4, 7, 8, 6, 5, 1, 0, 2, 9};
        sortIntArrayDesc(intArrayDesc);
        System.out.println(Arrays.toString(intArrayDesc));

        int[] intArrayAsc = {3, 4, 7, 8, 6, 5, 1, 0, 2, 9};
        sortIntArrayAsc(intArrayAsc);
        System.out.println(Arrays.toString(intArrayAsc));
    }
}

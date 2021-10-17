package com.night.sculler.algorithm.sort;

import java.util.Arrays;

import static com.night.sculler.algorithm.sort.SortOrderEnum.ASC;
import static com.night.sculler.algorithm.sort.SortOrderEnum.DESC;

/**
 * @author night-sculler
 * @version 1.0.0.release
 * @date 2021/9/21
 */
public class InsertSort {


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
        //无序区间
        for (int i = 1; i < length; i++) {
            //无序区间第一个元素下标
            int firstElementInUnSortedArea = intArray[i];
            int j;
            //有序区间
            for (j = i - 1; j >= 0; j--) {
                if (intArraySwapConditionMatch(sortOrder,intArray[j],firstElementInUnSortedArea)) {
                    intArray[j + 1] = intArray[j];
                    continue;
                }
                //如果无序区间的第一个元素比有序区间的最后一个元素大，进入下一个循环
                break;
            }
            //插入
            intArray[j + 1] = firstElementInUnSortedArea;
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

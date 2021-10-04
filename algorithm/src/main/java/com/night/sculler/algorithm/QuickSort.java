package com.night.sculler.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author houlongjie
 * @version 1.0
 * @date 2021/10/4
 */
public class QuickSort {
    /**
     * 对int数组升序排序
     *
     * @param intArr int数组
     */
    public static void sortIntArrAsc(int[] intArr) {
        quickSort(intArr, 0, intArr.length - 1);
    }

    /**
     * 快序排序
     *
     * @param intArr    int数组
     * @param lowIndex  低位index
     * @param highIndex 高位index
     */
    private static void quickSort(int[] intArr, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int pivotIndex = partition(intArr, lowIndex, highIndex);
            quickSort(intArr, lowIndex, pivotIndex - 1);
            quickSort(intArr, pivotIndex + 1, highIndex);
        }
    }

    /**
     * 分区 大的在右 小的在左
     *
     * @param intArr    int数组
     * @param lowIndex  低位index
     * @param highIndex 高位index
     */
    private static int partition(int[] intArr, int lowIndex, int highIndex) {
        int pivot = intArr[lowIndex];
        int start = lowIndex;
        while (lowIndex < highIndex) {
            while (lowIndex < highIndex && intArr[highIndex] >= pivot) {
                highIndex--;
            }
            while (lowIndex < highIndex && intArr[lowIndex] <= pivot) {
                lowIndex++;
            }
            if (lowIndex >= highIndex) {
                break;
            }
            int tmp = intArr[lowIndex];
            intArr[lowIndex] = intArr[highIndex];
            intArr[highIndex] = tmp;
        }
        intArr[start] = intArr[lowIndex];
        intArr[lowIndex] = pivot;
        return lowIndex;
    }

    public static void main(String[] args) {
        int[] source = {2, 1, 4, 5, 3};
        sortIntArrAsc(source);
        System.out.println(Arrays.toString(source));
    }
}

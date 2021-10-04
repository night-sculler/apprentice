package com.night.sculler.algorithm;

import com.sun.scenario.effect.Brightpass;

import java.util.Arrays;

/**
 * @author houlongjie
 * @version 1.0
 * @date 2021/9/27
 */
public class SortPractice {

    private static void sortIntArrayAsc(int[] intArr) {
        quickSort(intArr, 0, intArr.length - 1);
    }

    private static void quickSort(int[] intArr, int low, int high) {
        if (low < high) {
            int index = partition(intArr, low, high);
            quickSort(intArr, low, index - 1);
            quickSort(intArr, index + 1, high);
        }
    }

    private static int partition(int[] intArr, int low, int high) {
        int pivot = intArr[low];
        int start = low;
        while (low < high) {
            while (low < high && intArr[high] >= pivot) {
                high--;
            }
            while (low < high && intArr[low] <= pivot) {
                low++;
            }
            if (low >= high) {
                break;
            }
            int tmp = intArr[low];
            intArr[low] = intArr[high];
            intArr[high] = tmp;
        }
        intArr[start] = intArr[low];
        intArr[low] = pivot;
        return low;
    }


    public static void main(String[] args) {
        int[] source = {2, 3, 1, 5, 4};
        sortIntArrayAsc(source);
        System.out.println(Arrays.toString(source));
    }
}

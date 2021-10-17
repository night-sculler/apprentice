package com.night.sculler.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author night-sculler
 * @version 1.0.0.release
 * @date 2021/10/8
 */
public class HeapSort {
    public static void sortIntArrayAsc(int[] intArr) {
        int length = intArr.length;
        //堆
        int[] heap = new int[length + 1];
        System.arraycopy(intArr, 0, heap, 1, length);
        //建堆
        for (int i = length / 2; i >= 1; i--) {
            sink(heap, i, length);
        }
        //交换下沉元素的下标
        int swapSinkIndex = length;
        while (swapSinkIndex > 1) {
            Swapper.swapIntArrayElement(heap, 1, swapSinkIndex);
            swapSinkIndex--;
            sink(heap, 1, swapSinkIndex);
        }
        System.arraycopy(heap, 1, intArr, 0, length);
    }

    /**
     * 对下标为sinkIndex的元素进行下沉操作
     *
     * @param intArr    int数组
     * @param sinkIndex 需要下沉元素的下标
     * @param endIndex  int数组的末尾下标
     */
    private static void sink(int[] intArr, int sinkIndex, int endIndex) {
        //一直下沉到最后
        while (sinkIndex * 2 <= endIndex) {
            //左子节点下标
            int leftChildIndex = sinkIndex * 2;
            //右子节点下标
            int rightChildIndex = leftChildIndex + 1;
            //最大子节点下标
            int maxChildIndex = leftChildIndex;
            if (rightChildIndex <= endIndex && intArr[rightChildIndex] > intArr[leftChildIndex]) {
                maxChildIndex = rightChildIndex;
            }
            //如果当前元素比两个子节点中最大的小，那么该元素下沉（与最大的子节点交换）
            if (intArr[sinkIndex] < intArr[maxChildIndex]) {
                Swapper.swapIntArrayElement(intArr, sinkIndex, maxChildIndex);
            } else {
                //节点无需下沉，结束
                break;
            }
            //继续下沉
            sinkIndex = maxChildIndex;
        }
    }

    public static void main(String[] args) {
        int[] source = {8, 5, 7, 9, 2, 10, 1, 4, 6, 3,-1};
        sortIntArrayAsc(source);
        System.out.println(Arrays.toString(source));
    }
}

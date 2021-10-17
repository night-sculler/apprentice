package com.night.sculler.algorithm.sort;

import java.util.Arrays;

/**
 * @author houlongjie
 * @version 1.0
 * @date 2021/9/27
 */
public class SortPractice {

    private static void sortIntArrayAsc(int[] intArr) {
        int length = intArr.length;
        if (length < 1) {
            return;
        }
        //建大顶堆
        int[] heap = new int[length + 1];
        System.arraycopy(intArr, 0, heap, 1, length);
        //下沉建堆，从最后一个父节点开始
        for (int i = length / 2; i >= 1; i--) {
            sink(heap, i, length);
        }
        //交换排序
        int swapSinkIndex = length;
        while (swapSinkIndex > 1) {
            Swapper.swapIntArrayElement(heap, 1, swapSinkIndex);
            swapSinkIndex--;
            sink(heap, 1, swapSinkIndex);
        }
        System.arraycopy(heap, 1, intArr, 0, length);
    }

    private static void sink(int[] heap, int sinkIndex, int endIndex) {
        while (sinkIndex * 2 <= endIndex) {
            int leftChildIndex = sinkIndex * 2;
            int rightChildIndex = leftChildIndex + 1;
            int maxChildIndex = leftChildIndex;
            if (rightChildIndex <= endIndex && heap[leftChildIndex] < heap[rightChildIndex]) {
                maxChildIndex = rightChildIndex;
            }
            //大顶堆，父节点只要比子节点中的一个小，就要和最大的子节点交换，保证父节点一定比子节点大
            if (heap[sinkIndex] < heap[maxChildIndex]) {
                Swapper.swapIntArrayElement(heap, sinkIndex, maxChildIndex);
            }
            sinkIndex = maxChildIndex;
        }
    }

    public static void main(String[] args) {
        int[] source = {5, 20, 4, 3, 1};
        sortIntArrayAsc(source);
        System.out.println(Arrays.toString(source));
    }
}

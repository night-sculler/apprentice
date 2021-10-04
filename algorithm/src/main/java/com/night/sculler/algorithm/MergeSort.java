package com.night.sculler.algorithm;

import java.util.Arrays;

/**
 * @author houlongjie
 * @version 1.0
 * @date 2021/9/24
 */
public class MergeSort {

    /**
     * 对int数组排序 从小到大
     *
     * @param intArr intArr
     */
    public static void sortIntArray(int[] intArr) {
        mergeSort(intArr, 0, intArr.length - 1);
    }

    /**
     * 递归实现归并排序
     *
     * @param intArr 待排序数组
     * @param left   数组最左index
     * @param right  数组最右index
     */
    private static void mergeSort(int[] intArr, int left, int right) {
        //递归将数组切割到最小，然后从最小粒度开始，归并
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(intArr, left, mid);
            mergeSort(intArr, mid + 1, right);
            merge(intArr, left, mid, right);
        }
    }

    /**
     * 归并
     * <p>
     * 将一个数组从mid截断成两个数组，
     * 从两个数组的第一个元素开始进行比较，
     * 较小的元素放入到一个临时数组中，使临时数组的元素从小到大
     * 没进行过比较的元素直接追加到临时数组末尾
     * 最后将基本排好序的元素覆盖原数组
     *
     * @param intArr int数组
     * @param left   最左index
     * @param mid    中间index
     * @param right  最右index
     */
    private static void merge(int[] intArr, int left, int mid, int right) {
        int[] tmpBigArr = new int[right - left + 1];
        int tmpBigArrIndex = 0;
        int leftSmallArrIndex = left;
        int rightSmallArrIndex = mid + 1;
        while (leftSmallArrIndex <= mid && rightSmallArrIndex <= right) {
            if (intArr[leftSmallArrIndex] <= intArr[rightSmallArrIndex]) {
                tmpBigArr[tmpBigArrIndex++] = intArr[leftSmallArrIndex++];
            } else {
                tmpBigArr[tmpBigArrIndex++] = intArr[rightSmallArrIndex++];
            }
        }
        if (leftSmallArrIndex <= mid) {
            System.arraycopy(intArr, leftSmallArrIndex, tmpBigArr, tmpBigArrIndex, mid - leftSmallArrIndex + 1);
        } else {
            System.arraycopy(intArr, rightSmallArrIndex, tmpBigArr, tmpBigArrIndex, right - rightSmallArrIndex + 1);
        }
        System.arraycopy(tmpBigArr, 0, intArr, left, right - left + 1);
    }


    public static void main(String[] args) {
        int[] source = {5, 2, 4, 3, 1};
        sortIntArray(source);
        System.out.println(Arrays.toString(source));
    }
}

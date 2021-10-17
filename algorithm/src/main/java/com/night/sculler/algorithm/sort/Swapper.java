package com.night.sculler.algorithm.sort;

/**
 *
 * @author houlongjie
 * @version 1.0
 * @date 2021/9/18
 */
public class Swapper {

    /**
     * 交换int数组两个元素
     *
     * @param intArray    intArray
     * @param firstIndex  firstIndex
     * @param secondIndex secondIndex
     */
    public static void swapIntArrayElement(int[] intArray, int firstIndex, int secondIndex) {
        int length = intArray.length;
        if (firstIndex < 0 || firstIndex >= length) {
            throw new RuntimeException("下标越界了 firstIndex=" + firstIndex);
        }
        if (secondIndex < 0 || secondIndex >= length) {
            throw new RuntimeException("下标越界了 secondIndex=" + firstIndex);
        }
        int temp = intArray[firstIndex];
        intArray[firstIndex] = intArray[secondIndex];
        intArray[secondIndex] = temp;
    }
}

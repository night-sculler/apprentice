package com.night.sculler.algorithm;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author houlongjie
 * @version 1.0
 * @date 2021/10/8
 */
public class CountingSort {
    public static void sortIntArrayAsc(int[] intArr) {
        int length = intArr.length;
        if (length <= 1) {
            return;
        }

        //求出数组的最小最大值
        int min = intArr[0];
        int max = intArr[0];
        for (int element : intArr) {
            if (element < min) {
                min = element;
            }
            if (element > max) {
                max = element;
            }
        }

        //计数数组
        int[] numCountArr = new int[max - min + 1];
        //统计原数组中每个元素的个数，其元素减去偏移量作为计数数组的下标，个数作为计数数组的元素
        //切记计数数组的下标是原数组元素减去偏移量得到的，偏移量为原数组的最小值
        for (int element : intArr) {
            numCountArr[element - min]++;
        }
        //前缀数组(将计数数组当前缀数组使用，节省空间)
        for (int i = 1; i < numCountArr.length; i++) {
            numCountArr[i] = numCountArr[i] + numCountArr[i - 1];
        }

        //零时排序数组
        int[] tmpArr = new int[length];
        //遍历原数组，用原数组中的元素作为下标，到前缀数组中取数，这个数就是该元素在排序数组中对应的顺序
        for (int i = length - 1; i >= 0; i--) {
            int element = intArr[i];
            int tmpArrIndex = numCountArr[element - min] - 1;
            tmpArr[tmpArrIndex] = element;
        }
        //将有序元素copy到原数组
        System.arraycopy(tmpArr, 0, intArr, 0, length);
    }

    public static void main(String[] args) {
        int[] source = {5, 20, 4, 3, 1};
        sortIntArrayAsc(source);
        System.out.println(Arrays.toString(source));
    }
}

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
        int length = intArr.length;
        if (length <= 1) {
            return;
        }
        //求出最大最小元素
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
        //计数数组，统计原数组中每个元素存在多少个(做了偏移处理，偏移量为原数组的最小元素)
        //原数组中的元素减去偏移量，作为计数数组的下标，原数组元素个数作为计数数组的元素
        int[] countNumArr = new int[max - min + 1];
        for (int element : intArr) {
            countNumArr[element - min]++;
        }
        //前缀和数组，统计原数组中某个元素及其前面的元素总共多少个
        for (int i = 1; i < countNumArr.length; i++) {
            countNumArr[i] = countNumArr[i] + countNumArr[i - 1];
        }
        //零时排序数组
        int[] tmpSortArr = new int[length];
        //从后往前取出原数组中的元素
        //作为前缀和数组的下标
        //取出前缀和数组对应的元素
        //该元素值就是原数组元素对应零时排序数组的位置
        for (int i = length - 1; i >= 0; i--) {
            int element = intArr[i];
            int tmpSortArrIndex = countNumArr[element - min]-1;
            tmpSortArr[tmpSortArrIndex] = element;
        }
        System.arraycopy(tmpSortArr,0,intArr,0,length);
    }

    public static void main(String[] args) {
        int[] source = {5, 20, 4, 3, 1};
        sortIntArrayAsc(source);
        System.out.println(Arrays.toString(source));
    }
}

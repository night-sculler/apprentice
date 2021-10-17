package com.night.sculler.algorithm.match;

/**
 * BF自负匹配算法
 *
 * @author night-sculler
 * @version 1.0.0.release
 * @date 2021/10/17
 */
public class BfStringMatch {
    /**
     * 在原字符串中匹配目标字符串并返回第一次匹配到时首字母对应的下标
     *
     * @param source 原数组
     * @param target 目标数组
     * @return 第一次匹配到时首字母对应的下标
     */
    public static int match(String source, String target) {
        if (null == source || null == target) {
            return 0;
        }
        int sLen = source.length();
        int tLen = target.length();
        if (sLen < tLen) {
            return -1;
        }
        //按顺序将目标字符串中的字符和原数组进行匹配，匹配到了就接着匹配，匹配不到重新开始和原字符串的下一个字符匹配
        for (int i = 0; i < sLen - tLen + 1; i++) {
            int j;
            for (j = 0; j < tLen; j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == tLen) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int match = match("hello", "ll");
        System.out.println(match);
    }
}

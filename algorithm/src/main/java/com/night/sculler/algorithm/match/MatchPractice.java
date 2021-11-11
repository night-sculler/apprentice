package com.night.sculler.algorithm.match;

/**
 * @author houlongjie
 * @version 1.0
 * @date 2021/10/22
 */
public class MatchPractice {

    public static int match(String source, String target) {
        if (null == source || null == target) {
            return 0;
        }
        int sLen = source.length();
        int tLen = target.length();
        if (tLen > sLen) {
            return -1;
        }
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
        int match = match("hello", "lo");
        System.out.println(match);
    }
}

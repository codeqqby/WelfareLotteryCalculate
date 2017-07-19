package com.itbeezh.lottery.welfare.utils;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by szwb004 on 2017-06-29.
 */
public class FcDataUtil {
    /**
     * 获取两组号码相似度
     * @param numArrayA
     * @param numArrayB
     * @return
     */
    public static long getTwoNumSimilar(String[] numArrayA, String[] numArrayB){
        return Arrays.asList(numArrayA).stream().filter(str -> Arrays.asList(numArrayB).contains(str)).count();
    }

    /**
     * 分析指定号码的各项比例
     * 大小比，区间比，奇偶比,大小差
     * @param numArrayA
     * @return
     */
    public static String getNumAnalysisData(String[] numArrayA){
        long small =  Arrays.asList(numArrayA).stream().filter(str -> Integer.valueOf(str) < 18).count();
        long big =  Arrays.asList(numArrayA).stream().filter(str -> Integer.valueOf(str) >= 18).count();
        long before = Arrays.asList(numArrayA).stream().filter(str -> Integer.valueOf(str) >= 1 && Integer.valueOf(str) <= 11).count();
        long mid = Arrays.asList(numArrayA).stream().filter(str -> Integer.valueOf(str) >= 12 && Integer.valueOf(str) <= 22).count();
        long after = Arrays.asList(numArrayA).stream().filter(str -> Integer.valueOf(str) >= 23 && Integer.valueOf(str) <= 33).count();
        long odd = Arrays.asList(numArrayA).stream().filter(str -> Integer.valueOf(str) % 2 == 1).count();
        long even = Arrays.asList(numArrayA).stream().filter(str -> Integer.valueOf(str) % 2 == 0).count();
        long gapMinAndMax = Integer.valueOf(numArrayA[5]) - Integer.valueOf(numArrayA[0]);
        return new StringJoiner(" ").add(String.valueOf(small))
                .add(String.valueOf(big)).add(String.valueOf(before))
                .add(String.valueOf(mid)).add(String.valueOf(after))
                .add(String.valueOf(odd)).add(String.valueOf(even))
                .add(String.valueOf(gapMinAndMax)).add(getGapWithTwoBall(numArrayA)).toString();
    }

    public static String[] getSortNum(String[] numArrayA){
        List<String> arrayList = Arrays.asList(numArrayA);
        arrayList.sort((String arg0,String arg1) ->{
            return (Integer.valueOf(arg0) <= Integer.valueOf(arg1)) ? -1 : 1;
        });
        return (String[]) arrayList.toArray();
    }

    private static String getGapWithTwoBall(String[] numArrayA){
        StringJoiner stringJoiner = new StringJoiner(":");
        stringJoiner.add(String.valueOf(Integer.valueOf(numArrayA[1]) - Integer.valueOf(numArrayA[0])));
        stringJoiner.add(String.valueOf(Integer.valueOf(numArrayA[2]) - Integer.valueOf(numArrayA[1])));
        stringJoiner.add(String.valueOf(Integer.valueOf(numArrayA[3]) - Integer.valueOf(numArrayA[2])));
        stringJoiner.add(String.valueOf(Integer.valueOf(numArrayA[4]) - Integer.valueOf(numArrayA[3])));
        stringJoiner.add(String.valueOf(Integer.valueOf(numArrayA[5]) - Integer.valueOf(numArrayA[4])));
        return stringJoiner.toString();
    }
}

package com.itbeezh.lottery.welfare.utils;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * Created by szwb004 on 2017-06-29.
 */
public class FcDataHistoryAnalysis {

    /**
     * 分析指定年份历史数据进行分析，并保存分析结果
     * @param year
     */
    public static void analysisHistoryData(String year){
        String historyTxtPath = "data/history/"+year+".txt";
        String analysisTxtPath = "data/analysis/"+year+".txt";
        try {
            Map<String,String> analysis = new HashMap<>();
            Files.deleteIfExists(Paths.get(analysisTxtPath));
            Files.createFile(Paths.get(analysisTxtPath));
            Files.lines(Paths.get(historyTxtPath), StandardCharsets.UTF_8)
                    .forEach((str) -> {
                        String[] strArray = str.replaceAll("\\s+", " ").split(" ");
                        String result = strArray[0] + "     " + analysisData(strArray[1]) ;
                        try {
                            Files.write(Paths.get(analysisTxtPath), Arrays.asList(result), StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String analysisData(String original){
        original = getSortedNum(original);
        return   original + "    " + FcDataUtil.getNumAnalysisData(original.split("\\|")[0].split(","));
    }

    public static String getSortedNum (String original){
        String[] numArray = original.split("\\|");
        String[] sortRed = FcDataUtil.getSortNum(numArray[0].split(","));
        StringJoiner stringJoiner = new StringJoiner(",");
        Arrays.asList(sortRed).forEach((s) -> stringJoiner.add(s));
        return stringJoiner.toString() + "|" + numArray[1];
    }
}

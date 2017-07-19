package com.itbeezh.lottery.welfare.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by szwb004 on 2017-06-30.
 */
public class FcDataEnumAnalysis {

    /**
     * 枚举所有可能组合
     */
    public static void generateLevel0(){
        generateLevel0ByThread("0.txt",1,2,2,10);
        generateLevel0ByThread("1.txt",1,2,10,30);
        generateLevel0ByThread("2.txt",2,4,3,30);
        generateLevel0ByThread("3.txt",4,8,5,30);
        generateLevel0ByThread("4.txt",8,16,9,30);
        generateLevel0ByThread("5.txt",16,29,17,30);
    }
    private static void generateLevel0ByThread(String fileName,int initR1,int maxR1,int initR2,int maxR2){
        String dirPath = "data/analysis/level0/";
        new Thread(() -> {
            String filePath = dirPath + fileName;
            try {
                Files.deleteIfExists(Paths.get(filePath));
                Files.createFile(Paths.get(filePath));
                List<String> stringList = new ArrayList<String>();
                for (int r1 = initR1 ;r1 <maxR1 ; r1 ++ ){
                    int r2 = initR2;
                    if(r2<=r1){
                        r2 = r1 +1;
                    }
                    for (; r2< maxR2 ;r2++){
                        for (int r3 = r2+1; r3 < 31;r3++){
                            for (int r4 = r3 +1;r4<32;r4++){
                                for (int r5 = r4+1;r5<33;r5++){
                                    for (int r6 = r5+1;r6<34;r6++){
                                        String string = new StringJoiner(",")
                                                .add(String.format("%02d", r1))
                                                .add(String.format("%02d", r2))
                                                .add(String.format("%02d", r3))
                                                .add(String.format("%02d", r4))
                                                .add(String.format("%02d", r5))
                                                .add(String.format("%02d", r6)).toString();
                                        stringList.add(string+ "    "+FcDataUtil.getNumAnalysisData(string.split(",")));
                                    }
                                }
                            }
                        }
                    }
                }
                Files.write(Paths.get(filePath),stringList, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();;
    }

    public static void generateLevel1() throws IOException {
        String baseDirPath = "data/analysis/level0/";
        String genDirPath = "data/analysis/level1/";
        for (int i = 0 ; i < 6 ; i++){
            Files.write(Paths.get(genDirPath + i + ".txt"),
                Files.lines(Paths.get(baseDirPath + i +".txt"), StandardCharsets.UTF_8).filter((str) -> {
                    return Integer.valueOf(str.replaceAll("\\s+", " ").split(" ")[4]) > 10;
                }).collect(Collectors.toList()),StandardCharsets.UTF_8,StandardOpenOption.CREATE);
        }
    }

    public static void generateLevel(int level,int year) throws IOException {
        String baseDirPath = "data/analysis/level"+(level-1)+"/";
        String genDirPath = "data/analysis/level"+level+"/";
        for (int i = 0 ; i < 6 ; i++){
            Files.write(Paths.get(genDirPath + i + ".txt"),
                    Files.lines(Paths.get(baseDirPath + i +".txt"), StandardCharsets.UTF_8).filter((str) -> {
                        try {
                            return Files.lines(Paths.get("data/analysis/"+year+".txt")).allMatch((history) ->{
                                return FcDataUtil.getTwoNumSimilar(str.replaceAll("\\s+", " ").split(" ")[0].split(","),
                                        history.replaceAll("\\s+", " ").split(" ")[1].split("\\|")[0].split(",")) < 5;
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                            return false;
                        }
                    }).collect(Collectors.toList()),StandardCharsets.UTF_8,StandardOpenOption.CREATE);
        }
    }
}

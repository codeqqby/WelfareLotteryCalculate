package com.itbeezh.lottery.welfare.service.impl;

import com.itbeezh.lottery.welfare.entity.DCHistoryData;
import com.itbeezh.lottery.welfare.repository.DCHistoryDataRepository;
import com.itbeezh.lottery.welfare.service.DCHistoryAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

/**
 * Created by szwb004 on 2017-07-10.
 */
@Service
public class DCHistoryAnalysisServiceImpl implements DCHistoryAnalysisService {

    @Autowired
    DCHistoryDataRepository dcHistoryDataRepository;

    @Override
    public void analysisHistoryData(String year) throws Exception {
        File historyFile = ResourceUtils.getFile("classpath:history/"+year+".txt");
        Files.lines(historyFile.toPath(), StandardCharsets.UTF_8)
                .forEach((str) -> {
                    dcHistoryDataRepository.save(generateDCHistoryData(str));
                });

    }

    @Override
    public void analysisHistoryData(String serialNo, String balls, String kjDate) {

    }

    private DCHistoryData generateDCHistoryData(String historyDataStr){
        DCHistoryData dcHistoryData = new DCHistoryData();
        String[] strArray = historyDataStr.replaceAll("\\s+", " ").split(" ");
        dcHistoryData.setDcHistorySerialNo(strArray[0]);
        String[] balls = strArray[1].split("\\|");
        String[] reds = balls[0].split(",");
        List<String> arrayList = Arrays.asList(reds);
        arrayList.sort((String arg0, String arg1) ->{
            return (Integer.valueOf(arg0) <= Integer.valueOf(arg1)) ? -1 : 1;
        });
        String[] sortReds = (String[])arrayList.toArray();
        dcHistoryData.setDcRed1(Integer.valueOf(sortReds[0]));
        dcHistoryData.setDcRed2(Integer.valueOf(sortReds[1]));
        dcHistoryData.setDcRed3(Integer.valueOf(sortReds[2]));
        dcHistoryData.setDcRed4(Integer.valueOf(sortReds[3]));
        dcHistoryData.setDcRed5(Integer.valueOf(sortReds[4]));
        dcHistoryData.setDcRed6(Integer.valueOf(sortReds[5]));
        dcHistoryData.setDcBlue(Integer.valueOf(balls[1]));
        dcHistoryData.setDcKjDate(strArray[2]);
        dcHistoryData.setDcSmall((int)Arrays.asList(sortReds).stream().filter(str -> Integer.valueOf(str) < 18).count());
        dcHistoryData.setDcBig((int)Arrays.asList(sortReds).stream().filter(str -> Integer.valueOf(str) >= 18).count());
        dcHistoryData.setDcBefore((int)Arrays.asList(sortReds).stream().filter(str -> Integer.valueOf(str) >= 1 && Integer.valueOf(str) <= 11).count());
        dcHistoryData.setDcMid((int)Arrays.asList(sortReds).stream().filter(str -> Integer.valueOf(str) >= 12 && Integer.valueOf(str) <= 22).count());
        dcHistoryData.setDcAfter((int)Arrays.asList(sortReds).stream().filter(str -> Integer.valueOf(str) >= 23 && Integer.valueOf(str) <= 33).count());
        dcHistoryData.setDcOdd((int)Arrays.asList(sortReds).stream().filter(str -> Integer.valueOf(str) % 2 == 1).count());
        dcHistoryData.setDcEven((int)Arrays.asList(sortReds).stream().filter(str -> Integer.valueOf(str) % 2 == 0).count());
        dcHistoryData.setDcGap1(Integer.valueOf(sortReds[1]) - Integer.valueOf(sortReds[0]));
        dcHistoryData.setDcGap2(Integer.valueOf(sortReds[2]) - Integer.valueOf(sortReds[1]));
        dcHistoryData.setDcGap3(Integer.valueOf(sortReds[3]) - Integer.valueOf(sortReds[2]));
        dcHistoryData.setDcGap4(Integer.valueOf(sortReds[4]) - Integer.valueOf(sortReds[3]));
        dcHistoryData.setDcGap5(Integer.valueOf(sortReds[5]) - Integer.valueOf(sortReds[4]));
        return dcHistoryData;
    }


    public DCHistoryDataRepository getDcHistoryDataRepository() {
        return dcHistoryDataRepository;
    }

    public void setDcHistoryDataRepository(DCHistoryDataRepository dcHistoryDataRepository) {
        this.dcHistoryDataRepository = dcHistoryDataRepository;
    }
}

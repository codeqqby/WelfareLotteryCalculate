package com.itbeezh.lottery.welfare.service;

/**
 * Created by szwb004 on 2017-07-10.
 */
public interface DCHistoryAnalysisService {
    void analysisHistoryData(String year) throws Exception ;
    void analysisHistoryData(String serialNo,String balls,String kjDate);

}

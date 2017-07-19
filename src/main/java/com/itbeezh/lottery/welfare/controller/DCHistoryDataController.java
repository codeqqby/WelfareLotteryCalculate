package com.itbeezh.lottery.welfare.controller;

import com.itbeezh.lottery.welfare.service.DCHistoryAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by szwb004 on 2017-07-11.
 */
@RestController
@RequestMapping("/history")
public class DCHistoryDataController {
    public DCHistoryAnalysisService getDcHistoryAnalysisService() {
        return dcHistoryAnalysisService;
    }

    public void setDcHistoryAnalysisService(DCHistoryAnalysisService dcHistoryAnalysisService) {
        this.dcHistoryAnalysisService = dcHistoryAnalysisService;
    }

    @Autowired
    DCHistoryAnalysisService dcHistoryAnalysisService;

    @RequestMapping("/generate/{year}")
    public String generateHistoryData(@PathVariable String year){
        try {
            dcHistoryAnalysisService.analysisHistoryData(year);
        } catch (Exception e) {
            return "{0:'"+e.getMessage()+"'}";
        }
        return "{1:'success'}";
    }
}

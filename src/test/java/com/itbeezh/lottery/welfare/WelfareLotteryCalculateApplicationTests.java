package com.itbeezh.lottery.welfare;

import com.itbeezh.lottery.welfare.service.DCHistoryAnalysisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WelfareLotteryCalculateApplicationTests {

	public DCHistoryAnalysisService getDcHistoryAnalysisService() {
		return dcHistoryAnalysisService;
	}

	public void setDcHistoryAnalysisService(DCHistoryAnalysisService dcHistoryAnalysisService) {
		this.dcHistoryAnalysisService = dcHistoryAnalysisService;
	}

	@Autowired
	DCHistoryAnalysisService dcHistoryAnalysisService;
	@Test
	public void contextLoads() {
		try {
			dcHistoryAnalysisService.analysisHistoryData("2017");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

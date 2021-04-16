package com.aa.awesomecareer.controller;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aa.awesomecareer.service.ApplicationService;

@RestController
public class HighChartController {
	
	@Autowired
	ApplicationService applicationService;
	
	@GetMapping("/get-data")
//	@ResponseBody
    public ResponseEntity<Map<String, Long>> getPieChart() {
		System.out.println("Xem vao controller chua");
        Map<String, Long> graphData = new TreeMap<>();
        graphData.put("1",applicationService.countApplicantByTime(1, 2021));
        graphData.put("2",applicationService.countApplicantByTime(2, 2021));
        graphData.put("3",applicationService.countApplicantByTime(3, 2021));
        graphData.put("4",applicationService.countApplicantByTime(4, 2021));
        graphData.put("5",applicationService.countApplicantByTime(5, 2021));
        graphData.put("6",applicationService.countApplicantByTime(6, 2021));
        graphData.put("7",applicationService.countApplicantByTime(7, 2021));
        return new ResponseEntity<>(graphData, HttpStatus.OK);
    }

}

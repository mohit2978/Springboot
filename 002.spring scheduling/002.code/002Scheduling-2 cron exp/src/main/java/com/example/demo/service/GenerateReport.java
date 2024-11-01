package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class GenerateReport {
	@Scheduled(cron="0/20 * * * * *" )
	public void showReport() {
		System.out.println("report on "+new Date());
	}
}

package com.mypoc.poc_flexible_constructor_bodies;

import com.mypoc.poc_flexible_constructor_bodies.dto.FraudAnalysisRequest;
import com.mypoc.poc_flexible_constructor_bodies.service.FraudAnalysisService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class PocFlexibleConstructorBodiesApplication {

	public static void main(String[] args) {

		var request =
				new FraudAnalysisRequest(
						"123.456.789-01-XXX",
						"Icaro Caetano  ",
						"mobile",
						"98.7",
						"96.5"
				);

		new FraudAnalysisService().analyze(request);
	}

}

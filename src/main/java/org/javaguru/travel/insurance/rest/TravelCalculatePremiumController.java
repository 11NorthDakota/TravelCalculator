package org.javaguru.travel.insurance.rest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.core.service.TravelCalculatePremiumService;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumResponse;
import org.javaguru.travel.insurance.rest.logger.TravelCalculatePremiumLogger;
import org.javaguru.travel.insurance.rest.logger.TravelCalculatePremiumRequestExecutionTimeLogger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance/travel")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TravelCalculatePremiumController {

	private final TravelCalculatePremiumLogger logger;
	private final TravelCalculatePremiumRequestExecutionTimeLogger loggerTime;

	private final TravelCalculatePremiumService calculatePremiumService;

	@PostMapping(path = "/",
			consumes = "application/json",
			produces = "application/json")
	public TravelCalculatePremiumResponse calculatePremium(@RequestBody TravelCalculatePremiumRequest request) {
		logger.log(request,"REQUEST");



		long startTime = System.currentTimeMillis();
		TravelCalculatePremiumResponse response = calculatePremiumService.calculatePremium(request);
		long endTime = System.currentTimeMillis();

		logger.log(response,"RESPONSE");
		loggerTime.log(startTime,endTime);

		return response;
	}

}
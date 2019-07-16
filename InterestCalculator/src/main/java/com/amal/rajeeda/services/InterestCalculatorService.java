package com.amal.rajeeda.services;

import java.util.List;

import com.amal.rajeeda.model.InterestCalculator;

public interface InterestCalculatorService {
	
	List<InterestCalculator> findAllValues();
	void update(List<InterestCalculator> calculator);
}

package com.amal.rajeeda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amal.rajeeda.dao.InterestCalculatorRepo;
import com.amal.rajeeda.model.InterestCalculator;

@Service
public class InterestCalculatorServicesImpl implements InterestCalculatorService {
	
	@Autowired
	InterestCalculatorRepo calculatorRepo;
	
	@Override
	public List<InterestCalculator> findAllValues() {

		List<InterestCalculator> ictList = null;
		try {
			ictList = calculatorRepo.findAll();
		} catch (Exception e) {
			System.out.println("error in fetching data- Please check the DB");
		}
		return ictList;
	}

	@Override
	public void update(List<InterestCalculator> calculator) {
		
		System.out.println("inside save services ");
		calculatorRepo.saveAll(calculator);
		
	}

	

}

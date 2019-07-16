package com.amal.rajeeda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.amal.rajeeda.dao.InterestCalculatorRepo;
import com.amal.rajeeda.model.InterestCalculator;
import com.amal.rajeeda.services.InterestCalculatorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterestCalculatorServiceTest {

	@Autowired
	private InterestCalculatorService ictServices;

	@MockBean
	private InterestCalculatorRepo ictRepo;

	@Test
	public void getInterestCalculatorTest() {

		ArrayList<InterestCalculator> ictList = new ArrayList<InterestCalculator>();

		InterestCalculator ict = getIctData(1, 101, 40.3, 58.5, 0);
		InterestCalculator ict1 = getIctData(1, 102, 60.3, 518.5, 0);

		ictList.add(ict);
		ictList.add(ict1);

		when(ictRepo.findAll()).thenReturn(Stream.of(ict, ict1).collect(Collectors.toList()));

		assertEquals(ictList.size(), ictServices.findAllValues().size());
	}
	
	@Test
	public void interestUpdateTest() {
		
		ArrayList<InterestCalculator> ictList = new ArrayList<InterestCalculator>();
		InterestCalculator ict = getIctData(1, 101, 40.3, 58.5, 0);
		InterestCalculator ict1 = getIctData(1, 102, 60.3, 518.5, 0);
		ictList.add(ict);
		ictList.add(ict1);
		
		
		assertNotNull(ictList);
		ictServices.update(ictList);
		
	}

	private InterestCalculator getIctData(int id, int accountNo, double balance, double interestRate, double interest) {

		InterestCalculator ict = new InterestCalculator();
		ict.setId(1);
		ict.setAccountNo(101);
		ict.setBalance(40.3);
		ict.setInterestRate(58.5);
		ict.setInterest(0);

		return ict;

	}

}

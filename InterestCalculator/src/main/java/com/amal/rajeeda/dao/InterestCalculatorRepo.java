package com.amal.rajeeda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amal.rajeeda.model.InterestCalculator;

public interface InterestCalculatorRepo  extends JpaRepository<InterestCalculator, Integer> {

}

package com.endava.jbehave.test;



import org.junit.Test;

import org.junit.runner.RunWith;

import com.endava.jbehave.steps.IncreaseSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class IncreaseTest {


	    @Steps
	    IncreaseSteps increaseSteps;

	   
	    @Test
	    public void TheCounterIsIncreased() {
	    	//Given
	        increaseSteps.counterHasAnyIntegralValue();
	        //When
	    	increaseSteps.increasesTheCounter();
	    	//Then
	        increaseSteps.theValueOfTheCounterMustBe1Greater();
	    }
	
}



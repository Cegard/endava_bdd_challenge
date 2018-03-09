package com.endava.jbehave.steps;

import static org.junit.Assert.assertTrue;


import java.util.Random;



import net.thucydides.core.annotations.Step;

public class IncreaseSteps {
	private int counter;
	private int previousValue;



	@Step("Given the counter has any integral value")
	public void counterHasAnyIntegralValue() {
		counter = new Random().nextInt(5);
		previousValue = counter;
	}

	@Step("When the user increases the counter")
	public void increasesTheCounter() {
		counter++;
	}

	@Step("Then the value of the counter must be 1 greater than previous value")
	public void theValueOfTheCounterMustBe1Greater() {
		assertTrue(counter - previousValue == 1);
	}
}

package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		} else {
			return a + b;
		}		
	}
	
	public double divide(int a, int b) {		// This is a simple method that takes two integers and divides them
		if (b == 0) {							// Runs a check to ensure we are not dividing by zero
			throw new IllegalArgumentException("Cannot divide by zero");		// If we are dividing by zero, this throws an error with our message
		}
		
		return (double) a / b;	 				// The method divides our a value by the b value and returns the result
	}
	
	public int randomNumberSquared() {
		int randomInt = getRandomInt();
		return randomInt * randomInt;
	}
	
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
}
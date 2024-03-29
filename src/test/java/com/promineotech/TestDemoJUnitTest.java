package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
		
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		// Given: two integers 

		// When: they are both positive integers 
		
		// Then: they are added together and return the sum
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
		
		assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);	
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				Arguments.of(2, 3, 5, false),
				Arguments.of(0, 0, 0, false),
				Arguments.of(6, 6, 12, false),
				Arguments.of(-1, 2, 1, true)
			);
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(-3, 4)).isEqualTo(1);
	}
	
	@Test
	void assertThatTwoIntegersAreDividedCorrectly() {		// I used the @Test annotation and ran the tests with assertThat. I gave two values and their expected result
		assertThat(testDemo.divide(8, 2)).isEqualTo(4);		
		assertThat(testDemo.divide(6, 3)).isEqualTo(2);
		assertThat(testDemo.divide(3, 0)).isEqualTo(0);		// I made sure to add a test case that divided by zero to check if our error message is thrown correctly
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
}

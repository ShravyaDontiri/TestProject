package utils;

import java.util.Random;

public class VariableUtils {

	public int getRandomNumber() {
		int digits = 10; // Number of digits in the random number
		int min = (int) Math.pow(10, digits - 1); // Minimum value
		int max = (int) Math.pow(10, digits) - 1; // Maximum value

		Random randomNum = new Random();
		int randomNumber = randomNum.nextInt(max - min + 1) + min; // Generates a random number within the specified
																	// range
		System.out.println("Random Number: " + randomNumber);
		return randomNumber;

	}

}

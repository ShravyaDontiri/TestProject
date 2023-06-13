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

	public int getContactNumber() {
		int digits = 8; // Number of digits in the random number
		int min = (int) Math.pow(10, digits - 1); // Minimum value
		int max = (int) Math.pow(10, digits) - 1; // Maximum value

		Random randomNum = new Random();
		int contactNumber = randomNum.nextInt(max - min + 1) + min; // Generates a random number within the specified
																	// range
		System.out.println("Random Number: " + contactNumber);
		return contactNumber;

	}

	public int getPassport() {
		int digits = 4; // Number of digits in the random number
		int min = (int) Math.pow(10, digits - 1); // Minimum value
		int max = (int) Math.pow(10, digits) - 1; // Maximum value

		Random randomNum = new Random();
		int passport = randomNum.nextInt(max - min + 1) + min; // Generates a random number within the specified
																// range
		System.out.println("Random Number: " + passport);
		return passport;

	}

}

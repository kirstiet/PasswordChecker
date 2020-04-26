import java.util.Scanner;

public class PasswordChecker{
	
	public static void main(String[] args) {
		boolean passwordPassesCheck = false;

		System.out.println("Hello, world! This is a password checker!"
			+ "\nEnter a password!");
		String firstUserInput = userInput();
		System.out.println("Enter a second password!");
		String secondUserInput = userInput();

		boolean isFirstInputEmpty = checkEmptyInput(firstUserInput);
		boolean isSecondInputEmpty = checkEmptyInput(secondUserInput);

		while(isFirstInputEmpty == true || isSecondInputEmpty == true) {
			System.out.println("Passwords cannot be empty!" + "\nEnter a password again!");
			isFirstInputEmpty = checkEmptyInput(firstUserInput);
			System.out.println("Enter a second password again!");
			isSecondInputEmpty = checkEmptyInput(secondUserInput);

		}

		boolean inputPasswordMatches = verifyPasswordInput(firstUserInput, secondUserInput);
		while(inputPasswordMatches == false) {
			System.out.println("Try again." + "\nEnter a password!");
			firstUserInput = userInput();

			System.out.println("Please type in your password again.");
			secondUserInput = userInput();
			inputPasswordMatches = verifyPasswordInput(firstUserInput, secondUserInput);


		}

		if(passwordValidator(firstUserInput) == true){
			System.out.println("New password created.");

		} else {
			System.out.println("Password failed check.");

		}

	}

	public static String userInput() {
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		return userInput;

	}


	public static boolean checkEmptyInput(String firstUserInput) {
		boolean isEmpty = false;

		if(firstUserInput.equals("")) {
			isEmpty = true;

		} else {
			isEmpty = false;

		}

		return isEmpty;

	}


	public static boolean verifyPasswordInput(String firstUserInput, String secondUserInput) {
		boolean inputsAreEquivalent = false;

		if(firstUserInput.equals(secondUserInput)) {
			System.out.println("\nPasswords match."); 
			inputsAreEquivalent = true;

		} else {
			System.out.println("\nPasswords do not match.");
			inputsAreEquivalent = false;

		}

		return inputsAreEquivalent;

	}


	public static boolean passwordValidator(String userInput) {
		boolean passwordPassesCheck, passwordContainsProperLength, passwordContainsLowercase, passwordContainsUppercase, passwordContainsNumber, passwordContainsSpecial = false;

		if(userInput.length() >= 8) {
			passwordContainsProperLength = true;

		} else {
			System.out.println("Password is not the proper length.");
			passwordContainsProperLength = false;

		}

		if(userInput.matches(".*[a-z].*")) {
			passwordContainsLowercase = true;

		} else {
			System.out.println("Password does not contain a lowercase character.");
			passwordContainsLowercase = false;

		}

		if(userInput.matches(".*[A-Z].*")) {
			passwordContainsUppercase = true;

		} else {
			System.out.println("Password does not contain an uppercase character.");
			passwordContainsUppercase = false;

		}

		if(userInput.matches(".*\\d.*")) {
			passwordContainsNumber = true;

		} else {
			System.out.println("Password does not contain a number.");
			passwordContainsNumber = false;

		}

		if(userInput.matches(".*\\W.*")) {
			passwordContainsSpecial = true;

		} else {
			System.out.println("Password does not contain a special character.");
			passwordContainsSpecial = false;

		}

		if(passwordContainsProperLength == true && passwordContainsLowercase == true && passwordContainsUppercase == true && passwordContainsNumber == true && passwordContainsSpecial == true) {
			System.out.println("Password meets the requirements.");
			passwordPassesCheck = true;

		} else {
			System.out.println("Password does not meet the requirements. Invalid.");
			passwordPassesCheck = false;

		}

		return passwordPassesCheck;

	}

}
package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserInputValidator {

	private static ArrayList<Integer> numberList = new ArrayList<>();
	private static final String REGULAR_NUMBER_EXPRESSION = "[1-9]+";
	private static final int NUMBER_LENGTH = 3;

	public static ArrayList<Integer> getUserNumberList() {
		return numberList;
	}

	public static boolean saveUserNumberList(String userInput) {
		numberList.clear();
		if (!checkUserInputValidation(userInput)) {
			return false;
		}
		addUserInputToList(userInput);
		return true;
	}

	private static void addUserInputToList(String userInput) {
		for (char c : userInput.toCharArray()) {
			numberList.add(Integer.parseInt(String.valueOf(c)));
		}
	}

	private static boolean checkUserInputValidation(String userInput) {
		return checkNumberIsNull(userInput) && checkNumberHasOtherCharacter(userInput)
				&& checkNumberLength(userInput) && checkNumberDuplicated(userInput);
	}

	private static boolean checkNumberIsNull(String userInput) {
		return userInput != null;
	}

	private static boolean checkNumberDuplicated(String userInput) {
		Set<Character> numbers = new HashSet<>();
		for (char c : userInput.toCharArray()) {
			numbers.add(c);
		}

		return numbers.size() == NUMBER_LENGTH;
	}

	private static boolean checkNumberHasOtherCharacter(String userInput) {
		return userInput.matches(REGULAR_NUMBER_EXPRESSION);
	}

	private static boolean checkNumberLength(String userInput) {
		return userInput.length() == NUMBER_LENGTH;
	}

}

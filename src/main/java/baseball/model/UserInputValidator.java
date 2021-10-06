package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserInputValidator {

	private static ArrayList<Integer> numberList = new ArrayList<>();
	private static int restartFlag;
	private static final String REGULAR_NUMBER_EXPRESSION = "[1-9]+";
	private static final String REGULAR_RESTART_EXPRESSION = "[1-2]+";
	private static final int NUMBER_LENGTH = 3;
	private static final int RESTART_INPUT_LENGTH = 1;

	public static ArrayList<Integer> getUserNumberList() {
		return numberList;
	}

	public static int getRestartFlag() {
		return restartFlag;
	}

	public static boolean saveUserNumberList(String userInput) {
		numberList.clear();
		if (!validateUserNumber(userInput)) {
			return false;
		}
		addUserNumberToList(userInput);
		return true;
	}

	public static boolean saveRestartFlagFromUser(String userInput) {
		if (!validateRestartInput(userInput)) {
			return false;
		}
		restartFlag = Integer.parseInt(userInput);
		return true;
	}

	private static void addUserNumberToList(String userInput) {
		for (char c : userInput.toCharArray()) {
			numberList.add(Integer.parseInt(String.valueOf(c)));
		}
	}

	private static boolean validateUserNumber(String userInput) {
		return checkNumberIsNull(userInput) && checkNumberHasOtherCharacter(userInput)
				&& checkNumberLength(userInput) && checkNumberDuplicated(userInput);
	}

	private static boolean validateRestartInput(String userInput) {
		return checkRestartLength(userInput) && checkRestartHasOtherCharacter(userInput);
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

	private static boolean checkRestartHasOtherCharacter(String userInput) {
		return userInput.matches(REGULAR_RESTART_EXPRESSION);
	}

	private static boolean checkRestartLength(String userInput) {
		return userInput.length() == RESTART_INPUT_LENGTH;
	}
}

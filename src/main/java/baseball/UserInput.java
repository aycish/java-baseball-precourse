package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import nextstep.utils.Console;

public class UserInput {

	private static ArrayList<Integer> numberList = new ArrayList<>();
	private static final String REG_EXPRESSION = "[1-9]+";
	private static final int NUMBER_LENGTH = 3;

	public static ArrayList<Integer> getUserNumberList() {
		return numberList;
	}

	public static boolean getUserInput() {
		String userInput = Console.readLine();
		numberList.clear();

		if (checkUserInputValidation(userInput) == false) {
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
		return checkUserInputIsNull(userInput) && checkOtherCharacter(userInput)
			&& checkInputLength(userInput) && checkDuplicatedNumber(userInput);
	}

	private static boolean checkUserInputIsNull(String userInput) {
		return userInput != null;
	}

	private static boolean checkDuplicatedNumber(String userInput) {
		Set<Character> numbers = new HashSet<>();
		for (char c : userInput.toCharArray()) {
			numbers.add(c);
		}

		return numbers.size() == NUMBER_LENGTH;
	}

	private static boolean checkOtherCharacter(String userInput) {
		return userInput.matches(REG_EXPRESSION);
	}

	private static boolean checkInputLength(String userInput) {
		return userInput.length() == NUMBER_LENGTH;
	}

}

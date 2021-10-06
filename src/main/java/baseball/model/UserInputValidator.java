package baseball.model;

import baseball.dto.GameData;

import java.util.HashSet;
import java.util.Set;

public class UserInputValidator {

	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 9;
	private static final int FINISH_FLAG = 2;
	private static final String REGULAR_NUMBER_EXPRESSION = "[1-9]+";
	private static final String REGULAR_RESTART_EXPRESSION = "[1-2]+";
	private static final int NUMBER_LENGTH = 3;
	private static final int RESTART_INPUT_LENGTH = 1;

	public static void createRestartFlag(GameData gameData) {
		String userInput = gameData.getUserInput();
		try {
			checkRestartLength(userInput);
			checkRestartHasOtherCharacter(userInput);
			makeRestartToInt(gameData);
		} catch(IllegalArgumentException e) {
			gameData.setMessage(e.getMessage());
			throw e;
		}
	}

	private static void makeRestartToInt(GameData gameData) {
		gameData.setRestartFlag(Integer.parseInt(gameData.getUserInput()));
	}

	public static void createUserNumberList(GameData gameData) {
		String userInput = gameData.getUserInput();
		try {
			checkNumberDuplicated(userInput);
			checkNumberHasOtherCharacter(userInput);
			checkNumberLength(userInput);
			makeUserNumberToList(gameData);
		} catch(IllegalArgumentException e) {
			gameData.setMessage(e.getMessage());
		}
	}

	private static void makeUserNumberToList(GameData gameData) {
		gameData.getUserNumberList().clear();
		for (char c : gameData.getUserInput().toCharArray()) {
			gameData.getUserNumberList().add(Integer.parseInt(String.valueOf(c)));
		}
	}

	private static void checkNumberDuplicated(String userInput) {
		Set<Character> numbers = new HashSet<>();
		for (char c : userInput.toCharArray()) {
			numbers.add(c);
		}
		if (numbers.size() != NUMBER_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자만 입력할 수 있습니다.");
		}
	}

	private static void checkNumberHasOtherCharacter(String userInput) {
		if (!userInput.matches(REGULAR_NUMBER_EXPRESSION)) {
			throw new IllegalArgumentException(String.format("[ERROR] %d~%d까지의 숫자만 입력할 수 있습니다.",START_NUMBER, END_NUMBER));
		}
	}

	private static void checkNumberLength(String userInput) {
		if (userInput.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException(String.format("[ERROR] %d자리의 숫자만 입력할 수 있습니다.",NUMBER_LENGTH));
		}
	}

	private static void checkRestartHasOtherCharacter(String userInput) {
		if (!userInput.matches(REGULAR_RESTART_EXPRESSION)) {
			throw new IllegalArgumentException(String.format("[ERROR] %d~%d까지의 숫자만 입력할 수 있습니다.",START_NUMBER, FINISH_FLAG));
		}
	}

	private static void checkRestartLength(String userInput) {
		if (userInput.length() != RESTART_INPUT_LENGTH) {
			throw new IllegalArgumentException(String.format("[ERROR] %d자리의 숫자만 입력할 수 있습니다.",RESTART_INPUT_LENGTH));
		}
	}
}

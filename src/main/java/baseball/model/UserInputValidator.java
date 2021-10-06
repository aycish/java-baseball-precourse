package baseball.model;

import java.util.HashSet;
import java.util.Set;

import baseball.dto.GameData;

public class UserInputValidator {

	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 9;
	private static final int FINISH_FLAG = 2;
	private static final String REGULAR_NUMBER_EXPRESSION = "[1-9]+";
	private static final String REGULAR_RESTART_EXPRESSION = "[1-2]+";
	private static final int NUMBER_LENGTH = 3;
	private static final int RESTART_INPUT_LENGTH = 1;

	/**
	* 사용자 입력이 길이가 1인지, 1~2사이의 숫자로만 이루어져 있는지 체크한 뒤, gameData에 결과를 담는다.
	*
	* @param gameData : 사용자 입력을 전달한 뒤, 재시작 여부를 담는다.
	*/
	public static void createRestartFlag(GameData gameData) {
		String userInput = gameData.getUserInput();
		try {
			checkRestartLength(userInput);
			checkRestartHasOtherCharacter(userInput);
			makeRestartToInt(gameData);
		} catch(IllegalArgumentException e) {
			gameData.setMessage(e.getMessage());
		}
	}

	/**
	* 전달받은 사용자 입력 문자열을 Integer로 전환하여 담는다.
	 *
	* @param gameData : 사용자 입력을 전달한 뒤, 전환 결과를 담는다.
	*/
	private static void makeRestartToInt(GameData gameData) {
		gameData.setRestartFlag(Integer.parseInt(gameData.getUserInput()));
	}

	/**
	 * 사용자 입력이 길이가 3인지, 1~9사이의 숫자로만 이루어져 있는지, 중복되었는지를 체크한 뒤, gameData에 결과를 담는다.
	 *
	 * @param gameData : 사용자 입력을 전달한 뒤, Integer 리스트에 전환 결과를 담는다.
	 */
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

	/**
	 * 전달받은 사용자 입력 문자열을 Integer로 전환하여 담는다.
	 *
	 * @param gameData : 사용자 입력을 전달한 뒤, 전환 결과를 담는다.
	 */
	private static void makeUserNumberToList(GameData gameData) {
		gameData.getUserNumberList().clear();
		for (char c : gameData.getUserInput().toCharArray()) {
			gameData.getUserNumberList().add(Integer.parseInt(String.valueOf(c)));
		}
	}

	/**
	* Set을 활용하여 중복 여부를 확인한다. 중복되었다면 에러 메세지와 함께 익셉션을 던진다.
	*
	* @param userInput : 사용자가 입력한 문자열
	* @throw IllegalArgumentException 숫자들이 중복되었을 경우 발생
	*/
	private static void checkNumberDuplicated(String userInput) {
		Set<Character> numbers = new HashSet<>();
		for (char c : userInput.toCharArray()) {
			numbers.add(c);
		}

		if (numbers.size() != NUMBER_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자만 입력할 수 있습니다.");
		}
	}

	/**
	 * matches을 활용하여 1-9의 숫자로만 이뤄져 있는지 확인한다. 만약 아니라면 에러 메세지와 함께 익셉션을 던진다.
	 * 
	 * @param userInput : 사용자가 입력한 문자열
	 * @throw IllegalArgumentException 숫자들이 1에서 9사이의 숫자가 아닌 경우 발생
	 */
	private static void checkNumberHasOtherCharacter(String userInput) {
		if (!userInput.matches(REGULAR_NUMBER_EXPRESSION)) {
			throw new IllegalArgumentException(String.format("[ERROR] %d~%d까지의 숫자만 입력할 수 있습니다.",START_NUMBER, END_NUMBER));
		}
	}

	/**
	 * 사용자 입력이 3자리인지 확인한다. 만약 아니라면 에러 메세지와 함께 익셉션을 던진다.
	 * 
	 * @param userInput : 사용자가 입력한 문자열
	 * @throw IllegalArgumentException 3자리가 아닌 경우 발생
	 */
	private static void checkNumberLength(String userInput) {
		if (userInput.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException(String.format("[ERROR] %d자리의 숫자만 입력할 수 있습니다.",NUMBER_LENGTH));
		}
	}

	/**
	 * 사용자가 입력한 재시작/종료 여부가 1~2사이의 숫자인지 확인한다. 만약 아니라면 에러 메세지와 함께 익셉션을 던진다.
	 *
	 * @param userInput : 사용자가 입력한 문자열
	 * @throw IllegalArgumentException 숫자가 1애서 2사이의 숫자가 아닌 경우 발생
	 */
	private static void checkRestartHasOtherCharacter(String userInput) {
		if (!userInput.matches(REGULAR_RESTART_EXPRESSION)) {
			throw new IllegalArgumentException(String.format("[ERROR] %d~%d까지의 숫자만 입력할 수 있습니다.",START_NUMBER, FINISH_FLAG));
		}
	}

	/**
	 * 사용자가 입력한 재시작/종료 여부가 1자리 문자인지 확인한다. 만약 아니라면 에러 메세지와 함께 익셉션을 던진다.
	 *
	 * @param userInput : 사용자가 입력한 문자열
	 * @throw IllegalArgumentException 숫자 길이가 1자리가 아닌 경우 발생
	 */
	private static void checkRestartLength(String userInput) {
		if (userInput.length() != RESTART_INPUT_LENGTH) {
			throw new IllegalArgumentException(String.format("[ERROR] %d자리의 숫자만 입력할 수 있습니다.",RESTART_INPUT_LENGTH));
		}
	}
}

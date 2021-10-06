package baseball.view;

import nextstep.utils.Console;

public class GameViewer {
	private static final String INPUT_NOTICE = "숫자를 입력해주세요 : ";
	private static final String RESTART_NOTICE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String NOTHING = "낫싱";
	private static final String BALL_COUNT = "%d볼";
	private static final String STRIKE_COUNT = "%d스트라이크";
	private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
	private static final String LINE_END = "\n";
	private static final String SPACE = " ";

	public GameViewer() {}

	/**
	 * "숫자를 입력해주세요 : "문구를 출력한다.
	 *
	 * @return 사용자로부터 입력받은 문자열을 반환
	 */
	public static String printInputNotice() {
		System.out.format(INPUT_NOTICE);
		String userInput = Console.readLine();
		return userInput;
	}

	/**
	 * 전달 받은 에러 문구를 출력한다.
	 *
	 * @param message : 익셉션 발생 시, 설정해둔 문자열
	 * */
	public static void printWrongInputNotice(String message) {
		System.out.println(message);
	}

	/**
	* "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 문구를 출력한다.
	*
	* @return 사용자로부터 입력받은 문자열을 반환
	*/
	public static String printRestartNotice() {
		System.out.println(RESTART_NOTICE);
		String userInput = Console.readLine();
		return userInput;
	}

	/**
	* 게임 종료 문구를 출력한다.
	*/
	public static void printGameOver() {
		System.out.println(GAME_OVER);
	}

	/**
	* 채점 결과를 출력한다. 만약, 볼, 스트라이크 개수가 모두 0이라면 낫싱을 출력한다.
	*
	* @param strikeCount : 전달 받은 채점 결과 중, 스트라이크의 개수
	* @param ballCount   : 전달 받은 채점 결과 중, 볼의 개수
	*/
	public static void printScore(int strikeCount, int ballCount) {
		printStrikeCount(strikeCount, ballCount);
		printBallCount(ballCount);
		printNothing(strikeCount, ballCount);

		System.out.format(LINE_END);
	}

	/**
	* 스트라이크 개수를 출력한다. 볼이 존재한다면, 볼의 개수를 이어 출력하기 전에 공백을 출력한다.
	*
	* @param strikeCount : 출력할 채점 결과 중 스트라이크 개수
	* @param ballCount   : 볼 개수로, 스트라이크 출력 이후, 공백 출력 여부를 결정
	*/
	private static void printStrikeCount(int strikeCount, int ballCount) {
		if (strikeCount > 0 ) {
			System.out.format(STRIKE_COUNT, strikeCount);
		}
		if (strikeCount > 0 && ballCount > 0) {
			System.out.format(SPACE);
		}
	}

	/**
	* 채점 결과인 볼의 개수를 출력한다.
	*
	* @param ballCount : 출력할 채점 결과 중 볼의 개수
	*/
	private static void printBallCount(int ballCount) {
		if (ballCount > 0) {
			System.out.format(BALL_COUNT, ballCount);
		}
	}

	/**
	* 볼과 스트라이크 개수가 0이라면, 낫싱을 출력한다.
	*
	* @param strikeCount : 채점 결과 중, 스트라이크 개수
	* @param ballCount   : 채점 결과 중, 볼의 개수
	*/
	private static void printNothing(int strikeCount, int ballCount) {
		if (strikeCount == 0 && ballCount == 0) {
			System.out.format(NOTHING);
		}
	}
}

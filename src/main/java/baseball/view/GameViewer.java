package baseball.view;

import nextstep.utils.Console;

import java.util.NoSuchElementException;

public class GameViewer {
	private static final String INPUT_NOTICE = "숫자를 입력해주세요 : ";
	private static final String WRONG_INPUT_NOTICE = "[ERROR] 잘못된 입력입니다. 다시 입력해주세요.";
	private static final String RESTART_NOTICE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String NOTHING = "낫싱";
	private static final String BALL_COUNT = "%d볼";
	private static final String STRIKE_COUNT = "%d스트라이크";
	private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
	private static final String LINE_END = "\n";
	private static final String SPACE = " ";

	public GameViewer() {}

	public static String printInputNotice() {
		System.out.format(INPUT_NOTICE);
		String userInput = Console.readLine();
		return userInput;
	}

	public static void printWrongInputNotice(String message) {
		System.out.println(message);
	}

	public static String printRestartNotice() {
		System.out.println(RESTART_NOTICE);
		String userInput = Console.readLine();
		return userInput;
	}

	public static void printGameOver() {
		System.out.println(GAME_OVER);
	}

	public static void printScore(int strikeCount, int ballCount) {
		printStrikeCount(strikeCount, ballCount);
		printBallCount(ballCount);
		printNothing(strikeCount, ballCount);
		System.out.format(LINE_END);
	}

	private static void printStrikeCount(int strikeCount, int ballCount) {
		if (strikeCount > 0 ) {
			System.out.format(STRIKE_COUNT, strikeCount);
		}
		if (strikeCount > 0 && ballCount > 0) {
			System.out.format(SPACE);
		}
	}

	private static void printBallCount(int ballCount) {
		if (ballCount > 0) {
			System.out.format(BALL_COUNT, ballCount);
		}
	}

	private static void printNothing(int strikeCount, int ballCount) {
		if (strikeCount == 0 && ballCount == 0) {
			System.out.format(NOTHING);
			throw new NoSuchElementException(NOTHING);
		}
	}

}

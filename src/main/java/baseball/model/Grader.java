package baseball.model;

import java.util.ArrayList;

public class Grader {

	public static int ballCount;
	public static int strikeCount;
	private static final int ANSWER = 3;
	private static final int INITIAL_VALUE = 0;

	public static void gradeUserInput(ArrayList<Integer> computerNumberList, ArrayList<Integer> userNumberList) {
		ballCount = INITIAL_VALUE;
		strikeCount = INITIAL_VALUE;

		for (int index = 0 ; index < userNumberList.size(); index++) {
			ballCount += countBall(computerNumberList,userNumberList.get(index));
			strikeCount += countStrike(computerNumberList, userNumberList.get(index), index);
		}

		ballCount = ballCount - strikeCount;
	}

	public static boolean checkFullMark() {
		if (strikeCount == ANSWER) {
			return true;
		}
		return false;
	}

	private static int countBall (ArrayList<Integer> computerNumberList, int userNumber) {
		if (computerNumberList.contains(userNumber) == true) {
			return 1;
		}
		return 0;
	}

	private static int countStrike (ArrayList<Integer> computerNumberList, int userNumber, int index) {
		if (computerNumberList.get(index) == userNumber) {
			return 1;
		}
		return 0;
	}

	public static int getBallCount() {
		return ballCount;
	}

	public static int getStrikeCount() {
		return strikeCount;
	}
}

package baseball.model;

import java.util.ArrayList;

import baseball.dto.GameData;

public class Grader {
	private static final int INITIAL_VALUE = 0;

	public static void gradeUserInput(GameData gameData) {
		int ballCount = INITIAL_VALUE;
		int strikeCount = INITIAL_VALUE;
		for (int index = 0 ; index < gameData.getUserNumberList().size(); index++) {
			ballCount += countBall(gameData.getComputerNumberList(),gameData.getUserNumberList().get(index));
			strikeCount += countStrike(gameData.getComputerNumberList(), gameData.getUserNumberList().get(index), index);
		}
		ballCount = ballCount - strikeCount;
		gameData.setBallCount(ballCount);
		gameData.setStrikeCount(strikeCount);
	}

	private static int countBall(ArrayList<Integer> computerNumberList, int userNumber) {
		if (computerNumberList.contains(userNumber) == true) {
			return 1;
		}
		return 0;
	}

	private static int countStrike(ArrayList<Integer> computerNumberList, int userNumber, int index) {
		if (computerNumberList.get(index) == userNumber) {
			return 1;
		}
		return 0;
	}
}

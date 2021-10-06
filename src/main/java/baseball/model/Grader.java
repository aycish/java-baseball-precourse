package baseball.model;

import java.util.ArrayList;

import baseball.dto.GameData;

public class Grader {
	private static final int INITIAL_VALUE = 0;

	/**
	* 사용자 입력에 대해 채점한다. 볼과 스트라이크를 모두 센 뒤, 볼 개수에서 스트라이크 개수를 빼어 최종 볼 개수를 정한다.
	*
	* <p>
	* 일단 모든 볼 개수와 스트라이크 개수를 센 뒤, 마지막으로 볼 개수에서 스트라이크 개수를 빼어 최종 볼 개수를 정한다.
	* 예를 들어, 3스트라이크인 경우, 3볼 3스트라이크가 채점 결과로 나오게되고 최종 볼의 개수는 3 - 3이 되어 0이 된다.
	* </p>
	* @param gameData : 컴퓨터 숫자, 사용자가 입력한 숫자를 전달하고 채점 결과를 저장한다.
	*
	*/
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

	/**
	* 사용자의 숫자중 하나가 컴퓨터의 숫자중에 포함되어있는지 체크하여 존재한다면 1을 반환하여 더할 수 있게하고 없다면 0을 반환
	*
	* @param computerNumberList : 컴퓨터의 랜덤한 서로 다른 숫자 3자리
	* @param userNumber : 사용자의 숫자중 하나
	* @return 볼이라면 1, 아니면 0 반환
	*/
	private static int countBall(ArrayList<Integer> computerNumberList, int userNumber) {
		if (computerNumberList.contains(userNumber) == true) {
			return 1;
		}
		return 0;
	}

	/**
	* 비교하고자하는 사용자의 숫자와 위치를 활용하여 해당 위치의 컴퓨터의 숫자가 동일한지 확인하여 1 또는 0을 반환한다.
	*
	* @param computerNumberList : 컴퓨터의 랜덤한 서로 다른 숫자 3자리
	* @param userNumber : 사용자 숫자 리스트에 index에 위치한 숫자
	* @param index : 사용자 숫자 리스트중 userNumber가 존재하는 위치
	* @return 스트라이크라면 1, 아니면 0 반환
	*/
	private static int countStrike(ArrayList<Integer> computerNumberList, int userNumber, int index) {
		if (computerNumberList.get(index) == userNumber) {
			return 1;
		}
		return 0;
	}
}

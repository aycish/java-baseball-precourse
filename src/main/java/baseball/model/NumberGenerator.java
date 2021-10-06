package baseball.model;

import java.util.ArrayList;

import baseball.dto.GameData;
import nextstep.utils.Randoms;

public class NumberGenerator {

	private static final int START_INCLUSIVE = 1;
	private static final int END_INCLUSIVE = 9;
	private static final int NUMBER_LENGTH = 3;

	public static void generateRandomNumbers(GameData gameData) {
		ArrayList<Integer> numberList = new ArrayList<>();
		while (numberList.size() < NUMBER_LENGTH) {
			addRandomNumber(numberList, Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
		}
		gameData.setComputerNumberList(numberList);
	}

	private static void addRandomNumber(ArrayList<Integer> numberList,int randomNumber) {
		if (!numberList.contains(randomNumber)) {
			numberList.add(randomNumber);
		}
	}
}

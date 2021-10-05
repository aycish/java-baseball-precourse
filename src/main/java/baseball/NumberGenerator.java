package baseball;

import java.util.ArrayList;

import nextstep.utils.Randoms;

public class NumberGenerator {

	private static final ArrayList<Integer> numberList = new ArrayList<>();
	private static final int START_INCLUSIVE = 1;
	private static final int END_INCLUSIVE = 9;
	private static final int NUMBER_LENGTH = 3;

	public static ArrayList<Integer> generateRandomNumbers() {
		numberList.clear();
		while (numberList.size() < NUMBER_LENGTH) {
			addRandomNumber(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
		}
		return numberList;
	}

	private static void addRandomNumber(int randomNumber) {
		if (numberList.contains(randomNumber) == false) {
			numberList.add(randomNumber);
		}
	}
}

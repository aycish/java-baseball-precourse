package baseball.model;

import java.util.ArrayList;

import baseball.dto.GameData;
import nextstep.utils.Randoms;

public class NumberGenerator {

	private static final int START_INCLUSIVE = 1;
	private static final int END_INCLUSIVE = 9;
	private static final int NUMBER_LENGTH = 3;

	/**
	* Randoms를 활용하여 1-9 사이의 랜덤한 숫자를 생성하고, 3자리가 될때 까지 중복을 확인하며 추가한다.
	* @param gameData : 서로 다른 임의의 숫자 3자리 리스트를 담는다.
	*/
	public static void generateRandomNumbers(GameData gameData) {
		ArrayList<Integer> numberList = new ArrayList<>();
		while (numberList.size() < NUMBER_LENGTH) {
			addRandomNumber(numberList, Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
		}
		gameData.setComputerNumberList(numberList);
	}

	/**
	* contains를 통해 넣고자하는 숫자가 존재하는지 확인한 뒤, 없다면 해당 숫자를 삽입한다.
	* @param numberList : 임의의 숫자가 담길 숫자 리스트
	* @param randomNumber : 넣고자하는 임의의 숫자
	*/
	private static void addRandomNumber(ArrayList<Integer> numberList, int randomNumber) {
		if (!numberList.contains(randomNumber)) {
			numberList.add(randomNumber);
		}
	}
}

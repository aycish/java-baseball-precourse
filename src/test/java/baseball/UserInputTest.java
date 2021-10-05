package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputTest {

	@Test
	@DisplayName("사용자가 정상적인 숫자를 입력하는 테스트")
	void getNormalInput() {
		input("123");
		UserInput.getUserInput();

		ArrayList<Integer> numbers = UserInput.getUserNumberList();
		Assertions.assertThat(numbers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("사용자가 잘못된 문자를 입력하는 테스트")
	void getWrongInput() {
		input("abc");
		UserInput.getUserInput();

		ArrayList<Integer> numbers = UserInput.getUserNumberList();
		Assertions.assertThat(numbers.size()).isEqualTo(0);
	}

	@Test
	@DisplayName("사용자가 중복된 숫자를 입력하는 테스트")
	void getDuplicatedInput() {
		input("111");
		UserInput.getUserInput();

		ArrayList<Integer> numbers = UserInput.getUserNumberList();
		Assertions.assertThat(numbers.size()).isEqualTo(0);
	}

	@Test
	@DisplayName("사용자가 0이 포함된 숫자를 입력하는 테스트")
	void getZeroInput() {
		input("120");
		UserInput.getUserInput();

		ArrayList<Integer> numbers = UserInput.getUserNumberList();
		Assertions.assertThat(numbers.size()).isEqualTo(0);
	}

	@Test
	@DisplayName("사용자가 3자리가 아닌 숫자를 입력하는 테스트")
	void getShortAndLongInput() {
		input("12345");
		UserInput.getUserInput();

		ArrayList<Integer> numbers = UserInput.getUserNumberList();
		Assertions.assertThat(numbers.size()).isEqualTo(0);

		input("12");
		UserInput.getUserInput();

		numbers = UserInput.getUserNumberList();
		Assertions.assertThat(numbers.size()).isEqualTo(0);
	}

	private void input(String userInput) {
		final byte[] buf = userInput.getBytes();
		System.setIn(new ByteArrayInputStream(buf));
	}

}
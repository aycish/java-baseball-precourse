package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

class UserInputTest {

	@Test
	@DisplayName("사용자가 정상적인 숫자를 입력하는 테스트")
	void getNormalInput() {
		input("123");
		UserInput.getUserInput();

		ArrayList<Integer> numbers = UserInput.getUserNumberList();
		Assertions.assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@DisplayName("사용자가 잘못된 문자를 입력하는 테스트")
	@ValueSource(strings = {"abc", "ab-", "b12", "db2"})
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

	@ParameterizedTest
	@DisplayName("사용자가 0이 포함된 숫자를 입력하는 테스트")
	@ValueSource(strings = {"120", "102", "012", "001", "010", "100", "000"})
	void getZeroInput(String userInput) {
		input(userInput);
		UserInput.getUserInput();

		ArrayList<Integer> numbers = UserInput.getUserNumberList();
		Assertions.assertThat(numbers.size()).isEqualTo(0);
	}

	@ParameterizedTest
	@DisplayName("사용자가 3자리가 아닌 숫자를 입력하는 테스트")
	@ValueSource(strings = {"12345", "12"})
	void getShortAndLongInput(String userInput) {
		input(userInput);
		UserInput.getUserInput();

		ArrayList<Integer> numbers = UserInput.getUserNumberList();
		Assertions.assertThat(numbers.size()).isEqualTo(0);
	}

	private void input(String userInput) {
		final byte[] buf = userInput.getBytes();
		System.setIn(new ByteArrayInputStream(buf));
	}

}
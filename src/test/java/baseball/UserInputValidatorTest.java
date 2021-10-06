package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.model.UserInputValidator;
import nextstep.utils.Console;

class UserInputValidatorTest {

	boolean returnValue;
	int restartFlag;
	@Test
	@DisplayName("사용자가 정상적인 숫자를 입력하는 테스트")
	void getNormalNumber() {
		input("123");
			returnValue = UserInputValidator.saveUserNumberList(Console.readLine());
		assertThat(returnValue).isTrue();
	}

	@ParameterizedTest
	@DisplayName("사용자가 잘못된 문자를 입력하는 테스트")
	@ValueSource(strings = {"abc", "ab-", "121", "112", "102", "012", "12345", "12"})
	void getWrongInput(String userInput) {
		input(userInput);
		returnValue = UserInputValidator.saveUserNumberList(Console.readLine());
		assertThat(returnValue).isFalse();
	}

	@ParameterizedTest
	@DisplayName("재시작, 종료 정상 입력 테스트")
	@ValueSource(strings = {"1", "2"})
	void getNormalRestart(String userInput) {
		input(userInput);
		returnValue = UserInputValidator.saveRestartFlagFromUser(Console.readLine());
		assertThat(returnValue).isTrue();

		restartFlag = UserInputValidator.getRestartFlag();
		assertThat(restartFlag).isEqualTo(Integer.parseInt(userInput));
	}

	@ParameterizedTest
	@DisplayName("재시작, 종료 잘못된 문자를 입력하는 테스트")
	@ValueSource(strings = {"a", "ab", "3", "123", "11"})
	void getAbnormalRestart(String userInput) {
		input(userInput);
		returnValue = UserInputValidator.saveRestartFlagFromUser(Console.readLine());
		assertThat(returnValue).isFalse();
	}

	private void input(String userInput) {
		final byte[] buf = userInput.getBytes();
		System.setIn(new ByteArrayInputStream(buf));
	}

}
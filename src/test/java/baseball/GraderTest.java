package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GraderTest {


	ArrayList<Integer> computerNumberList = new ArrayList<Integer>(Arrays.asList(1,2,3));
	@ParameterizedTest
	@DisplayName("정답 채점 테스트")
	@CsvSource(value= {"123:3:0", "124:2:0", "145:1:0", "132:1:2", "134:1:1", "312:0:3", "412:0:2", "345:0:1", "456:0:0"},delimiter = ':')
	void gradeUserInput(String userInput, int strikeCount, int ballCount) {
		System.out.println("S = " + userInput + ", strike = " + strikeCount + ", ball = " + ballCount);

		ArrayList<Integer> userNumberList = convertStringToIntegerList(userInput);
		Grader.gradeUserInput(computerNumberList, userNumberList);

		assertThat(Grader.getStrikeCount()).isEqualTo(strikeCount);
		assertThat(Grader.getBallCount()).isEqualTo(ballCount);
	}

	private void input(String userInput) {
		final byte[] buf = userInput.getBytes();
		System.setIn(new ByteArrayInputStream(buf));
	}

	private ArrayList<Integer> convertStringToIntegerList (String userInput) {
		ArrayList<Integer> result = new ArrayList<>();

		for(char c : userInput.toCharArray()) {
			result.add(Integer.parseInt(String.valueOf(c)));
		}

		return result;
	}
}
package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.model.NumberGenerator;

class NumberGeneratorTest {

	@Test
	@DisplayName("3자리 랜덤한 숫자 생성 테스트")
	void generateRandomNumbers() {
		ArrayList<Integer> numbers = NumberGenerator.generateRandomNumbers();

		assertThat(numbers.size()).isEqualTo(3);
		assertThat(numbers.get(0)).isNotEqualTo(numbers.get(1)).isNotEqualTo(numbers.get(2));
		assertThat(numbers.get(1)).isNotEqualTo(numbers.get(0)).isNotEqualTo(numbers.get(2));
		assertThat(numbers.get(2)).isNotEqualTo(numbers.get(0)).isNotEqualTo(numbers.get(1));
	}
}
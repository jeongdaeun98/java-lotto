package lotto.util;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberUtilsTest {

    @DisplayName("정수인지 아닌지 판단하는 테스트")
    @ParameterizedTest
    @MethodSource("provideReturnIntegerTest")
    void returnIntegerTest(String string, Integer expected) {
        assertEquals(expected, NumberUtils.returnInteger(string));
    }

    private static Stream<Arguments> provideReturnIntegerTest() {
        return Stream.of(
            Arguments.of("45", 45),
            Arguments.of("0", 0)
        );
    }

    @DisplayName("정수인지 아닌지 판단하는 테스트")
    @ParameterizedTest
    @MethodSource("provideReturnIntegerBadTest")
    void returnIntegerBadTest(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> NumberUtils.returnInteger(string));
    }

    private static Stream<Arguments> provideReturnIntegerBadTest() {
        return Stream.of(
            Arguments.of("asd"),
            Arguments.of("0.03")
        );
    }

    @DisplayName("수익률 계산 테스트")
    @ParameterizedTest
    @MethodSource("provideCalcualteYieldTest")
    void calculateYieldTest(int inputPrice, int income, double expected) {
        assertEquals(expected, NumberUtils.calculateYield(inputPrice, income));
    }

    private static Stream<Arguments> provideCalcualteYieldTest() {
        return Stream.of(
            Arguments.of(14000, 5000, 0.35),
            Arguments.of(10000, 5000, 0.5),
            Arguments.of(2000, 2000000000, 1000000.0),
            Arguments.of(2000, 0, 0.0)
        );
    }
}
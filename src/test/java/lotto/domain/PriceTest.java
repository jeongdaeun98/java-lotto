package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PriceTest {
    @DisplayName("10으로 나누어지는 0이 아닌 금액일 경우 객체가 생성됨")
    @ParameterizedTest
    @MethodSource("provideCheckPriceGoodTest")
    void checkPriceGoodTest(String string) {
        Price price = new Price(string);
        assertEquals(price, price.getPrice());
    }

    private static Stream<Arguments> provideCheckPriceGoodTest() {
        return Stream.of(
            Arguments.of("24000"),
            Arguments.of("1000")
        );
    }

    @DisplayName("10으로 나누어지지 않고 0인 금액일 경우 예외가 남")
    @ParameterizedTest
    @MethodSource("provideCheckPriceBadTest")
    void checkPriceBadTest(String string) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Price(string));
    }

    private static Stream<Arguments> provideCheckPriceBadTest() {
        return Stream.of(
            Arguments.of("asdkfjasd"),
            Arguments.of("24"),
            Arguments.of("0000"),
            Arguments.of("0")
        );
    }

    @DisplayName("가격을 기준으로 티켓 개수 테스트")
    @ParameterizedTest
    @MethodSource("provideCalculateTicketsTest")
    public void calculateTicketsTest(int money, int tickets) {
        assertEquals(tickets, new Price(money).calculateTicketCount());
    }

    private static Stream<Arguments> provideCalculateTicketsTest() {
        return Stream.of(
            Arguments.of(24000, 24),
            Arguments.of(1000, 1)
        );
    }

    @DisplayName("총 티켓 당첨금 테스트")
    @ParameterizedTest
    @MethodSource("provideCalculateTotalPrizeTest")
    public void calculateTotalPrizeTest(Map<Revenue, Integer> revenue, int expected) {
        Price price = new Price();
        int totalRevenue = price.calculateTotalPrize(revenue);
        assertEquals(expected, totalRevenue);
    }

    private static Stream<Arguments> provideCalculateTotalPrizeTest() {
        Map<Revenue, Integer> revenueMap = new HashMap<>();
        revenueMap.put(Revenue.NOTHING, 1);
        revenueMap.put(Revenue.THREE, 1);
        revenueMap.put(Revenue.FIVE_AND_BONUS, 2);
        return Stream.of(
            Arguments.of(revenueMap, 60005000)
        );
    }
}

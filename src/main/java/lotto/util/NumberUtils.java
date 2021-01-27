package lotto.util;

import java.math.BigDecimal;
import java.util.List;

public class NumberUtils {

    private static final int FIRST_RANGE_LOTTO_NUMBER = 0;
    private static final int END_RANGE_LOTTO_NUMBER = 46;

    public static Integer returnInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double calculateYield(int inputPrice, int income) {
        BigDecimal bd = new BigDecimal((double) income / inputPrice);
        return bd.setScale(2, BigDecimal.ROUND_FLOOR).doubleValue();
    }

    public static boolean isNumberUnique(List<String> numbers) {
        return numbers
            .stream()
            .distinct()
            .count() == numbers.size();
    }

    public static boolean isNumberInRange(List<String> numbers) {
        return numbers
            .stream()
            .map(Integer::parseInt)
            .allMatch(NumberUtils::checkLottoNumber);
    }

    public static boolean checkLottoNumber(int num) {
        return FIRST_RANGE_LOTTO_NUMBER < num && num < END_RANGE_LOTTO_NUMBER;
    }
}

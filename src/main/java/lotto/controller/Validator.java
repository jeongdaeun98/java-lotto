package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.util.NumberUtils;

public class Validator {

    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String FORMAT_REGEX = "[0-9]+(,\\s[0-9]+)*$";
    private static final int FIRST_RANGE_LOTTO_NUMBER = 0;
    private static final int END_RANGE_LOTTO_NUMBER = 46;
    private static final String COMMA = ", ";
    private static final int LOTTO_COUNT = 6;

    public boolean isPriceValidate(String price) {
        Integer priceOrNull = NumberUtils.returnInteger(price);
        return priceOrNull != null && priceOrNull != 0 && priceOrNull % ONE_LOTTO_PRICE == 0;
    }

    public boolean validateWinningNumber(String winningNumber) {
        // String 받아 올때 " " 없애서 받아오기!
        //String trimed = winningNumber.replaceAll(" ", "");  // 임시 코드
        // TODO: length check. 하드 코딩 했음!!! 다른 방법 알아보기!
        // TODO: unique Number check.
        Pattern pattern = Pattern.compile(FORMAT_REGEX);
        List<String> numbers = Arrays.asList(winningNumber.split(COMMA));
        return pattern.matcher(winningNumber).matches()
            && numbers.size() == LOTTO_COUNT
            && isNumberUnique(numbers)
            && isNumberInRange(numbers);
    }

    public boolean isNumberUnique(List<String> numbers) {
        return numbers
            .stream()
            .distinct()
            .count() == numbers.size();
    }

    // NumberUtil로..?
    public boolean isNumberInRange(List<String> numbers) {
        return numbers
            .stream()
            .map(Integer::parseInt)
            .allMatch(this::checkLottoNumber);
    }

    public boolean validateBonusNumber(String bonusNumber) {
        Integer bonusNumberOrNull = NumberUtils.returnInteger(bonusNumber);
        return bonusNumberOrNull != null && checkLottoNumber(bonusNumberOrNull);
    }

    private boolean checkLottoNumber(int num) {
        return FIRST_RANGE_LOTTO_NUMBER < num && num < END_RANGE_LOTTO_NUMBER;
    }
}

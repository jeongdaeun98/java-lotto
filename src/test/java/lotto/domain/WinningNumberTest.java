package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningNumberTest {

    @Test
    @DisplayName("로또랑 비교하여 당첨 결과를 구한다.")
    public void winningResult() {
        //given
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        String lottoNumbers = "1, 3, 5, 7, 9, 11";
        LottoTicket lottoTicket = new LottoTicket(Arrays.stream(lottoNumbers.split(", "))
                .map(s -> new LottoNumber(Integer.parseInt(s)))
                .collect(Collectors.toList()));
        LottoMachine lottoMachine = new LottoMachine();
        WinningNumber winningNumber = lottoMachine.winningNumber(winningNumbers);

        //when
        int winningCount = winningNumber.winningCount(lottoTicket);

        //then
        assertEquals(3, winningCount);
    }
}
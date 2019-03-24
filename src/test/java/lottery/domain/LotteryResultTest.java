package lottery.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryResultTest {

    //TODO :  Arrays.asList 요런것처럼 Map도 가능할 것 같은데, 어떤 키워드로 검색해야 나올지..
    @Test
    public void 당첨조회테스트() {
        Map<Integer, Integer> resultDatas = new HashMap<>();
        resultDatas.put(1, 0);
        resultDatas.put(2, 1);
        resultDatas.put(3, 2);
        resultDatas.put(4, 3);
        LotteryResult lotteryResult = new LotteryResult(Arrays.asList(2,3,4,4,3,4));
        assertThat(lotteryResult.getResultDatas()).isEqualTo(resultDatas);
    }

    @Test
    public void 수익률조회테스트() {
        List<Integer> matchedDatas =  Arrays.asList(5,5,5,5,5,5,5,5,5,5,5,5,5,4);
        LotteryResult lotteryResult = new LotteryResult(matchedDatas);
        System.out.println(lotteryResult.getResultDatas());
        assertThat(lotteryResult.getEarningRates()).isEqualTo(0.35);
    }

}
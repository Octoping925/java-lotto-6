package lotto.domain;

import java.util.List;

public class LottoProfitRateCalculator {
    private static final int PERCENT = 100;
    private final int lottoPrice;

    public LottoProfitRateCalculator(int lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public LottoProfitRate calculate(List<LottoGrade> lottoGrades) {
        if (lottoGrades.isEmpty()) {
            return new LottoProfitRate(0);
        }

        int totalWinningMoney = getTotalWinningMoney(lottoGrades);
        int lottoBoughtPrice = getLottoBoughtPrice(lottoGrades);

        return new LottoProfitRate(
                getProfitRate(totalWinningMoney, lottoBoughtPrice)
        );
    }

    private int getTotalWinningMoney(List<LottoGrade> lottoGrades) {
        return lottoGrades.stream()
                .mapToInt(LottoGrade::getWinningMoney)
                .sum();
    }

    private int getLottoBoughtPrice(List<LottoGrade> lottoGrades) {
        return lottoGrades.size() * lottoPrice;
    }

    private double getProfitRate(int totalWinningMoney, int lottoBoughtPrice) {
        return (double) totalWinningMoney / lottoBoughtPrice * PERCENT;
    }
}

package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> elements;

    public Lottos(List<Lotto> elements) {
        this.elements = elements;
    }

    public List<Lotto> getElements() {
        return this.elements;
    }

    public long size() {
        return this.elements.size();
    }

    public WinningStatistics getWinningStatics(WinningNumbers winningNumbers) {
        Map<WinningGrade, Integer> lotteryStatistics = initStatistics();

        this.elements.stream().map(winningNumbers::getWinningGrade)
                .forEach(winningGrade -> lotteryStatistics.put(winningGrade, lotteryStatistics.get(winningGrade) + 1));

        return new WinningStatistics(Collections.unmodifiableMap(lotteryStatistics));
    }

    private Map<WinningGrade, Integer> initStatistics() {
        Map<WinningGrade, Integer> lotteryStatistics = new HashMap<>();
        for (WinningGrade grade : WinningGrade.values()) {
            lotteryStatistics.put(grade, 0);
        }
        return lotteryStatistics;
    }

}
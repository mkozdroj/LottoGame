package games.lotto.logic;

import org.example.model.LottoGameResultInfo;

import java.util.HashSet;
import java.util.Set;

public class LottoNumbersOfHits {

    public LottoGameResultInfo getNumbersOfHits(Set<Integer> userNumbers, Set<Integer> randomNumbers){
        Set<Integer> totalHitNumbers = new HashSet<>(userNumbers);
        totalHitNumbers.retainAll(randomNumbers);
        return new LottoGameResultInfo(userNumbers,randomNumbers,totalHitNumbers);

    }
}

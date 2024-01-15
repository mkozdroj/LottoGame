package org.example.model;

import games.lotto.messages.LottoMessages;
import games.model.GameResultInfo;
import lombok.Data;

import java.util.Set;

@Data
public class LottoGameResultInfo implements GameResultInfo {

    private final Set<Integer> userNumbers;
    private final Set<Integer> randomNumbers;
    private final Set<Integer> totalHitsNumbers;

    @Override
    public String getGameResultMessage() {
        return String.format(LottoMessages.LOTTO_RESULT, totalHitsNumbers.size(), randomNumbers, userNumbers);
    }
}

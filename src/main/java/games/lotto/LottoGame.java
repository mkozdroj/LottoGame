package games.lotto;

import games.Game;
import games.lotto.input.LottoUserInput;
import games.lotto.logic.LottoNumbersOfHits;
import games.lotto.logic.LottoRandomNumberGenerator;
import games.lotto.messages.LottoMessages;
import games.model.GameResult;
import games.model.GameResultInfo;
import lombok.Data;

import java.util.Scanner;
import java.util.Set;

import static games.lotto.messages.LottoMessages.GAME_NAME;

@Data
public class LottoGame implements Game {

    private final LottoUserInput lottoUserInput;
    private final LottoRandomNumberGenerator lottoRandomNumberGenerator;
    private final LottoNumbersOfHits lottoNumbersOfHits;
    private final Scanner scanner;


    public GameResult startGame() {
        System.out.println(String.format(LottoMessages.GAME_NUMBER_STARTED, GAME_NAME));
        final GameResultInfo gameResultInfo = getHitNumbers();
        return getGameResult(gameResultInfo);
    }

    private GameResultInfo getHitNumbers() {
        final Set<Integer> userNumbers = lottoUserInput.getSixNumbers(scanner);
        final Set<Integer> randomNumbers = lottoRandomNumberGenerator.getSixRandomNumbers();
        return lottoNumbersOfHits.getNumbersOfHits(userNumbers, randomNumbers);
    }


    private GameResult getGameResult(GameResultInfo gameResultInfo) {
        final GameResult gameResult = new GameResult(this, gameResultInfo);
        System.out.println(gameResult.getGameResultInfo().getGameResultMessage());
        return gameResult;
    }


}
package games.lotto;

import games.Game;
import games.lotto.input.LottoUserInput;
import games.lotto.logic.LottoNumbersOfHits;
import games.lotto.logic.LottoRandomNumberGenerator;
import games.model.GameResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoGameTest {
    private static final Scanner scannerMock = new Scanner(System.in);
    private static final LottoNumbersOfHits LOTTO_NUMBERS_OF_HITS = new LottoNumbersOfHits();
    private static final LottoUserInput lottoUserInputMock = mock(LottoUserInput.class);
    private static final LottoRandomNumberGenerator lottoRandomGeneratorMock = mock(LottoRandomNumberGenerator.class);

    @ParameterizedTest(name="player gave {0}, random numbers were {1}, message: {2}")
    @MethodSource("provideNumbersAndReturnMessages")
    void shouldReturnCorrectMessageWhenParametersWereGiven(Set<Integer> userNumbers,
                                                           Set<Integer> randomNumbers,
                                                           String expectedMessage) {
        //given
        mockNumbers(userNumbers, randomNumbers);
        Game lottoGame = new LottoGame(lottoUserInputMock, lottoRandomGeneratorMock, LOTTO_NUMBERS_OF_HITS, scannerMock);
        //when
        final GameResult gameResult = lottoGame.startGame();
        //then
        assertEquals(expectedMessage, gameResult.getGameResultInfo().getGameResultMessage());
    }

    private static Stream<Arguments> provideNumbersAndReturnMessages() {
        final Arguments arg1 = Arguments.of(Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(4, 12, 23, 34, 76, 65))),
                "You hit 1 numbers! Winning numbers were [4, 12, 23, 34, 76, 65], and yours were [1, 2, 3, 4, 5, 6]");
        final Arguments arg2 = Arguments.of(Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                "You hit 6 numbers! Winning numbers were [1, 2, 3, 4, 5, 6], and yours were [1, 2, 3, 4, 5, 6]");
        final Arguments arg3 = Arguments.of(Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(1, 2, 20, 40, 5, 6))),
                Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                "You hit 4 numbers! Winning numbers were [1, 2, 3, 4, 5, 6], and yours were [1, 2, 20, 40, 5, 6]");
        return Stream.of(arg1, arg2, arg3);
    }

    private void mockNumbers(Set<Integer> userNumbers, Set<Integer> randomNumbers) {
        when(lottoUserInputMock.getSixNumbers(scannerMock)).thenReturn(userNumbers);
        when(lottoRandomGeneratorMock.getSixRandomNumbers()).thenReturn(randomNumbers);
    }


}
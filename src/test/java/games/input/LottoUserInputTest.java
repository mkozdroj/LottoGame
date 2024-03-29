package games.input;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;


import games.lotto.input.LottoUserInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LottoUserInputTest {
    LottoUserInput lottoUserInput = new LottoUserInput();

    @Test
    public void shouldReturnNumbersInSetWhenAllInRange() {
        // given
        //  Set<Integer> expectedNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 6);
        ;
        String givenNumbers = "1 2 3 4 5 6";
        Scanner scanner = mockScannerIn(givenNumbers);
        // when
        final Set<Integer> userNumbers = lottoUserInput.getSixNumbers(scanner);
        // then
        assertEquals(expectedNumbers, userNumbers);
    }

    @Test
    public void shouldReturnNumbersInSetWhenOneIsNotInRange() {
        // given
        Set<Integer> expectedNumbers = Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 33)));
        String givenNumbers = "1 2 3 4 5 33";
        Scanner scanner = mockScannerIn(givenNumbers);
        // when
        final Set<Integer> userNumbers = lottoUserInput.getSixNumbers(scanner);
        // then
        assertThat(expectedNumbers).isEqualTo(userNumbers);
    }

    private Scanner mockScannerIn(String data) {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        return new Scanner(inputStream);
    }

}

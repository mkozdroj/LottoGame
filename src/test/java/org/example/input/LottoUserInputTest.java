package org.example.input;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

import static org.junit.Assert.*;

public class LottoUserInputTest {

    LottoUserInput lottoUserInput = new LottoUserInput();

    @Test
    void shouldReturnNumbersInSetWhenAllInRange(){
        // given
        Set<Integer> expectedNumbers = Set.of(1,2,3,4,5,6);
        String givenNumbers = "1 2 3 4 5 6";
        Scanner userNumbers = mockScannerIn(givenNumbers);
        // when
        final Set<Integer> userInputNumbers = lottoUserInput.getSixNumbers(userNumbers);
        // then
        assertEquals(expectedNumbers,userInputNumbers);

    }



    private Scanner mockScannerIn(String input) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;

    }

}

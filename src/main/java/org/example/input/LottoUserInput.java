package org.example.input;

import org.example.messages.LottoMessages;

import java.util.*;

import static org.example.configuration.LottoGameConfiguration.HOW_MANY_NUMBERS_FROM_USER;

public class LottoUserInput {

    //System scanner = new Scanner(System.in);


    private Set<Integer> getNumbersFromUserInput(Scanner input) {
        final Set<Integer> givenNumbers = new HashSet<>();
        System.out.println(String.format(LottoMessages.PLEASE_GIVE_NUMBER, HOW_MANY_NUMBERS_FROM_USER));
        while (areUserInputLessThanSixNumbers(givenNumbers)) {
            System.out.println("Give next number: ");
            while (!input.hasNextInt()) {
                System.out.println("bad value");
                if (!input.hasNext()) {
                    return Collections.emptySet();
                }
            }
            final int userInput = input.nextInt();
        }
        return givenNumbers;
    }

        private boolean areUserInputLessThanSixNumbers(Set<Integer> numbers){
            return numbers.size() <HOW_MANY_NUMBERS_FROM_USER;
        }

    }


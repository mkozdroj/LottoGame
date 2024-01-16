package games.lotto.input;

import games.lotto.messages.LottoMessages;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static games.lotto.configuration.LottoGameConfiguration.*;

public class LottoUserInput {

    public Set<Integer> getSixNumbers(Scanner scanner) {
        Set<Integer> givenNumbersFromUser = getNumbersFromUserInput(scanner);
        scanner.close();
        return givenNumbersFromUser;
    }

    private Set<Integer> getNumbersFromUserInput(Scanner input) {
        final Set<Integer> givenNumbers = new HashSet<>();
        boolean invalidInput = false;

        while (areUserInputLessThanSixNumbers(givenNumbers)) {
            if (invalidInput) {
                System.out.printf(LottoMessages.NOT_INT_GIVE_NUMBER, LOWER_BOUND, UPPER_BOUND);
                invalidInput = false;
            }
            System.out.printf(LottoMessages.GIVE_NUMBER, LOWER_BOUND, UPPER_BOUND);

            if (input.hasNextInt()) {
                int userInput = input.nextInt();
                validateUserNumbers(givenNumbers, userInput);
            } else {
                input.next();
                invalidInput = true;
            }
        }
        return givenNumbers;
    }

    public void validateUserNumbers(Set<Integer> givenNumbers, int userInput) {

        if (isInRange(userInput)) {
            givenNumbers.add(userInput);
        } else {
            System.out.printf(LottoMessages.NOT_IN_RANGE_WITH_GIVEN_NUMBER, userInput, LOWER_BOUND, UPPER_BOUND);
        }
    }

    private boolean isInRange(int userInput) {
        return (userInput >= RANDOM_NUMBERS_START && userInput <= RANDOM_NUMBERS_END);
    }

    private boolean areUserInputLessThanSixNumbers(Set<Integer> numbers) {
        return numbers.size() < HOW_MANY_NUMBERS_FROM_USER;
    }
}


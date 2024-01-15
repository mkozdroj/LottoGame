package games.lotto.input;

import games.lotto.messages.LottoMessages;

import java.util.*;

import static games.lotto.configuration.LottoGameConfiguration.*;

public class LottoUserInput {

    public Set<Integer> getSixNumbers(Scanner scanner) {
        Set<Integer> givenNumbersFromUser = getNumbersFromUserInput(scanner);
        scanner.close();
        return givenNumbersFromUser;
    }

    private Set<Integer> getNumbersFromUserInput(Scanner input) {
        final Set<Integer> givenNumbers = new HashSet<>();
        System.out.println(String.format(LottoMessages.PLEASE_GIVE_NUMBER, HOW_MANY_NUMBERS_FROM_USER));
        while (areUserInputLessThanSixNumbers(givenNumbers)) {
            System.out.printf(LottoMessages.GIVE_NUMBER, LOWER_BOUND, UPPER_BOUND);
            while (!input.hasNextInt()) {
                System.out.printf(LottoMessages.IS_NOT_IN_RANGE, LOWER_BOUND, UPPER_BOUND);
                if (!input.hasNext()) {
                    return Collections.emptySet();
                }
            }
            final int userInput = input.nextInt();
            validateUserNumbers(givenNumbers, userInput);
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


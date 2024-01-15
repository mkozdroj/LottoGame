package games.lotto.logic;

import games.lotto.configuration.LottoGameConfiguration;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoRandomNumberGenerator {
    public Set<Integer> getSixRandomNumbers(){
        Set<Integer> sixRandomNumbers = new HashSet<>();
       Random random = new Random();
       while(sixRandomNumbers.size()<6){
           Integer newRandom = random.nextInt(LottoGameConfiguration.RANDOM_NUMBERS_START, LottoGameConfiguration.RANDOM_NUMBERS_END);
           sixRandomNumbers.add(newRandom);
           }
       return sixRandomNumbers;
    }
}

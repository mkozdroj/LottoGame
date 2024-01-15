package org.example;


import games.Game;
import games.lotto.LottoGame;
import games.lotto.input.LottoUserInput;
import games.lotto.logic.LottoNumbersOfHits;
import games.lotto.logic.LottoRandomNumberGenerator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final Game lottoGame = getLottoGame();
        lottoGame.startGame();
    }
        private static Game getLottoGame(){
        final LottoUserInput lottoUserInput = new LottoUserInput();
        final LottoRandomNumberGenerator lottoRandomNumberGenerator = new LottoRandomNumberGenerator();
        final LottoNumbersOfHits lottoNumbersOfHits = new LottoNumbersOfHits();
        final Scanner scanner = new Scanner(System.in);
        return new LottoGame(lottoUserInput,lottoRandomNumberGenerator, lottoNumbersOfHits,scanner);





    }
}


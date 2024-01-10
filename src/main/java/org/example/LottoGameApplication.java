package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        System.out.println("Hello!");
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        double random = lottoNumberGenerator.generateRandomNumber();
        System.out.println(random);






    }
}


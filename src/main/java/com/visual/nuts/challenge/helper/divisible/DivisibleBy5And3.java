package com.visual.nuts.challenge.helper.divisible;

public class DivisibleBy5And3 extends Divisible {

    @Override
    public String isDivisible(int number) {
        if (number % 5 == 0 && number % 3 == 0) {
            return "Visual Nuts";
        }
        return checkNext(number);
    }
}

package com.visual.nuts.challenge.helper.divisible;

public class DivisibleBy5 extends Divisible {

    @Override
    public String isDivisible(int number) {
        if (number % 5 == 0) {
            return "Nuts";
        }
        return checkNext(number);
    }
}

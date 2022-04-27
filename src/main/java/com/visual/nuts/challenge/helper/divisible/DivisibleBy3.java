package com.visual.nuts.challenge.helper.divisible;

public class DivisibleBy3 extends Divisible {

    @Override
    public String isDivisible(int number) {
        if (number % 3 == 0) {
            return "Visual";
        }
        return checkNext(number);
    }
}

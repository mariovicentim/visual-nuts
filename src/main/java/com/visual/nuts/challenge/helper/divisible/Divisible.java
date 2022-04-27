package com.visual.nuts.challenge.helper.divisible;

public abstract class Divisible {
    Divisible next;

    public abstract String isDivisible(int number);

    public Divisible linkWith(Divisible next) {
        this.next = next;
        return next;
    }

    protected String checkNext(int number) {
        if (next == null) {
            return String.valueOf(number);
        }
        return next.isDivisible(number);
    }

}

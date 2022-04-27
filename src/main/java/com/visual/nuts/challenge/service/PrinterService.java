package com.visual.nuts.challenge.service;

import com.visual.nuts.challenge.exception.InvalidNumberException;
import com.visual.nuts.challenge.helper.divisible.Divisible;
import com.visual.nuts.challenge.helper.divisible.DivisibleBy3;
import com.visual.nuts.challenge.helper.divisible.DivisibleBy5;
import com.visual.nuts.challenge.helper.divisible.DivisibleBy5And3;

public class PrinterService {

    public String print100VisualNuts() {
        return printVisualNuts(100);
    }

    public String printVisualNuts(int numbersToPrint) {
        if (numbersToPrint < 1) {
            throw new InvalidNumberException();
        }
        return printNumber(numbersToPrint, new StringBuilder(), 1);
    }

    private String printNumber(int numbersToPrint,
                               StringBuilder printer, int actualNumber) {
        if (numbersToPrint == 0) {
            return printer.toString();
        }
        String print = getPrintValue(actualNumber);
        System.out.println(print);
        printer.append(print);
        return printNumber(--numbersToPrint, printer, ++actualNumber);
    }

    private String getPrintValue(int actualNumber) {
        Divisible divisible = new DivisibleBy5And3()
                .linkWith(new DivisibleBy5())
                .linkWith(new DivisibleBy3());
        String print = divisible.isDivisible(actualNumber);
        return print;
    }
}

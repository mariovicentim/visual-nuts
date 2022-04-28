package com.visual.nuts.challenge.service;

import com.visual.nuts.challenge.exception.InvalidNumberException;
import com.visual.nuts.challenge.helper.divisible.Divisible;
import com.visual.nuts.challenge.helper.divisible.DivisibleBy3;
import com.visual.nuts.challenge.helper.divisible.DivisibleBy5;
import com.visual.nuts.challenge.helper.divisible.DivisibleBy5And3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrinterService {
    private static final Logger LOG = LoggerFactory.getLogger(PrinterService.class);

    public List<String> print100VisualNuts() {
        return printVisualNuts(100);
    }

    public List<String> printVisualNuts(int numbersToPrint) {
        if (numbersToPrint < 1) {
            throw new InvalidNumberException();
        }
        return printNumber(numbersToPrint, new ArrayList<>(), 1);
    }

    private List<String> printNumber(int numbersToPrint,
                                     ArrayList<String> printer, int actualNumber) {
        if (numbersToPrint == 0) {
            return printer;
        }
        String print = getPrintValue(actualNumber);
        LOG.info(print);
        printer.add(print);
        return printNumber(--numbersToPrint, printer, ++actualNumber);
    }

    private String getPrintValue(int actualNumber) {
        Divisible divisible = new DivisibleBy5And3();
        divisible.linkWith(new DivisibleBy5())
                .linkWith(new DivisibleBy3());
        return divisible.isDivisible(actualNumber);
    }
}

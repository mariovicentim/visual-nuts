package com.visual.nuts.challenge;

import com.visual.nuts.challenge.service.PrinterService;
import configuration.TestContextConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@Import(TestContextConfiguration.class)
public class PrinterTest {

    @Autowired
    private PrinterService printerService;

    @Test
    public void print100VisualNuts() {

        final List<String> result = printerService.print100VisualNuts();
        Assert.assertEquals("Visual", result.get(2));//line 3
        Assert.assertEquals("Nuts", result.get(4));// line 5
        Assert.assertEquals("Visual Nuts", result.get(14));//line 15
        Assert.assertEquals("11", result.get(10));//line 11
        Assert.assertEquals(100, result.size());

        final List<String> result2 = printerService.printVisualNuts(500);
        Assert.assertEquals("Visual", result2.get(152));//line 153
        Assert.assertEquals("Nuts", result2.get(399));// line 400
        Assert.assertEquals("Visual Nuts", result2.get(359));//line 360
        Assert.assertEquals("311", result2.get(310));//line 311
        Assert.assertEquals(500, result2.size());
    }

}

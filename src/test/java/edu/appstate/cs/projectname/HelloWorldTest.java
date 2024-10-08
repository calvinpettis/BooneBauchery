package edu.appstate.cs.projectname;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.appstate.cs.BooneBauchery.main.Helloworld;

public class HelloWorldTest {
    
    @Test
    public void testNormalPercentComputation() {
        Helloworld test = new Helloworld();
        String result = test.test();
        assertEquals("Hello, World!", result, "She's not workin' :(");
    }

//    @Test
//    public void testZeroDenominator() {
//        float result = App.computePercent(50, 0);
//        assertEquals(0.0, result, "Should get a 0.0 with 0.0 for denominator");
//    }
}

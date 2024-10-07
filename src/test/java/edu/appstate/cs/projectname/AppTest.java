package edu.appstate.cs.projectname;

import edu.appstate.cs.BooneBauchery.display.gui.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest
{
    @Test
    public void testApp()
    {
        assertTrue(true, "This should never fail");
    }

    GUI constructorTest = new GUI();
    String result = constructorTest.getBigLogo();
    @Test
    public void testConstructor()
    {
        assertEquals("Hello, World!", result, "She's workin' baby.");
    }
}
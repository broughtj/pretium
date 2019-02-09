package org.brough.pretium;

import org.brough.pretium.Util.Util;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/*
this is to test the different functionality of the Pricing Engine
 */

public class EngineTester {



    //example of a basic unit test
    @Test
    public void testUtilChoose(){
        double d = Util.choose(5, 3);
        assertEquals(d, (double) 10, .00001);
    }
}

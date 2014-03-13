package edu.berkeley.ischool.aep;

import org.junit.Test;


import static junit.framework.Assert.assertEquals;

/**
 * Created by derekkan on 3/7/14.
 */
public class ReverseTest {

    @Test
    public void shouldReverseString(){
        String s = "re";

        assertEquals("er", Reverser.reverse(s));
    }
}

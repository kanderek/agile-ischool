package edu.berkeley.ischool.aep;

import edu.berkeley.ischool.aep.Rectangle;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by derekkan on 1/24/14.
 */
public class RectangleTest {

    @Test
    public void shouldReturnAreaOfTenForTwoByFiveRectangle() {
        Rectangle rectangle = new Rectangle(5, 2);
        assertEquals(10.0, rectangle.getArea());

    }

    @Test
    public void shouldReturnAreaOfTwelveForThreeByFourRectangle() {
        Rectangle rectangle = new Rectangle(3, 4);
        assertEquals(12.0, rectangle.getArea());

    }
}

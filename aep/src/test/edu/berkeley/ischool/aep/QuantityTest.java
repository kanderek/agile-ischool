package edu.berkeley.ischool.aep;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by derekkan on 2/14/14.
 */
public class QuantityTest {

    @Test
    public void ThreeFeetShouldBeEqualToOneYard() {
        assertEquals(new ArithmeticQuantity(1.0, Unit.YARDS), new ArithmeticQuantity(3, Unit.FEET));
    }

    @Test
    public void oneThousandSomethingsYardsShouldBeEqualToOneMile() {
        assertEquals(new ArithmeticQuantity(1760, Unit.YARDS), new ArithmeticQuantity(1, Unit.MILES));
    }

    @Test
    public void oneTbsShouldEqualThreeTsp() {
        Assert.assertEquals(new ArithmeticQuantity(1, Unit.TABLESPOONS), (new ArithmeticQuantity(3, Unit.TEASPOONS)));
    }

    @Test
    public void oneOzShouldEqualTwoTbs() {
        Assert.assertEquals(new ArithmeticQuantity(1, Unit.OUNCES), (new ArithmeticQuantity(2, Unit.TABLESPOONS)));
    }

    @Test
    public void EightOzShouldEqualOneCup() {
        Assert.assertEquals(new ArithmeticQuantity(8, Unit.OUNCES), (new ArithmeticQuantity(1, Unit.CUPS)));
    }

    //@Test(expected = RuntimeException.class)
    //public void OneFootShouldNotEqualThreeTsp() {
    //    assertFalse(new ArithmeticQuantity(1, Unit.FEET).equals(new ArithmeticQuantity(3, Unit.TABLESPOONS)));
    //}

    @Test
    public void TwoInchesPlusTwoInchesEqualFourInches() {
        Assert.assertEquals(new ArithmeticQuantity(4, Unit.INCHES), (new ArithmeticQuantity(2, Unit.INCHES)).add(new ArithmeticQuantity(2, Unit.INCHES)));
    }

    @Test
    public void TwoTbsPlusOneOzEqualTwelveTsp() {
        Assert.assertEquals(new ArithmeticQuantity(12, Unit.TEASPOONS), (new ArithmeticQuantity(2, Unit.TABLESPOONS)).add(new ArithmeticQuantity(1, Unit.OUNCES)));
    }

    @Test(expected = RuntimeException.class)
    public void twoOzPlusOne() throws RuntimeException {
        Assert.assertEquals(new ArithmeticQuantity(1, Unit.FEET), (new ArithmeticQuantity(2, Unit.INCHES)).add(new ArithmeticQuantity(1, Unit.OUNCES)));
    }

    @Test
    public void twoHundredTwelveFarenheitShouldEqualOneHundredCelcius() {
        assertEquals(new Quantity(212, Unit.DEG_F), new Quantity(100, Unit.DEG_C));
        assertEquals(new Quantity(100, Unit.DEG_C), new Quantity(212, Unit.DEG_F));
    }

    @Test
    public void thirtyTwoFarenheitShouldEqualZeroCelcius() {
        assertEquals(new Quantity(32, Unit.DEG_F), new Quantity(0, Unit.DEG_C));
        assertEquals(new Quantity(0, Unit.DEG_C), new Quantity(32, Unit.DEG_F));
    }

    @Test
    public void OneFootShouldBeBetterThanSixInches() {
        assertTrue(new Quantity(1, Unit.FEET).betterThan(new Quantity(6, Unit.INCHES)));
    }

    @Test(expected = RuntimeException.class)
    public void twoUnitscomparedtotwoouncesshouldthrowexception()
    {
        assertTrue(new Quantity(1, Unit.FEET).betterThan(new Quantity(6, Unit.OUNCES)));

    }

    @Test(expected = RuntimeException.class)
    public void shouldNotBeAbleToCompareTwoUnitsOfDifferentTypes(){
        assertEquals(new Quantity(1, Unit.FEET), (new Quantity(2, Unit.INCHES)).betterThan(new Quantity(1, Unit.OUNCES)));
    }

    @Test
    public void oneFootShouldBeBestOfSetOfLengthsLessThanOneFoot(){

        Quantity a = new Quantity(1, Unit.FEET);
        Quantity b = new Quantity(2, Unit.INCHES);
        Quantity c = new Quantity(3, Unit.INCHES);

        Quantity[] quantitySet = {a, b, c};

        Bester testBester = new Bester(quantitySet);
        assertEquals(a, testBester.best());

    }

    @Test(expected = RuntimeException.class)
    public void setOfIncompatibleQuantitiesWhenComparedShouldReturnException(){

        Quantity a = new Quantity(1, Unit.FEET);
        Quantity b = new Quantity(2, Unit.INCHES);
        Quantity c = new Quantity(3, Unit.OUNCES);

        Quantity[] quantitySet = {a, b, c};

        Bester testBester = new Bester(quantitySet);
        assertEquals(a, testBester.best());
        assertEquals(a, testBester.best());

    }

}

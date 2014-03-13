package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by derekkan on 1/31/14.
 */
public class ChanceTest {

    @Test
    public void oneChanceShouldNotBeEqualToAnother() {
        Chance coinToss = new Chance(0.5);
        Chance dieThrow = new Chance((double) (0.7));
        //assertFalse(dieThrow.equals(coinToss));
        assertEquals(new Chance(0.5), coinToss);
        assertEquals(new Chance(0.5), coinToss.not());
    }

    @Test
    public void equalsShouldWorkAccordingToContract() {
        Chance coinToss = new Chance(0.5);
        assertFalse(coinToss.equals(null));
        assertFalse(coinToss.equals(new Object()));
    }

    @Test
    public void logicalAnd(){
        Chance eventA = new Chance(0.1);
        Chance eventB = new Chance(0.1);
        assertEquals(new Chance(0.1*0.1), eventA.and(eventB));
        assertEquals(new Chance(0.1*0.1), eventB.and(eventA));

        eventA = new Chance(0.5);
        assertEquals(new Chance(0.1*0.5), eventA.and(eventB));
        assertEquals(new Chance(0.1*0.5), eventB.and(eventA));
    }

    @Test
    public void logicalOr(){
        Chance eventA = new Chance(0.1);
        Chance eventB = new Chance(0.1);
        assertEquals(new Chance(0.1+0.1), eventA.or(eventB));
        assertEquals(new Chance(0.1+0.1), eventB.or(eventA));

        eventA = new Chance(0.5);
        assertEquals(new Chance(0.1+0.5), eventA.or(eventB));
        assertEquals(new Chance(0.1+0.5), eventB.or(eventA));
    }

    @Test
    public void aProbabiltyofHalfshouldbebetterThanprobabilityofquarter(){
        Chance eventA = new Chance(0.5);
        Chance eventB = new Chance(0.25);
        assertEquals(true, eventA.betterThan(eventB));
    }

    @Test
    public void comparingThreeProbabilitiesShouldReturnBest(){
        Chance eventA = new Chance(0.5);
        Chance eventB = new Chance(0.25);
        Chance eventC = new Chance(0.75);
        Chance eventD = new Chance(0.15);
        Bester newBester = new Bester(eventA, eventB, eventC, eventD);

        assertEquals(eventC, newBester.best());
    }




}
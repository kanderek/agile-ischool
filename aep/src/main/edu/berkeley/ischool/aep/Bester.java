package edu.berkeley.ischool.aep;

/**
 * Created by derekkan on 3/7/14.
 Bester understands what is the best possible item of a set of items

 */
public class Bester {

    private final /*Bestable[]*/Comparison[] thingsToCompare;

    public Bester(/*Bestable*/Comparison... thingsToCompare) {
        if (thingsToCompare == null) throw new NullPointerException();
        this.thingsToCompare = thingsToCompare;
    }

    public /*Bestable*/Comparison best() {
        /*Bestable*/Comparison champion = thingsToCompare[0];

        for(int i = 1; i < thingsToCompare.length; i++){
            Comparison challenger = thingsToCompare[i];

            if(challenger.betterThan(champion)){
                champion = challenger;
            }
        }
        return champion;
    }
}

package edu.berkeley.ischool.aep;

/**
 * Created by derekkan on 1/31/14.
 */
public class Chance implements Comparison<Chance>{
    final private double probability;

    public Chance(double probability){
        this.probability = probability;
    }

    public Chance not(){
        return new Chance( 1 - this.probability);
    }

    @Override
    public boolean equals(Object other){
        if (other == this) return true;
        if (!(other instanceof Chance)) return false;
        return this.probability == ((Chance) other).probability;
    }

    @Override
    public int hashCode() {
        return 42;
    }

    public Chance and(Chance b){

        return new Chance(this.probability*b.probability);
    }

    public Chance or(Chance b){

        return new Chance(this.probability+b.probability);
    }

    @Override
    public boolean betterThan(Chance otherChance){
        //casting here makes Jez feel dirty...
        return this.probability > otherChance.probability;
    }

    @Override
    public String toString(){
        return "Probability: " + this.probability;
    }
}

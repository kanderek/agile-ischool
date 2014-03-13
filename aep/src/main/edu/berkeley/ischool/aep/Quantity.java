package edu.berkeley.ischool.aep;

/**
 * Created by derekkan on 2/21/14.
 */
public class Quantity implements Comparison<Quantity> {
    /*
        3 ft = 1 yd
        1760 yd = 1 mi
        1 tbsp = 3 tsp
        1 oz = 2 tbsp
        8 oz = 1 cup
        */
    double value;
    Unit unit;

    public Quantity(double value, Unit unit) {
        this.unit = unit;
        this.value = value;
    }

    double convertTo(Unit otherUnit) {
        return unit.convertTo(value, otherUnit);
    }

    //methods should be verbs (object oriented philosophy)
    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof Quantity)) return false;
        Quantity otherQuantity = (Quantity) other;
        try {
            double otherValue = otherQuantity.convertTo(this.unit);//convert to me, quantity class must know itself (unit and value)!
            return Math.abs(this.value - otherValue) <= 0.0000001;//Double.MIN_VALUE;
        }
        catch(Exception e){
            return false;
        }
        //dont's ask tell! Maintain encapsulation!
    }

    public boolean betterThan(Quantity otherQuantity){

        double otherValue = otherQuantity.convertTo(this.unit);//convert to me, quantity class must know itself (unit and value)!
        return this.value > otherValue;

    }
/*
    public static Comparison bestOf(Quantity[] quantities){
        Quantity best = quantities[0];

        for(int i = 0; i < quantities.length - 1; i++){
           if(quantities[i+1].betterThan(best)){
               best = quantities[i+1];
           }
        }

        return best;
    }
*/
    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public String toString(){
        return "Value: " + this.value + " " + this.unit;
    }
}

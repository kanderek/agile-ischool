package edu.berkeley.ischool.aep;

// Understands unit equivalence
public class ArithmeticQuantity extends Quantity {

    public ArithmeticQuantity(double value, Unit unit) {
        super(value, unit);
    }

    public ArithmeticQuantity add(ArithmeticQuantity arithmeticQuantity) {

        double otherValue = arithmeticQuantity.unit.convertTo(arithmeticQuantity.value, this.unit);
        return new ArithmeticQuantity((this.value + otherValue), this.unit);

    }

}

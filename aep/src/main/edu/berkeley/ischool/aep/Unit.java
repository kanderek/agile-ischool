package edu.berkeley.ischool.aep;

// Understands how to convert between different types of quantities
public class Unit {

    public static Unit INCHES = new Unit(1, "Inches", UnitType.LENGTH);
    public static Unit FEET = new Unit(12, "Feet",  UnitType.LENGTH);
    public static Unit YARDS = new Unit(36, "Yards",  UnitType.LENGTH);
    public static Unit MILES = new Unit(1760*3*12, "Miles",  UnitType.LENGTH);

    public static Unit TEASPOONS = new Unit(1, "Teaspoons",  UnitType.VOLUME);
    public static Unit TABLESPOONS = new Unit(3, "Tablespoons",  UnitType.VOLUME);
    public static Unit OUNCES = new Unit(6, "Ounces", UnitType.VOLUME);
    public static Unit CUPS = new Unit(48, "Cups", UnitType.VOLUME);

    //5*32/9 = 17.7777778
    public static Unit DEG_F = new Unit(1, -17.7777778, "Deg F", UnitType.TEMPERATURE);
    public static Unit DEG_C = new Unit(1.8, 32, "Deg C", UnitType.TEMPERATURE);


    public enum UnitType { LENGTH, VOLUME, TEMPERATURE };
    private final double conversionFactor;
    private final double offset;
    private final String name;
    private final UnitType type;

    private Unit(double conversionFactor, String name, UnitType type) {
        this.conversionFactor = conversionFactor;
        this.offset = 0;
        this.name = name;
        this.type = type;
    }

    /* HW
        212 degF = 100 degC
        32 degF = 0 degC

        F to C -> C * 9/5 + 32 = F
        C to F -> (F - 32) * 5/9 = C
    */
    private Unit(double conversionFactor, double offset, String name, UnitType type) {
        this.conversionFactor = conversionFactor;
        this.offset = offset;
        this.name = name;
        this.type = type;
    }

    double convertTo(double size, Unit otherUnit) {

        if(this.type != otherUnit.type){
            throw new RuntimeException();
        }

        double converted =  size * conversionFactor / otherUnit.conversionFactor + this.offset;
//        System.out.println(conversionFactor + ", " + otherUnit.conversionFactor + ", " + this.offset);
//        System.out.println(size + " " + this + " equals " + converted + " " +  otherUnit);
        return converted;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

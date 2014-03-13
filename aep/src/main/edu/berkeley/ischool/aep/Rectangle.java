package edu.berkeley.ischool.aep;

/**
 * Understands a four-sided figure with sides at right angles
 */
public class Rectangle {
    double height;
    double width;

    public Rectangle(){
        this.height = 0;
        this.width = 0;
    }

    public Rectangle(double width, double height){
        setWidth(width);
        setHeight(height);
    }

    private double getHeight() {
        return this.height;
    }

    private double getWidth() {
        return this.width;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    public double getArea(){
        return this.height*this.width;
    }

    public double getPerimeter(){
        return this.height*2+this.width*2;
    }

    public boolean isSquare(){
        if (this.height == this.width){
            return true;
        }
        else {
            return false;
        }
    }

}

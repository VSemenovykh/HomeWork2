package ru.ncedu.oopoop2.myrectangle;

import java.util.Objects;

/**
 * This class MyRectangle
 * Override methods equals and hashcode
 * @version 2.0, 3 Jan 2021
 * @author Vladislav Semenovykh
 */
public class MyRectangle {
    private float length = 1.0f;
    private float width = 1.0f;

    /**
     * Constructor - creating a new instance
     * @see #MyRectangle(float, float)
     */
    public MyRectangle(){

    }

    /**
     * Constructor - creating a new instance with specific values
     * @param length
     * @param width
     */
    public MyRectangle(float length, float width){
        this.length = length;
        this.width = width;

    }

    /**
     * Method to get field {@link #length}
     * @return length
     */
    public float getLength(){
        return this.length;
    }

    /**
     * Procedure for determination field {@link #length}
     * @param length
     */
    public void setLength(float length){
        this.length = length;
    }

    /**
     * Method to get field {@link #width}
     * @return width
     */
    public float getWidth(){
        return this.width;
    }

    /**
     * Procedure for determination field {@link #width}
     * @param width
     */
    public void setWidth(float width){
        this.width = width;
    }

    /**
     * Method to get area rectangle
     * @return area
     */
    public double getArea(){
        return (double)(this.length*this.width);
    }

    /**
     * Method to get perimeter rectangle
     * @return perimeter
     */
    public double gerPerimeter(){
        return (double)(this.width+this.length);
    }

    /**
     * String representation instance this class
     * @return "Recrangle[length={@link #length}, width={@link #width}]"
     */
    @Override
    public String toString() {
        return "Rectangle[" +
                          "length=" + length +
                        ", width=" + width +
                         "]";
    }

    /**
     * Method is compare this instance with Object o
     * @param o
     * @return true if this instance == Object o, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyRectangle rectangle = (MyRectangle) o;
        return Float.compare(rectangle.length, length) == 0 &&
               Float.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }
}

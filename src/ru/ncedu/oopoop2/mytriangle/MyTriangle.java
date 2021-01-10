package ru.ncedu.oopoop2.mytriangle;

import ru.ncedu.oopoop2.mypoint.MyPoint;

import java.util.Objects;

/**
 * This class MyTriangle
 * Override methods equals and hashcode
 * @version 2.0, 3 Jan 2021
 * @author Vladislav Semenovykh
 */
public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public enum typeTriangle{
        EQUILATERAL, ISOSCELES, SCALENE;
    }

    /**
     * Constructor - creating a new instance with specific values
     * @param x1
     * @param y1
     * @param x2
     * @param y3
     * @param x3
     * @param y3
     * @see #MyTriangle(MyPoint, MyPoint, MyPoint)
     */
    public MyTriangle(int x1, int y1, int x2, int y2,
                      int x3, int y3){

        this.v1 = new MyPoint(x1, y1);
        this.v2 = new MyPoint(x2, y2);
        this.v3 = new MyPoint(x3, y3);

    }

    /**
     * Constructor - creating a new instance with specific values
     * @param v1
     * @param v2
     * @param v3
     * @see #MyTriangle(int, int, int, int, int, int)
     */
    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3){
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    /**
     * String representation instance this class
     * @return "MyTriangle[v1=(x1,y1), v2=(x2,y2), v3=(x3,y3)]"
     */
    @Override
    public String toString() {
        return "MyTriangle[" +
                           "v1=" + v1.toString() +
                         ", v2=" + v2.toString() +
                         ", v3=" + v3.toString() +
                         "]";
    }

    /**
     * Method calculate perimeter triangle
     * @return perimeter
     */
    public double getPerimeter(){
        double distOne = this.v1.distance(this.v2);
        double distTwo = this.v1.distance(this.v3);
        double distThree = this.v2.distance(this.v3);
        return (distOne + distTwo + distThree);
    }

    /**
     * Method definition type triangle
     * @return type
     */
    public String getType(){
        Double distOneTwo = this.v1.distance(this.v2);
        Double distOneThree = this.v1.distance(this.v3);
        Double distTwoThree = this.v2.distance(this.v3);

        /*СonditionOne for an equilateral triangle*/
        boolean conditionOne = ( ( distOneTwo.compareTo(distOneThree) == 0 )
                               & ( distOneThree.compareTo(distTwoThree) == 0 )
                               & ( distOneThree.compareTo(distTwoThree) == 0 ) );

        /*conditionTwo for an isosceles triangle*/
        boolean conditionTwo = ( ( ( distOneTwo.compareTo(distOneThree) != 0 ) & ( distOneTwo.compareTo(distTwoThree) == 0 ) )
                               | ( ( distOneTwo.compareTo(distTwoThree) != 0 ) & ( distOneTwo.compareTo(distOneThree) == 0 )  )
                               | ( ( distOneThree.compareTo(distTwoThree) != 0 ) & ( distOneThree.compareTo(distOneTwo) == 0 ) ) );

        return conditionOne ? String.valueOf(typeTriangle.EQUILATERAL) : conditionTwo ? String.valueOf(typeTriangle.ISOSCELES) : String.valueOf(typeTriangle.SCALENE);
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
        MyTriangle that = (MyTriangle) o;
        return Objects.equals(v1, that.v1) &&
                Objects.equals(v2, that.v2) &&
                Objects.equals(v3, that.v3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, v3);
    }
}

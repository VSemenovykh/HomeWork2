package ru.ncedu.oopoop2.myemployee;

import java.util.Objects;

/**
 * This class  Employee
 * Override methods equals and hashcode
 * @version 2.0, 3 Jan 2021
 * @author Vladislav Semenovykh
 */
public class Employee{
    private int id ;
    private String firstName;
    private String lastName ;
    private int salary;

    /**
     * Constructor - creating a new instance with specific values
     * @param id
     * @param firstName
     * @param lastName
     * @param salary
     */
    public Employee(int id, String firstName, String lastName, int salary){
        this.id =id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    /**
     * Method to get field {@link #id}
     * @return id
     */
    public int getID(){
        return this.id;
    }

    /**
     * Method to get field {@link #firstName}
     * @return firstName
     */
    public String getFirstName(){
        return  this.firstName;
    }

    /**
     * Method to get field {@link #lastName}
     * @return lastName
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * Method to get values full name
     * @return "{@link #firstName} {@link #lastName}"
     */
    public String getName(){
        return this.firstName+" "+this.lastName;
    }

    /**
     * Method to get field {@link #salary}
     * @return salary
     */
    public int getSalary(){
        return this.salary;
    }

    /**
     * Procedure for determination field {@link #salary}
     * @param salary
     */
    public void setSalary(int salary){
        this.salary = salary;
    }

    /**
     * Method to get  annual Salary
     * @return salary*12
     */
    public int getAnnualSalary(){
        return  (this.salary*12);
    }

    /**
     * Method to get  raise Salary
     * @return percent
     */
    public int raiseSalary(int percent){
        double salary = (double)this.salary;
        double raiseSalary = salary *(1.0 + (((double)percent)/100));
        return (int)raiseSalary;
    }

    /**
     * String representation instance this class
     * @return "Employee[id={@link #id}, name={@link #getName()}, salary={@link #salary}]"
     */
    @Override
    public String toString() {
        return "Employee[" +
                         "id=" + id +
                       ", firstName='" + firstName + '\'' +
                       ", lastName='" + lastName + '\'' +
                       ", salary=" + salary +
                       ']';
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
        Employee employee = (Employee) o;
        return id == employee.id &&
                salary == employee.salary &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, salary);
    }
}

package ru.ncedu.oopoop2.mybook;

import  java.lang.StringBuffer;
import java.util.Arrays;
import java.util.Objects;

/**
 * This class BookImp
 * Override methods equals and hashcode
 * @version 2.0, 3 Jan 2021
 * @author Vladislav Semenovykh
 */
public class Book{
    private String name;
    private Author[] authors;
    private double price;
    private int qry;

    /**
     * Constructor - creating a new instance with specific values
     * @param name
     * @param authors
     * @param price
     * @see #Book(String, Author[], double, int)
     */
    public Book(String name, Author[] authors, double price){
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    /**
     * Constructor - creating a new instance with specific values
     * @param name
     * @param authors
     * @param price
     * @param qry
     * @see #Book(String, Author[], double)
     */
    public Book(String name, Author[] authors, double price, int qry){
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qry = qry;
    }

    /**
     * Method to get field {@link #name}
     * @return name book
     */
    public String getName(){
        return this.name;
    }

    /**
     * Method to get field {@link #authors}
     * @return massiv objects Authors
     */
    public Author[] getAuthors(){
        return this.authors;
    }

    /**
     * Method to get field {@link #price}
     * @return price
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * Procedure for determination field {@link #price}
     * @param price
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     * Method to get field {@link #qry}
     * @return qry
     */
    public int getQry(){
        return this.qry;
    }

    /**
     * Procedure for determination field {@link #qry}
     * @param qry
     */
    public void setQry(int qry){
        this.qry = qry;
    }

    /**
     * String representation
     * @return "Book[name={@link #name},
     *               authors={authors[name={@link Book.Author#name},
     *                               email={@link Book.Author#email},
     *                               gender={@link Author#getName()}],....},
     *               price={@link #price},qty={@link #qry}]"
     */
    public String toString(){
        StringBuffer authors = new StringBuffer();
        for(int i=0; i<this.authors.length; i++){
            authors.append(this.authors[i].show()+",");
        }
        authors.replace(authors.length()-1, authors.length(), "" );
        return "Book[name=" + this.name +
                   ",authors={" + authors + "}" +
                   ",price=" + this.price +
                   ",qty=" + this.qry + "]";
    }

    /**
     * Method to get list authors
     * @return "authorName1, authorName2,..."
     */
    public String getAuthorNames(){
        StringBuffer authorNames = new StringBuffer();
        for(int i=0; i<this.authors.length; i++){
            authorNames.append(this.authors[i].getName()+",");
        }
        return authorNames.toString();
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
        Book book = (Book) o;
        return  Double.compare(book.price, price) == 0 &&
                qry == book.qry &&
                Objects.equals(name, book.name) &&
                Arrays.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, price, qry);
        result = 31 * result + Arrays.hashCode(authors);
        return result;
    }

    /**
     * Static class Author
     */
    public static class Author {
        private String name;
        private String email;
        private char gender;

        /**
         * Constructor - creating a new instance with specific values
         */
        public Author(String name, String email, char gender) {
            this.name = name;
            this.email = email;
            this.gender = gender;
        }

        /**
         * Method to get field {@link Book.Author#name}
         *
         * @return name
         */
        public String getName() {
            return this.name;
        }

        /**
         * Method to get field {@link Book.Author#email}
         */
        public String getEmail() {
            return this.email;
        }

        /**
         * Method to get fied {@link Book.Author#gender}
         */
        public char getGender() {
            return this.gender;
        }

        /**
         * String representation instance this class
         *
         * @return "Author[name={@link Book.Author#name}
         * ,email={@link Book.Author#email}
         * ,gender={@link Book.Author#gender}]";
         */
        public String show() {
            return "Author[name=" + this.name +
                    ",email=" + this.email +
                    ",gender=" + this.gender + "]";
        }

    }
}


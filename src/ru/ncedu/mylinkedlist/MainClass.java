package ru.ncedu.mylinkedlist;

import ru.ncedu.oopoop2.mycircle.Circle;
import java.util.*;

/**
 * This class MainClass
 * @version 1.0, 5 Jan 2021
 * @author Vladislav Semenovykh
 */
public class MainClass {
    /**
     * Static method is prints the running time of a piece of code
     * @param start
     * @param finish
     */
    public static void printElapsed(long start, long finish){
        long elapsed = finish - start;
        System.out.println("elapsed time, ns: " + elapsed);
        System.out.println();
    }

    /**
     * Static method is prints the running time of add by elements operations for class MyLinkedListImp
     * @param myLinkedListImp
     * @param iter
     */
    public static void addTimeMyLinkedList(MyLinkedListImp myLinkedListImp, long iter){
        long start= System.nanoTime();
        for(int i = 0; i < iter; i++){
            myLinkedListImp.add(new Integer(i));
        }
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of add by index and elements operations for class MyLinkedListImp
     * @param myLinkedListImp
     * @param iter
     */
    public static void addIndexTimeMyLinkedList(int index, MyLinkedListImp myLinkedListImp, long iter){
        long start= System.nanoTime();
        myLinkedListImp.add(index, new Integer(155));
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of remove by index operations for class MyLinkedListImp
     * @param index
     * @param myLinkedListImp
     */
    public static void removeTimeMyLinkedList(int index, MyLinkedListImp myLinkedListImp){
        long start= System.nanoTime();
        myLinkedListImp.remove(index);
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of clear operations for class MyLinkedListImp
     * @param myLinkedListImp
     */
    public static void clearTimeMyLinkedList(MyLinkedListImp myLinkedListImp){
        long start= System.nanoTime();
        myLinkedListImp.clear();
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of add by elements operations for class LinkedList
     * @param linkedlist
     * @param iter
     */
    public static void addTimeLinkedList(LinkedList linkedlist, long iter){
        long start= System.nanoTime();
        for(int i = 0; i < iter; i++){
            linkedlist.add(new Integer(i));
        }
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of add by index and elements operations for class LinkedList
     * @param index
     * @param linkedlist
     * @param iter
     */
    public static void addIndexTimeLinkedList(int index, LinkedList linkedlist, long iter){
        long start= System.nanoTime();
        linkedlist.add(index, new Integer(155));
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of remove by index operations for class LinkedList
     * @param index
     * @param linkedlist
     */
    public static void removeTimeLinkedList(int index, LinkedList linkedlist){
        long start= System.nanoTime();
        linkedlist.remove(index);
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of clear operations for class LinkedList
     * @param linkedlist
     */
    public static void clearTimeLinkedList(LinkedList linkedlist){
        long start= System.nanoTime();
        linkedlist.clear();
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method Main where compare classes MyLinedListImp and LinkedList
     * Also here to testing class MyLinedListImp
     */
    public static void main(String[] args) {
        final long N = 10000;

        /********** MyLinkedListImp ***********/
        System.out.println("----- MyLinkedListImp -----");
        MyLinkedListImp<Integer> mylinkedlist = new MyLinkedListImp<Integer>();
        //add by elements
        System.out.println("add(E elements)" );
        addTimeMyLinkedList( mylinkedlist, N);
        //add by index and elements
        System.out.println("add(int index, E elemnts)" );
        addIndexTimeMyLinkedList(500,  mylinkedlist, N);
        //remove by index
        System.out.println("remove(int index)" );
        removeTimeMyLinkedList(500,  mylinkedlist);
        //clear
        System.out.println("clear");
        clearTimeMyLinkedList(mylinkedlist);

        /********** LinkedList ***********/
        System.out.println("----- LinkedList -----");
        LinkedList<Integer> linkedlist = new LinkedList<Integer>();
        //add by elements
        System.out.println("add(E elements)" );
        addTimeLinkedList( linkedlist, N);
        //add by index and elements
        System.out.println("add(int index, E elemnts)" );
        addIndexTimeLinkedList(500,  linkedlist, N);
        //remove by index
        System.out.println("remove(int index)" );
        removeTimeLinkedList(500,  linkedlist);
        //clear
        System.out.println("clear");
        clearTimeLinkedList(linkedlist);

        /********** Testing MyLinkedListImp ***********/
        MyLinkedListImp mylinkedlist2 = new MyLinkedListImp();
        mylinkedlist2.add(new Circle(2.0, "green"));
        mylinkedlist2.add(new Circle( 2.5, "red"));
        mylinkedlist2.add(new Circle(0.5, "yellow"));
        mylinkedlist2.add(new Circle(2.0, "blue"));
        mylinkedlist2.add(2, new Circle(10.0, "gray"));

        System.out.println("get: " +  mylinkedlist2.get(2));
        System.out.println("indexOf: " +  mylinkedlist2.indexOf(new Circle(0.5, "yellow")) );
        System.out.println("remove: " + mylinkedlist2.remove(1));
        System.out.println("toString: " + mylinkedlist2.toString());
        System.out.println("size():  " + mylinkedlist2.size());

        mylinkedlist2.add(1, new Circle(22.0, "ewf"));
        System.out.println("toString: " + mylinkedlist2.toString());
        System.out.println("size():  " + mylinkedlist2.size());

        mylinkedlist2.set(4, new Circle(5, "fv"));

        System.out.println("Iterator");
        Iterator<Circle> itr = mylinkedlist2.iterator();
        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + "\n");
        }
        System.out.println();
        System.out.println("clear(): ");
        mylinkedlist2.clear();
        System.out.println("toString: " + mylinkedlist2.toString());
    }
}

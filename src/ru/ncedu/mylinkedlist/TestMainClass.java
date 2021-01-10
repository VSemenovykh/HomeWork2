package ru.ncedu.mylinkedlist;

import java.util.*;
/**
 * This class TestMainClass
 * @version 1.0, 4 Jan 2021
 * @author Vladislav Semenovykh
 */
public class TestMainClass {
    /**
     * Static method is prints the running time of a piece of code
     * @param start
     * @param finish
     */
    public static void printElapsed(long start, long finish){
        long elapsed = finish - start;
        System.out.println("elapsed time, ns: " + elapsed);
    }

    /**
     * Static method is add for interface Set
     * @param set
     * @param iter
     */
    public static void addSet(Set set, long iter){
        for(int i = 0; i < iter; i++){
            set.add(new Integer(i));
        }
    }

    /**
     * Static method is add for interface List
     * @param list
     * @param iter
     */
    public static void addList(List list, long iter){
        for(int i = 0; i < iter; i++){
            list.add(new Integer(i));
        }
    }

    /**
     * Static method is put for interface Map
     * @param map
     * @param iter
     */
    public static void putMap(Map map, long iter){
        for(int i = 0; i < iter; i++){
            map.put(i, new Integer(i*2));
        }
        long finish = System.nanoTime();
    }

    /**
     * Static method is prints the running time of add by elements operations for interface Set
     * @param set
     * @param iter
     */
    public static void addTimeSet(Set set, long iter){
        long start= System.nanoTime();
        for(int i = 0; i < iter; i++){
            set.add(new Integer(i));
        }
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of add by elements operations for interface List
     * @param list
     * @param iter
     */
    public static void addTimeList(List list, long iter){
        long start= System.nanoTime();
        for(int i = 0; i < iter; i++){
            list.add(new Integer(i));
        }
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of add by index and elements operations for interface List
     * @param list
     * @param list
     * @param element
     */
    public static void addIndexTimeList(int index, List list, int element){
        long start= System.nanoTime();
        list.add(index, new Integer(element));
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of add by key - values operations for interface <ap>
     * @param map
     * @param iter
     */
    public static void putTimeMap(Map map, long iter){
        long start= System.nanoTime();
        for(int i = 0; i < iter; i++){
            map.put(i, new Integer(i*2));
        }
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of clear operations for interface Set
     * @param set
     */
    public static void clearTimeSet(Set set){
        long start= System.nanoTime();
        set.clear();
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of clear operations for interface List
     * @param list
     */
    public static void clearTimeList(List list){
        long start= System.nanoTime();
        list.clear();
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of clear operations for interface Map
     * @param map
     */
    public static void clearTimeMap(Map map){
        long start= System.nanoTime();
        map.clear();
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of remove by index operations for interface List
     * @param index
     * @param list
     */
    public static void removeTimeList(int index, List list){
        long start= System.nanoTime();
        list.remove(index);
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    /**
     * Static method is prints the running time of remove by key operations for interface Map
     * @param key
     * @param map
     */
    public static void removeTimeMap(Integer key, Map map){
        long start= System.nanoTime();
        map.remove(key);
        long finish = System.nanoTime();
        printElapsed(start, finish);
    }

    public static void main(String[] args){
        final int N= 50000;
        System.out.println("N = " + N + ", Object new Integer()");
        //Compare ArrayList, LinkedList
        System.out.println("----- Compare ArrayList, LinkedList -----");
        //ArrayList
        System.out.println("----- ArrayList -----");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        /*add*/
        System.out.println("add(Object)");
        addTimeList(arrayList, N);
        /*add(index, object)*/
        System.out.println("add(index, object)");
        System.out.println("start:");
        addIndexTimeList(1,arrayList, 15555);
        System.out.println("middle:");
        addIndexTimeList(500,arrayList, 15555);
        System.out.println("end:");
        addIndexTimeList(1000,arrayList, 15555);
        /*clear*/
        System.out.println("clear()");
        addList(arrayList, N);
        clearTimeList(arrayList);
        /*remove(index, instance)*/
        System.out.println("remove(index, instance)");
        addList(arrayList, N);
        System.out.println(" start:");
        removeTimeList(0, arrayList);
        addList(arrayList, N);
        System.out.println(" middle:");
        removeTimeList(500, arrayList);
        addList(arrayList, N);
        System.out.println(" end:");
        removeTimeList(1000, arrayList);

        //LinkedList
        System.out.println("----- LinkedList -----");
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        /*add*/
        System.out.println("add(Object)");
        addTimeList(linkedList, N);
        /*add(index, object)*/
        System.out.println("add(index, object)");
        System.out.println("start:");
        addIndexTimeList(1,linkedList, 15555);
        System.out.println("middle:");
        addIndexTimeList(500,linkedList, 15555);
        System.out.println("end:");
        addIndexTimeList(1000,linkedList, 15555);
        /*clear*/
        System.out.println("clear()");
        addList(linkedList, N);
        clearTimeList(linkedList);
        /*remove(index, instance)*/
        System.out.println("remove(index, instance)");
        addList(linkedList, N);
        System.out.println(" start:");
        removeTimeList(0, linkedList);
        addList(linkedList, N);
        System.out.println(" middle:");
        removeTimeList(500, linkedList);
        addList(linkedList, N);
        System.out.println(" end:");
        removeTimeList(1000, linkedList);

        //Compare HashSet, LinkedHashSet, TreeSet
        System.out.println("----- Compare HashSet, LinkedHashSet, TreeSet -----");
        //HashSet
        System.out.println("----- HashSet -----");
        HashSet<Integer> hashSet = new HashSet<Integer>();
        /*add*/
        System.out.println("add(Object)");
        addTimeSet(hashSet, N);
        /*clear*/
        System.out.println("clear()");
        addSet(hashSet, N);
        clearTimeSet(hashSet);

        //LinkedHashSet
        System.out.println("----- LinkedHashSet -----");
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();
        /*add*/
        System.out.println("add(Object)");
        addTimeSet(linkedHashSet, N);
        /*clear*/
        System.out.println("clear()");
        addSet(linkedHashSet, N);
        clearTimeSet(linkedHashSet);

        //TreeSet
        System.out.println("----- TreeSet -----");
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        /*add*/
        System.out.println("add(Object)");
        addTimeSet(treeSet, N);
        /*clear*/
        System.out.println("clear()");
        addSet(treeSet, N);
        clearTimeSet(treeSet);

        //Compare HashMap, LinkedHashMap, TreeMap
        System.out.println("----- Compare HashMap, LinkedHashMap, TreeMap -----");
        //HashMap
        System.out.println("----- HashMap -----");
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        /*put*/
        System.out.println("put(Integer key, Object Circle)");
        putTimeMap(hashMap, N);
        /*clear*/
        System.out.println("clear()");
        putMap(hashMap, N);
        clearTimeMap(hashMap);
        System.out.println("remove(Object key)");
        putMap(hashMap,N);
        removeTimeMap(500,hashMap);

        //LinkedHashMap
        System.out.println("----- LinkedHashMap -----");
        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        /*put*/
        System.out.println("put(Integer key, Object Circle)");
        putTimeMap(linkedHashMap, N);
        /*clear*/
        System.out.println("clear()");
        putMap(linkedHashMap, N);
        clearTimeMap(linkedHashMap);
        System.out.println("remove(Object key)");
        putMap(linkedHashMap,N);
        removeTimeMap(500,linkedHashMap);

        //TreeMap
        System.out.println("----- TreeMap -----");
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer, Integer>();
        /*put*/
        System.out.println("put(Integer key, Object Circle)");
        putTimeMap(treeMap, N);
        /*clear*/
        System.out.println("clear()");
        putMap(treeMap, N);
        clearTimeMap(treeMap);
        System.out.println("remove(Object key)");
        putMap(treeMap,N);
        removeTimeMap(500,treeMap);
    }
}

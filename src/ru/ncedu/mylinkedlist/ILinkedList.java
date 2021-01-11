package ru.ncedu.mylinkedlist;

/**
 * This interface ILinkedList
 * @version 1.0, 3 Jan 2021
 * @author Vladislav Semenovykh
 */
public interface ILinkedList<E> extends Iterable<E>{
    void add(E element);
    void add(int index, E element);
    void clear();
    E get(int index);
    int indexOf(E element);
    E remove(int index);
    E set(int index, E element);
    int size();
    E[] toArray();
    String toString();
}

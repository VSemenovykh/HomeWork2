package ru.ncedu.mylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * This class MyLinkedListImp
 * @version 1.0, 3 Jan 2021
 * @author Vladislav Semenovykh
 */
public class MyLinkedListImp<E> implements ILinkedList<E> {
    private Node<E> head;
    private int nElementLinkList;

    /**
     * Static class Node which describes node
     */
    static class Node<E>{
        private E element;
        private Node<E> nextNode;

        public Node(E e) {
            this.element = e;
        } 

        public E getElement(){
            return this.element;
        }

        public void setElement(E element){this.element = element;}

        public Node<E> getNextNode(){
            return this.nextNode;
        }

        public void setNextNode(Node<E> next){
            this.nextNode = next;
        }

        /**
         * @return string representation instance class Node
         */
        @Override
        public String toString() {
            return "Node{" +
                    "element =" + this.element +
                    '}';
        }
    }

    /**
     * Constructor - creating a new instance with specific values
     */
    public MyLinkedListImp(){
        this.head = new Node(null);
        nElementLinkList = 0;
    }
    /**
     * Appends the specified element to the end of this list.
     * @param element
     * */
    @Override
    public void add(E element){
        Node<E> temp = new Node<E>(element);
        Node<E> current = this.head;
        while(current.getNextNode() != null)
            current = current.getNextNode();
        current.setNextNode(temp);
        nElementLinkList++;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element){
        Node<E> temp = new Node(element);
        Node<E> current = this.head;
        for(int i=0; i<index && current.getNextNode() != null; i++)
            current = current.getNextNode();
        temp.setNextNode(current.getNextNode());
        current.setNextNode(temp);
        nElementLinkList++;
    }

    /**
     * Removes all of the elements from this list.
     */
    @Override
    public void clear(){
        Node<E> curent = this.head;
        while (curent != null) {
            curent.nextNode = null;
            curent = curent.getNextNode();
        }
        curent = null;
    }
    /**
     * Returns the element at the specified position in this list.
     * @param index
     * @return element
     */
    @Override
    public E get(int index){
       if((index > size()) & (index < 0)) throw new IndexOutOfBoundsException();
       if(index == 0) return this.head.getElement();
       Node<E> crunchifyCurrent = this.head.getNextNode();
       for (int i = 1; i < index; i++) {
            if (crunchifyCurrent.getNextNode() == null)
                return crunchifyCurrent.getElement();
            crunchifyCurrent = crunchifyCurrent.getNextNode();
      }
      return crunchifyCurrent.getElement();
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     * @param element
     * @return index element
     */
    @Override
    public int indexOf(E element){
        Node<E> temp = this.head.getNextNode();
        Node<E> newNode = new Node<E>(element);
        int index = -1;
        if(temp.getNextNode() == null) return index;
        for(int i=0; i < size(); i++){
            if(temp.getElement().equals(element)){
                index = i;
                break;
            }
            temp = temp.getNextNode();
        }
        return index;
    }

    /**
     * Removes the element at the specified position in this list.
     * @param index
     * @return element
     */
    @Override
    public E remove(int index){
        if(isEmpty()) return null;
        if(index > size()) throw new NoSuchElementException();
        Node<E> curent = this.head;
        Node<E> curent2 = new Node<E>(get(index));
        if (this.head.getElement() == get(index)) {                     //if the 1st element is the one we need
            this.head = this.head.getNextNode();                        //switch the pointer of the beginning to the 2nd element
            return curent2.getElement();                                //and exit
        }
        while (curent.getNextNode() != null) {                          //while the next element exists
            if (curent.getNextNode().getElement() == get(index)) {      //check the next element
                curent.nextNode = curent.getNextNode().getNextNode();   //throw away the found item
                return curent2.getElement();                            //and exit
            }
            curent = curent.getNextNode();                              //otherwise keep looking
        }
        return null;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index
     * @param element
     * @return element
     */
    @Override
    public E set(int index, E element){
        Node<E> crunchifyCurrent =this.head;
        for (int i = 1; i < index; i++) {
            if (crunchifyCurrent.getNextNode() == null) return null;
            crunchifyCurrent = crunchifyCurrent.getNextNode();
        }
        crunchifyCurrent.setElement(element);
        return crunchifyCurrent.getElement();
    }

    /**
     * Returns the number of elements in this list.
     * @return size
     */
    @Override
    public int size(){
        return nElementLinkList;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence
     * (from first to last element).
     * @return array elements
     */
    @Override
    public E[] toArray(){
       E[] array = (E[]) new Object[size()+1];
        int i = 0;
        for (E e: this) {
            array[i] = (E) e;
            i++;
        }
        return array;
    }

    /**
     * String representation instance this class
     * @return "LinkedList = [null, node1, node2,...]"
     */
    @Override
    public String toString() {
        Node<E> current = this.head.getNextNode();
        StringBuffer output = new StringBuffer();
        output.append("LinkedList = [" + this.head.getElement());
        while (current != null) {
            output.append(", " + current.getElement());
            current = current.getNextNode();
        }
        output.append("]");
        return output.toString();
    }

    /**
     * Returns an iterator over the elements in this list (in proper sequence)
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
     *Class linkedListIterator which realizes interface Iterator
     */
    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;
        public E next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            E item = current.getElement();
            current = current.getNextNode();
            return item;
        }
        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException(); }
    }

    /**
     * Returns true if this list contains no elements
     * @return true if list is empty
     */
    public boolean isEmpty() {
        Integer n = nElementLinkList;
        return n.equals(0);
    }
}

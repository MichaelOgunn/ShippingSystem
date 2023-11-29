package com.example.demo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import javafx.collections.ObservableList;
@XStreamAlias("GenList")
public class GenList<O> {

    public GenNode<O> getFirst(){
        return first;
    }
    GenNode<O> first = null;
    public int size;
//    public ge

    public boolean isEmpty() {
        return first == null; // Return true if the list is empty
    }
    public int size() {
        return size;
    }

    public void add(O item) {
        // The line `GenNode<N> newNode = new GenNode<>(item);` is creating a new instance of the `GenNode` class with the
        // specified item as its data. The `<N>` is a generic type parameter that allows the `GenNode` class to be used
        // with different types of data. The `newNode` variable is then assigned to reference this newly created `GenNode`
        // object.
        GenNode<O> newNode = new GenNode<>(item);
        if (first == null) {
            first = newNode;
        } else {
            GenNode<O> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;

    }

    public void reset() {
        first = null;
    }
    public boolean contains(O item) {
        GenNode<O> current = first;
        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }




    public class GenNode<N> {
        GenNode<N> next = null;
        private N data;

        public GenNode(N data) {
            this.data = data;
        }

        public N getData() {
            return data;
        }
        public GenNode<N> getNext() {
            return next;
        }
    }
    public void remove(O item) {
        if (first == null) {
            return;
        }

        if (first.getData().equals(item)) {
            first = first.next;
            return;
        }

        GenNode<O> current = first;

        while (current.next != null && !current.next.getData().equals(item)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
        size--;
    }

    @Override
    public String toString() {
        return "GenList{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}



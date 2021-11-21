package com.company;

import java.util.Collection;

public class BoundedWaitList<E> extends WaitList<E>{
    private int capacity;
    public BoundedWaitList(int capacity){
        super();
        this.capacity = capacity;
    }
    public int getCapacity(){
        return capacity;
    }
    public void add(E element){
        super.content.add(element);
    }
    public String toString(){
        return "WaitList{" +
                "content=" + super.content +
                '}';
    }
}

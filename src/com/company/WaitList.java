package com.company;

import java.util.Collection;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

class WaitList<E> implements IWaitList<E>{
    final protected Deque<E> content = new ConcurrentLinkedDeque<>();
    public WaitList(){

    }
    public WaitList(Collection<E> c){
        content.addAll(c);
    }
    public String toString() {
        return "WaitList{" +
                "content=" + content +
                '}';
    }
    @Override
    public void add(E element){
        content.add(element);
    }
    @Override
    public E remove(){
        return content.remove();
    }
    @Override
    public boolean contains(E element){
        return content.contains(element);
    }
    @Override
    public boolean containsAll(Collection<E> c){
        return content.containsAll(c);
    }
    @Override
    public boolean isEmpty(){
        return content.isEmpty();
    }
}

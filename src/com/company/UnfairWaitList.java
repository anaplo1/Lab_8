package com.company;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class UnfairWaitList<E> extends WaitList<E>{
    private Queue<E> used = new ConcurrentLinkedQueue<>();
    private Deque<E> tempUsed = new ConcurrentLinkedDeque<>();
    public UnfairWaitList(){
        super();
    }
    public void remove(E element){
        if (super.content.peekFirst() == element){
            System.out.println("Первый элемент не может быть удален");
        }
        else {
            super.content.remove(element);
            used.add(element);
        }
    }
    @Override
    public void add(E element){
        boolean f = false;
        for (int i=0;i<used.size();i++){
            tempUsed.addFirst(used.poll());
            if (tempUsed.peek() == element){
                f=true;
            }
        }
        if (!f){
            super.content.add(element);
        }
        else{
            System.out.println("Введенный элемент уже был введен");
        }
    }
    public void moveToBack(E element){
        super.content.remove(element);
        super.content.addLast(element);
    }
}

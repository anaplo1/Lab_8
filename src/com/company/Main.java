package com.company;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) {
        Queue<String> q;
        q = new ConcurrentLinkedQueue<>();
        q.add("БАм");
        q.add("Бум");
        q.add("Пим");
        WaitList<String> a = new WaitList<>(q);
        System.out.println(a.toString());
        a.add("Картошка");
        System.out.println(a.toString());
        a.remove();
        System.out.println(a.toString());
        System.out.println("Нахождение элемента Пим :"+a.contains("Пим"));
        System.out.println("Нахождение элемента БАм :"+a.contains("БАм"));
        q.remove();
        System.out.println("Нахождение коллекции q :"+a.containsAll(q));
        System.out.println("Пустота списка :"+a.isEmpty());
        while(!a.isEmpty()){
            a.remove();
        }
        System.out.println("Пустота списка :"+a.isEmpty());
        BoundedWaitList b = new BoundedWaitList(5);
        b.add("БАм");
        b.add("Бум");
        b.add("Пим");
        System.out.println(b.getCapacity());
        System.out.println(b.toString());
        UnfairWaitList c = new UnfairWaitList();
        c.add("БАм");
        c.add("Бум");
        c.add("Пим");
        System.out.println(c.toString());
        c.moveToBack("БАм");
        System.out.println(c.toString());
        c.remove("Пим");
        System.out.println(c.toString());
        c.add("Пим");
        c.add("Пам");
        System.out.println(c.toString());
    }
}

package org.example;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        LinkedList ls = new LinkedList();
        Random r = new Random();

        for (int i = 0; i < 10; i++) {

            ls.addLast(r.nextInt(10));
        }

        System.out.println("Сгенерированный лист: " + ls);
        ls.revert();
        System.out.println("Развёрнутый лист: " + ls);
    }
}
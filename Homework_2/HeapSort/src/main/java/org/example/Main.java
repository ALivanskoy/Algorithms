package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int length = 1;

        do {
            timeTest(length);
            length *= 10;
        } while (length <= 100000000);

    }

    public static void fillArrayRandomly(int[] arr, int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100); // генерируем случайное число от 0 до 99
        }
    }

    public static void timeTest(int length) {

        int[] arr = new int[length];
        long time = System.currentTimeMillis();
        fillArrayRandomly(arr, length);
        HeapSort.heapSort(arr);
        long deltaTime = System.currentTimeMillis() - time;
        System.out.println(length + " итераций за " + deltaTime + "mc");
    }
}
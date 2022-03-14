package com.java.pattern;


import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[10];

        IntStream
                .range(0, arr.length)
                .map(i -> {
            int[] a = new int[10];
            int[] b = new int[10];
            return a[i] * b[i];
        }).forEach(System.out::println);
    }


}

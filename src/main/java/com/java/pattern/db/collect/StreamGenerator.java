package com.java.pattern.db.collect;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class StreamGenerator {

    // My queue
    private final BlockingQueue<BigInteger> queue =
            new ArrayBlockingQueue<>(10);

    @NotNull public  <T> Stream<? super T> getByStream(
            @Nullable T t) {
        return Stream.generate(() -> {
            try {
                return queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

     public void getThread() {
        new Thread(new Runnable() {
            // Must be final to be accessible inside `run`.
            final AtomicInteger i = new AtomicInteger();

            @Override
            public void run() {
                // Slow feed to the queue.
                while (true) {
                    // Add a new number to the queue.
                    queue.add(BigInteger.valueOf(i.getAndIncrement()));
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public void init(){
 //       biStream.filter(x -> x.testBit(2))
               // .limit(20)
               // .forEach(x -> System.out.println(x));

    }

}

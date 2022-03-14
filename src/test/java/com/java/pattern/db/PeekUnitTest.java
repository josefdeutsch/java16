package com.java.pattern.db;

import com.java.pattern.db.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.StringWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeekUnitTest {

    private StringWriter out;

    @BeforeEach
    void setup() {
        this.out = new StringWriter();
    }

    @Test
    void givenStringStream_whenCallingPeekOnly_thenNoElementProcessed() {

        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");
        nameStream.peek(out::append);

        assertTrue(out.toString().isEmpty());

        //  “This method exists mainly to support debugging,
        //   where you want to see the elements as they flow past a certain point in a pipeline“.
    }

    @Test
    void givenStringStream_whenCallingForEachOnly_thenElementsProcessed() {

        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");
        nameStream.forEach(out::append);

        assertEquals(out.toString(),"AliceBobChuck");
    }

    @Test
    void givenStringStream_whenCallingPeekAndNoopForEach_thenElementsProcessed() {

        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");
        nameStream.peek(out::append).forEach(this::noop);

        assertEquals(out.toString(),"AliceBobChuck");
    }

    @Test
    void givenStringStream_whenCallingPeekAndCollect_thenElementsProcessed() {

        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");
        nameStream.peek(out::append).collect(Collectors.toList());

        assertEquals(out.toString(),"AliceBobChuck");
    }

    @Test
    void givenStringStream_whenCallingPeekAndForEach_thenElementsProcessedTwice() {

        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");
        nameStream.peek(out::append).forEach(out::append);

        assertEquals(out.toString(),"AliceAliceBobBobChuckChuck");
    }

    @Test
    void givenStringStream_whenCallingPeek_thenElementsProcessedTwice() {

        Stream<User> userStream = Stream.of(new User("Alice"), new User("Bob"), new User("Chuck"));
        userStream.peek(u -> u.setName(u.getName().toLowerCase()))
                .map(User::getName)
                .forEach(out::append);

        assertEquals(out.toString(),"alicebobchuck");
    }

    public void noop(String s) {
    }

}

package com.java.pattern.functional;

import org.junit.jupiter.api.Test;
import java.util.function.Function;

import static com.java.pattern.functional.ShortToByteFunction.transformArray;
import static org.junit.jupiter.api.Assertions.*;

public class Functional {
    @Test
    public void givenOptional_whenIsPresentWorks_thenCorrect() {

        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Integer, String> quoteIntToString = quote.compose(intToString);

        assertEquals("'5'", quoteIntToString.apply(5));
    }

    @Test
    public void givenOptional_whenIsPresentWorks_thenCorrect2() {

        short[] array = {(short) 1, (short) 2, (short) 3};
        byte[] transformedArray = transformArray(array, s -> (byte) (s * 2));

        byte[] expectedArray = {(byte) 2, (byte) 4, (byte) 6};
        assertArrayEquals(expectedArray, transformedArray);


    }
}

package com.java.pattern.db;

import com.java.pattern.db.model.User;
import com.java.pattern.db.util.NumberUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;


public class StreamReduceUnitTest {

    @Test
    public void givenIntegerList_whenReduceWithSumAccumulatorLambda_thenCorrect() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int actual = numbers
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element);

        assertEquals(21,actual);
    }

    @Test
    public void givenIntegerList_whenReduceWithSumAccumulatorMethodReference_thenCorrect() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int actual = numbers.stream().reduce(0, Integer::sum);

        assertEquals(21,actual);
    }

    @Test
    public void givenStringList_whenReduceWithConcatenatorAccumulatorLambda_thenCorrect() {

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String actual = letters
                .stream()
                .reduce("", (partialString, element) -> partialString + element);

        assertEquals("abcde",actual);
    }

    @Test
    public void givenStringList_whenReduceWithConcatenatorAccumulatorMethodReference_thenCorrect() {

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String actual = letters
                .stream()
                .reduce("", String::concat);

        assertEquals("abcde",actual);
    }

    @Test
    public void givenStringList_whenReduceWithUppercaseConcatenatorAccumulator_thenCorrect() {

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String actual = letters
                .stream()
                .reduce("",
                        (partialString, element) -> partialString.toUpperCase() + element.toUpperCase());

        assertEquals("ABCDE",actual);
    }

    @Test
    public void givenUserList_whenReduceWithAgeAccumulatorAndSumCombiner_thenCorrect() {

        List<User> users = Arrays.asList(
                new User("John", 30),
                new User("Julie", 35));

        int actual = users
                .stream()
                .reduce(0,
                        (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);

        assertEquals(65,actual);
    }

    @Test
    public void givenStringList_whenReduceWithParallelStream_thenCorrect() {

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String actual = letters
                .parallelStream()
                .reduce("", String::concat);

        assertEquals("abcde",actual);
    }

    @Test
    public void givenNumberUtilsClass_whenCalledDivideListElements_thenCorrect() {

        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertEquals(21,NumberUtils.divideListElements(actual, 1));

    }

    @Test
    public void givenNumberUtilsClass_whenCalledDivideListElementsWithExtractedTryCatchBlock_thenCorrect() {

        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertEquals(21,NumberUtils.divideListElementsWithExtractedTryCatchBlock(actual, 1));

    }

    @Test
    public void givenStream_whneCalleddivideListElementsWithApplyFunctionMethod_thenCorrect() {

        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertEquals(21,NumberUtils.divideListElementsWithApplyFunctionMethod(actual, 1));

    }
}
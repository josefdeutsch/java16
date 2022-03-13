package com.java.pattern.db;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.*;
import com.java.pattern.db.model.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class Java8StreamApiUnitTest {

    //https://github.com/eugenp/tutorials/tree/master/core-java-modules/core-java-11-2/src
    //https://www.youtube.com/watch?v=4BUKaazoYyg

    public static List<Product> productList;

    @BeforeAll
    public static void init() {
        productList = asList(
                new Product(23, "potatoes"),
                new Product(14, "orange"),
                new Product(13, "lemon"),
                new Product(23, "bread"),
                new Product(13, "sugar"));
    }

    @Test
    public void checkPipeline_whenStreamOneElementShorter_thenCorrect2() {

        String expected = "abc";
        String actual = "abc";

        expected.substring(0,3);
        assertEquals(expected.substring(0,3), actual);
    }

    @Test
    public void checkPipeline_whenStreamOneElementShorter_thenCorrect() {

        List<String> expected = asList("abc1", "abc2", "abc3");
        long actual = expected.stream().skip(1)
                .map(element -> element.substring(0, 3)).count();

        assertEquals(expected.size() - 1, actual);
    }

    @Test
    public void convertStringToUpperCaseStreams() {
        List<String> expected = asList("A", "B", "HELLO");
        List<String> actual = Stream.of("a", "b", "hello")
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test
    public void testflatMap() throws Exception {
        List<Integer> actual = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(List::stream)
                .map(integer -> integer + 1)
                .collect(Collectors.toList());

        assertEquals(asList(2, 3, 4, 5), actual);
    }

    @Test
    public void checkOrder_whenChangeQuantityOfMethodCalls_thenCorrect() {

        List<String> list = asList("abc1", "abc2", "abc3");
        AtomicLong actual = new AtomicLong();
        list.stream().skip(2).map(element -> {
            actual.getAndIncrement();
            return element.substring(0, 3);
        }).count();

        assertEquals(1, actual);
    }

    @Test
    public void checkOrder_whenChangeQuantityOfMethodCalls_thenCorrect2() {

        List<String> list = asList("abc1", "abc2", "abc3");
        AtomicLong counter = new AtomicLong();
        list.stream().map(element -> {
            counter.getAndIncrement();
            return element.substring(0, 3);
        }).skip(2).count();

        assertEquals(3, counter);
    }

    @Test
    public void createEmptyStream_whenEmpty_thenCorrect() {

        Stream<String> actual = Stream.empty();
        assertEquals(0, actual.count());

    }

    @Test
    public void createStreamFromCollection_whenCreated_thenCorrect() {

        Collection<String> collection = asList("a", "b", "c");
        Stream<String> actual = collection.stream();
        assertEquals(3, actual.count());

    }

    @Test
    public void createEmptyStreamFromCollection_whenEmpty_thenCorrect() {

        List<String> list = Collections.emptyList();
        Stream<String> actual = Product.streamOf(list);
        assertTrue(actual.count() == 0);

    }

    @Test
    public void createStreamFromArray_countStartToEnd_thenCorrect() {

        String[] arr = new String[] { "a", "b", "c" };
        Stream<String> actual = Arrays.stream(arr, 1, 3);
        assertEquals(2, actual.count());

    }

    @Test
    public void createStreamFromIntStream_calculateLength_thenCorrect() {

        IntStream actual = IntStream.range(1, 3);
        assertEquals(2, actual.count());

    }

    @Test
    public void createStreamFromLongStream_calculateLength_thenCorrect() {

        LongStream actual = LongStream.rangeClosed(1, 3);
        assertEquals(3, actual.count());

    }

    @Test
    public void createStreamFromDoubleStream_calculateLength_thenCorrect() {

        Random random = new Random();
        DoubleStream actual = random.doubles(3);
        assertEquals(3, actual.count());

    }

    @Test
    public void createCharStreamBulder_addChars_thenCorrect() {

        Stream<String> actual = Stream.<String> builder().add("a").add("b").add("c").build();
        assertEquals(3, actual.count());

    }

    @Test
    public void createCharStream_dynamicallyWithLimit_thenCorrect() {

        Stream<String> actual = Stream.generate(() -> "element").limit(10);
        assertEquals(10, actual.count());

    }

    @Test
    public void createCharStream_iterateConditionallyWithLimit_thenCorrect() {

        Stream<Integer> actual = Stream.iterate(40, n -> n + 2).limit(20);
        assertTrue(40 <= actual.findAny().get());

    }

    @Test
    public void createIntStreamFromCharStream_calculateLength_thenCorrect() {

        IntStream actual = "abc".chars();
        assertEquals(3, actual.count());

    }

    @Test
    public void runStreamPipeline_whenOrderIsRight_thenCorrect() {

        List<String> list = asList("abc1", "abc2", "abc3");

        Optional<String> actual = list.stream().filter(element -> {
            return element.contains("2");
        }).map(element -> {
            return element.toUpperCase();
        }).findFirst();

        assertEquals("ABC2", actual.get());
    }

    @Test
    public void reduceStream_whenExpected_thenCorrect() {

        OptionalInt reduced = IntStream.range(1, 4)
                .reduce((a, b) -> a + b);
        assertEquals(6, reduced.getAsInt());

    }

    @Test
    public void reduceArrayIntoStream_whenExpected_thenCorrect() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> actual = numbers
                .stream()
                .reduce(((a, b) -> a + b));

        assertEquals(21,actual.get().intValue());

    }

    @Test
    public void reduceArrayIntoStream_WithRangeWhenExpected_thenCorrect() {

        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int actual = numbers
                .stream()
                .reduce(10,((a, b) -> a + b));

        assertEquals(16,actual);

    }

    @Test
    public void reduce_whenExpected_thenCorrect4() {

        int actual = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b, (a, b) -> a + b);

        assertEquals(16, actual);

    }

    @Test
    public void reduce_whenExpected_thenCorrect5() {

        int actual = asList(1, 2, 3)
                .parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> a + b);
        assertEquals(36, actual);
    }


    @Test
    public void assertThat_isInstanceOf_List() {

        List<String> collectorCollection = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        assertTrue(collectorCollection instanceof List);

    }

    @Test
    public void assertThat_Stream_into_Collector_hasSize_equalTo() {

        List<String> collectorCollection = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        assertEquals(5, collectorCollection.size());

    }
    @Test
    public void asserThat_Stream_intoCollector_hasRegex() {

        String listToString = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", ", "[", "]"));

        assertTrue(listToString.contains(",")
                && listToString.contains("[")
                && listToString.contains("]"));

    }
    @Test
    public void asserThat_Stream_intoCollector_hasAverageInt() {

        double averagePrice =
                productList.stream()
                        .collect(Collectors.averagingInt(Product::getPrice));
        assertTrue(17.2 == averagePrice);

    }
    @Test
    public void asserThat_Stream_intoCollector_isSumOf() {

        int summingPrice =
                productList.stream()
                        .collect(Collectors.summingInt(Product::getPrice));
        assertEquals(86, summingPrice);

    }
    @Test
    public void asserThat_Stream_intoCollector_isSummarizingInt() {

        IntSummaryStatistics statistics =
                productList.stream()
                        .collect(Collectors.summarizingInt(Product::getPrice));
        assertEquals(23, statistics.getMax());

    }
    @Test
    public void asserThat_Stream_intoCollector_isGroupedBy_EqualTo() {

        Map<Integer, List<Product>> collectorMapOfLists =
                productList.stream()
                .collect(Collectors.groupingBy(Product::getPrice));

        assertEquals(3, collectorMapOfLists.keySet().size());

    }
    @Test
    public void asserThat_Stream_intoCollector_isPartition_EqualTo() {

        Map<Boolean, List<Product>> mapPartioned =
                productList.stream().
                        collect(Collectors.partitioningBy(element -> element.getPrice() > 15));

        assertEquals(2, mapPartioned.keySet().size());

    }


    @Test
    public void customCollector_whenResultContainsAllElementsFrSource_thenCorrect() {
        Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                                            first.addAll(second);
                                            return first;
                                    }
       );
        LinkedList<Product> linkedListOfPersons = productList.stream().collect(toLinkedList);
        assertTrue(linkedListOfPersons.containsAll(productList));
    }

    @Test
    public void parallelStream_whenWorks_thenCorrect() {
        Stream<Product> streamOfCollection = productList.parallelStream();
        boolean isParallel = streamOfCollection.isParallel();
        boolean haveBigPrice = streamOfCollection.map(product -> product.getPrice() * 12).anyMatch(price -> price > 200);
        assertTrue(isParallel && haveBigPrice);
    }

    @Test
    public void parallel_whenIsParallel_thenCorrect() {
        IntStream intStreamParallel = IntStream.range(1, 150).parallel().map(element -> element * 34);
        boolean isParallel = intStreamParallel.isParallel();
        assertTrue(isParallel);
    }

    @Test
    public void parallel_whenIsSequential_thenCorrect() {
        IntStream intStreamParallel = IntStream.range(1, 150).parallel().map(element -> element * 34);
        IntStream intStreamSequential = intStreamParallel.sequential();
        boolean isParallel = intStreamParallel.isParallel();
        assertFalse(isParallel);
    }


}

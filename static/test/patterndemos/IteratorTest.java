package patterndemos;

import org.junit.jupiter.api.Test;
import patterndemos.iterator.Cat;
import patterndemos.iterator.CatIterator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IteratorTest {
    @Test
    public void testIterator() {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Paul");
        names.add("George");
        names.add("Ringo");

        CatIterator catIterator = new CatIterator(names);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("John meows");
        expectedResult.add("Paul meows");
        expectedResult.add("George meows");
        expectedResult.add("Ringo meows");


        for (Cat cat : catIterator) {
            assertEquals(expectedResult.remove(0), cat.meow());
        }
    }
}

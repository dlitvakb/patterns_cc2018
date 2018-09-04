package patterndemos;

import org.junit.Test;
import patterndemos.memento.MementedDog;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MementoTest {
    @Test
    public void testMemento() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Jake");
        expected.add("Goofy");
        expected.add("Scooby");

        MementedDog dog = new MementedDog("Jake");
        dog.setName("Goofy");
        dog.setName("Scooby");

        for (MementedDog d : dog.replay()) {
           assertEquals(d.getName(), expected.remove(0));
        }
    }
}

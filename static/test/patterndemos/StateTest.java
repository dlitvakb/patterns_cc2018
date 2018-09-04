package patterndemos;

import org.junit.Test;
import patterndemos.state.AdultState;
import patterndemos.state.InfantState;
import patterndemos.state.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTest {
    @Test
    public void testState() {
        Person p = new Person(new InfantState());

        assertEquals(p.crawl(), "agugugaga");
        assertEquals(p.walk(), "me no walkie walkie");

        p.setState(new AdultState());

        assertEquals(p.crawl(), "i'm too old for this");
        assertEquals(p.walk(), "strolling down the cruise");
    }
}

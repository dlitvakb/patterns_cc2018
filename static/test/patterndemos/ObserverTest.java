package patterndemos;

import org.junit.Test;
import patterndemos.observer.EmitterDog;
import patterndemos.observer.SubscriberOwner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObserverTest {
    @Test
    public void testObserver() {
        EmitterDog dog = new EmitterDog();
        SubscriberOwner owner = new SubscriberOwner();

        dog.subscribe(owner);

        assertFalse(owner.dogHasBarked());

        dog.bark();

        assertTrue(owner.dogHasBarked());
    }
}

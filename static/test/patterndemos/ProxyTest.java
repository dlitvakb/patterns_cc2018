package patterndemos;

import org.junit.Test;
import patterndemos.proxy.Dog;
import patterndemos.proxy.NamingDogProxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProxyTest {
    @Test
    public void test() {
        Dog dog = new Dog("Poochy");
        NamingDogProxy namingDogProxy = new NamingDogProxy(dog);

        assertEquals(dog.bark(), "woof");
        assertEquals(namingDogProxy.bark(), "Poochy says: woof");
    }
}

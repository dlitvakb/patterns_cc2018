package patterndemos.state;

public class Person {
    private PersonState state;

    public Person(PersonState state) {
        this.state = state;
    }

    public String crawl() {
        return this.state.crawl();
    }

    public String walk() {
        return this.state.walk();
    }

    public void setState(PersonState state) {
        this.state = state;
    }
}

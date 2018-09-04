package patterndemos.state;

public class AdultState implements PersonState {
    @Override
    public String walk() {
        return "strolling down the cruise";
    }

    @Override
    public String crawl() {
        return "i'm too old for this";
    }
}

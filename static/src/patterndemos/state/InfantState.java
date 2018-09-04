package patterndemos.state;

public class InfantState implements PersonState {
    @Override
    public String walk() {
        return "me no walkie walkie";
    }

    @Override
    public String crawl() {
        return "agugugaga";
    }
}

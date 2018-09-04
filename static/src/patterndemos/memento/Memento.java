package patterndemos.memento;

import java.util.ArrayList;

public interface Memento<T> {
    ArrayList<T> replay();
}

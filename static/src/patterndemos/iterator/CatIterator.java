package patterndemos.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CatIterator implements Iterable<Cat> {
    private final List<Cat> cats = new ArrayList<>();

    public CatIterator(List<String> catNames) {
        for (String name: catNames) {
            this.cats.add(new Cat(name));
        }
    }

    @Override
    public Iterator<Cat> iterator() {
        return this.cats.iterator();
    }
}

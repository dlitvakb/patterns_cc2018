package patterndemos.iterator;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String meow() {
        return this.getName() + " meows";
    }

    public String getName() {
        return this.name;
    }
}

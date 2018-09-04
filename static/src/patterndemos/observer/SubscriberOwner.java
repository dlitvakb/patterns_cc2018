package patterndemos.observer;

public class SubscriberOwner {

    private boolean dogBarked = false;

    public boolean dogHasBarked() {
       return this.dogBarked;
    }

    public void update() {
        this.dogBarked = true;
    }
}

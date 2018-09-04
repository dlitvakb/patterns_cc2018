package patterndemos.memento;

import java.util.ArrayList;
import java.util.List;

public class MementedDog implements Memento<MementedDog> {
    private String name;
    private List<String> nameHistory = new ArrayList<>();

    public MementedDog(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        this.nameHistory.add(name);
        this.name = name;
    }

    @Override
    public ArrayList<MementedDog> replay() {
        ArrayList<MementedDog> replayStates = new ArrayList<>();

        for (String name : this.nameHistory) {
            replayStates.add(new MementedDog(name));
        }

        return replayStates;
    }

    public String getName() {
        return this.name;
    }
}

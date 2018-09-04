package patterndemos.abstractfactory;

import java.util.ArrayList;
import java.util.List;

public class NetworkFileConnection implements FileConnection {
    private final String location;

    public NetworkFileConnection(String connectionString) {
        this.location = connectionString;
    }

    @Override
    public List<String> readLines() {
        ArrayList<String> result = new ArrayList<>();

        result.add("did something in the network supposedly");

        return result;
    }
}

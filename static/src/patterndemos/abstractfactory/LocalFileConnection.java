package patterndemos.abstractfactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LocalFileConnection implements FileConnection {
    private final String location;

    public LocalFileConnection(String connectionString) {
        this.location = connectionString;
    }


    @Override
    public List<String> readLines() {
        ArrayList<String> result = new ArrayList<>();
        try {
            File file = new File(this.location);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

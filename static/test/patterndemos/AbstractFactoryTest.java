package patterndemos;

import org.junit.Test;
import patterndemos.abstractfactory.FileConnection;
import patterndemos.abstractfactory.FileConnectionAbstractFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractFactoryTest {
    @Test
    public void testLocalFile() {
        FileConnection localFileConnection = FileConnectionAbstractFactory.open("/Users/contentdave/dev/PatternDemos/SomeText.txt");
        List<String> expectedLocalResult = new ArrayList<>();
        expectedLocalResult.add("hello coder cruise!");

        assertEquals(localFileConnection.readLines(), expectedLocalResult);
    }

    @Test
    public void testRemoteFile() {
        FileConnection remoteFileConnection = FileConnectionAbstractFactory.open("ssh://user@pass:foo.bar.com/something.txt");
        List<String> expectedRemoteResult = new ArrayList<>();
        expectedRemoteResult.add("did something in the network supposedly");

        assertEquals(remoteFileConnection.readLines(), expectedRemoteResult);
    }
}

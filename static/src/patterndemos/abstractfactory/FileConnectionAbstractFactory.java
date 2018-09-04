package patterndemos.abstractfactory;

public abstract class FileConnectionAbstractFactory {
    public static FileConnection open(String connectionString) {
        if (connectionString.startsWith("/")) {
            return new LocalFileConnection(connectionString);
        } else if (connectionString.startsWith("ssh://")) {
            return new NetworkFileConnection(connectionString);
        }

        throw new RuntimeException("File type not recognized");
    }
}

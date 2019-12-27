package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileReader {
    String readFile() throws IOException;
}

package file;

import tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileWriter {
    void writeIntoFile(String message) throws IOException;
}

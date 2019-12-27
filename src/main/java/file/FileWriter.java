package file;

import tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;

public interface FileWriter {
    File writeIntoFile() throws FileNotFoundException;
}

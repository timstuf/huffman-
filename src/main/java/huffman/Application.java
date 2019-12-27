package huffman;

import file.HuffmanFileWriter;
import file.OriginalFileReader;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
       new Decider(args[0]).decide();
    }
}

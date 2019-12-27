package huffman;

import file.HuffmanFileWriter;
import file.OriginalFileReader;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        new Decider("D:\\res.hf").decide();
    }
}

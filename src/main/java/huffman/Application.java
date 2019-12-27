package huffman;

import file.HuffmanFileWriter;
import file.OriginalFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Application {
    final static Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) throws IOException {
     //  String s = args[0];
      // String s = "toCode.txt";
       String s = "res.hf";
        new Decider(s).decide();
    }
}

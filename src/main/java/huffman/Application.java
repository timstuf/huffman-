package huffman;

import file.HuffmanFileWriter;
import file.OriginalFileReader;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {




        // String fbr = new OriginalFileReader("C:\\Users\\agris\\OneDrive\\Documents\\obdz\\er.bmp").readFile() ;

        new Coder("D:\\result.txt").codeMessage();
    }
}

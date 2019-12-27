package huffman;

import file.HuffmanFileWriter;
import file.OriginalFileReader;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {


        // String fbr = new OriginalFileReader("C:\\Users\\agris\\OneDrive\\Documents\\obdz\\er.bmp").readFile() ;
        String fbr = new OriginalFileReader("D:\\result.txt").readFile() ;
        new Coder(fbr).codeMessage();

        byte i = new Byte ("1011");
        System.out.println(i);
    }
}

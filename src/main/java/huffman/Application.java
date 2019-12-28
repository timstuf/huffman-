package huffman;


import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
     //  String s = args[0];
     String s = "toCode.txt";
        new Decider(s).decide();
        s = "res.hf";
        new Decider(s).decide();
    }
}

package file;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class OriginalFileReader implements FileReader {
    private File readingFile;

    public OriginalFileReader(String path) {
        readingFile = new File(path);
    }

    @Override
    public String readFile() throws IOException {
        FileInputStream fis = new FileInputStream(readingFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        int digit;
        StringBuilder message = new StringBuilder();
        while ((digit = bis.read()) != -1) {
            message.append((char) digit);
        }

        return message.toString();
    }
    /*public Map<Character, Integer> readMap() throws IOException {
        FileInputStream fis = new FileInputStream(readingFile);
        Map<Character, Integer> huff = new HashMap<>();
        int digit;
        while ((digit = fis.read()) != -1) {
            char character = (char) digit;
            fis.read();
            int frequency = fis.read();
            fis.read();
            huff.put(character, frequency-ASCII_1);
        }
        return huff;
    }*/
    public static String addZerosAtTheBeginning(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append("0");
        }
        return result.toString();
    }
}

package file;

import java.io.*;

public class OriginalFileReader implements FileReader {
    public static final int BITS_SIZE = 8;
    private File readingFile;
    private String encodedMessage;

    public OriginalFileReader(String path) {
        encodedMessage = "";
        readingFile = new File(path);
    }

    @Override
    public String readFile() throws IOException {
        FileInputStream fis = new FileInputStream(readingFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        int digit;
        while ((digit = bis.read()) != -1) {
            encodedMessage += digit;
            // encodedMessage += convertIntoBits(digit);
        }

        return encodedMessage;
    }

    private String convertIntoBits(int digit) {
        StringBuilder bits = new StringBuilder();
        int bitCount = BITS_SIZE;
        while (bitCount > 0) {
            String newBits = Integer.toBinaryString(digit);
            bits.append(addZerosAtTheBeginning(bitCount - newBits.length()));
            bits.append(newBits);
            bitCount -= 8;
        }
        return bits.toString();
    }

    public static String addZerosAtTheBeginning(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += "0";
        }
        return result;
    }
}
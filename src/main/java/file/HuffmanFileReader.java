package file;

import tree.Tree;

import java.io.*;

public class HuffmanFileReader {
    public static final int BITS_SIZE = 8;
    private File readingFile;
    private String decodedMessage;

    public HuffmanFileReader(String path) {
        decodedMessage = "";
        readingFile = new File(path);
    }

    private byte[] getByteInBits(byte nextByte){
       byte[] bits = new byte[7];
        for(int i = 0; i<7; i++){
            byte b = (byte) ((nextByte >> (i - 1)));
            if(b%2==0) bits[i] = 0;
            else bits[i] = 1;
        }
        return bits;
    }
    private String bitsToString(byte[] nextByte){
        String message = "";
        for (int i = 0; i < 7; i++) {
            if(nextByte[i]==0) message+="0";
            else message+="1";
        }
        return message;
    }

    public String readFile() throws IOException {
        FileInputStream fis = new FileInputStream(readingFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte b;
        while((b= (byte) bis.read())!=-1){
            decodedMessage+=bitsToString(getByteInBits(b));
        }

        return decodedMessage;
    }
}

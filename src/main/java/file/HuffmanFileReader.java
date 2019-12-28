package file;

import huffman.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tree.Tree;

import java.io.*;

public class HuffmanFileReader {
    public static final int BITS_SIZE = 8;
    final static Logger logger = LoggerFactory.getLogger(HuffmanFileReader.class);
    private File readingFile;
    private String decodedMessage;

    public HuffmanFileReader(String path) {
        decodedMessage = "";
        readingFile = new File(path);
    }

    private byte[] getByteInBits(byte nextByte){
       byte[] bits = new byte[Constants.BITS_IN_BYTE];
        for(int i = 0; i<Constants.BITS_IN_BYTE; i++){
            byte b = (byte) ((nextByte >> (Constants.BITS_IN_BYTE-i-1)));
            if(b%2==0) bits[i] = 0;
            else bits[i] = 1;
        }
        return bits;
    }
    private String bitsToString(byte[] nextByte){
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < Constants.BITS_IN_BYTE; i++) {
            if(nextByte[i]==0) message.append("0");
            else message.append("1");
        }
        return message.toString();
    }

    public String readFile() throws IOException {
        FileInputStream fis = new FileInputStream(readingFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte b;
        while((b= (byte) bis.read())!=-1){
            decodedMessage+=bitsToString(getByteInBits(b));
        }
        logger.debug("decoded message: {}", decodedMessage);
        return decodedMessage;
    }
}

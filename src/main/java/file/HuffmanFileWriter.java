package file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class HuffmanFileWriter implements FileWriter {
    final static Logger logger = LoggerFactory.getLogger(HuffmanFileWriter.class);
    public static final int BITS_SIZE = 8;
    private File writingFile;
    private Byte[] bytes;
    public HuffmanFileWriter(Byte[] bytes, File writingFile){
        this.bytes = bytes;
        this.writingFile = writingFile;
    }
    @Override
    public void writeIntoFile(String message) throws IOException {
       FileOutputStream fos = new FileOutputStream(writingFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
       byte[] normalBytes = new byte[bytes.length];
       int[] bytesInInt = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            normalBytes[i] = bytes[i];
            bytesInInt[i] = bytes[i];
            bos.write(bytesInInt[i]);
            logger.debug("byte {} written: {}",i,normalBytes[i]);
        }

        //bos.write(normalBytes);
        //bos.write(bytesInInt.);
        bos.write(1);
        bos.flush();
        //int writeByte = message.substring(0,8);

    }

    public void writeStringUsingBitset(String message) throws IOException {
        FileOutputStream fos = new FileOutputStream(writingFile);
        BitSet huffmanBitset = new BitSet(message.length());
        for (int i = 0; i < message.length(); i++) {
            huffmanBitset.set(i);
        }
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(huffmanBitset);
    }
    public void writeByte(byte writing){

    }


}

package file;

import tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HuffmanFileWriter implements FileWriter {
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
       byte[] normalBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            normalBytes[i] = bytes[i];
        }
        fos.write(normalBytes);
        fos.write(1);
        fos.flush();
        //int writeByte = message.substring(0,8);

    }



}

package file;

import tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    public File writeIntoFile() throws FileNotFoundException {
       FileOutputStream fos = new FileOutputStream(writingFile);



        //int writeByte = message.substring(0,8);
        return null;
    }



}

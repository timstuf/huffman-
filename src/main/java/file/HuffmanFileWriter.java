package file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;


public class HuffmanFileWriter implements FileWriter {
    private final static Logger logger = LoggerFactory.getLogger(HuffmanFileWriter.class);
    public static final int BITS_SIZE = 8;
    private File writingFile;
    private Integer[] bytes;
    public HuffmanFileWriter(Integer[] bytes, File writingFile){
        this.bytes = bytes;
        this.writingFile = writingFile;
    }
    @Override
    public void writeIntoFile() throws IOException {
       FileOutputStream fos = new FileOutputStream(writingFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
       int[] normalBytes = new int[bytes.length];
       //int[] bytesInInt = {119,63,65,11,135,251,80};
        for (int i = 0; i < bytes.length; i++) {
            normalBytes[i] = bytes[i];
            bos.write(normalBytes[i]);
            logger.debug("byte {} written: {}",i,normalBytes[i]);
        }

        bos.flush();
    }
}

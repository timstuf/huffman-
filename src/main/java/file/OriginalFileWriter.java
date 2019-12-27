package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OriginalFileWriter implements FileWriter{
    private File readingFile;
    private String decodedMessage;
    public OriginalFileWriter(String path){
        readingFile = new File(path);
    }

    @Override
    public void writeIntoFile(String message) throws IOException {
       decodedMessage = message;
        FileOutputStream fos = new FileOutputStream(readingFile);
        fos.write(decodedMessage.getBytes());
        fos.flush();
    }
}

package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OriginalFileWriter implements FileWriter{
    private File writingFile;
    private String decodedMessage;
    public OriginalFileWriter(String path, String decodedMessage){
        this.decodedMessage = decodedMessage;
        writingFile = new File(path);
    }

    @Override
    public void writeIntoFile() throws IOException {
        FileOutputStream fos = new FileOutputStream(writingFile);
        fos.write(decodedMessage.getBytes());
        fos.flush();
    }
}

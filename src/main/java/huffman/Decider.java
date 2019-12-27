package huffman;

import java.io.File;
import java.io.IOException;

public class Decider {
    private File file;
    public Decider(String path){
        file = new File(path);
    }

    private String getFileExtension() {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    public void decide() throws IOException {
        String extension = getFileExtension();
        if(extension.equals("hf")){
            new Decoder(file.getPath()).decodeMessage();
        }
        else{
            new Coder(file.getPath()).codeMessage();
        }
    }
}

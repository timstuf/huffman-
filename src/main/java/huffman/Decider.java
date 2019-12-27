package huffman;

import java.io.File;

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

    public void decide(){
        String extension = getFileExtension();
        if(extension.equals("hf")){
            Decoder decode = new Decoder(file.getPath());
        }
        else{
            Coder encoder = new Coder(file.getPath());
        }
    }
}

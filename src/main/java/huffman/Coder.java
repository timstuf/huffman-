package huffman;

import file.HuffmanFileWriter;
import file.OriginalFileReader;
import file.OriginalFileWriter;
import tree.Node;
import tree.TableBuilder;
import tree.Tree;
import tree.TreeBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Coder {
    private Tree tree;
    private final String path;


    public Coder(String path){
        this.path = path;
    }

    public void codeMessage() throws IOException {
       String message = new OriginalFileReader(path).readFile();

        Map<Character, Integer> table = getFrequencyTable(message);
        tree = new TreeBuilder().build(table);
        Map<Character, String> huffmanMap= new TableBuilder().buildTable(tree);

        String encodedMessage = shifrMessage(huffmanMap,message);
        writeTable(huffmanMap);
        Byte[] encodedFileBytes = convertListToByteArray(encodeBytes(encodedMessage));
        new HuffmanFileWriter(encodedFileBytes, new File("D:\\res.hf")).writeIntoFile("");
    }
    private void writeTree() throws IOException {
        String encodedTree = tree.encodeHuffmanTree();
        List<Byte> b = encodeBytes(encodedTree);
        Byte[] encodedFileBytes = convertListToByteArray(b);
        new HuffmanFileWriter(encodedFileBytes, new File("D:\\resTa.hf")).writeIntoFile("");
    }
    
    private void writeTable( Map<Character, String> huffmanMap) throws IOException {
        StringBuilder st = new StringBuilder();
       huffmanMap.entrySet().forEach((c)->{st.append(c.getValue());st.append(' ');st.append(c.getKey());st.append('\n');});
       st.deleteCharAt(st.length()-1);
       new OriginalFileWriter("D:\\table.txt").writeIntoFile(st.toString());
    }
    
    private String shifrMessage( Map<Character, String> huffmanMap, String message){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            result.append(huffmanMap.get(message.charAt(i)));
        }
        return result.toString();
    }

    private Map<Character, Integer> getFrequencyTable(String message){
        Map<Character, Integer> table = new HashMap<>();
        List<Character> messageInChars = new ArrayList<>();
        for (char ch:message.toCharArray()) {
            messageInChars.add(ch);
        }

        messageInChars.forEach((ch)->{
            if(table.containsKey(ch))  table.put(ch, 1+table.get(ch));
            else{
                table.put(ch, 1);
            }
        });
        table.put('E', 1);
        return table;
    }

    private Byte[] convertListToByteArray(List<Byte> bytes){
        Byte[] actualBytes = new Byte[bytes.size()];
        return bytes.toArray(actualBytes);
    }

    private List<Byte> encodeBytes(String encodedMessage){
        List<Byte> bytes = new ArrayList<>();
        StringBuilder message = new StringBuilder(encodedMessage);
        int size;
        if(message.length()%7==0) size = message.length()/7;
        else size = message.length()/7+1;
        byte[] encodedBytes = new byte[size];
        while(message.length()>0){
            if(message.length()<6) {
                int len = message.length();
                for (int i = 6; i >=len ; i--) {
                    message.append("0");
                }
            }
            bytes.add(convertBitArrayToByte(convertByteToBitsArray(message.substring(0,7))));
            message.delete(7, message.length());
        }
        return bytes;
    }

    private byte convertBitArrayToByte(byte[] bits){
        byte buffer = 0x00;
        for (int i = 0; i < 7; i++) {
            buffer = (byte) (buffer << 1);
            buffer |= bits[i];
        }
        return buffer;
    }
    private byte[] convertByteToBitsArray(String mes){
        byte[] bits = new byte[7];
        for (int i = 0; i < 7; i++) {
            if(mes.charAt(i)=='0') bits[i] = 0;
            else bits[i] = 1;
        }
        return bits;
    }

}

package huffman;

import file.HuffmanFileWriter;
import tree.Node;
import tree.TableBuilder;
import tree.Tree;
import tree.TreeBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Coder {
    private Tree tree;
    private final String message;

    public Coder(String message){
        this.message = message;
    }

    public void codeMessage() throws FileNotFoundException {
        Map<Character, Integer> table = getFrequencyTable();
        tree = new TreeBuilder().build(table);
        Map<Character, String> huffmanMap= new TableBuilder().buildTable(tree);

        String encodedMessage = "";
        String encodedTree = tree.encodeHuffmanTree();
        Byte[] encodedFileBytes = convertListToByteArray(encodeBytes(encodedTree+encodedMessage));
        File huffmanEncodedFile = new HuffmanFileWriter(encodedFileBytes, new File("")).writeIntoFile();
    }

    //TODO PUT HERE END OF FILE
    private Map<Character, Integer> getFrequencyTable(){
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
        if(message.length()%8==0) size = message.length()/8;
        else size = message.length()/8+1;
        byte[] encodedBytes = new byte[size];
        while(message.length()>0){
            if(message.length()<7) {
                int len = message.length();
                for (int i = 6; i >=len ; i--) {
                    message.append("0");
                }
            }
            bytes.add(convertBitArrayToByte(convertByteToBitsArray(message.substring(0,8))));
            message.delete(8, message.length());
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

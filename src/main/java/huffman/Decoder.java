package huffman;

import file.HuffmanFileReader;
import file.OriginalFileReader;
import file.OriginalFileWriter;
import tree.Node;
import tree.Tree;
import tree.TreeBuilder;

import java.io.IOException;
import java.util.Map;

public class Decoder {
    private Tree tree;
    private final String path;
    private String message;

    Decoder(String path) {
        this.path = path;
    }


    public void decodeMessage() throws IOException {
        String newMess = "";
        message = new HuffmanFileReader(path).readFile();
        Map<Character,Integer> table = getTable();
        tree = new TreeBuilder().build(table);
        int i = 0;
        char character;
        while((character = tree.getChar(message.substring(i++,message.length()),tree.getRoot()))!='E'){
            newMess+=character;
        }
        new OriginalFileWriter("D:\\decoded.txt").writeIntoFile(newMess);
    }


    public int getCharFromString(String mes) {
        int two = 1;
        int result = 0;
        for (int i = 6; i >= 0; i--) {
            int c;
            if (mes.charAt(i) == '0') c = 0;
            else c = 1;
            result += c * two;
            two *= 2;
        }
        return result;
    }

    public Node decodeNode() {
        char symb = message.charAt(0);
        message.substring(1, message.length());
        if (symb == '0') {
            String mes = message.substring(0, 7);
            int symbol = getCharFromString(mes);
            message = message.substring(8, message.length());
            return new Node(1, String.valueOf(symbol), null, null);
        } else {
            Node leftChild = decodeNode();
            Node rightChild = decodeNode();
            return new Node(0,"",leftChild,rightChild);
        }
    }

    public Map<Character, Integer> getTable() throws IOException {
        return new OriginalFileReader("D:\\table.txt").readMap();
    }

    public Tree decodeHuffmanTree() {
        return new Tree(decodeNode());
    }
}

package huffman;

import file.HuffmanFileReader;
import file.OriginalFileReader;
import file.OriginalFileWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tree.Node;
import tree.Tree;
import tree.TreeBuilder;

import java.io.IOException;
import java.util.Map;

public class Decoder {
    private Tree tree;
    private final String path;
    private String message;
    final static Logger logger = LoggerFactory.getLogger(Decoder.class);

    Decoder(String path) {
        this.path = path;
    }


    public void decodeMessage() throws IOException {
        message = new HuffmanFileReader(path).readFile();
        //message = "011111000011111000011111000110000000000"
        //          001111101111000110000010001100000000100000;
        Map<Character,Integer> table = getTable();
        tree = new TreeBuilder().build(table);
        String finalMessage = tree.decodeMessageUsingTree(message);
        logger.debug("result message: {}", finalMessage);
        new OriginalFileWriter("decoded.txt").writeIntoFile(finalMessage);
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
        return new OriginalFileReader("table.txt").readMap();
    }

    public Tree decodeHuffmanTree() {
        return new Tree(decodeNode());
    }
}

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

class Decoder {
    private final String path;
    private String message;
    private final static Logger logger = LoggerFactory.getLogger(Decoder.class);

    Decoder(String path) {
        this.path = path;
    }


    void decodeMessage() throws IOException {
        message = new HuffmanFileReader(path).readFile();
        Tree tree = decodeHuffmanTree();
        String finalMessage = tree.decodeMessageUsingTree(message);
        logger.debug("result message: {}", finalMessage);
        new OriginalFileWriter("decoded.txt", finalMessage).writeIntoFile();
    }
    private int getCharFromString(String mes) {
        int two = 1;
        int result = 0;
        for (int i = Constants.BITS_IN_BYTE-1; i >= 0; i--) {
            int digit;
            if (mes.charAt(i) == '0') digit = 0;
            else digit = 1;
            result += digit * two;
            two *= 2;
        }
        return result;
    }
    private Node decodeNode() {
        char symb = message.charAt(0);
       message = message.substring(1);
        if (symb == '1') {
            int symbol = getCharFromString(message.substring(0, Constants.BITS_IN_BYTE));
            message = message.substring(Constants.BITS_IN_BYTE);
            return new Node(1, Character.toString((char)symbol), null, null);
        } else {
            Node leftChild = decodeNode();
            Node rightChild = decodeNode();
            return new Node(0,"",leftChild,rightChild);
        }
    }
    private Tree decodeHuffmanTree() {
        return new Tree(decodeNode());
    }
}

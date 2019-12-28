package tree;

import file.OriginalFileReader;
import huffman.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

public class Tree {
    private Node root;
    private final static Logger logger = LoggerFactory.getLogger(Tree.class);

    public Tree(Node root) {
        this.root = root;
    }

    Node getRoot() {
        return root;
    }

    public String decodeMessageUsingTree(String message) {
        StringBuilder finalMessage = new StringBuilder();
        Node node = root;
        char anotherCharacter = 0;
        while (anotherCharacter != Constants.EOF) {
            while (!node.isLeaf()) {
                if (message.charAt(0) == '0') {
                    node = node.getLeft();
                    message = message.substring(1);
                } else {
                    node = node.getRight();
                    message = message.substring(1);
                }
            }
            logger.debug("else return symbol {}", node.getSymbol());
            anotherCharacter = node.getSymbol();
            node = root;
            finalMessage.append(anotherCharacter);
        }
       return finalMessage.substring(0, finalMessage.length()-1);
    }


    public String encodeHuffmanTree() {
        return root.encodeNode("");
    }
}

package tree;

import file.OriginalFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

public class Tree {
    private Node root;
    final static Logger logger = LoggerFactory.getLogger(Tree.class);
    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public char getChar(String message,Node node){
        while(!node.isLeaf())
        {
            if(message.charAt(0)=='0') {
               // logger.debug("if 0 then go left return {}",getChar(message.substring(1),node.getLeft()));
                node = node.getLeft();
                message = message.substring(1);
            }
            else{
               // logger.debug("if 1 then go right return {}",getChar(message.substring(1),node.getRight()));
               node = node.getRight();
                message = message.substring(1);
            }
        }

            logger.debug("else return symbol {}", node.getSymbol());
            return node.getSymbol();
    }



    public String encodeHuffmanTree() {
        return root.encodeNode("");
    }
}

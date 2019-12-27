package tree;

import file.OriginalFileReader;

import java.util.PriorityQueue;

public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public char getChar(String message,Node node){
        if(!node.isLeaf())
        {
            if(message.charAt(0)=='0') getChar(message.substring(1,message.length()),node.getLeft());
            else getChar(message.substring(1,message.length()),node.getRight());
            return 'd';
        }
        else return node.getSymbol();
    }



    public String encodeHuffmanTree() {
        return root.encodeNode("");
    }
}

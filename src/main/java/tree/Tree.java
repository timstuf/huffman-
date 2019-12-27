package tree;

import file.OriginalFileReader;

import java.util.PriorityQueue;

public class Tree {
    private Node root;

    Tree(Node root) {
        this.root = root;
    }

    Node getRoot() {
        return root;
    }

    public String encodeHuffmanTree() {
       return root.encodeNode("");
    }
}

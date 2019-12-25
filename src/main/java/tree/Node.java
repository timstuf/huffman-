package tree;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Node implements Comparable<Node> {
    private final int frequency;
    private final String symbols;
    private final Node left;
    private final Node right;

    public Character getSymbol(){ return symbols.charAt(0);}
    public int compareTo(Node node) {
        return frequency - node.frequency;
    }
    public boolean isLeaf(){return left==null&&right==null;}
    public Node getLeft(){return left;}
    public Node getRight(){return right;}
    public Node combineTwoNodes(Node bigger) {
        return new Node(frequency+bigger.frequency, symbols+bigger.symbols, this, bigger);
    }
}

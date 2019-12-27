package tree;

import file.OriginalFileReader;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Node implements Comparable<Node> {
    private final int frequency;
    private final String symbols;
    private final Node left;
    private final Node right;

    Character getSymbol() {
        return symbols.charAt(0);
    }

    public int compareTo(Node node) {
        return frequency - node.frequency;
    }

    boolean isLeaf() {
        return left == null && right == null;
    }

    Node combineTwoNodes(Node bigger) {
        return new Node(frequency + bigger.frequency, symbols + bigger.symbols, this, bigger);
    }



    public String encodeNode(String result) {
        if (isLeaf()) {
            result += "1";
            String symbol = Integer.toBinaryString(getSymbol());
            result += OriginalFileReader.addZerosAtTheBeginning(8 - symbol.length());
            result += symbol;
        } else {
            result += "0";
            result += left.encodeNode(result);
            result += right.encodeNode(result);
        }
        return result;
    }
}

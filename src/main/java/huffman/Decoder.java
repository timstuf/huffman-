package huffman;

import file.HuffmanFileReader;
import tree.Node;
import tree.Tree;

import java.io.IOException;

public class Decoder {
    private Tree tree;
    private final String path;
    private String message;

    Decoder(String path) {
        this.path = path;
    }


    public void decodeMessage() throws IOException {
        message = new HuffmanFileReader(path).readFile();

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

    public Tree decodeHuffmanTree() {
        return new Tree(decodeNode());
    }
}

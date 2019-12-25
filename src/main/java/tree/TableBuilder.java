package tree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TableBuilder {
    private Map<Character, String> huffmanMap;
    public TableBuilder(){huffmanMap = new HashMap<>();
    }


    //TODO reverse hashmap
    public Map<Character, String> buildTable(Tree tree){
        goToNode(tree.getRoot(), "");
        return huffmanMap;
    }
    public void goToNode(Node root, String code){
        if(root.isLeaf()){
            huffmanMap.put(Character.valueOf(root.getSymbol()), code);
            return;
        }
        if(root.getRight()!=null){
            goToNode(root.getRight(), code+"1");
        }
        if(root.getLeft()!=null){
            goToNode(root.getLeft(), code+"0");
        }
    }
}

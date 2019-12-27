package tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TableBuilder {
    private Map<Character, String> huffmanMap;
    final static Logger logger = LoggerFactory.getLogger(TableBuilder.class);
    public TableBuilder(){huffmanMap = new HashMap<>();
    }


    public Map<Character, String> buildTable(Tree tree){
        goToNode(tree.getRoot(), "");
        huffmanMap.forEach((key, value)->logger.debug("encoded character = {}, it's code = {}", key, value));
        return huffmanMap;
    }
    private void goToNode(Node root, String code){
        if(root.isLeaf()){
            huffmanMap.put(root.getSymbol(), code);
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

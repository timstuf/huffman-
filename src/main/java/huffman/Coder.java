package huffman;

import tree.TableBuilder;
import tree.Tree;
import tree.TreeBuilder;

import java.util.*;

public class Coder {
   ;
    private Tree tree;
    private final String message;

    public Coder(String message){
        this.message = message;
    }

    public void codeMessage() {
        Map<Character, Integer> table = getFrequencyTable();
        Tree tree = new TreeBuilder().build(table);
        Map<Character, String> huffmanMap= new TableBuilder().buildTable(tree);
    }

    //TODO PUT HERE END OF FILE
    public Map<Character, Integer> getFrequencyTable(){
        Map<Character, Integer> table = new HashMap<>();
        List<Character> messageInChars = new ArrayList<>();
        for (char ch:message.toCharArray()) {
            messageInChars.add(ch);
        }

        messageInChars.forEach((ch)->{
            if(table.containsKey(ch))  table.put(ch, 1+table.get(ch));
            else{
                table.put(ch, 1);
            }
        });
        return table;
    }
}

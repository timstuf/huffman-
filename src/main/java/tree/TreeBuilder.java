package tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.Map;
import java.util.PriorityQueue;

public class TreeBuilder {
    final static Logger logger = LoggerFactory.getLogger(TreeBuilder.class);
    private final PriorityQueue<Node> nodeQueue = new PriorityQueue<>();
    public TreeBuilder(){}
    private void putIntoQueue(Node node)
    {
        nodeQueue.add(node);
    }
    public Tree build(Map<Character, Integer> table){
        table.forEach((key, value) -> putIntoQueue(new Node(value, String.valueOf(key), null, null)));
        nodeQueue.forEach((node)->logger.debug("in priority queue symbol = {} freq = {}", node.getSymbol(), node.getFrequency()));
        if(nodeQueue.size()<1) throw new InvalidStateException("The queue is empty");
        if(nodeQueue.size()==1) return new Tree(nodeQueue.poll());
        while(nodeQueue.size()>2)
        {
            Node left = nodeQueue.poll();
            Node right = nodeQueue.poll();
            putIntoQueue(left.combineTwoNodes(right));
        }
        Node head = nodeQueue.poll().combineTwoNodes(nodeQueue.poll());
        return new Tree(head);

    }
}

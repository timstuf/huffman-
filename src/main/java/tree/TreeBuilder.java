package tree;

import sun.plugin.dom.exception.InvalidStateException;

import java.util.Map;
import java.util.PriorityQueue;

public class TreeBuilder {
    private final PriorityQueue<Node> nodeQueue = new PriorityQueue<>();
    public TreeBuilder(){}
    private void putIntoQueue(Node node)
    {
        nodeQueue.add(node);
    }
    public Tree build(Map<Character, Integer> table){
        table.forEach((key, value) -> putIntoQueue(new Node(value, String.valueOf(key), null, null)));
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

package tree;

import java.util.Map;
import java.util.PriorityQueue;

public class TreeBuilder {
    private final PriorityQueue<Node> nodeQueue = new PriorityQueue<>();
    public TreeBuilder(){}
    public void putIntoQueue(Node node)
    {
        nodeQueue.add(node);
    }
    public Tree build(Map<Character, Integer> table){
        table.entrySet().forEach((e)->  putIntoQueue(new Node(e.getValue(), String.valueOf(e.getKey()), null,null)));
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

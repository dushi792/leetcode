// Iterative
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        int index = 0;
        // clone nodes
        while (index < nodes.size()) {
            UndirectedGraphNode head = nodes.get(index++);
            for (int i = 0; i < head.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }

        // clone edges
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode newHead = map.get(nodes.get(i));
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                newHead.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }

        return map.get(node);
    }
}


// Recursive
public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map
            = new HashMap<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        if (map.containsKey(node.label))
            return map.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode item : node.neighbors) {
            clone.neighbors.add(cloneGraph(item));
        }
        return clone;
    }

}

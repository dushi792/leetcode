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

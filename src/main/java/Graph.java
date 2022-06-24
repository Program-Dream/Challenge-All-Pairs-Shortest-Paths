import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Graph {

    private final int[][] weights;
    private final Map<String, Integer> nameMapping;
    private final int nodes;

    public Graph(final int amountOfNodes) {
        nodes = amountOfNodes;
        weights = new int[nodes][nodes];
        nameMapping = new HashMap<>(nodes);
    }

    public int addNode(final String nodeName) {
        if (nameMapping.containsKey(nodeName)) {
            throw new IllegalStateException(String.format("A node with the name \"%s\" was already added.", nodeName));
        }

        // get the next free index. If no nodes are added yet, use 0.
        int freeIndex = nameMapping.values().stream().max(Integer::compareTo).orElse(0);

        if (freeIndex >= nodes) {
            throw new IllegalStateException("Out of space - all nodes have already been added.");
        }

        nameMapping.put(nodeName, freeIndex);
        return freeIndex;
    }

    public void setWeight(String fromNode, String toNode, int weight) {
        if (!(nameMapping.containsKey(fromNode) && nameMapping.containsKey(toNode))) {
            throw new IllegalArgumentException("Not all given names have a node associated.");
        }

        int i = nameMapping.get(fromNode);
        int j = nameMapping.get(toNode);

        weights[i][j] = weight;
    }
}

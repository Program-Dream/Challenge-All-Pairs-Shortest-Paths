package tk.programdream.challenges.floyd_warshall;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Graph {

    private final Weight[][] weights;
    private final BiMap<String, Integer> nameMapping;
    private final int nodes;

    public Graph(final int amountOfNodes) {
        nodes = amountOfNodes;
        weights = new Weight[nodes][nodes];
        nameMapping = HashBiMap.create(nodes);

        initWeights();
    }

    private void initWeights() {
        final int len = weights.length;
        final int total = len * len;

        for (int i = 0; i < total; i++) {
            final int major = i / len;
            final int minor = i % len;

            final Weight weight;
            if (major == minor) {
                weight = new Weight(0);
            } else {
                weight = new Weight();
            }

            weights[major][minor] = weight;
        }
    }

    public int getAmountOfNodes() {
        return nodes;
    }

    public boolean hasNode(String nodeName) {
        return nameMapping.containsKey(nodeName);
    }

    public int addNode(final String nodeName) {
        if (nameMapping.containsKey(nodeName)) {
            throw new IllegalStateException(String.format("A node with the name \"%s\" was already added.", nodeName));
        }

        // get the next free index. If no nodes are added yet, use 0.
        final int freeIndex = nameMapping.values().stream().max(Integer::compareTo).map(i -> i + 1).orElse(0);

        if (freeIndex >= nodes) {
            throw new IllegalStateException("Out of space - all nodes have already been added.");
        }

        nameMapping.put(nodeName, freeIndex);
        return freeIndex;
    }

    public void setWeight(final String fromNode, final String toNode, final Weight weight) {
        if (!(nameMapping.containsKey(fromNode) && nameMapping.containsKey(toNode))) {
            throw new IllegalArgumentException("Not all given names have a node associated.");
        }

        final int i = nameMapping.get(fromNode);
        final int j = nameMapping.get(toNode);

        weights[i][j] = weight;
    }

    /**
     * Get the weights of the graph as adjacency matrix.
     *
     * @return a clone of the 2d weights array
     */
    public Weight[][] getAdjacencyMatrix() {
        return Arrays.stream(weights)
                .map(Weight[]::clone)
                .toArray(Weight[][]::new);
    }

    public String getNodeNameByIndex(final int index) {
        return nameMapping.inverse().get(index);
    }

    int getNodeIndexByName(final String name) {
        return nameMapping.get(name);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Set<String> nodeNames = nameMapping.keySet();

        for (String fromNode : nodeNames) {
            builder.append(fromNode);
            builder.append(" [");
            for (String toNode : nodeNames) {
                final int i = nameMapping.get(fromNode);
                final int j = nameMapping.get(toNode);

                builder.append(toNode).append(": ")
                        .append(weights[i][j]).append(", ");
            }
            builder.append(']').append('\n');
        }

        return builder.toString();
    }
}

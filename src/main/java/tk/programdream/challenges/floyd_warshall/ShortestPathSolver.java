package tk.programdream.challenges.floyd_warshall;

import java.util.List;

/**
 * Uses the Floyd Warshall algorithm to calculate the "all pairs shortest path".
 */
public class ShortestPathSolver {

    private final Graph graph;
    private final Weight[][] shortestDistance;
    private final int[][] nextNode;
    private final int nodes;

    public ShortestPathSolver(final Graph graph) {
        this.graph = graph;
        this.shortestDistance = graph.getAdjacencyMatrix();
        this.nodes = graph.getAmountOfNodes();
        this.nextNode = new int[nodes][nodes];

        for (int i = 0; i < nodes * nodes; i++) {
            final int major = i / nodes;
            final int minor = i % nodes;
            final int nextNode;

            if (shortestDistance[major][minor].isPresent()) {
                nextNode = minor;
            } else {
                nextNode = -1;
            }
            this.nextNode[major][minor] = nextNode;
        }
    }

    public void solve() {
        for (int alternative = 0; alternative < nodes; alternative++) {
            for (int existingPath = 0; existingPath < nodes * nodes; existingPath++) {
                final int i_0 = existingPath / nodes;
                final int i_1 = existingPath % nodes;

                final Weight currentlyShortest = shortestDistance[i_0][i_1];
                final List<Weight> discoveredPath = List.of(
                        shortestDistance[i_0][alternative],
                        shortestDistance[alternative][i_1]
                );

                if (currentlyShortest.isPresent() && discoveredPath.stream().allMatch(Weight::isPresent)) {
                    final int discoveredPathWeight = discoveredPath.stream().mapToInt(Weight::getValue).sum();
                    if (discoveredPathWeight < currentlyShortest.getValue()) {
                        shortestDistance[alternative][i_1] = new Weight(discoveredPathWeight);
                        nextNode[i_0][i_1] = nextNode[i_0][alternative];
                    }
                }
            }
        }
    }

    public Path getShortestPath(final int fromIndex, final int toIndex) {
        int current = fromIndex;
        final Path path = new Path(graph.getNodeNameByIndex(fromIndex));

        while (current != toIndex) {
            current = nextNode[current][toIndex];
            path.push(graph.getNodeNameByIndex(current));
        }

        return path;
    }

}

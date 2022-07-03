package tk.programdream.challenges.floyd_warshall;

import java.util.Deque;
import java.util.LinkedList;

public class Path {

    private final Deque<String> nodes = new LinkedList<>();
    private final int totalWeight;

    public Path(String startNode, int totalWeight) {
        this.totalWeight = totalWeight;
        append(startNode);
    }

    public void append(String nodeName) {
        nodes.add(nodeName);
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public Deque<String> getNodes() {
        return new LinkedList<>(nodes);
    }

    @Override
    public String toString() {
        return (
                // Head: What path is visualized.
                '(' +
                nodes.peekFirst() + ", " +
                nodes.peekLast() +
                "): " +

                // visualize path
                String.join(" -> ", nodes) +
                ", " +

                // add total weight
                "total = " + totalWeight
        );
    }
}

package tk.programdream.challenges.floyd_warshall;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
}

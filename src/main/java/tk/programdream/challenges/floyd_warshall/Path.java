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
}

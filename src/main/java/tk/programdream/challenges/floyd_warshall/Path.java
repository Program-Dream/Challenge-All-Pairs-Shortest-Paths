package tk.programdream.challenges.floyd_warshall;

import java.util.Deque;
import java.util.LinkedList;

public class Path {
    private final Deque<String> nodes = new LinkedList<>();

    public Path(String startNode) {
        append(startNode);
    }

    public void append(String nodeName) {
        nodes.add(nodeName);
    }
}

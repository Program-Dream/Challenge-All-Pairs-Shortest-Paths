package tk.programdream.challenges.floyd_warshall;

import java.util.Comparator;
import java.util.Deque;

public class PathComparator implements Comparator<Path> {

    @Override
    public int compare(Path path_0, Path path_1) {
        final int weightComp = Integer.compare(path_0.getTotalWeight(), path_1.getTotalWeight());
        if (weightComp != 0) {
            return weightComp;
        }

        final Deque<String> nodes_0 = path_0.getNodes();
        final Deque<String> nodes_1 = path_1.getNodes();
        final int pathLengthComp = Integer.compare(nodes_0.size(), nodes_1.size());
        if (pathLengthComp != 0) {
            return pathLengthComp;
        }

        final String start_0 = nodes_0.peekFirst();
        final String start_1 = nodes_1.peekFirst();
        assert start_0 != null;
        assert start_1 != null;
        final int startComp = start_0.compareToIgnoreCase(start_1);
        if (startComp != 0) {
            return startComp;
        }

        final String dest_0 = nodes_0.peekLast();
        final String dest_1 = nodes_1.peekLast();
        final int destComp = dest_0.compareToIgnoreCase(dest_1);
        if (destComp != 0) {
            return startComp;
        }

        return 0;
    }
}

package tk.programdream.challenges.floyd_warshall;

public class FileParser {
    private final Graph graph;
    private final String filename;

    public FileParser(final String filename) {
        this.filename = filename;
        this.graph = new Graph(3);
    }

    void apply(final String dataLine) {
        final String[] tokens = dataLine.split("\\s+");

        if (tokens.length < 3) throw new IllegalArgumentException("Line has too few tokens.");

        final String fromNode = tokens[0];
        final String toNode = tokens[2];
        final int weight = (int) tokens[1].chars().filter(c -> c == '-').count();

        if (!graph.hasNode(fromNode)) graph.addNode(fromNode);
        if (!graph.hasNode(toNode)) graph.addNode(toNode);

        graph.setWeight(fromNode, toNode, weight);
    }

}

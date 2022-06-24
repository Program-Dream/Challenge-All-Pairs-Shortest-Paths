package tk.programdream.challenges.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileParser {
    private Graph graph;
    private final String filename;

    public FileParser(final String filename) {
        this.filename = filename;
    }

    private void apply(final String dataLine) {
        final String[] tokens = dataLine.split("\\s+");

        if (tokens.length < 3) throw new IllegalArgumentException("Line has too few tokens.");

        final String fromNode = tokens[0];
        final String toNode = tokens[2];
        final int weight = (int) tokens[1].chars().filter(c -> c == '-').count();

        if (!graph.hasNode(fromNode)) graph.addNode(fromNode);
        if (!graph.hasNode(toNode)) graph.addNode(toNode);

        graph.setWeight(fromNode, toNode, new Weight(weight));
    }

    private BufferedReader createFileReader() throws IOException {
        final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
        if (inputStream == null) throw new IOException("Resource not accessible.");
        final InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        return new BufferedReader(streamReader);
    }

    public void read() throws IOException, NumberFormatException {
        BufferedReader reader = createFileReader();
        final String firstLine = reader.readLine();
        graph = new Graph(Integer.parseInt(firstLine));
        reader.lines().forEach(this::apply);
    }

    public Graph get() {
        return graph;
    }

}

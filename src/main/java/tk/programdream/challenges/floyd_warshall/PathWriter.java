package tk.programdream.challenges.floyd_warshall;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class PathWriter {
    private final ShortestPathSolver solver;

    public PathWriter(ShortestPathSolver solver) {
        this.solver = solver;
    }

    public void writeFile() throws IOException {
        Path file = Paths.get("out.txt");
        Files.write(file, getOutput(), StandardCharsets.UTF_8);
    }

    public List<String> getOutput() {
        List<String> out = new LinkedList<>();



        return out;
    }
}

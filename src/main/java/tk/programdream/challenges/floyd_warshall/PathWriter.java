package tk.programdream.challenges.floyd_warshall;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class PathWriter {
    private final ShortestPathSolver solver;

    public PathWriter(ShortestPathSolver solver) {
        this.solver = solver;
    }

    public void writeFile(String fileName) throws IOException {
        java.nio.file.Path file = Paths.get(fileName);
        Files.write(file, getOutput(), StandardCharsets.UTF_8);
    }

    public List<String> getOutput() {
        return solver.getAllShortestPaths().stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .sorted(new PathComparator())
                .map(Path::toString)
                .toList();
    }
}

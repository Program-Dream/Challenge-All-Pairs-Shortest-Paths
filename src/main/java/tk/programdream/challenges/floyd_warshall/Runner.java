package tk.programdream.challenges.floyd_warshall;

import java.io.IOException;
import java.util.Optional;

public class Runner {

    private static final String INPUT_FILE_NAME = "demo.txt";
    private static final String OUTPUT_FILE_NAME = "out.txt";

    public static void main(String[] args) {
        FileParser fp = new FileParser(INPUT_FILE_NAME);
        try {
            fp.read();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Unable to parse file");
            e.printStackTrace();
        }

        Graph g = fp.get();

        ShortestPathSolver solver = new ShortestPathSolver(g);
        solver.solve();

        PathWriter writer = new PathWriter(solver);
        try {
            writer.writeFile(OUTPUT_FILE_NAME);
        } catch (IOException e) {
            System.out.println("Unable to write file");
            e.printStackTrace();
        }
    }
}

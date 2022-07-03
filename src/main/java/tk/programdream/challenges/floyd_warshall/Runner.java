package tk.programdream.challenges.floyd_warshall;

import java.io.IOException;
import java.util.Optional;

public class Runner {
    public static void main(String[] args) {
        FileParser fp = new FileParser("demo.txt");
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
            writer.writeFile("out.txt");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Unable to write file");
            e.printStackTrace();
        }
    }
}

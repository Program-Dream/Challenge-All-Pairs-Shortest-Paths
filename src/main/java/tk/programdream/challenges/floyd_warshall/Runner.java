package tk.programdream.challenges.floyd_warshall;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        FileParser fp = new FileParser("demo.txt");
        try {
            fp.read();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Unable to parse file");
            e.printStackTrace();
        }
        fp.get();
    }
}

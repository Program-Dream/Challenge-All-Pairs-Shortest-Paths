package tk.programdream.challenges.floyd_warshall;

public class Weight {
    private static int value;
    private static boolean present;

    public Weight(int value) {
        present = true;
        this.value = value;
    }

    public Weight() {
        present = false;
    }

    @Override
    public String toString() {
        return present ? Integer.toString(value) : "infinity";
    }

    @Override
    public int hashCode() {
        return present ? value : -1;
    }
}

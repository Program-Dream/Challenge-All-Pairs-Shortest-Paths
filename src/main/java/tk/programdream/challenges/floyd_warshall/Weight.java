package tk.programdream.challenges.floyd_warshall;

public class Weight {
    private final Integer value;
    private final boolean present;

    public Weight(int value) {
        present = true;
        this.value = value;
    }

    public Weight() {
        value = null;
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

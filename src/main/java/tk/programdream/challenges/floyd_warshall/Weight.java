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

    public boolean isPresent() {
        return present;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (present) {
            assert value != null;
            return Integer.toString(value);
        } else {
            return "infinity";
        }
    }

    @Override
    public int hashCode() {
        if (present) {
            assert value != null;
            return value;
        } else {
            return -1;
        }
    }
}

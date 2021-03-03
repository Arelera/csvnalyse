import java.util.ArrayList;
import java.util.HashMap;

public class Column<T> {

    private String name;
    private ArrayList<T> values;

    public Column(String name) {
        this.name = name;
        this.values = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addValue(T[] vals) {
        for (T val : vals) {
            addValue(val);
        }
    }

    public void addValue(T val) {
        values.add(val);
    }

    public HashMap<String, Integer> frequencies() {
        HashMap<String, Integer> freqs = new HashMap<>();

        for (T val : values) {
            String valStr = (String) val;

            if (freqs.containsKey(valStr)) {
                freqs.put(valStr, freqs.get(val) + 1);
            } else {
                freqs.put(valStr, 1);
            }
        }
        return freqs;
    }

    @Override
    public String toString() {
        return name + " has: " + values.toString();
    }
}

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class File {

    private ArrayList<Column> columns;
    private ArrayList<String[]> rows;

    public File(String fileName) {
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
        readFile(fileName);
        createColumns();
    }

    private void readFile(String fileName) {
        try {
            Files.lines(Paths.get(fileName)).forEach(row ->
                    rows.add(row.split(","))
            );
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public void createColumns() {
        // create new columns with names
        for (String name : rows.get(0)) {
            // TODO: implement getting the right type from string
            columns.add(new Column<String>(name));
        }

        // populate columns with data
        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);

            // loop through row and add each value to corresponding column
            for (int j = 0; j < row.length; j++) {
                Column<String> col = columns.get(j);
                col.addValue(row[j]);
            }
        }
    }

    // todo: method to add a row

    public String analyse(String colName) {
        List<Column> colList = columns.stream().filter(c -> c.getName().equals(colName)).collect(Collectors.toList());
        if (colList.size() == 0) return "Column doesn't exist.";

        Column col = colList.get(0);
        HashMap<String, Integer> freqs = col.frequencies();

        String res = "Column " + colName + " analysed:\n";
        for (String key : freqs.keySet()) {
            res += key + ": " + freqs.get(key) + "\n";
        }
        return res;
    }

    @Override
    public String toString() {
        String out = "";

        String rowStr = "";
        for (String[] row : rows) {
            for (String val : row) {
                out += val + " | ";
            }
            out += "\n";
        }

        return out;
    }
}

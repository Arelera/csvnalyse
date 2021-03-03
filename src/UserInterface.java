import java.util.Scanner;

public class UserInterface {

    private Scanner scan;

    public UserInterface(Scanner scan) {
        this.scan = scan;
    }

    public void start() {
        System.out.println("Welcome to Csvnalyzer!");

        System.out.println("Enter file name: ");
        String fileName = "data.csv"; // scan.nextLine();
        File file = new File(fileName);

        System.out.println("Commands: \n" +
                "full -> prints all columns \n" +
                "a 'columnName' -> analyses given column\n" +
                "stop -> stops program");

        while (true) {
            System.out.println("Command: ");
            String cmd = scan.nextLine();

            if (cmd.equals("stop")) break;

            if (cmd.equals("full")) {
                System.out.println(file);

            } else if (cmd.split(" ")[0].equals("a")) {
                System.out.println(file.analyse(cmd.split(" ")[1]));
            } else {
                System.out.println("Unknown command.");
            }
        }
    }
}
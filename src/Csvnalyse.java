import java.util.Scanner;

public class Csvnalyse {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        UserInterface ui = new UserInterface(scan);

        ui.start();

    }
}

import java.io.IOException;

public class Main {
    public static Display display = new Display();

    public static void main(String[] args) throws IOException {
        //todo create "switch case" for app's menu
        display.displayMainMenu();
        display.displayTransactionPanel();
        display.displayTrade();
        display.displayTransactionFile();
        display.displayRegisterMenu();
        display.displayUser();
        display.displayUserDatabaseFile();
    }
}
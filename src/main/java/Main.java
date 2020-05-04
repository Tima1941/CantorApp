import java.io.IOException;

public class Main {
    public static Display display = new Display();

    public static void main(String[] args) throws IOException {
        //todo create "switch case" for app's menu
        //transaction zrobic podobnie jak user
//        display.displayMainMenu();
//        display.displayTransactionPanel();
//        display.displayTrade();
//        display.displayTransactionFile();

        display.displayRegisterMenu();
        display.displayUser();
        display.displayUserDatabaseFile();
        display.displayUserListSortedByUserId();
    }
}
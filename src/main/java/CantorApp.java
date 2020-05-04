import utils.Display;
import utils.ConfigurationLoader;
import java.io.IOException;

public class CantorApp {
    public static Display display = new Display();
    public static ConfigurationLoader configurationLoader = new ConfigurationLoader();

    public static void main(String[] args) throws IOException {
        configurationLoader.loadProperties();

        //todo create "switch case" for app's menu
        //transaction zrobic podobnie jak user
//        display.displayMainMenu();
//        display.displayTransactionPanel();
//        display.displayTrade();
//        display.displayTransactionFile();

//        display.displayRegisterMenu();
//        display.displayUser();
//        display.displayUserDatabaseFile();
//        display.displayUserListSortedByLogin();
//        display.displayUserListSortedByName();
        display.displayUserListSortedByUserId();
        display.displayTest();
    }
}
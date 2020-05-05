import utils.Display;
import utils.ConfigurationLoader;
import java.io.IOException;
import java.util.Scanner;

public class CantorApp {
    public static Display display = new Display();
    public static ConfigurationLoader configurationLoader = new ConfigurationLoader();

    public static void main(String[] args) throws IOException {
        configurationLoader.loadProperties();

        int value;
        do
        {
            display.displayMainMenu();
            System.out.print("Enter value: \n");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();

            switch(value) {
                case 1:
                    display.displayUserRegister();
                    break;
                case 2:
                    do {
                        display.displayUserMenu();
                        System.out.printf("Enter value: \n");
                        value = scanner.nextInt();

                        switch (value) {
                            case 1:
                                display.displayCheckRates();
                                break;
                            case 2:
                                display.displayTransaction();
                                break;
                            case 3:
                                display.displayTransactionFile();
                                break;
                            case 4:
                                display.displayUserDatabaseFile();
                                break;
                            case 5:
                                display.displayUserListSortedByLogin();
                                break;
                            case 6:
                                display.displayUserListSortedByName();
                                break;
                            case 7:
                                display.displayUserListSortedByUserId();
                                break;
                        }

                    } while (value!=9);

//                    display.displayUserMenu();
//                    System.out.printf("Enter value: \n");
//                    value = scanner.nextInt();
//                    if (value == 1){
//                        display.displayCheckRates();
//                    } else if (value == 2) {
//                        display.displayTransaction();
//                    } else if (value == 3) {
//                        display.displayTransactionFile();
//                    } else if (value == 4) {
//                        display.displayUserDatabaseFile();
//                    } else if (value == 5) {
//                        display.displayUserListSortedByLogin();
//                    } else if (value == 6) {
//                        display.displayUserListSortedByName();
//                    } else if (value == 7) {
//                        display.displayUserListSortedByUserId();
//                    } else {
//                        System.out.print("Wrong action");
//                    }

                    break;
                case 3:
                    display.displayCheckRates();
                    break;
                case 4:
                    display.displayTransaction();
                    break;
//                default:
//                    System.out.printf("pomyłka, ale dalej jestes w petli\n"+ value);
            }
//            System.out.printf("Enter 4 to exit\n");

        } while(value!=0);
//        System.out.printf("Out of While loop\n");
        //return h;


        //todo create "switch case" for app's menu
        //transaction zrobic podobnie jak user
//        display.displayMainMenu();
//        display.displayTransactionPanel();
//        display.displayTrade();
//        display.displayTransactionFile();
//        display.displayCheckRates();

//        display.displayRegisterMenu();
//        display.displayUser();
//        display.displayUserDatabaseFile();
//        display.displayUserListSortedByLogin();
//        display.displayUserListSortedByName();
//        display.displayUserListSortedByUserId();
//        display.displayLoginMenu();
//        display.displayUserMenu();
//        display.displayTest();
    }
}
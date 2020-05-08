package utils;

import model.Trade;
import model.User;
import java.io.IOException;
import java.util.List;

public class Display {
    public static User user = new User();
    public static Trade trade = new Trade();
    public static Database database = new Database();

    public void displayMainMenu() {
        System.out.print("\n************************************\n");
        System.out.print("************   Cantor   ************");
        System.out.print("\n************************************\n");
        System.out.print("1. Register\n");
        System.out.print("2. Login\n");
        System.out.print("3. Check rates\n");
        System.out.print("4. Transaction\n");
        System.out.print("0. Exit");
        System.out.print("\n************************************\n");
    }

    public void displayUserRegister() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tRegister User");
        System.out.print("\n************************************\n");

        System.out.print("Enter User Login: ");
        user.setUserLogin();

        System.out.print("Enter User Name: ");
        user.setUserName();

        System.out.print("Enter User Surname: ");
        user.setUserSurname();

        System.out.print("Enter User Password: ");
        user.setUserPassword();

        System.out.print("Enter Email Address: ");
        user.setEmailAddress();

        user.setUserId();
        user.setDataCreation();
        database.saveUserInDatabase(user);

        System.out.print("\n*********** Created User ***********\n");
        System.out.print("User ID:\t\t" + user.getUserId() +
                "\nLogin:\t\t\t" + user.getUserLogin() +
                "\nUser Name:\t\t" + user.getUserName() +
                "\nUser Surname:\t" + user.getUserSurname() +
                "\nEmail Address:\t" + user.getEmailAddress() +
                "\nCreation Date:\t" + user.getCreationDate());
        System.out.print("\n************************************\n");
    }

    public boolean displayLogin() {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tLogin");
        System.out.print("\n************************************\n");

        System.out.print("Enter User Login: ");
        user.setUserLogin();

        System.out.print("Enter User Password: ");
        user.setUserPassword();

        if (database.loginChecker(user.login, user.password) == true) {
            System.out.println("Login accepted");
        } else {
            System.out.println("Wrong login/password");
        }

        return database.loginChecker(user.login, user.password);
    }

    public void displayCheckRates () throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tCheck Rates");
        System.out.print("\n************************************\n");
        trade.setTradeDate();
        System.out.print("Today is: " + trade.getTradeDate());

        System.out.println("\nEnter currency1: ");
        trade.setCurrency1();

        System.out.println("Enter currency2: ");
        trade.setCurrency2();

        trade.setRate(trade.getCurrency1(), trade.getCurrency2());
        System.out.println("Rate: " + trade.getRate());
    }

    public void displayTransaction() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tTransaction");
        System.out.print("\n************************************\n");

        System.out.print("Enter currency1: ");
        trade.setCurrency1();

        System.out.print("Enter currency2: ");
        trade.setCurrency2();

        System.out.print("Enter amount: ");
        trade.setAmount();

        trade.setRate(trade.getCurrency1(), trade.getCurrency2());
        trade.setValue(trade.getRate(), trade.getAmount());
        trade.setTradeDate();
        database.saveTradeInDatabase(trade);

        System.out.print("\n********* Transaction data *********\n");
        System.out.print("TradeDate: " + trade.getTradeDate() +
                        "\nCurrency1:\t" + trade.getCurrency1() +
                        "\nCurrency2:\t" + trade.getCurrency2() +
                        "\nAmount:\t" + trade.getAmount() +
                        "\nRate:\t" + trade.getRate() +
                        "\nValue:\t" + trade.getValue());
        System.out.print("\n************************************\n");
    }

    public void displayUserMenu() {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tUser Menu");
        System.out.print("\n************************************\n");
        System.out.print("\t\tWelcome: " + user.login);
        System.out.print("\n1. Transaction");
        System.out.print("\n2. Display Trade's Database");
        System.out.print("\n3. Display User's Database");
        System.out.print("\n4. Display Users' sorted by ID");
        System.out.print("\n5. Display Users' sorted by Login");
        System.out.print("\n6. Display Users' sorted by Name");
        System.out.print("\n7. Display Users' sorted by Surname");
        System.out.print("\n8. Display Users' sorted by Email Address");
        System.out.print("\n9. Display Users' sorted by Creation date");
        System.out.print("\n10. <- Back Menu");
        System.out.print("\n************************************\n");
    }

    public void displayTradeFile() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tTrade Database file");
        System.out.print("\n************************************\n");
        List<Trade> tradeList = database.readTradeDatabaseFile();

        int k = 1;
        for (int i = 0; i < tradeList.size(); i++) {
            System.out.println("ID: " + k + ", " + tradeList.get(i));
            k++;
        }
    }

    public void displayUserDatabaseFile() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers Database file");
        System.out.print("\n************************************\n");
        List<User> usersList = database.readUserDatabaseFile();

        int k = 1;
        for (int i = 0; i < usersList.size(); i++) {
            System.out.println("ID: " + k + ", " + usersList.get(i));
            k++;
        }
    }

    public void displayUserListSortedById() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by User ID");
        System.out.print("\n************************************\n");
        database.userListSortedById();
    }

    public void displayUserListSortedByLogin() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Login");
        System.out.print("\n************************************\n");
        database.userListSortedByLogin();
    }

    public void displayUserListSortedByName() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Name");
        System.out.print("\n************************************\n");
        database.userListSortedByName();
    }

    public void displayUserListSortedBySurname() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Surname");
        System.out.print("\n************************************\n");
        database.userListSortedBySurname();
    }

    public void displayUserListSortedByEmailAddress() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Email Address");
        System.out.print("\n************************************\n");
        database.userListSortedByEmailAddress();
    }

    public void displayUserListSortedByCreationDate() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Creation Date");
        System.out.print("\n************************************\n");
        database.userListSortedByCreationDate();
    }

    public void displayTest() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tTest");
        System.out.print("\n************************************\n");

    }

//    -------------------------------do not remove !!! to use for future main menu fixing ------------------------------------

//    public void displayUserDatabase() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\t\tUser Database");
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tWelcome: " + user.login);
//        System.out.print("\n1. Display User Database");
//        System.out.print("\n2. Display Users sorted by ID");
//        System.out.print("\n3. Display Users sorted by Login");
//        System.out.print("\n4. Display Users sorted by Name");
//        System.out.print("\n5. Display Users sorted by Surname");
//        System.out.print("\n6. Display Users sorted by Email Address");
//        System.out.print("\n7. Display Users sorted by Creation date");
//        System.out.print("\n9. <- Back Menu");
//        System.out.print("\n************************************\n");
//    }
//
//    public void displayTradeDatabase() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\t\tTrade Database");
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tWelcome: " + user.login);
//        System.out.print("\n1. Display Trade Database");
//        System.out.print("\n2. Display Trade sorted by Amount");
//        System.out.print("\n3. Display Trade sorted by Currency1");
//        System.out.print("\n4. Display Trade sorted by Currency2");
//        System.out.print("\n5. Display Trade sorted by Rate");
//        System.out.print("\n6. Display Trade sorted by Value");
//        System.out.print("\n7. Display Trade sorted by TradeDate");
//        System.out.print("\n9. <- Back Menu");
//        System.out.print("\n************************************\n");
//    }
//
//    public void displayTradeFile() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade Database file");
//        System.out.print("\n************************************\n");
//        List<Trade> tradeList = database.readTradeDatabaseFile();
//
//        int k = 1;
//        for (int i = 0; i < tradeList.size(); i++) {
//            System.out.println("ID: " + k + ", " + tradeList.get(i));
//            k++;
//        }
//    }
//
//    public void displayUserDatabaseFile() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tUser Database file");
//        System.out.print("\n************************************\n");
//        List<User> usersList = database.readUserDatabaseFile();
//
//        int k = 1;
//        for (int i = 0; i < usersList.size(); i++) {
//            System.out.println("ID: " + k + ", " + usersList.get(i));
//            k++;
//        }
//    }
//
//    public void displayUserListSortedById() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tUser List Sorted by User ID");
//        System.out.print("\n************************************\n");
//        database.userListSortedById();
//    }
//
//    public void displayUserListSortedByLogin() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tUser List Sorted by Login");
//        System.out.print("\n************************************\n");
//        database.userListSortedByLogin();
//    }
//
//    public void displayUserListSortedByName() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tUser List Sorted by Name");
//        System.out.print("\n************************************\n");
//        database.userListSortedByName();
//    }
//
//    public void displayUserListSortedBySurname() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tUser List Sorted by Surname");
//        System.out.print("\n************************************\n");
//        database.userListSortedBySurname();
//    }
//
//    public void displayUserListSortedByEmailAddress() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tUser List Sorted by Email Address");
//        System.out.print("\n************************************\n");
//        database.userListSortedByEmailAddress();
//    }
//
//    public void displayUserListSortedByCreationDate() {
//        System.out.print("\n************************************\n");
//        System.out.print("\tUser List Sorted by Creation Date");
//        System.out.print("\n************************************\n");
//        database.userListSortedByCreationDate();
//    }
//
//    public void displayTest() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTest");
//        System.out.print("\n************************************\n");
//
////        displayTradeListSortedByAmount();
////        displayTradeListSortedByCurrency1();
////        displayTradeListSortedByCurrency2();
////        displayTradeListSortedByRate();
////        displayTradeListSortedByValue();
////        displayTradeListSortedByTradeDate();
//    }
//
//    public void displayTradeListSortedByAmount() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade List Sorted by Amount");
//        System.out.print("\n************************************\n");
//        database.tradeListSortedByAmount();
//    }
//
//    public void displayTradeListSortedByCurrency1() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade List Sorted by Currency1");
//        System.out.print("\n************************************\n");
//        database.tradeListSortedByCurrency1();
//    }
//
//    public void displayTradeListSortedByCurrency2() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade List Sorted by Currency2");
//        System.out.print("\n************************************\n");
//        database.tradeListSortedByCurrency2();
//    }
//
//    public void displayTradeListSortedByRate() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade List Sorted by Rate");
//        System.out.print("\n************************************\n");
//        database.tradeListSortedByRate();
//    }
//
//    public void displayTradeListSortedByValue() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade List Sorted by Value");
//        System.out.print("\n************************************\n");
//        database.tradeListSortedByValue();
//    }
//
//    public void displayTradeListSortedByTradeDate() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade List Sorted by TradeDate");
//        System.out.print("\n************************************\n");
//        database.tradeListSortedByTradeDate();
//    }
}
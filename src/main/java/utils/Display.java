package utils;

import model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Display {
    public static Helper helper = new Helper();
    public static User user = new User();

    public void displayMainMenu() {
        System.out.print("\n************************************\n");
        System.out.print("************   Cantor   ************");
        System.out.print("\n************************************\n");
        System.out.print("1. Register\n");
        System.out.print("2. Login\n");
        System.out.print("3. Check rates\n");
        System.out.print("4. Transaction\n");
        System.out.print("0. Exit\n");
        System.out.print("************************************\n");
    }

    public void displayRegisterMenu() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\tRegister Menu");
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
        helper.saveUserInDatabase(user);
    }

    public void displayLoginMenu() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tLogin Menu");
        System.out.print("\n************************************\n");

        System.out.print("Enter User Login: ");
        user.setUserLogin();

        System.out.print("Enter User Password: ");
        user.setUserPassword();

//        helper.createLoginUser(user.login, user.password);
        helper.loginMenu(user.login, user.password);
//        System.out.println("\nlogin:" + user.login  + ", password: " + user.password + "\n");
    }

    public void displayTrade () throws IOException {
        System.out.println("\n********** Transaction data **********");
        String tradeContent =
                "TradeDate: " + helper.getTradeDate() +
                        "\nCurrency1:\t" + helper.getCurrency1() +
                        "\nCurrency2:\t" + helper.getCurrency2() +
                        "\nAmount:\t" + helper.getAmount() +
                        "\nRate:\t" + helper.getRate() +
                        "\nValue:\t" + helper.getCalculate();
        System.out.println(tradeContent);
        System.out.print("************************************\n");

        helper.saveTransaction();
    }

    public void displayCheckRates () throws IOException {
        System.out.print("\n************************************\n");
        System.out.println("\n********** Check Rates Menu **********");
        System.out.print("\n************************************\n");
        helper.setTradeDate();
        System.out.println("Today is: " + helper.getTradeDate());

        System.out.print("Enter currency1: ");
        helper.setCurrency1();

        System.out.print("Enter currency2: ");
        helper.setCurrency2();

        helper.setRate(helper.getCurrency1(), helper.getCurrency2());
        System.out.println("Rate: " + helper.getRate());
    }

    public void displayTransactionPanel() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\tTransaction Menu");
        System.out.print("\n************************************\n");

        System.out.print("Enter currency1: ");
        helper.setCurrency1();

        System.out.print("Enter currency2: ");
        helper.setCurrency2();

        System.out.println("Enter amount: ");
        helper.setAmount();

        helper.setRate(helper.getCurrency1(), helper.getCurrency2());
        helper.setCalculate(helper.getRate(), helper.getAmount());
        helper.setTradeDate();
    }

    public void displayUser () throws IOException {
        System.out.println("\n********** Created User **********");
        String userContent =
                "Login:\t\t\t" + user.getUserLogin() +
                        "\nUser Name:\t\t" + user.getUserName() +
                        "\nUser Surname:\t" + user.getUserSurname() +
                        "\nUser Password:\t" + user.getUserPassword() +
                        "\nEmail Address:\t" + user.getEmailAddress() +
                        "\nUser ID:\t\t" + user.getUserId();
        System.out.println(userContent);
        System.out.print("************************************\n");

        helper.saveUserInDatabase(user);
    }

    public void displayTransactionFile () {
        System.out.print("\n************************************\n");
        System.out.print("\t\tTransaction file");
        System.out.print("\n************************************\n");
        helper.readData();
    }

    public void displayUserDatabaseFile() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers Database file");
        System.out.print("\n************************************\n");
        List<User> usersList = helper.readUserDatabaseFile();

        int k = 1;
        for (int i = 0; i < usersList.size(); i++) {
            System.out.println("ID: " + k + ", " + usersList.get(i));
            k++;
        }
    }

    public void displayUserListSortedByUserId() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by User ID");
        System.out.print("\n************************************\n");
        helper.userListSortedByUserId();
    }

    public void displayUserListSortedByName() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Name");
        System.out.print("\n************************************\n");
        helper.userListSortedByUserName();
    }

    public void displayUserListSortedByLogin() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Login");
        System.out.print("\n************************************\n");
        helper.userListSortedByLogin();
    }

    public void displayTest() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\tTest");
        System.out.print("\n************************************\n");
        helper.test();
    }
}

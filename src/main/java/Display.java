import java.io.IOException;
import java.util.List;

public class Display {
    public static Helper helper = new Helper();
    public static User user = new User();

    public void displayMainMenu() {
        System.out.print("\n------------------------------------\n");
        System.out.print("\t\t\tCantor");
        System.out.print("\n------------------------------------\n");
        System.out.print("1. Register\n");
        System.out.print("2. Log in\n");
        System.out.print("3. Check rates for currencies\n");
        System.out.print("4. Calculate exchange\n");
        System.out.print("0. Exit\n");
    }

    public void displayRegisterMenu() {
        System.out.print("\n------------------------------------\n");
        System.out.print("\t\tRegister Menu");
        System.out.print("\n------------------------------------\n");

        System.out.print("Enter User Login: ");
        user.setUserLogin();

        System.out.print("Enter User Name: ");
        user.setUserName();

        System.out.print("Enter User Surname: ");
        user.setUserSurname();

        System.out.print("Enter Email Address: ");
        user.setEmailAddress();

        user.setUserId();
    }

    public void displayTransactionPanel(){
        System.out.print("\n------------------------------------\n");
        System.out.print("\t\tTransaction Panel");
        System.out.print("\n------------------------------------\n");

        helper.setTradeDate();
        System.out.print("Transaction date: " + helper.getTradeDate() + "\n");

        System.out.print("Provide currency1 (/EUR/USD/GBP/PLN): ");
        helper.setCurrency1();

        System.out.print("Provide currency2 (/EUR/USD/GBP/PLN): ");
        helper.setCurrency2();
        helper.setCurrencyPair(helper.getCurrency1(), helper.getCurrency2());

        System.out.println("Provide amount: ");
        helper.setAmount();

        helper.setRate();
        helper.setCalculate(helper.getRate(), helper.getAmount());
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

    public void displayUser () throws IOException {
        System.out.println("\n********** Created User **********");
        String userContent =
                "Login:\t\t\t" + user.getUserLogin() +
                        "\nUser Name:\t\t" + user.getUserName() +
                        "\nUser Surname:\t" + user.getUserSurname() +
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
        System.out.print("\t\tUser Database file");
        System.out.print("\n************************************\n");
        List<User> usersList = helper.readUserDatabaseFile();
        for (User i : usersList) {
            System.out.println("Login: " + i.login + ", Name: " + i.name + ", Surname: " + i.surname +
                    ", Email Address: " + i.emailAddress + ", User ID: " + i.userId);
        }
    }

    public void displayUserListSortedByUserId() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUser List Sorted by User ID");
        System.out.print("\n************************************\n");
        helper.userListSortedByUserId();
    }

    public void displayUserListSortedByName() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUser List Sorted by Name");
        System.out.print("\n************************************\n");
        helper.userListSortedByUserName();
    }

    public void displayUserListSortedByLogin() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUser List Sorted by Login");
        System.out.print("\n************************************\n");
        helper.userListSortedByLogin();
    }
}

import java.io.IOException;

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

    public void displayRegisterMenu() throws IOException {
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
                        "\nCurrency1: " + helper.getCurrency1() +
                        "\nCurrency2: " + helper.getCurrency2() +
                        "\nAmount: " + helper.getAmount() +
                        "\nRate: " + helper.getRate() +
                        "\nValue: " + helper.getCalculate();
        System.out.println(tradeContent);
        System.out.print("************************************\n");

        helper.saveTransaction();
    }

    public void displayUser () throws IOException {
        System.out.println("\n********** User data **********");
        String userContent =
                "Login: " + user.getUserLogin() +
                        "\nUser Name: " + user.getUserName() +
                        "\nUser Surname: " + user.getUserSurname() +
                        "\nEmail Address: " + user.getEmailAddress() +
                        "\nUser ID: " + user.getUserId();
        System.out.println(userContent);
        System.out.print("************************************\n");

        helper.saveUserInDatabase(String.valueOf(user));
    }



    public void displayTransactionFile () {
        System.out.print("\n************************************\n");
        System.out.print("\t\tTransaction file");
        System.out.print("\n************************************\n");
        helper.readData();
    }

    public void displayUserDatabaseFile() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUser Database file");
        System.out.print("\n************************************\n");
        helper.readUserDatabaseFile();
    }
}

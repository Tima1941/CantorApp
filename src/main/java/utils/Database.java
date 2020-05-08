package utils;

import model.Trade;
import model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Database {
    //For User class
    public void saveUserInDatabase(User user) throws IOException {
        FileWriter fileWriter = new FileWriter(System.getProperty("user.database"), true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(user.userId + ", " + user.login + ", " + user.name + ", " + user.surname + ", "
                            + user.password + ", " + user.emailAddress + ", " + user.creationDate + "\n");
        printWriter.close();
    }

    static List<User> readUserDatabaseFile() {
        List<User> userList = new ArrayList<>();

        try {
            File myObj = new File(System.getProperty("user.database"));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(", ");
                User user = createUser(attributes);
                userList.add(user);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return userList;
    }

    public boolean loginChecker(String inputLogin, String inputPass) {
        boolean login = false;

        try {
            File myObj = new File(System.getProperty("user.database"));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(", ");
                User user = createUser(attributes);
                if (user.login.equals(inputLogin) && user.password.equals(inputPass)) {
                    login = true;
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return login;
    }

    private static User createUser(String[] metadata) {
        int userId = Integer.parseInt(metadata[0]);
        String login = metadata[1];
        String name = metadata[2];
        String surname = metadata[3];
        String password = metadata[4];
        String emailAddress = metadata[5];
        String creationDate = metadata[6];

        // create and return user of this metadata
        return new User(userId, login, name, surname, password, emailAddress, creationDate);
    }

    public void userListSortedById() {
        List<User> userId = readUserDatabaseFile();
        userId.sort( Comparator.comparing(user -> user.userId) );

        int k = 1;
        for (int i = 0; i < userId.size(); i++) {
            System.out.println("ID: " + k + ", " + userId.get(i));
            k++;
        }
    }

    public void userListSortedByLogin() {
        List<User> userLogin = readUserDatabaseFile();
        userLogin.sort(Comparator.comparing(user -> user.login));

        int k = 1;
        for (int i = 0; i < userLogin.size(); i++) {
            System.out.println("ID: " + k + ", " + userLogin.get(i));
            k++;
        }
    }

    public void userListSortedByName() {
        List<User> userName = readUserDatabaseFile();
        userName.sort( Comparator.comparing(user -> user.name) );

        int k = 1;
        for (int i = 0; i < userName.size(); i++) {
            System.out.println("ID: " + k + ", " + userName.get(i));
            k++;
        }
    }

    public void userListSortedBySurname() {
        List<User> userSurname = readUserDatabaseFile();
        userSurname.sort( Comparator.comparing(user -> user.surname) );

        int k = 1;
        for (int i = 0; i < userSurname.size(); i++) {
            System.out.println("ID: " + k + ", " + userSurname.get(i));
            k++;
        }
    }

    public void userListSortedByEmailAddress() {
        List<User> emailAddress = readUserDatabaseFile();
        emailAddress.sort( Comparator.comparing(user -> user.emailAddress) );

        int k = 1;
        for (int i = 0; i < emailAddress.size(); i++) {
            System.out.println("ID: " + k + ", " + emailAddress.get(i));
            k++;
        }
    }

    public void userListSortedByCreationDate() {
        List<User> creationDate = readUserDatabaseFile();
        creationDate.sort( Comparator.comparing(user -> user.creationDate) );

        int k = 1;
        for (int i = 0; i < creationDate.size(); i++) {
            System.out.println("ID: " + k + ", " + creationDate.get(i));
            k++;
        }
    }
    //    For Trade class
    public void saveTradeInDatabase(Trade trade) throws IOException {
        FileWriter fileWriter = new FileWriter(System.getProperty("trade.database"), true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(trade.amount + ", " + trade.currency1 + ", " + trade.currency2 + ", " +
                            trade.rate + ", " + trade.value + ", " + trade.tradeDate + "\n");
        printWriter.close();
    }

    public static List<Trade> readTradeDatabaseFile() {
        List<Trade> tradeList = new ArrayList<>();

        try {
            File myObj = new File(System.getProperty("trade.database"));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(", ");
                Trade trade = createTrade(attributes);
                tradeList.add(trade);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return tradeList;
    }

    private static Trade createTrade(String[] metadata) {
        double amount = Double.parseDouble(metadata[0]);
        String currency1 = metadata[1];
        String currency2 = metadata[2];
        double rate = Double.parseDouble(metadata[3]);
        double value = Double.parseDouble(metadata[4]);
        String tradeDate = metadata[5];

        // create and return trade of this metadata
        return new Trade(amount, currency1, currency2, rate, value, tradeDate);
    }
}
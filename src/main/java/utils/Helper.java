package utils;

import model.Trade;
import model.User;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Helper {
    public static Trade tradeModel = new Trade();
    public static Date date = new Date();
    public static HttpConnection http = new HttpConnection();

    public double setRate () {
        String currencyPair = getCurrencyPair();
        if ("EURUSD".equals(currencyPair)) {
            tradeModel.rate = (float) 1.08;
        } else if ("EURGBP".equals(currencyPair)) {
            tradeModel.rate = (float) 0.88;
        } else if ("EURPLN".equals(currencyPair)) {
            tradeModel.rate = (float) 4.55;
        } else if ("USDEUR".equals(currencyPair)) {
            tradeModel.rate = (float) 0.93;
        } else if ("USDGBP".equals(currencyPair)) {
            tradeModel.rate = (float) 0.81;
        } else if ("USDPLN".equals(currencyPair)) {
            tradeModel.rate = (float) 4.21;
        } else if ("PLNEUR".equals(currencyPair)) {
            tradeModel.rate = (float) 0.22;
        } else if ("PLNUSD".equals(currencyPair)) {
            tradeModel.rate = (float) 0.24;
        } else if ("GBPEUR".equals(currencyPair)) {
            tradeModel.rate = (float) 1.13;
        } else if ("GBPUSD".equals(currencyPair)) {
            tradeModel.rate = (float) 1.23;
        } else if ("GBPPLN".equals(currencyPair)) {
            tradeModel.rate = (float) 5.13;
        } else {
            System.out.print("Wrong currencies, enter again \n");
        }
        return tradeModel.rate;
    }

    public double getRate (){
        return tradeModel.rate;
    }

    public void getFakeRate () throws IOException {
        http.connection();
    }

    public void setCurrencyPair (String ccy1, String ccy2) {
        tradeModel.currencyPair = ccy1 + ccy2;
    }

    public String getCurrencyPair (){
        return tradeModel.currencyPair;
    }

    public void setAmount() {
        Scanner scanner = new Scanner(System.in);
        String reader = scanner.nextLine();
        tradeModel.amount = Float.valueOf(reader);
    }

    public double getAmount() {
        return tradeModel.amount;
    }

    public void setTradeDate () {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        tradeModel.tradeDate = dateFormat.format(date);
    }

    public String getTradeDate () {
        return tradeModel.tradeDate;
    }

    public void setCurrency1(){
        Scanner scanner = new Scanner(System.in);
        String currency1;
        do {
            //todo zmien na duze albo male znaki zeby wszystko zamienialo
            currency1 = scanner.nextLine();
        }
        while (!"EUR".equals(currency1) && !"USD".equals(currency1)&& !"GBP".equals(currency1)&& !"PLN".equals(currency1));
        tradeModel.currency1 = currency1;
    }

    public String getCurrency1() {
        return tradeModel.currency1;
    }

    public void setCurrency2(){
        Scanner scanner = new Scanner(System.in);
        String currency2;
        do {
            //todo zmien na duze albo male znaki zeby wszystko zamienialo
            currency2 = scanner.nextLine();
        }
        while (!"EUR".equals(currency2) && !"USD".equals(currency2)&& !"GBP".equals(currency2)&& !"PLN".equals(currency2));
        tradeModel.currency2 = currency2;
    }
    public String getCurrency2() {
        return tradeModel.currency2;
    }

    public double setCalculate (double rate, double amount){
        return tradeModel.value = rate * amount;
    }

    public double getCalculate (){
        return tradeModel.value;
    }

    //todo pobieranie kursów ze strony internetowej

    public void saveTransaction () throws IOException {
//        FileWriter fileWriter = new FileWriter(transactionsDatabase, true);
        FileWriter fileWriter = new FileWriter(System.getProperty("transactions.database"), true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        String tradeContent =
                "\nTradeDate: " + getTradeDate() +
                        ",\tCurrency1: " + getCurrency1() +
                        ",\tCurrency2: " + getCurrency2() +
                        ",\tAmount: " + getAmount() +
                        ",\tRate: " + getRate() +
                        ",\tValue: " + getCalculate();
        printWriter.print(tradeContent);
        printWriter.close();
    }

    public void readData (){
        try {
            File myObj = new File(System.getProperty("transactions.database"));
//            File myObj = new File(transactionsDatabase);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void saveUserInDatabase(User user) throws IOException {
//        FileWriter fileWriter = new FileWriter("src/main/resources/UsersDatabase.txt", true);
        FileWriter fileWriter = new FileWriter(System.getProperty("users.database"), true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(user.login + ", " + user.name + ", " + user.surname + ", " + user.emailAddress + ", " + user.userId + "\n");
        printWriter.close();
    }

    static List<User> readUserDatabaseFile() {
        Path pathToFile = Paths.get(System.getProperty("users.database"));
        List<User> userList = new ArrayList<>();

        // create an instance of BufferedReader using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {
            // use string.split to load a string array with the values from each line of the file, using a comma as the delimiter
                String[] attributes = line.split(", ");
                User user = createUser(attributes);

                // adding book into ArrayList
                userList.add(user);
                // read next line before looping // if end of file reached,
                // line would be null

                line = br.readLine();
            }
        } catch (IOException ioe)
                 { ioe.printStackTrace(); }

        return userList;
    }

    public void userListSortedByUserId() throws IOException {
        List<User> userId = readUserDatabaseFile();
        userId.sort( Comparator.comparing(user -> user.userId) );

        int k = 1;
        for (int i = 0; i < userId.size(); i++) {
            System.out.println("ID: " + k + ", " + userId.get(i));
            k++;
        }
    }

    public void userListSortedByUserName() throws IOException {
        List<User> userName = readUserDatabaseFile();
        userName.sort( Comparator.comparing(user -> user.name) );

        int k = 1;
        for (int i = 0; i < userName.size(); i++) {
            System.out.println("ID: " + k + ", " + userName.get(i));
            k++;
        }
    }

    public void userListSortedByLogin() throws IOException {
        List<User> userLogin = readUserDatabaseFile();
        userLogin.sort(Comparator.comparing(user -> user.login));

        int k = 1;
        for (int i = 0; i < userLogin.size(); i++) {
            System.out.println("ID: " + k + ", " + userLogin.get(i));
            k++;
        }
    }

    private static User createUser(String[] metadata) {
        String login = metadata[0];
        String name = metadata[1];
        String surName = metadata[2];
        String emailAddress = metadata[3];
        int userId = Integer.parseInt(metadata[4]);

        // create and return user of this metadata
        return new User(login, name, surName, emailAddress, userId);
    }
}




















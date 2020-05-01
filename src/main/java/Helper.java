package com.company;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import static com.company.Display.helper;
import static com.company.Display.user;

public class Helper {
    public static TradeModel tradeModel = new TradeModel();
    public static Date date = new Date();

    public double setRate () {
        switch (getCurrencyPair()) {
            case "EURUSD":
                tradeModel.rate = (float) 1.08;
                break;
            case "EURGBP":
                tradeModel.rate = (float) 0.88;
                break;
            case "EURPLN":
                tradeModel.rate = (float) 4.55;
                break;
            case "USDEUR":
                tradeModel.rate = (float) 0.93;
                break;
            case "USDGBP":
                tradeModel.rate = (float) 0.81;
                break;
            case "USDPLN":
                tradeModel.rate = (float) 4.21;
                break;
            case "PLNEUR":
                tradeModel.rate = (float) 0.22;
                break;
            case "PLNUSD":
                tradeModel.rate = (float) 0.24;
                break;
            case "GBPEUR":
                tradeModel.rate = (float) 1.13;
                break;
            case "GBPUSD":
                tradeModel.rate = (float) 1.23;
                break;
            case "GBPPLN":
                tradeModel.rate = (float) 5.13;
                break;
            default:
                System.out.print("Wrong currencies, enter again \n");
        };
        return tradeModel.rate;
    }

    public double getRate (){
        return tradeModel.rate;
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
        FileWriter fileWriter = new FileWriter("transaction.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        String tradeContent =
                "\n|\tTradeDate: " + helper.getTradeDate() +
                        "|\tCurrency1: " + helper.getCurrency1() +
                        "|\tCurrency2: " + helper.getCurrency2() +
                        "|\tAmount: " + helper.getAmount() +
                        "|\tRate: " + helper.getRate() +
                        "|\tValue: " + helper.getCalculate();
        printWriter.print(tradeContent);
        printWriter.close();
    }

    public void readData (){
        try {
            File myObj = new File("transaction.txt");
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

    public void saveUserInDatabase() throws IOException {
        FileWriter fileWriter = new FileWriter("UserDatabase.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(user);
        printWriter.close();
    }

    public void readUserDatabaseFile() {
        try {
            File myObj = new File("UserDatabase.txt");
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
}




















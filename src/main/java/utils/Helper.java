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

    public void setRate (String currency1, String currency2) throws IOException {
        tradeModel.rate = http.getRate(currency1, currency2);
    }

    public double getRate (){
        return tradeModel.rate;
    }

    public void test() throws IOException {
//        http.getRate( "USD", "PLN");
//        System.out.println(http.getRate( "USD", "PLN"));
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

    public void saveTransaction () throws IOException {
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
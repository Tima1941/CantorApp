package model;

import utils.HttpConnection;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Trade {
    public String currency1;
    public String currency2;
    public String tradeDate;
    public double amount;
    public double rate;
    public double value;

    public Trade(double amount, String currency1, String currency2, double rate, double value, String tradeDate) {
        this.amount = amount;
        this.currency1 = currency1;
        this.currency2 = currency2;
        this.rate = rate;
        this.value = value;
        this.tradeDate = tradeDate;
    }

    public Trade(){
    }

    public void setCurrency1() {
        Scanner scan = new Scanner(System.in);
        this.currency1 = scan.nextLine().toUpperCase();
    }

    public String getCurrency1() {
        return currency1;
    }

    public void setCurrency2() {
        Scanner scan = new Scanner(System.in);
        this.currency2 = scan.nextLine().toUpperCase();
    }

    public String getCurrency2() {
        return currency2;
    }

    public void setAmount() {
        Scanner scan = new Scanner(System.in);
        this.amount = Double.parseDouble(scan.nextLine());
    }

    public double getAmount() {
        return amount;
    }

    public void setRate(String currency1, String currency2) throws IOException {
        HttpConnection http = new HttpConnection();
        this.rate = http.getRate(currency1, currency2);
    }

    public double getRate() {
        return rate;
    }

    public void setValue(double rate, double amount) {
        this.value = rate * amount;
    }

    public double getValue() {
        return value;
    }

    public void setTradeDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.tradeDate = dateFormat.format(date);
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public String toString(){
        return "Amount: " + amount + ", Currency1: " + currency1 + ", Currency2: " + currency2 +
                ", Rate: " + rate + ", Value: " + value + ", TradeDate: " + tradeDate;
    }
}
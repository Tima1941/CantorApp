package model;

import utils.HttpConnection;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Trade extends BaseEntity {
	protected String currency1;
	protected String currency2;
	protected LocalDateTime tradeDate;
	protected double amount1;
	protected double rate;

	public Trade(String currency1, String currency2, LocalDateTime tradeDate, double amount1, double rate) {
		super();
		this.currency1 = currency1;
		this.currency2 = currency2;
		this.tradeDate = tradeDate;
		this.amount1 = amount1;

	}

	public Trade(UUID id, LocalDateTime createdDate, String currency1, String currency2, LocalDateTime tradeDate,
			double amount1, double rate) {
		super(id, createdDate);
		this.currency1 = currency1;
		this.currency2 = currency2;
		this.tradeDate = tradeDate;
		this.amount1 = amount1;
		this.rate = rate;
	}

	/**
	 * @return the currency1
	 */
	public String getCurrency1() {
		return currency1;
	}

	/**
	 * @param currency1 the currency1 to set
	 */
	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}

	/**
	 * @return the currency2
	 */
	public String getCurrency2() {
		return currency2;
	}

	/**
	 * @param currency2 the currency2 to set
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}

	/**
	 * @return the tradeDate
	 */
	public LocalDateTime getTradeDate() {
		return tradeDate;
	}

	/**
	 * @param tradeDate the tradeDate to set
	 */
	public void setTradeDate(LocalDateTime tradeDate) {
		this.tradeDate = tradeDate;
	}

	/**
	 * @return the amount1
	 */
	public double getAmount1() {
		return amount1;
	}

	/**
	 * @param amount1 the amount1 to set
	 */
	public void setAmount1(double amount1) {
		this.amount1 = amount1;
	}

	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}

	/**
	 * @return the amount2
	 */
	public double getAmount2() {
		return this.amount1 * this.rate;
	}

	/*
	 * public Trade(double amount, String currency1, String currency2, double rate,
	 * double value, String tradeDate) { this.amount = amount; this.currency1 =
	 * currency1; this.currency2 = currency2; this.rate = rate; this.value = value;
	 * this.tradeDate = tradeDate; }
	 * 
	 * public Trade(){ }
	 * 
	 * public void setCurrency1() { Scanner scan = new Scanner(System.in);
	 * this.currency1 = scan.nextLine().toUpperCase(); }
	 * 
	 * public String getCurrency1() { return currency1; }
	 * 
	 * public void setCurrency2() { Scanner scan = new Scanner(System.in);
	 * this.currency2 = scan.nextLine().toUpperCase(); }
	 * 
	 * public String getCurrency2() { return currency2; }
	 * 
	 * public void setAmount() { Scanner scan = new Scanner(System.in); this.amount
	 * = Double.parseDouble(scan.nextLine()); }
	 * 
	 * public double getAmount() { return amount; }
	 * 
	 * public void setRate(String currency1, String currency2) throws IOException {
	 * HttpConnection http = new HttpConnection(); this.rate =
	 * http.getRate(currency1, currency2); }
	 * 
	 * public double getRate() { return rate; }
	 * 
	 * public void setValue(double rate, double amount) { this.value = rate *
	 * amount; }
	 * 
	 * public double getValue() { return value; }
	 * 
	 * public void setTradeDate() { DateFormat dateFormat = new
	 * SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); Date date = new Date();
	 * this.tradeDate = dateFormat.format(date); }
	 * 
	 * public String getTradeDate() { return tradeDate; }
	 * 
	 * public String toString(){ return "Amount: " + amount + ", Currency1: " +
	 * currency1 + ", Currency2: " + currency2 + ", Rate: " + rate + ", Value: " +
	 * value + ", TradeDate: " + tradeDate; }
	 */
}
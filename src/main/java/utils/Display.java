package utils;

import model.Client;
import model.Trade;
import model.User;
import services.ClientService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Display {
	protected ClientService clientServices;

	public Display(ClientService clientServices) {
		super();
		this.clientServices = clientServices;
	}

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
		String login;
		String name;
		String surname;
		String emailAddress;
		String password;
		
		displayTitle("Register User");

		login = inputValue("Enter User Login: ");

		name = inputValue("Enter User Name: ");

		surname = inputValue("Enter User Surname: ");

		password = inputValue("Enter User Password: ");

		emailAddress = inputValue("Enter Email Address: ");

		Client client = clientServices.createClient(login, name, surname, emailAddress, password);

		System.out.print("\n*********** Created User ***********\n");
		System.out.print(client.toString());
		System.out.print("\n************************************\n");
	}

	private void displayTitle(String title) {
		System.out.print("\n************************************\n");
		System.out.print("\t\t\t" + title);
		System.out.print("\n************************************\n");

	}

	private String inputValue(String label) {
		String value;

		System.out.print(label);
		Scanner scan = new Scanner(System.in);
		value = scan.nextLine();

		return value;

	}

}
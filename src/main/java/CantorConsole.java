import utils.Display;
import utils.ConfigurationLoader;
import java.io.IOException;
import java.util.Scanner;

import repository.ClientRepository;
import services.ClientService;
import services.UserService;

public class CantorConsole {
	public static ConfigurationLoader configurationLoader = new ConfigurationLoader();

	public static void main(String[] args) throws IOException {
		configurationLoader.loadProperties();
		int value;
		String dataPath = System.getProperty("data.path");

		ClientService clientService = new ClientService(new ClientRepository(dataPath));
		UserService userService = new UserService(new ClientRepository(dataPath));

		Scanner scanner = new Scanner(System.in);
		Display display = new Display(clientService, userService);

		do {
			display.displayMainMenu();
			System.out.print("Enter value: \n");

			value = scanner.nextInt();

			switch (value) {
			case 1:
				display.displayUserRegister();
				break;
			case 2:
				display.displayUserLogin();
				if (display.getCurrentUser() != null) {
					do {
						display.displayClientMenu();
						System.out.printf("Enter value: \n");
						value = scanner.nextInt();

						switch (value) {
						case 1:
							display.diplayCurrentClientTrades();
							break;
						case 2:
							display.displayAddTrade();
							break;
						
						}
					} while (value != 0);
				}
				break;

			case 5:
				display.displayAllClients();
				break;

			}
		} while (value != 0);
		scanner.close();
	}
}
import utils.Display;
import utils.ConfigurationLoader;
import java.io.IOException;
import java.util.Scanner;

import repository.ClientRepository;
import services.ClientService;

public class CantorConsole {
	public static ConfigurationLoader configurationLoader = new ConfigurationLoader();

	public static void main(String[] args) throws IOException {
		configurationLoader.loadProperties();
		int value;
		String dataPath = System.getProperty("data.path");

		ClientService clientService = new ClientService(new ClientRepository(dataPath));
		Scanner scanner = new Scanner(System.in);
		Display display = new Display(clientService);

		do {
			display.displayMainMenu();
			System.out.print("Enter value: \n");

			value = scanner.nextInt();

			switch (value) {
			case 1:
				display.displayUserRegister();
				break;
			
			}
		} while (value != 0);
		scanner.close();
	}
}
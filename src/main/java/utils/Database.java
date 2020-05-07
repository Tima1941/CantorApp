package utils;

import model.User;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Database {

    public void saveUserInDatabase(User user) throws IOException {
        FileWriter fileWriter = new FileWriter(System.getProperty("users.database"), true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(user.userId + ", " + user.login + ", " + user.name + ", " + user.surname + ", "
                            + user.password + ", " + user.emailAddress + ", " + user.creationDate + "\n");
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

    public boolean loginChecker(String inputLogin, String inputPass) {
        Path pathToFile = Paths.get(System.getProperty("users.database"));
        boolean login = false;

        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(", ");
                User user = createUser(attributes);

                if (user.login.equals(inputLogin) && user.password.equals(inputPass)) {
                    login = true;
                    break;
                }

                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
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

    public void userListSortedByUserId() {
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

    public void userListSortedByUserName() {
        List<User> userName = readUserDatabaseFile();
        userName.sort( Comparator.comparing(user -> user.name) );

        int k = 1;
        for (int i = 0; i < userName.size(); i++) {
            System.out.println("ID: " + k + ", " + userName.get(i));
            k++;
        }
    }
}

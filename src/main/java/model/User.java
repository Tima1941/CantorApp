package model;

import java.util.Random;
import java.util.Scanner;

//ciekawy projekt do podpatrzenia https://www.journaldev.com/2315/java-json-example
//listy artyhul https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
//stronka jak odczytac plik https://www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html

public class User {
    public String login;
    public String name;
    public String surname;
    public String emailAddress;
    public String password;
    public int userId;
    //todo add user date creation
    //todo add use function (cantor worker/boss/client)

    public User(String login, String name, String surname, String password, String emailAddress, int userId) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.emailAddress = emailAddress;
        this.userId = userId;
    }

    public User() {
        this.login = getUserLogin();
        this.name = getUserName();
        this.surname = getUserSurname();
        this.password = getUserPassword();
        this.emailAddress = getEmailAddress();
        this.userId = getUserId();
    }

    public void setUserLogin () {
        Scanner scan = new Scanner(System.in);
        this.login = scan.nextLine();
    }

    public String getUserLogin(){
        return login;
    }

    public void setUserName () {
        Scanner scan = new Scanner(System.in);
        this.name = scan.nextLine();
    }

    public String getUserName(){
        return name;
    }

    public void setUserSurname () {
        Scanner scan = new Scanner(System.in);
        this.surname = scan.nextLine();
    }

    public String getUserSurname(){
        return surname;
    }

    public void setUserPassword () {
        Scanner scan = new Scanner(System.in);
        this.password = scan.nextLine();
    }

    public String getUserPassword(){
        return password;
    }

    public void setEmailAddress (){
        Scanner scan = new Scanner(System.in);
        this.emailAddress = scan.nextLine();
    }

    public String getEmailAddress () {
        return emailAddress;
    }

    public void setUserId (){
        Random rand = new Random();
        int userIdGenerated = rand.nextInt(1000);
        this.userId = userIdGenerated;
    }

    public int getUserId (){
        return userId;
    }

    public String toString(){
        return "Login: " + login + ", Name: " + name + ", Surname: " + surname + ", Password: " + password + ", Email Address: " + emailAddress + ", User ID: " + userId;
    }
}
//todo add password function / improve user id generation / make class bigger
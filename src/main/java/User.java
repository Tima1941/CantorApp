package com.company;

import java.util.Scanner;

//ciekawy projekt do podpatrzenia https://www.journaldev.com/2315/java-json-example

public class User {
    String name;
    String surname;
    String login;
    String emailAddress;
    String userId;

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

    public void setEmailAddress (){
        Scanner scan = new Scanner(System.in);
        this.emailAddress = scan.nextLine();
    }

    public String getEmailAddress () {
        return emailAddress;
    }

    public void setUserId (){
        String userIdGenerated = getUserName() + getUserSurname();
        this.userId = userIdGenerated;
    }

    public String getUserId (){
        return userId;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n********** User Details **********\n");
        sb.append("Login: " + getUserLogin() + "\n");
        sb.append("Name: " + getUserName() + "\n");
        sb.append("Surname: " + getUserSurname() + "\n");
        sb.append("Email Address: " + getEmailAddress() + "\n");
        sb.append("User ID: " + getUserId() + "\n");
        sb.append("*****************************\n");
        return sb.toString();
    }
}
//todo add password function / improve user id generation / make class bigger
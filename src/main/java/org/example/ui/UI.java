package org.example.ui;

import org.example.Main;
import org.example.atm.ATM;
import org.example.atm.ATMService;
import org.example.card.Card;
import org.example.card.CardService;
import org.example.user.User;
import org.example.user.UserService;

import java.util.List;
import java.util.UUID;

public class UI {
    private final UserService userService = UserService.getInstance();
    private final ATMService atmService = ATMService.getInstance();
    private final CardService cardService = CardService.getInstance();


    {
        ATM atm = new ATM(UUID.randomUUID(), "Agro", 1);
        atmService.add(atm);
        ATM atm2 = new ATM(UUID.randomUUID(), "Kapital", 1);
        atmService.add(atm2);
    }

    public void start() {
        boolean isExited = false;

        while (!isExited) {
            System.out.print("""
                    1. Register
                    2. Sign in
                    0. Exit
                    >>> \s""");
            int command = Main.scannerInt.nextInt();
            switch (command) {
                case 1 -> register();
                case 2 -> signIn();
                case 0 -> isExited = true;
                default -> System.out.println("You've entered wrong command!");
            }

        }
    }

    public void register() {
        System.out.print("Enter your name: ");
        String name = Main.scannerStr.nextLine();
        System.out.print("Enter your surname: ");
        String surname = Main.scannerStr.nextLine();
        System.out.print("Create your username: ");
        String username = Main.scannerStr.nextLine();
        System.out.print("Create your password: ");
        String password = Main.scannerStr.nextLine();
        User user = new User(UUID.randomUUID(), name, surname, username, password, true);
        user = userService.add(user);
        if (user == null) {
            System.out.println("This username has been already used!");
        } else {
            System.out.println("You've registered successfully!");
        }
    }

    public void signIn() {
        System.out.print("Enter your username: ");
        String username = Main.scannerStr.nextLine();
        System.out.print("Enter your password: ");
        String password = Main.scannerStr.nextLine();
        User user = userService.signIn(username, password);
        if (user == null) {
            System.out.println("Username or password is wrong! Try again");
        } else {
            cardMenu(user);
        }
    }

    private void ATMMenu(User user) {
        List<ATM> all = atmService.getAll();
        for (int i = 0; i < all.size(); i++) {
            System.out.println(i + ". " + all.get(i).getName());
        }
        System.out.print("Choose ATM: ");
        int index = Main.scannerInt.nextInt();
        if (index >= 0 && index < all.size()) {
            ATM atm = all.get(index);
            System.out.println("You've chosen " + atm.getName());
            operationMenu(user);
        }
    }

    private void operationMenu(User user) {
        boolean isExited = false;
        while (!isExited) {
            System.out.print("""
                    1. Balance
                    2. Top up your balance
                    3. Transfer money
                    0. Exit
                    >>> \s""");
            int command = Main.scannerInt.nextInt();
            switch (command) {
                case 1:
                    balance(user);
                    break;
                case 2:
                    topUpBalance(user);
                    break;
                case 3:
                    transferMoney(user);
                    break;
                case 0:
                    isExited = true;
                    break;
                default:
                    System.out.println("You've entered wrong command!");
            }

        }
    }

    private void transferMoney(User user) {

    }

    private void topUpBalance(User user) {

    }

    private String balance(User user) {
        return "Your balance: ";
    }


    private void cardMenu(User user) {
        boolean isExited = false;
        while (!isExited) {
            System.out.print("""
                    1. Add card
                    2. My cards
                    0. Exit
                    >>> \s""");
            int command = Main.scannerInt.nextInt();
            switch (command) {
                case 1 -> addCard(user);
                case 2 -> myCards(user);
                case 0 -> isExited = true;
                default -> System.out.println("You've entered wrong command!");
            }
        }
    }

    private void myCards(User user) {
        List<Card> cards = cardService.getAll();
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(i + ". " + cards.get(i).getCardNumber());
        }
        System.out.print("Choose your card: ");
        int index = Main.scannerInt.nextInt();
        if (index >= 0 && index < cards.size()) {
            Card card = cards.get(index);
            System.out.println("You've chosen " + card.getCardNumber());
            ATMMenu(user);
        }

    }

    private void addCard(User user) {
        System.out.print("Enter your card number: ");
        String cardNumber = Main.scannerStr.nextLine();
        System.out.print("Enter your balance: ");
        float balance = Main.scannerInt.nextInt();
        System.out.print("Enter your password: ");
        String password = Main.scannerStr.nextLine();
        Card card = new Card(UUID.randomUUID(), cardNumber, balance, password, user.getId(), true);
        card = cardService.add(card);
        if (card == null) {
            System.out.println("This card has been already used");
        } else {
            System.out.println("Card added successfully");
        }
    }
}

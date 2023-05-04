import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        GneralUser generalUser = new GneralUser();
        LoggedInUser loggedUser = new LoggedInUser();
        String data[];
        String user = "General";
        int choice = 0;
        while(user == "General" && choice != 5){
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to Toffee Store");
            System.out.println("1- log in.");
            System.out.println("2- Register.");
            System.out.println("3- View Categories.");
            System.out.println("4- Search for Item.");
            System.out.println("5- Exit.");
            System.out.print("What do you want to do? choose a number (1, 2, 3, 4, or 5): ");
            choice = sc.nextInt();
            if (choice == 1) {
                generalUser.logIn();
                user = "logged";
            } else if (choice == 2) {
                data = generalUser.register();
                loggedUser = new LoggedInUser(data);
                user = "logged";
            } else if (choice == 3) {
                generalUser.viewCategories();
            } else if (choice == 4) {
                generalUser.searchForItem();
            }
            else if(choice == 5){
                return;
            }
        }
        while(choice != 3) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome " + loggedUser.getName());
            System.out.println("1- View Categories.");
            System.out.println("2- Search for Item.");
            System.out.println("3- Exit.");
            System.out.print("What do you want to do? choose a number (1, 2, or 3): ");
            choice = sc.nextInt();
            if (choice == 1) {
                loggedUser.viewCategories();
            } else if (choice == 2) {
                loggedUser.searchForItem();
            } else if (choice == 3) {
                return;
            }
        }
    }
}

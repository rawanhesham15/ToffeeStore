import java.io.*;
import java.util.Scanner;

class GneralUser {
    private static final String FILE_PATH = "users.txt";
   private static final int MAX_USERS = 10;

    public static String[] register() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("^^^^^REGISTER^^^^^");
        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
        System.out.print("Enter your Address: ");
        String address = sc.nextLine();
        System.out.print("Enter your Phone Number: ");
        String phoneNum = sc.nextLine();
        System.out.print("Enter your Email: ");
        String email = sc.nextLine();
        System.out.print("Enter your Password: ");
        String pass = sc.nextLine();

        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter("users.txt", true); //true tells to append data.
            out = new BufferedWriter(fstream);
            out.write("\n");
            out.write(name +",");
            out.write(address + ",");
            out.write(phoneNum + ",");
            out.write(email + ",");
            out.write( pass + ",");
            out.write("Status:Active ");
            out.write("LoyaltyPoints: 0");
        }

        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        finally {
            if(out != null) {
                out.close();
            }
        }
        String data[] = {name,pass, address, phoneNum, email};
        System.out.println("^^^^^Done You Are Now Registered.^^^^^");
        return data;
    }

    public void logIn() {
        String[][] userArray = new String[MAX_USERS][2];
        int numberOfUsers = 0;
  
        // load the login data from the file
        File file = new File(FILE_PATH);
        try (Scanner scanner = new Scanner(file)) {
           while (scanner.hasNextLine() && numberOfUsers < MAX_USERS) {
              String line = scanner.nextLine();
              String[] parts = line.split(",");
              userArray[numberOfUsers][0] = parts[0]; // username
              userArray[numberOfUsers][1] = parts[1]; // password
              numberOfUsers++;
           }
        } catch (FileNotFoundException e) {
           System.out.println("File not found: " + FILE_PATH);
        }
  
        // prompt the user to enter their username and password
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
  
        // search the userArray for a matching username and password
        int index = -1;
        for (int i = 0; i < numberOfUsers; i++) {
           if (userArray[i][0].equals(username) && userArray[i][1].equals(password)) {
              index = i;
              break;
           }
        }
  
        if (index >= 0) {
           System.out.println("Welcome " + userArray[index][0] + "!");
        } else {
           System.out.println("Invalid login.");
        }
    }

    public void viewCategories() {
        System.out.println("^^^^^VIEW CATEGORIES^^^^^");
    }

    public void searchForItem() {
        System.out.println("^^^^^SEARCH FOR ITEM^^^^^");
    }
}
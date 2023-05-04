import java.io.*;
import java.util.Scanner;

class GneralUser {
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
            FileWriter fstream = new FileWriter("C:\\Users\\Dell\\IdeaProjects\\ToffeeStore\\src\\users.txt", true); //true tells to append data.
            out = new BufferedWriter(fstream);
            out.write("\n");
            out.write("Name:" + name + " ");
            out.write("Address:" + address + " ");
            out.write("phoneNumber:" + phoneNum + " ");
            out.write("Email:" + email + " ");
            out.write("password:" + pass + " ");
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
        String data[] = {name, address, phoneNum, email, pass};
        System.out.println("^^^^^Done You Are Now Registered.^^^^^");
        return data;
    }

    public void logIn() {
        System.out.println("^^^^^LOG IN^^^^^");
    }

    public void viewCategories() {
        System.out.println("^^^^^VIEW CATEGORIES^^^^^");
    }

    public void searchForItem() {
        System.out.println("^^^^^SEARCH FOR ITEM^^^^^");
    }
}
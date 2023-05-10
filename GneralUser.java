import java.io.*;
import java.net.ConnectException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GneralUser {
    private static final String FILE_PATH = "users.txt";
    private static final int MAX_USERS = 10;

    // general user may have a store
    public static String[] register() throws IOException {
        boolean nvalid = true  , pvalid = true , evalid = true , phvalid = true;
        // regex part for the data
        final String NAME_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";

        final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

        // alphanumeric and underscore are allowed
        final String USERNAME_REGEX = "^[a-zA-Z0-9_]+$";

        final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REGEX);

        // US phone number with or without dashes
        final String PHONE_REGEX = "^([0]([\\s-./\\\\])?)?(\\(?[0-9]\\d{1}\\)?|[1-9]\\d{2})([\\s-./\\\\])?([0-9]{3}([\\s-./\\\\])?[0-9]{4}|[a-zA-Z0-9]{7}|([0-9]{3}[-][a-zA-Z0-9]{4}))";

        final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

        // local-part + @ + domain part
        final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*" +
                "@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        // 8-16 characters password with at least one digit, one lowercase letter,
        // one uppercase letter, one special character with no whitespaces
        final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";

        final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

        String name = ""  , pass = "" , address = "", phoneNum = "", email = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("\n     ^^^^^REGISTER^^^^^");
        System.out.println("-----------------------------");
        while (nvalid) {
            System.out.print("Enter your Name: ");
            name = sc.nextLine();
            if(NAME_PATTERN.matcher(name).matches())
            {
                nvalid = false;
            }
            else
            {
                System.err.println("Please enter a vaild name");
            }
        }

        while(pvalid)
        {
            System.out.print("Enter your Password: ");
            pass = sc.nextLine();
            if(PASSWORD_PATTERN.matcher(pass).matches())
            {
                pvalid = false;
            }

            else
            {
                System.err.println("please enter a valid password");
            }
        }
        while(phvalid)
        {
            System.out.print("Enter your Phone Number: ");
            phoneNum = sc.nextLine();
            if(PHONE_PATTERN.matcher(phoneNum).matches())
            {
                phvalid = false;
            }

            else
            {
                System.err.println("please enter a valid phone number");
            }
        }
        while(evalid)
        {
            System.out.print("Enter your Email: ");
            email = sc.nextLine();
            if(EMAIL_PATTERN.matcher(email).matches())
            {
                evalid = false;
            }

            else
            {
                System.err.println("please enter a valid email");
            }
        }
        
        System.out.print("Enter your Address: ");
        address = sc.nextLine();

        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter("users.txt", true); // true tells to append data.
            out = new BufferedWriter(fstream);
            out.write(name + ",");
            out.write(pass + ",");
            out.write(phoneNum + ",");
            out.write(email + ",");
            out.write(address + ",");
            out.write("Active,");
            out.write("0");
            out.write("\n");
        }

        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        finally {
            if (out != null) {
                out.close();
            }
        }
        String data[] = { name, pass, address, phoneNum, email };
        System.out.println("\n^^^^^Done You Are Now Registered.^^^^^");
        System.out.println("----------------------------------------------------");

        return data;
    }

    public String[] logIn() {
        System.out.println("\n      ^^^^^LOG IN^^^^^");
        System.out.println("------------------------------");

        String name, pass, email, status, phoneNum, address, points;
        String[][] userArray = new String[MAX_USERS][7];
        int numberOfUsers = 0;

        // load the login data from the file
        File file = new File(FILE_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine() && numberOfUsers < MAX_USERS) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                userArray[numberOfUsers][0] = parts[0]; // username
                userArray[numberOfUsers][1] = parts[1]; // password
                userArray[numberOfUsers][2] = parts[2]; // phoneNum
                userArray[numberOfUsers][3] = parts[3]; // email
                userArray[numberOfUsers][4] = parts[4]; // address
                userArray[numberOfUsers][5] = parts[5]; // status
                userArray[numberOfUsers][6] = parts[6]; // loaylty points
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
        System.out.println("------------------------------");

        // search the userArray for a matching username and password
        for (int i = 0; i < numberOfUsers; i++) {
            if (userArray[i][0].equals(username) && userArray[i][1].equals(password)) {
                name = userArray[i][0];
                pass = userArray[i][1];
                phoneNum = userArray[i][2];
                email = userArray[i][3];
                address = userArray[i][4];
                status = userArray[i][5];
                points = userArray[i][6];
                String data[] = { name, pass, address, phoneNum, email, status, points };
                return data;
            }
        }
        String data[] = { null };
        return data;
    }

    public void viewCategories() {
        System.out.println("^^^^^VIEW CATEGORIES^^^^^");
    }

    public void searchForItem() {
        System.out.println("^^^^^SEARCH FOR ITEM^^^^^");
    }
}
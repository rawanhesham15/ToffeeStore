import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import javax.mail.*;


public class Email {
    static String otp;
    public static void sendOTP(String email) {
        otp = generateOTP();
        // Send the OTP by email
        String to = email;
        String from = "toffeestoreOfficial@gmail.com";
        String host = "smtp.gmail.com";
        String username = "toffeestore.eg@gmail.com";
        String password = "fvymovdgrxmqntcx";


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("OTP Verification.");
            message.setText("Your OTP is: " + otp);

            Transport.send(message);

            System.out.println("OTP sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    // Generate a random OTP, this method is called in sendOTP() method,
    private static String generateOTP() {
        int length = 4;
        String numbers = "0123456789";
        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(numbers.length());
            char digit = numbers.charAt(index);
            sb.append(digit);
        }

        return sb.toString();
    }

    public static String getOTP() {
        return otp;
    }
}

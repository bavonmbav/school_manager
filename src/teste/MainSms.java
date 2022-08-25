
package teste;

//import com.teknikindustries.bulksms.SMS;
//import java.net.MalformedURLException;
//import java.net.URL;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MainSms {


    public static void main(String[] args) throws AddressException{

   Properties properties;
        Session session;
        MimeMessage message;

        properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");//TLS
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("XXXXXXXgmail.com", "xxxxxxx");
            }
        };

        session = Session.getDefaultInstance(properties, auth);

    
        /*
                    internet addresse contient une addresse mail de destinataire
                    il est evident que l'objet internetaddrress soit un tableau a l'initial
                     et a la taille x on instancie un objet nouveau avec un ou plusieur paramettre
                    
        */
        InternetAddress[] recipient = new InternetAddress[1];
        recipient[0] = new InternetAddress("XXXXXXXx");

        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress("xxxxxxxxxxxxx"));
            message.addRecipients(Message.RecipientType.TO, recipient);
            message.setSubject("un eleve a etait enregistrer");
            message.setText("message recu");

            Transport.send(message);
            System.out.println("Email envoyer");
        } catch (Exception e) {
            e.printStackTrace();
        }

       
    }
    
}

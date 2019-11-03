import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PlainTextMessageDemo {
public static void main(String[] args) throws FileNotFoundException, IOException, AddressException, MessagingException {
	Properties properties=new Properties();
	/*properties.load(new FileInputStream
			(new File
					("E:\\Java8\\JavaMaiEmailDemo\\src\\main\\resources\\mail.properties")));
					*/
	properties.load(PlainTextMessageDemo.class.getResourceAsStream("mail.properties"));
	System.out.println(properties);
	
	/*Session session=Session.getInstance(properties,new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("", "");
		    }
	});*/
	
	Session session=Session.getInstance(properties,new CustomAuthenticator("javaemailapitesting@gmail.com", "Javamail123"));
	
	MimeMessage message=new MimeMessage(session);
	message.setFrom(new InternetAddress("javaemailapitesting@gmail.com"));
	message.addRecipient(Message.RecipientType.TO, new InternetAddress("jbmca2011@gmail.com"));
	message.addRecipient(Message.RecipientType.BCC, new InternetAddress("javatech.tharun@gmail.com"));

	message.setSubject("Mail from sreenutech");
	message.setText("No Class tommorow");
	
	Transport.send(message);
	
	System.out.println("Mail sent successfully");
}
}

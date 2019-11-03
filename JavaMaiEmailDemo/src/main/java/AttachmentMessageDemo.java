import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class AttachmentMessageDemo {
	public static void main(String[] args)
			throws FileNotFoundException, IOException, AddressException, MessagingException {
		Properties properties = new Properties();
		/*
		 * properties.load(new FileInputStream (new File
		 * ("E:\\Java8\\JavaMaiEmailDemo\\src\\main\\resources\\mail.properties")));
		 */
		properties.load(AttachmentMessageDemo.class.getResourceAsStream("mail.properties"));
		System.out.println(properties);

		/*
		 * Session session=Session.getInstance(properties,new Authenticator() {
		 * protected PasswordAuthentication getPasswordAuthentication() { return new
		 * PasswordAuthentication("", ""); } });
		 */

		Session session = Session.getInstance(properties,
				new CustomAuthenticator("javaemailapitesting@gmail.com", "Javamail123"));

		MimeMessage message = new MimeMessage(session);

		message.setFrom(new InternetAddress("javaemailapitesting@gmail.com"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("jbmca2011@gmail.com"));
		message.addRecipient(Message.RecipientType.BCC, new InternetAddress("javatech.tharun@gmail.com"));

		Multipart multipart = new MimeMultipart();

		BodyPart bodyPart = MailUtils.createHTMLText("<h1>Please refer attachment</h1>");
		multipart.addBodyPart(bodyPart);

		BodyPart bodyPart1 = MailUtils.createText("It contains materials");
		multipart.addBodyPart(bodyPart1);

		BodyPart attchmentBody=MailUtils.createAttachment("AopMaterial.docx","C:\\Users\\Hello\\Desktop\\AOP.docx");
		multipart.addBodyPart(attchmentBody);

		BodyPart pdfattechment=MailUtils.createAttachment("Pdfcontent.pdf","C:\\Users\\Hello\\Desktop\\Yerraguntala.pdf");
		multipart.addBodyPart(pdfattechment);
		
		message.setContent(multipart);

		Transport.send(message);

		System.out.println("Mail sent successfully");
	}


}

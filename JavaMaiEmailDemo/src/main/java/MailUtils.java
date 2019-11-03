import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

public class MailUtils {
	public static BodyPart createAttachment(String filename, String filelocation) throws MessagingException {
		BodyPart attchmentBody = new MimeBodyPart();
		DataSource dataSource = new FileDataSource(filelocation);
		attchmentBody.setDataHandler(new DataHandler(dataSource));
		attchmentBody.setFileName(filename);
		return attchmentBody;

	}
	
	public static BodyPart createText(String message) throws MessagingException {
		BodyPart attchmentBody = new MimeBodyPart();
		attchmentBody.setText(message);
		return attchmentBody;

	}
	
	public static BodyPart createHTMLText(String message) throws MessagingException {
		BodyPart attchmentBody = new MimeBodyPart();
		attchmentBody.setContent(message,"text/html");
		return attchmentBody;

	}
}

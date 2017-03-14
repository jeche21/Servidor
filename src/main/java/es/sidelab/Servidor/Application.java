package es.sidelab.Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Application {
	
	public static void main( String[] args ) {
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("salewebdad@gmail.com","JesusAlvaroCesar");
				}
		});
		while(true){
			try {
			
				ServerSocket serverSocket = new ServerSocket (5555);
			
				Socket socket = serverSocket.accept();
				BufferedReader leerCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String linea = leerCliente.readLine();
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("salewebdad@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(linea));
				message.setSubject("Confirmacion SaleWeb");
				message.setText("Gracias por comprar en SaleWeb");

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
}

package es.sidelab.Servidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("salewebEmail")
public class SaleWebEmailApi {
	
	@Autowired
	private MailSender salewebmail;
 
	public void saleweb_enviar(String emisor, String destinatario, String asunto, String cuerpo) {
 
		SimpleMailMessage salewebMensaje = new SimpleMailMessage();
		salewebMensaje.setFrom(emisor);
		salewebMensaje.setTo(destinatario);
		salewebMensaje.setSubject(asunto);
		salewebMensaje.setText(cuerpo);
		salewebmail.send(salewebMensaje);
	}

}

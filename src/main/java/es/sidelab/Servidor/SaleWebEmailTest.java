package es.sidelab.Servidor;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SaleWebEmailTest {
	
	@SuppressWarnings("resource")
	public static void main(String args[]) {
 
		String configuracion = "saleweb-bean.xml";
		ConfigurableApplicationContext contexto = new ClassPathXmlApplicationContext(configuracion);
 
		SaleWebEmailApi salewebEmailApi = (SaleWebEmailApi) contexto.getBean("salewebEmail");
		String emisor = "salewebdad@gmail.com";
		String destinatario = "agalanez5@gmail.com";	
		String asunto = "Comfirmacion de compra.";
		String cuerpo = "Querido usuario, su compra ha sido confirmada. A continuacion se muestran los detalles"
				+ " de su pedido. Muchas gracias por confiar en SaleWeb. Hasta su proxima compra!";
		
		salewebEmailApi.saleweb_enviar(emisor, destinatario, asunto, cuerpo);
	}

}

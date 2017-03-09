package es.sidelab.SaleWeb;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.ServerSocket;
	import java.net.Socket;

	public class Server {
		
		public static void main(String[] args) {
			
			try {
				
				ServerSocket serverSocket = new ServerSocket(5555);
				
				Socket socket = serverSocket.accept();
				BufferedReader leerCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter escribirCliente = new PrintWriter(socket.getOutputStream());
				
				while (true){
					String linea = leerCliente.readLine();
					escribirCliente.println(linea);
					escribirCliente.flush();
				}
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}

}

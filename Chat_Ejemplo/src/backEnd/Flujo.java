package backEnd;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Enumeration;

public class Flujo extends Thread{
	Socket nsfd;
	DataInputStream flujoLectura;
	DataOutputStream flujoEscritura;


	public Flujo(Socket nsfd) {
		super();
		this.nsfd = nsfd;

		try {
			flujoLectura = new DataInputStream(new BufferedInputStream(nsfd.getInputStream()));
			flujoEscritura = new DataOutputStream(new BufferedOutputStream(nsfd.getOutputStream()));

		} catch (IOException ioe) {
			System.out.println("IOException(Flujo: "+ioe);
		}
	}

	public void run() {

		broadcast(nsfd.getInetAddress()+"> se ha conectado");
		Servidor.usuarios.add((Object) this);

		while(true) {
			try {
				String linea = flujoLectura.readUTF();
				if (!linea.equals("")) {
					linea = nsfd.getInetAddress() + "> "+ linea;
					broadcast(linea);

				}

			} catch (IOException ioe) {
				Servidor.usuarios.removeElement(this);
				broadcast(nsfd.getInetAddress()+"> se ha desconectado");
				break;
			}	
		}	
	}

	public void broadcast(String mensaje) {
		synchronized (Servidor.usuarios) {
			Enumeration e = Servidor.usuarios.elements();
			while (e.hasMoreElements()) {
				Flujo f = (Flujo) e.nextElement();

				try {
					synchronized (f.flujoEscritura ) {
						f.flujoEscritura.writeUTF(mensaje);
						f.flujoEscritura.flush();			
					}		
				} catch (IOException ioe) {
					System.out.println("Error: "+ioe);
				}
			}
		}
	}




}

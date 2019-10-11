package backEnd;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Servidor extends Thread {

	public static Vector usuarios = new Vector();
	private static ServerSocket sfd;

	public static void main(String[] args) {
		sfd = null;
		try {
			sfd = new ServerSocket(7000);

		} catch (IOException ioe) {
			System.out.println("Comunicacion rechazada. "+ioe);
			System.exit(1);
		}

		while (true) {
			try {
				Socket nsfd = sfd.accept();
				System.out.println("Conexion aceptada de: "+nsfd.getInetAddress());
				Flujo flujo = new Flujo(nsfd);
				Thread t = new Thread(flujo);
				t.start();
			} catch (IOException ioe) {
				System.out.println("Error: "+ioe);
			}			
		}
	}
}

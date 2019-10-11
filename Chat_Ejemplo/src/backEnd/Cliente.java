package backEnd;

import java.awt.Event;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente extends Frame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static Socket sfd = null;
	static DataInputStream EntradaSocket;
	static DataOutputStream SalidaSocket;
	
	static TextField salida;
	static TextArea entrada;
	String texto;

	public Cliente() {
		setTitle("CHAT");
		setSize(350, 200);
		salida = new TextField(30);
		salida.addActionListener(this);

		entrada = new TextArea();
		entrada.setEditable(false);

		add("South", salida);
		add("Center", entrada);
		setVisible(true);
	}

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		try {
			sfd = new Socket("127.0.0.1", 7000);
			EntradaSocket = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
			SalidaSocket = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));

		} catch (UnknownHostException uhe) {
			System.out.println("No se puede acceder al servidor.");
			System.exit(1);
		}
		catch (IOException ioe) {
			System.out.println("Comunicacion rechazada.");
			System.exit(1);
		}
		while(true) {
			try {
				String linea = EntradaSocket.readUTF();
				entrada.append(linea+"\n");

			} catch (Exception e) {
				System.exit(1);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		texto = salida.getText();
		salida.setText("");
		try {
			SalidaSocket.writeUTF(texto);
			SalidaSocket.flush();

		} catch (IOException ioe) {
			System.out.println("Error: "+ioe);
		}
	}

	public boolean handleEvent(Event e) {

		if ((e.target == this) && (e.id == Event.WINDOW_DESTROY)) {
			if ( sfd != null) {
				try {
					sfd.close();
				} catch (IOException ioe) {
					System.out.println("Error: "+ioe);
				}
				this.dispose();
			}

		}

		return true;
	}



}

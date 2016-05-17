package framework;

/**
 * @author Romain CHAPEL
 * @author Christophe SANCHEZ
 * @version 1.0
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GestionnaireConnection {

	/**
	 * Constructeur de classe
	 * @param numPort Le numero du port de connexion
	 */
	public GestionnaireConnection(int numPort) {
		try {
			_serverSocket = new ServerSocket(numPort);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permet a un client de se connecter
	 */
	public void initialiserConnection() {
		try {
			_socket = _serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ferme la connexion du cote serveur
	 */
	public void fermerConnection() {
		try {
			_socket.close();
			_serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getter sur _socket
	 * @return attribut _socket
	 */
	public Socket getSocket() {
		return _socket;
	}

	private ServerSocket _serverSocket;
	private Socket _socket;

}

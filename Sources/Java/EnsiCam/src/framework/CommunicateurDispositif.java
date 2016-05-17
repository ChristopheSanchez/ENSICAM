package framework;

/**
 * @author Romain CHAPEL
 * @author Christophe SANCHEZ
 * @version 1.0
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 
 * @author chapel
 *
 */
public abstract class CommunicateurDispositif implements Runnable {

	/**
	 * Constructeur de classe
	 * @param s Socket associee a la connexion
	 * @param op Operateur traitant les donnee
	 */
	public CommunicateurDispositif(Socket s, Operateur op) {
		try {
			_dout = new DataOutputStream(s.getOutputStream());
			_din = new DataInputStream(s.getInputStream());
			_operateur = op;
			_actif = true;
			_client = false;
			new Thread(this).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getter sur _actif
	 * @return attribut _actif
	 */
	public boolean getActif() {
		return _actif;
	}

	/**
	 * Getter sur _din
	 * @return attribut _din
	 */
	public DataInputStream getInput() {
		return _din;
	}

	/**
	 * Getter sur _dout
	 * @return attribut _dout
	 */
	public DataOutputStream getOutput() {
		return _dout;
	}

	/**
	 * Permet de stopper le thread
	 */
	public void stopperCommunicateur() {
		_actif = false;
	}

	/**
	 * Getter sur _operateur
	 * @return attribut _operateur
	 */
	public Operateur getOperateur() {
		return _operateur;
	}

	/**
	 * Setter sur _client
	 * Met l'attribut _client a true
	 */
	public void setClient() {
		_client = true;
	}

	/**
	 * Getter sur _client
	 * @return attribut _client
	 */
	public boolean getClient() {
		return _client;
	}

	/**
	 * Methode abstraite du thread
	 */
	abstract public void run();

	private boolean _actif;
	private DataOutputStream _dout;
	private DataInputStream _din;
	private Operateur _operateur;
	private boolean _client;

}

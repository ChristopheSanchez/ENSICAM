package serveur;

/**
 * @author Romain CHAPEL
 * @author Christophe SANCHEZ
 * @version 1.0
 */


import java.io.IOException;
import java.net.Socket;

import framework.CommunicateurDispositif;
import framework.Operateur;


public class CameraCommunicateurDispositif extends CommunicateurDispositif {

	/**
	 * Constructeur de classe
	 * @param s socket associee a la connexion
	 * @param op operateur associe au serveur
	 */
	public CameraCommunicateurDispositif(Socket s, Operateur op) {
		super(s, op);
	}

	/**
	 * Methode contenant les instruction du thread
	 * Recupere les donnees emise par un client
	 */
	public void run() {
		byte taille[] = new byte[8];
		byte donnee[];
		byte tmp;
		String tailleString;
		int tailleInt;
		while (getActif()) {
			if (getClient()) {
				try {
					getInput().read(taille, 0, 8);
					tailleString = new String(taille);
					tailleInt = Integer.parseInt(tailleString);
					donnee = new byte[tailleInt];
					for (int i = 0; i < tailleInt; i++) {
						tmp = getInput().readByte();
						donnee[i] = tmp;
					}
					((CameraOperateur)getOperateur()).getCacheTabBytes().setTab(donnee);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}

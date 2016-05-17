package framework;

/**
 * @author Romain CHAPEL
 * @author Christophe SANCHEZ
 * @version 1.0
 */


import framework.ServeurDispositif;


public class Serveur {

	/**
	 * Constructeur de classe
	 * @param nbDispositifs nombre de dispositifs utilisé ( caméra, NFC ...)
	 */
	public Serveur(int nbDispositifs) {
		_serveurDispositifs = new ServeurDispositif[nbDispositifs];
	}

	/**
	 * Getter sur _serveurDispositifs
	 * @return attribut _serveurDispositifs
	 */
	public ServeurDispositif[] getDispositif() {
		return _serveurDispositifs;
	}

	/**
	 * Setter sur _serveurDispositifs
	 * @param ind indice du dispositif a affecter
	 * @param d le dispositif a affecter
	 */
	public void setDispositif(int ind, ServeurDispositif d) {
		_serveurDispositifs[ind] = d;
	}

	private ServeurDispositif _serveurDispositifs[];

}

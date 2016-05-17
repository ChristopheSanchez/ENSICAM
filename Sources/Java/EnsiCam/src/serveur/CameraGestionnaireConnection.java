package serveur;

/**
 * @author Romain CHAPEL
 * @author Christophe SANCHEZ
 * @version 1.0
 */


import framework.GestionnaireConnection;



public class CameraGestionnaireConnection extends GestionnaireConnection {

	/**
	 * Constructeur de classe
	 * @param numPort numero de port ou la connexion sera cree
	 */
	public CameraGestionnaireConnection(int numPort) {
		super(numPort);
	}

}

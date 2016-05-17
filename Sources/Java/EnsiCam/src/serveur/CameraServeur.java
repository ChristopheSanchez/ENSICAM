package serveur;

/**
 * @author Romain CHAPEL
 * @author Christophe SANCHEZ
 * @version 1.0
 */


import framework.GestionnaireConnection;
import framework.ServeurDispositif;


public class CameraServeur extends ServeurDispositif {

	/**
	 * Constructeur de classe
	 */
	public CameraServeur() {
		super();
		setOperateur(new CameraOperateur());

		setGestionnaireDispositif(new GestionnaireConnection(6500));
		setGestionnaireAndroid(new GestionnaireConnection(6501));

		getGestionnaireDispositif().initialiserConnection();

		setCommunicateurDispositif((new CameraCommunicateurDispositif(
				getGestionnaireDispositif().getSocket(), getOperateur())));
		getComunicateurDispositif().setClient();

		getGestionnaireAndroid().initialiserConnection();
		
		setCommunicateurAndroid((new CameraCommunicateurAndroid(
				getGestionnaireAndroid().getSocket(), getOperateur())));
		getComunicateurAndroid().setClient();
	}

}

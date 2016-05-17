package framework;

/**
 * @author Romain CHAPEL
 * @author Christophe SANCHEZ
 * @version 1.0
 */


import framework.CommunicateurDispositif;
import framework.GestionnaireConnection;
import framework.Operateur;

public class ServeurDispositif {

	/**
	 * Constructeur de classe
	 */
	public ServeurDispositif() {

	}

	/**
	 * Getter sur _gestionnaireDispositif
	 * @return attribut _gestionnaireDispositif
	 */
	public GestionnaireConnection getGestionnaireDispositif() {
		return _gestionnaireDispositif;
	}

	public void setGestionnaireDispositif(GestionnaireConnection g) {
		_gestionnaireDispositif = g;
	}

	/**
	 * Getter sur _gestionnaireAndroid
	 * @return attribut _gestionnaireAndroid
	 */
	public GestionnaireConnection getGestionnaireAndroid() {
		return _gestionnaireAndroid;
	}

	/**
	 * Setter sur _gestionnaireAndroid
	 * @param g le gestionnaire a affecter
	 */
	public void setGestionnaireAndroid(GestionnaireConnection g) {
		_gestionnaireAndroid = g;
	}

	/**
	 * Setter sur _gestionnaireAndroid
	 * @param c le gestionnaire a affecter
	 */
	public void setCommunicateurDispositif(CommunicateurDispositif c) {
		_communicateurDispositif = c;
	}

	/**
	 * Getter sur _communicateurDispositif
	 * @return attribut _communicateurDispositif
	 */
	public CommunicateurDispositif getComunicateurDispositif() {
		return _communicateurDispositif;
	}

	/**
	 * Setter sur _communicateurAndroid
	 * @param c le communicateur a affecter
	 */
	public void setCommunicateurAndroid(CommunicateurDispositif c) {
		_communicateurAndroid = c;
	}
	
	/**
	 * Getter sur _communicateurAndroid
	 * @return attribut _communicateurAndroid
	 */
	public CommunicateurDispositif getComunicateurAndroid() {
		return _communicateurAndroid;
	}

	/**
	 * Getter sur _operateur
	 * @return attribut _operateur
	 */
	public Operateur getOperateur() {
		return _operateur;
	}

	/**
	 * Setter sur _operateur
	 * @param o l'operateur a affecter
	 */
	public void setOperateur(Operateur o) {
		_operateur = o;
	}

	private GestionnaireConnection _gestionnaireDispositif;
	private CommunicateurDispositif _communicateurDispositif;
	private GestionnaireConnection _gestionnaireAndroid;
	private CommunicateurDispositif _communicateurAndroid;
	private Operateur _operateur;

}

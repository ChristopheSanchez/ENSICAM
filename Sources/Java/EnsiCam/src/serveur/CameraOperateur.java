package serveur;

/**
 * @author Romain CHAPEL
 * @author Christophe SANCHEZ
 * @version 1.0
 */


import framework.Operateur;


public class CameraOperateur extends Operateur {

	/**
	 * Constructeur de classe
	 */
	public CameraOperateur() {
		super();
		_cacheBytes = new CacheTabBytes();
		_imageRedimensionnee = new CacheTabBytes();
		_redimensionneur = new Redimensionneur(_cacheBytes,
				_imageRedimensionnee);
	}

	/**
	 * Getter sur _cacheBytes
	 * @return attribut _cacheBytes
	 */
	public CacheTabBytes getCacheTabBytes() {
		return _cacheBytes;
	}
	
	/**
	 * Getter sur _imageRedimensionnee
	 * @return attribut _imageRedimensionnee
	 */
	public CacheTabBytes getRedimensionnee(){
		return _imageRedimensionnee;
	}

	private CacheTabBytes _cacheBytes;
	@SuppressWarnings("unused")
	private Redimensionneur _redimensionneur;
	private CacheTabBytes _imageRedimensionnee;

}

package serveur;

/**
 * @author Romain CHAPEL
 * @author Christophe SANCHEZ
 * @version 1.0
 */


public class CacheTabBytes {

	/**
	 * Constructeur de classe
	 */
	public CacheTabBytes() {
		_vide = true;
	}

	/**
	 * Setter sur _tabBytes
	 * @param t le tableau a affecter
	 */
	synchronized public void setTab(byte[] t) {
		if (!_vide) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		_tabBytes = t;
		_vide = false;
		notify();
	}

	/**
	 * Getter sur _tabBytes
	 * @return attribut _tabBytes
	 */
	synchronized byte[] getTab() {
		if (_vide) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		_vide = true;
		notify();
		return _tabBytes;
	}

	private byte _tabBytes[];
	private boolean _vide;

}

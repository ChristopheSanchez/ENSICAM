package serveur;

/**
 * @author Romain CHAPEL
 * @author Christophe SANCHEZ
 * @version 1.0
 */


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mortennobel.imagescaling.experimental.ImprovedMultistepRescaleOp;


public class Redimensionneur implements Runnable {

	/**
	 * Constructeur de classe
	 * @param c le cache contenant l'image a redimensionnee
	 * @param cr le cache contennat l'image redimensionnee
	 */
	public Redimensionneur(CacheTabBytes c, CacheTabBytes cr) {
		_tabOfByte = c;
		_imageRedimensionne = cr;
		_actif = true;
		new Thread(this).start();
	}

	/**
	 * Instruction de redimension executees par le thread
	 */
	public void run() {
		while (_actif) {
			try {
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(
						_tabOfByte.getTab()));
				ImprovedMultistepRescaleOp resampleOp = new ImprovedMultistepRescaleOp(
						640, 480);
				image = resampleOp.filter(image, null);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image, "jpg", baos);
				baos.flush();
				_imageRedimensionne.setTab(baos.toByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private CacheTabBytes _tabOfByte;
	private CacheTabBytes _imageRedimensionne;
	private boolean _actif;

}

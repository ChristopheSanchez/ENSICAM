package serveur;

/**
 * @author Romain CHAPEL
 * @author Christophe SANCHEZ
 * @version 1.0
 */


import java.io.IOException;
import java.net.Socket;
/*import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;*/

import framework.CommunicateurDispositif;
import framework.Operateur;

public class CameraCommunicateurAndroid extends CommunicateurDispositif {

	/**
	 * Constructeur de classe
	 * @param s socket associee a la connexion
	 * @param op operateur associe au serveur
	 */
	public CameraCommunicateurAndroid(Socket s, Operateur op) {
		super(s, op);
	}

	/**
	 * Methode contenant les instruction du thread
	 * Envoie les donnees au client
	 */
	public void run() {
		int k = 0;
		/*RSAPublicKey publicKey = null;
		Cipher cipher = null;
		int keyLen = 0;
		byte b;
		byte res[] = null;
		try {
			cipher = Cipher.getInstance("RSA");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			e1.printStackTrace();
		}
		if (getActif() && getClient()) {
			try {
				keyLen = getInput().readInt();
				byte keyTmp[] = new byte[keyLen];
				for (int i = 0; i < keyLen; i++) {
					keyTmp[i] = getInput().readByte();
				}
				try {
					publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA")
							.generatePublic(new X509EncodedKeySpec(keyTmp));
					try {
						cipher.init(Cipher.ENCRYPT_MODE, publicKey);
					} catch (InvalidKeyException e) {
						e.printStackTrace();
					}
				} catch (InvalidKeySpecException e) {
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		while (getActif()) {
			if (getClient()) {
				byte tab[] = ((CameraOperateur) getOperateur())
						.getRedimensionnee().getTab();
				k++;
				/*int count = 0;
				int nbBlocks = 0;
				byte buffToEnc[] = new byte[117];
				byte buffEnc[] = new byte[128];
				nbBlocks = tab.length / 117;
				res = new byte[nbBlocks * 128];

				for (int j = 0; j < tab.length; j += 116) {
					for (int p = j; p < 116; p++) {
						if (count > tab.length - 1) {
							buffToEnc[p] = 0;
							count++;
						} else {
							buffToEnc[p] = tab[count];
							count++;
						}
					}
					try {
						buffEnc = cipher.doFinal(buffToEnc);
					} catch (IllegalBlockSizeException e) {
						e.printStackTrace();
					} catch (BadPaddingException e) {
						e.printStackTrace();
					}
					for (int p = j; p < 116; p++) {
						res[p + j] = buffEnc[p];
					}
				}*/

				if (k < 10) {
					continue;
				}
				k = 0;
				// System.out.println(res.length);

				try {
					getOutput().writeInt(tab.length);
					for (int i = 0; i < tab.length; i++) {
						getOutput().writeByte(tab[i]);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

package com.example.chris.cam;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by chris on 30/03/15.
 */
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by Christophe Sanchez and Romain Chapel on 29/03/15.
 */
public class CommunicateurAndroid implements Runnable {

    public CommunicateurAndroid(Socket s) {
        try {
            _din = new DataInputStream(s.getInputStream());
            _dout = new DataOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }

    public void run() {
        /*Cipher cipher = null;
        RSAPublicKey publicKey = null;
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            try {
                cipher = Cipher.getInstance("RSA");
                kpg.initialize(1024);
                KeyPair keyPair = kpg.generateKeyPair();
                RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
                publicKey = (RSAPublicKey) keyPair.getPublic();
                try {
                    cipher.init(Cipher.DECRYPT_MODE, privateKey);

                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            byte byteKey[] = publicKey.getEncoded();
            _dout.writeInt(byteKey.length);
            for (int i = 0; i < byteKey.length; i++) {
                _dout.writeByte(byteKey[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte buffEnc[];
        byte buffToDec[] = new byte[128];
        byte buffDec[] = new byte[117];*/
        int length;
        byte tmp;
        while (true) {
            /*byte tab[] = new byte[length];
                int nbBlocks = length/128;
                buffEnc = new byte[128*nbBlocks];
                for (int i=0; i<128*nbBlocks; i++) {
                    buffEnc[i] = _din.readByte();
                }
                for(int i=0; i<nbBlocks; i++) {
                    for(int j=0; j<128; j++) {
                        buffToDec[j] = buffEnc[j+i*128];
                    }
                    try {
                        buffDec = cipher.doFinal(buffToDec);
                    } catch (IllegalBlockSizeException e) {
                        e.printStackTrace();
                    } catch (BadPaddingException e) {
                        e.printStackTrace();
                    }
                    System.out.println(buffDec.length);
                }*/
            try {
                length = _din.readInt();

                byte tab[] = new byte[length];
                for (int i=0; i<length; i++) {
                    tmp = _din.readByte();
                    tab[i]=tmp;
                }
                ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(tab);
                _image = BitmapFactory.decodeStream(arrayInputStream);

                if( _image != null) {
                    _main.rafraichir();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setView( MyView v) {
        _view = v;
    }

    public Bitmap getImage() {
        return _image;
    }

    public void setMain( Bouton1Activity m) {
        _main = m;
    }

    private Bouton1Activity _main;
    private DataInputStream _din;
    private DataOutputStream _dout;
    private Bitmap _image;
    private Canvas _canvas;
    private MyView _view;
}
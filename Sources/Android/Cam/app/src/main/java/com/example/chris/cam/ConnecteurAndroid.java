package com.example.chris.cam;
import com.example.chris.cam.Bouton1Activity;
import com.example.chris.cam.CommunicateurAndroid;
import com.example.chris.cam.MyView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Christophe Sanchez and Romain Chapel on 29/03/15.
 */
public class ConnecteurAndroid implements Runnable{

    public ConnecteurAndroid(String adresse, int numPort, MyView v, Bouton1Activity m) {
        _adresse = adresse;
        _numPort = numPort;
        _view = v;
        _main = m;
        new Thread(this).start();
    }

    public void initialisation() {
        try {
            _socket = new Socket(InetAddress.getByName(_adresse), _numPort);
            _communicateur = new CommunicateurAndroid(_socket);
            _communicateur.setView(_view);
            _view.setCommunicateur(_communicateur);
            _communicateur.setMain(_main);
            _connecte = true;
            setCommuniCateurView(_view);
        } catch (IOException e) {
            _connecte = false;
        }
    }

    public Socket getSocket() {
        return _socket;
    }

    public boolean getConnecte() {
        return _connecte;
    }

    public void fermerSocket() {
        try {
            _socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCommunicateurMain( Bouton1Activity m) {
        _communicateur.setMain(m);
    }

    public void setCommuniCateurView( MyView v) {
        _communicateur.setView(v);
    }

    public void run() {
        initialisation();
    }

    private Bouton1Activity _main;
    private Socket _socket;
    private boolean _connecte;
    private String _adresse;
    private int _numPort;
    private CommunicateurAndroid _communicateur;
    private MyView _view;

}
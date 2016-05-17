package com.example.chris.cam;

/**
 * Created by  Christophe Sanchez and Romain Chapel on 07/04/15.
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends Activity  {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Mettre en mode paysage
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Enlever la barre de titre
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Mettre en plein ecran
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Afficher le contenu
        setContentView(R.layout.accueil);


        final Button connect = (Button) findViewById(R.id.okbutton);

        connect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final EditText log = (EditText) findViewById(R.id.username);
                final EditText mp = (EditText) findViewById(R.id.password);
                final TextView txt = (TextView) findViewById(R.id.textView5);

                String mot = mp.getText().toString();
                String user = log.getText().toString();
                if(!mot.equals("ensicam") || !user.equals("ensicaen")) {
                    txt.setText("Le mot de passe ou le nom d'utilisateur n'est pas correct !!");
                }

                else if (mot.equals("ensicam") && user.equals("ensicaen")){
                    Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                    startActivity(intent);
                }

            }


        });

    }
}
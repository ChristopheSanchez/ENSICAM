package com.example.chris.cam;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.Socket;

/**
 * Created by Christophe Sanchez an Romain Chapel on 30/03/15.
 */
public class AccueilActivity extends Activity {

    private TextView txt;
    private Socket _socket;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Enlever la barre de titre
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Mettre en plein ecran
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Afficher le contenu
        setContentView(R.layout.activity_main);


        final Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, Bouton1Activity.class);
                startActivity(intent);

            }
        });
        final Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, Bouton2Activity.class);
                startActivity(intent);

            }
        });

        /*final Button b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, Bouton3Activity.class);
                startActivity(intent);

            }
        });*/


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}



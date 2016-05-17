package com.example.chris.cam;

import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.*;

import static com.example.chris.cam.R.layout.*;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;


/**
 * Created by Christophe Sanchez and Romain Chapel on 07/01/15.
 */
public class Bouton1Activity extends Activity {


    private MyView _myView;
    private Handler _handler;
    private Timer swipeTimer;
    private ConnecteurAndroid _connecteurAndroid;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Mettre en plein ecran
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        _handler = new Handler();
        _myView = new MyView(this);
        _connecteurAndroid = new ConnecteurAndroid("192.168.1.14",6501, _myView, this);
        //setContentView(R.layout.activity_main);
        _myView.setBackgroundColor(Color.YELLOW);
        setContentView(_myView);

    }



    protected void onStart() {
        super.onStart();
        runOnUiThread(new Runnable() {
            public void run() {
            }
        });
    }

    public void rafraichir() {
        final Runnable Update = new Runnable() {
            public void run() {
                setContentView(_myView);
            }
        };
        runOnUiThread(Update);
    }


}

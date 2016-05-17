package com.example.chris.cam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;

/**
 * Created by  Christophe Sanchez and Romain Chapel on 07/04/15.
 */

public class MyView extends SurfaceView {

    private CommunicateurAndroid _communicateur;

    Paint paint = new Paint();

    public MyView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
    }

    public void setCommunicateur( CommunicateurAndroid c) {
        _communicateur = c;
    }

    public void onDraw(Canvas canvas) {
        if( _communicateur!= null && _communicateur.getImage() != null) {
            canvas.drawBitmap(_communicateur.getImage(), (this.getWidth()-_communicateur.getImage().getWidth())/2,(this.getHeight()-_communicateur.getImage().getHeight())/2, paint);
        }
    }
}

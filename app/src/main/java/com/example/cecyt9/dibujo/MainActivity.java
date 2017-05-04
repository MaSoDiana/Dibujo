package com.example.cecyt9.dibujo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // setContentView(R.layout.main);

            SpecialView miVista = new SpecialView(this);
            setContentView(miVista);
        }



        class SpecialView extends View {
            float x = 50;
            float y = 50;
            String accion = "Accion";
            String texto = "Evento";
            Path path = new Path();

            public SpecialView(Context context) {

                super(context);
            }

            @Override
            protected void onDraw(Canvas canvas) {
                //canvas.drawColor(Color.rgb(255, 255, 150));
                canvas.drawColor(Color.BLACK); // color de fondo
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(5);
                paint.setColor(Color.GREEN);

                if (accion == "down") {
                    path.moveTo(x, y);
                    path.addCircle(x,y,8, Path.Direction.CCW);
                }
                if (accion == "move") {
                    path.addCircle(x,y,8, Path.Direction.CCW);
                }
                canvas.drawPath(path, paint);
                paint.setColor(Color.WHITE);
                paint.setTextSize(30);
                paint.setStrokeWidth(5);
                canvas.drawText(texto, 80, 130, paint); canvas.drawText("x = " + x +
                        "  y = " + y, 100, 50, paint);
                //canvas.drawc
            }

            @Override
            public boolean onTouchEvent(MotionEvent evento) {

                x = evento.getX();
                y = evento.getY();

                if (evento.getAction() == MotionEvent.ACTION_DOWN) {
                    accion = "down";
                    texto = "Action Down";
                }

                if (evento.getAction() == MotionEvent.ACTION_UP) {
                    texto = "Action Up";
                }

                if (evento.getAction() == MotionEvent.ACTION_MOVE) {
                    accion = "move";
                    texto = "Action Move";
                }
                invalidate();
                return true;
            }
        }
    }

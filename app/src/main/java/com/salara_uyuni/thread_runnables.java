package com.salara_uyuni;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class thread_runnables extends AppCompatActivity {

    private TextView textViewTitulo;
    private Button tvBoton1;
    private Button tvBoton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_runnables);

        textViewTitulo = findViewById(R.id.textViewTitulo);
        tvBoton1 = findViewById(R.id.tvBoton1);
        tvBoton2 = findViewById(R.id.tvBoton2);

        tvBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textViewTitulo.setText(R.string.hilo_ejecutado);
                            }
                        });
                    }
                });
                thread.start();
            }
        });
    }
}

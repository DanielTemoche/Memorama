package com.kytom.memorama;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bienestaraprendiz.emparejapp.R;
import com.kytom.memorama.BD.Crud;
import com.kytom.memorama.Pantallas.Names;


public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Crud crud=new Crud(this,"puntaje",null,1);
        crud.iniciarBD(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pasar = new Intent(splashscreen.this,Names.class);
                startActivity(pasar);
                finish();
            }
        },3000);


    }
}

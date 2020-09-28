package com.kytom.memorama.Pantallas;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.View;

import android.widget.Button;


import android.view.View;
import android.widget.Button;

import com.kytom.memorama.Adaptadores.AdapterPuntajes;
import com.kytom.memorama.BD.Crud;
import com.kytom.memorama.Entidades.ListaVo;
import com.kytom.memorama.Entidades.PuntajesVo;
import com.example.bienestaraprendiz.emparejapp.R;

import java.util.ArrayList;

public class Puntajes extends AppCompatActivity {
    ArrayList<PuntajesVo> lista;
    ArrayList<ListaVo> puntajes;
    RecyclerView recycler;
    AdapterPuntajes adapter;
    Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);
        lista=new ArrayList<>();
        puntajes=new ArrayList<>();
        recycler=findViewById(R.id.contenedor);
        volver=findViewById(R.id.volver);
        consulta();
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void consulta(){
        Crud  crud=new Crud(this,"puntaje",null,1);
        crud.consultar(this,"tb_puntaje",lista);
        for(int i=0;i<6;i++){
            puntajes.add(new ListaVo(
                    lista.get(i*5).getNombre(),
                    lista.get((i*5)+1).getNombre(),
                    lista.get((i*5)+2).getNombre(),
                    lista.get((i*5)+3).getNombre(),
                    lista.get((i*5)+4).getNombre(),
                    lista.get(i*5).getPuntaje(),
                    lista.get((i*5)+1).getPuntaje(),
                    lista.get((i*5)+2).getPuntaje(),
                    lista.get((i*5)+3).getPuntaje(),
                    lista.get((i*5)+4).getPuntaje(),
                    lista.get(i*5).getTiempo(),
                    lista.get((i*5)+1).getTiempo(),
                    lista.get((i*5)+2).getTiempo(),
                    lista.get((i*5)+3).getTiempo(),
                    lista.get((i*5)+4).getTiempo()
            ));
            recycler.setLayoutManager(new LinearLayoutManager(this));
            adapter= new AdapterPuntajes(puntajes);
            recycler.setAdapter(adapter);
        }
    }
}

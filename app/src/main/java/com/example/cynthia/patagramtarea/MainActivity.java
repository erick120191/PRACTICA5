package com.example.cynthia.patagramtarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.mascota1,"Terry",0));
        mascotas.add(new Mascota(R.drawable.mascota2,"Abril",0));
        mascotas.add(new Mascota(R.drawable.mascota3,"Guffy",0));
        mascotas.add(new Mascota(R.drawable.mascota4,"Taison",0));
        mascotas.add(new Mascota(R.drawable.mascota5,"Lashka",0));

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        rvMascotas.setAdapter(adaptador);

    }


    //agregando boton de acción al toolbar
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {

            case R.id.abRanking:
                Toast.makeText(this.getApplicationContext(), "Ranking", Toast.LENGTH_SHORT);
                Intent inr = new Intent(MainActivity.this, ranking.class);
                MainActivity.this.startActivity(inr);
                break;
            case R.id.mContacto:
                Intent intent=new Intent(this,Acerca.class);
                startActivity(intent);
                break;
            case R.id.mAcerca:
                //Intent intents=new Intent(this,ActivitySettings.class);
                //startActivity(intents);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}

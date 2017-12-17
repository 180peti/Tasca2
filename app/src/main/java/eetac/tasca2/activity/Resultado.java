package eetac.tasca2.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import eetac.tasca2.adapter.AdapterView;
import eetac.tasca2.api.Service;
import eetac.tasca2.R;
import eetac.tasca2.modelo.Lista;
import eetac.tasca2.modelo.Pelicula;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Resultado extends AppCompatActivity {

    public static final String BASE_URL = "http://api.themoviedb.org/";
    private static final String api_key="48b8a9b575f4ca2237f8c7134f02cd4d";
    private Retrofit retrofit=null;
    private RecyclerView rwRepollistat = null;
    private String busqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        busqueda=getIntent().getStringExtra("busqueda");
        rwRepollistat=findViewById(R.id.view);
        rwRepollistat.setHasFixedSize(true);
        rwRepollistat.setLayoutManager(new LinearLayoutManager(this));
        conexion();
    }

    public void conexion(){

        if(retrofit==null){
            this.retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        final ProgressDialog prog=new ProgressDialog(this);
        prog.setIndeterminate(true);
        prog.setMessage("Buscando");
        prog.show();

        Service retro=retrofit.create(Service.class);
        Call<Lista> call=retro.getSearch(api_key,busqueda);
        call.enqueue(new Callback<Lista>() {
            @Override
            public void onResponse(Call<Lista> call, Response<Lista> response) {
                List<Pelicula> movies = response.body().getLista();
                rwRepollistat.setAdapter(new AdapterView(movies, R.layout.pelicula, getApplicationContext()));
                prog.dismiss();
            }

            @Override
            public void onFailure(Call<Lista> call, Throwable throwable) {
            }
        });


    }
}

package eetac.tasca2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import eetac.tasca2.R;

public class Cerca extends AppCompatActivity {

    EditText concepto;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerca);
        concepto=findViewById(R.id.busqueda);
        boton=findViewById(R.id.buscar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent datos=new Intent(Cerca.this,Resultado.class);
                datos.putExtra("busqueda",concepto.getText().toString());
                startActivity(datos);
            }
        });



    }
}

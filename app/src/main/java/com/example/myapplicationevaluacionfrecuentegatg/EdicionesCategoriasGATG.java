package com.example.myapplicationevaluacionfrecuentegatg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplicationevaluacionfrecuentegatg.Adaptadores.AdaptadorLibro;
import com.example.myapplicationevaluacionfrecuentegatg.Adaptadores.AdaptadorRevista;
import com.example.myapplicationevaluacionfrecuentegatg.Modelo.Libro;
import com.example.myapplicationevaluacionfrecuentegatg.Modelo.Revista;
import com.example.myapplicationevaluacionfrecuentegatg.WebService.Asynchtask;
import com.example.myapplicationevaluacionfrecuentegatg.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EdicionesCategoriasGATG extends AppCompatActivity implements Asynchtask {
    private ListView lstOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ediciones_categorias_gatg);

        //recibe los datos de la actividad que envia
        Bundle bundle = this.getIntent().getExtras();

        //se crea una variable para la url del web service y se le concatena el parametrp id
        String url = "https://revistas.uteq.edu.ec/ws/issues.php?j_id=" +bundle.getString("id");

        //se crea objeto map para el envio de datos al web service y se inicializa el mismo
        Map<String,String> datos = new HashMap<String,String>();
        WebService webservice = new WebService(url, datos, EdicionesCategoriasGATG.this, EdicionesCategoriasGATG.this);
        webservice.execute("GET");

        //vista
        lstOp = (ListView) findViewById(R.id.lwedicionescat);


    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONArray JSONlistalibro = new JSONArray(result);
        //modelo o DATA
        ArrayList<Libro> lstlibro = Libro.JsonObjectsBuild(JSONlistalibro);

        //Adaptador
        AdaptadorLibro AdaptadorLibro = new AdaptadorLibro(EdicionesCategoriasGATG.this,lstlibro);
        lstOp.setAdapter(AdaptadorLibro);

        //inicializacion del evento Onclick
        //lstOp.setOnItemClickListener(this);
    }
}
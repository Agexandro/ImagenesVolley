package com.alex.imagenesinternet;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.alex.imagenesinternet.Squeleton.AdapterHeroes;
import com.alex.imagenesinternet.Squeleton.ListaHeroes;
import com.alex.imagenesinternet.Squeleton.RequestQ;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity {
    ListView listView; //listview para mostrar la info de los heroes
    ArrayList<ListaHeroes> listaHeroes; //Arreglo de heroes
    AdapterHeroes adapterHeroes; // Adaptador de lista heroes
    String url = "https://simplifiedcoding.net/demos/view-flipper/heroes.php";

    RequestQueue requestQueue;
    StringRequest stringRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//Oculta la Action Bar
        listView = findViewById(R.id.lvImagenes);
        listaHeroes = new ArrayList<>();
        listaHeroes.clear();
        requestQueue=Volley.newRequestQueue(this);

        parseEmp();
    }

    private void parseEmp() {
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              try {
                  JSONObject jsonObject = new JSONObject(response);
                  JSONArray jsonArray = jsonObject.getJSONArray("heroes");
                  for (int i = 0; i< jsonArray.length();i++){
                      JSONObject heroe = jsonArray.getJSONObject(i);
                      listaHeroes.add(new ListaHeroes(heroe.getString("name"),heroe.getString("imageurl")));
                      AdapterHeroes adapterHeroes = new AdapterHeroes(getApplicationContext(),listaHeroes);
                      listView.setAdapter(adapterHeroes);
                  }
              }catch (Exception e){
                  e.printStackTrace();
              }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(stringRequest);
    }
}

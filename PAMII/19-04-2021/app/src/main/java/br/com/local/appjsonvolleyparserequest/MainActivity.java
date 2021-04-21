package br.com.local.appjsonvolleyparserequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView txtResult;
    private Button btnParse;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnParse = findViewById(R.id.btnParse);
        mQueue = Volley.newRequestQueue(this);

        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {
        ListView list = (ListView) findViewById(R.id.narutoList);
        ArrayList<String> listItems=new ArrayList<String>();

        //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
        ArrayAdapter<String> adapter;
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        list.setAdapter(adapter);
        String urlJutsus = "https://api-naruto-pwiii.herokuapp.com/jutsus";

        JsonArrayRequest request3 = new JsonArrayRequest(Request.Method.GET, urlJutsus, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            listItems.add("                              Jutsus" + "\n\n\n");
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jutsus = response.getJSONObject(i);

                                int id = jutsus.getInt("id");
                                String nome = jutsus.getString("nome");
                                String classificacao = jutsus.getString("classificacao");
                                String tipo = jutsus.getString("tipo");
                                String classe = jutsus.getString("classe");

                                listItems.add(nome + " - " + classificacao +  " - " + tipo + " - " + classe + "\n\n");
                                adapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        String urlAldeias = "https://api-naruto-pwiii.herokuapp.com/aldeias";

        JsonArrayRequest request2 = new JsonArrayRequest(Request.Method.GET, urlAldeias, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            listItems.add("                              Aldeias" + "\n\n\n");
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject aldeia = response.getJSONObject(i);

                                int id = aldeia.getInt("id");
                                String vila = aldeia.getString("vila");
                                String lider = aldeia.getString("lider");
                                String jinchuriki = aldeia.getString("jinchuriki");

                                listItems.add(vila + " - " + lider +  " - " + jinchuriki + "\n\n");
                            }
                            mQueue.add(request3);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        String urlPersonagens = "https://api-naruto-pwiii.herokuapp.com/personagens";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, urlPersonagens, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            listItems.add("                              Naruto" + "\n" + "                         Personagens" + "\n\n");
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject personagem = response.getJSONObject(i);

                                int id = personagem.getInt("id");
                                String name = personagem.getString("nome");
                                String sexo = personagem.getString("sexo");
                                String equipamento = personagem.getString("equipamento");

                                listItems.add(name + " - " + equipamento +  " - " + equipamento + "\n\n");
                            }
                            mQueue.add(request2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });


        mQueue.add(request);
    }
}
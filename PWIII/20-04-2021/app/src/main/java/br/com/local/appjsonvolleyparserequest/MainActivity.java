package br.com.local.appjsonvolleyparserequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity {
    private TextView txtResult;
    private Button btnParse;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.txtResult);
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
        String urlJutsus = "https://api-naruto-pwiii.herokuapp.com/jutsus";

        JsonArrayRequest request3 = new JsonArrayRequest(Request.Method.GET, urlJutsus, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            txtResult.append("                              Jutsus" + "\n\n\n");
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jutsus = response.getJSONObject(i);

                                int id = jutsus.getInt("id");
                                String nome = jutsus.getString("nome");
                                String classificacao = jutsus.getString("classificacao");
                                String tipo = jutsus.getString("tipo");
                                String classe = jutsus.getString("classe");

                                txtResult.append(nome + " - " + classificacao +  " - " + tipo + " - " + classe + "\n\n");
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
                            txtResult.append("                              Aldeias" + "\n\n\n");
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject aldeia = response.getJSONObject(i);

                                int id = aldeia.getInt("id");
                                String vila = aldeia.getString("vila");
                                String lider = aldeia.getString("lider");
                                String jinchuriki = aldeia.getString("jinchuriki");

                                txtResult.append(vila + " - " + lider +  " - " + jinchuriki + "\n\n");
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
                            txtResult.append("                              Naruto" + "\n" + "                         Personagens" + "\n\n");
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject personagem = response.getJSONObject(i);

                                int id = personagem.getInt("id");
                                String name = personagem.getString("nome");
                                String sexo = personagem.getString("sexo");
                                String equipamento = personagem.getString("equipamento");

                                txtResult.append(name + " - " + equipamento +  " - " + equipamento + "\n\n");
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
package com.camila.ortiz.vid20221;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class editarActivity extends AppCompatActivity {

    ImageView imagenL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);


        animeClass  animeClass  = (animeClass) getIntent().getSerializableExtra("anime");
        assert animeClass != null;

        EditText nombreT = findViewById(R.id.editTextTextPersonName4);
        EditText descrT = findViewById(R.id.editTextTextPersonName5);

        nombreT.setText(animeClass.getNombre());
        descrT.setText(animeClass.getDescripcion());

        Log.e("id ",animeClass.getId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://62a1f956cc8c0118ef5a4a78.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Servicio serv = retrofit.create(Servicio.class);

        Button registrar = findViewById(R.id.button);


        registrar.setOnClickListener(v -> {

            String nombre = nombreT.getText().toString();
            String descrip = descrT.getText().toString();

            if(nombre.equals("")){
                Toast.makeText(editarActivity.this,"El nombre del anime es necesario",Toast.LENGTH_LONG).show();
                return;
            }

            if(descrip.equals("")){
                Toast.makeText(editarActivity.this,"La descripcion del anime es necesario",Toast.LENGTH_LONG).show();
                return;
            }


            animeClass animeClassS = new animeClass();
            animeClassS.setNombre(nombre);
            animeClassS.setDescripcion(descrip);

            Call<ResponseBody> capturar = serv.updateUser(animeClass.getId(),animeClassS);

            capturar.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    Log.e("info ", String.valueOf(response.code()));
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }
            });

        });
    }
}
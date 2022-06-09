package com.camila.ortiz.vid20221;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class crearAnime extends AppCompatActivity {

    ImageView imagenL;

    Uri imageUri;
    String imagenString = "";

    private static final int PICK_IMAGE = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_anime);

        EditText nombreT = findViewById(R.id.editTextTextPersonName4);
        EditText descrT = findViewById(R.id.editTextTextPersonName5);
        imagenL = findViewById(R.id.imagen);

        imagenL.setOnClickListener(v -> cargarImagen());

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
                Toast.makeText(crearAnime.this,"El nombre del anime es necesario",Toast.LENGTH_LONG).show();
                return;
            }

            if(descrip.equals("")){
                Toast.makeText(crearAnime.this,"La descripcion del anime es necesario",Toast.LENGTH_LONG).show();
                return;
            }


            if(imagenString.equals("")){
                Toast.makeText(crearAnime.this,"La imagen del anime es necesario",Toast.LENGTH_LONG).show();
                return;
            }

            Log.d("BASE 64",imagenString);

            animeClass animeClass = new animeClass();
            animeClass.setNombre(nombre);
            animeClass.setDescripcion(descrip);
            animeClass.setURL("imagenBase64");

            Call<Void> capturar = serv.crear(animeClass);

            capturar.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {

                    Log.e("info ", String.valueOf(response.code()));
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }
            });

        });
    }

    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        //noinspection deprecation
        startActivityForResult(intent, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imagenL.setImageURI(imageUri);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                byte[] image = outputStream.toByteArray();
                imagenString = Base64.encodeToString(image, Base64.DEFAULT);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
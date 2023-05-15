package com.example.proyectoretrofeed;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import models.Propietario;
import request.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Propietario> propietario;

    public PerfilActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<Propietario> getPropietario() {
        if (propietario == null) {
            propietario = new MutableLiveData<>();
        }
        return propietario;
    }

    public void cargarPerfil(){

        SharedPreferences preferencias = context.getSharedPreferences("token.xml", 0);
        String token = preferencias.getString("token", "");

        Log.d("token obtener", token);
        ApiClient.EndpointInmobiliaria endpoint = ApiClient.getEndpoint();
        Call<Propietario> call = endpoint.obtenerPerfil(token);
        call.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        //propietario.setValue(response.body());
                        Log.d("salida perfil", response.body().getNombre());
                    }
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(context, "Error al obtener perfil", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


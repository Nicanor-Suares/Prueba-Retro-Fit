package com.example.proyectoretrofeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.proyectoretrofeed.databinding.ActivityPerfilBinding;

public class PerfilActivity extends AppCompatActivity {

    private PerfilActivityViewModel mv;
    private ActivityPerfilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPerfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(PerfilActivityViewModel.class);

        mv.cargarPerfil();

    }
}
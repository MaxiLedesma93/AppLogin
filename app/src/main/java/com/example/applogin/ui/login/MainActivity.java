package com.example.applogin.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.applogin.R;
import com.example.applogin.databinding.ActivityMainBinding;
import com.example.applogin.modelo.Usuario;
import com.example.applogin.request.ApiClient;
import com.example.applogin.ui.registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel vmMain;
    private ActivityMainBinding binding;
    private ApiClient api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        vmMain = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        setContentView(binding.getRoot());
        api = new ApiClient();
        vmMain.getmUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
        binding.btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = binding.etUsuario.getText().toString();
                String pass = binding.etPasswordL.getText().toString();
                vmMain.Loguear(user, pass);
            }
        });

    }
}
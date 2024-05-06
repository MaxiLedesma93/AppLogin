package com.example.applogin.ui.registro;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.applogin.R;
import com.example.applogin.databinding.ActivityRegistroBinding;
import com.example.applogin.modelo.Usuario;
import com.example.applogin.request.ApiClient;

public class RegistroActivity extends AppCompatActivity {
    private RegistroActivityViewModel vmRegistro;
    private ActivityRegistroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        vmRegistro = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
                .create(RegistroActivityViewModel.class);
        setContentView(binding.getRoot());
        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.etNombre.getText().toString();
                String apellido = binding.etApellido.getText().toString();
                Long dni = Long.valueOf(binding.etDni.getText().toString());
                String email = binding.etEmail.getText().toString();
                String password = binding.etPasswordR.getText().toString();
                Usuario user = new Usuario(nombre, apellido, dni, email, password);
                ApiClient.guardar(getApplication(), user);
            }
        });
        vmRegistro.getmUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                binding.etNombre.setText(usuario.getNombre());
                binding.etApellido.setText(usuario.getApellido());
                binding.etDni.setText(usuario.getDni()+"");
                binding.etEmail.setText(usuario.getEmail());
                binding.etPasswordR.setText(usuario.getPassword());

            }
        });
        vmRegistro.mostrar();



    }
}
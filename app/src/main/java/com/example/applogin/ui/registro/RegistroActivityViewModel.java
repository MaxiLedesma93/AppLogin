package com.example.applogin.ui.registro;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.applogin.request.ApiClient;
import com.example.applogin.modelo.Usuario;

public class RegistroActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Usuario> mUsuario;

    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);

    }

    public MutableLiveData<Usuario> getmUsuario() {
        if(mUsuario == null){
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }

    public void mostrar(){
       Usuario usuario = ApiClient.obtener(getApplication());
       if(usuario.getNombre()!="-1"){
           mUsuario.setValue(ApiClient.obtener(getApplication()));
       }



    }
}


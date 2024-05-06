package com.example.applogin.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.applogin.modelo.Usuario;
import com.example.applogin.request.ApiClient;

public class MainActivityViewModel extends AndroidViewModel{
    private MutableLiveData<Usuario> mUsuario;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);



    }

    public LiveData<Usuario> getmUsuario() {
        if(mUsuario == null){
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }
    public void Loguear(String user, String pass){
        Usuario usuario = ApiClient.login(getApplication(), user, pass);
        if(usuario!=null){
            mUsuario.setValue(usuario);
        }
    }

}

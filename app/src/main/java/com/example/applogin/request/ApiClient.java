package com.example.applogin.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.applogin.modelo.Usuario;

public class ApiClient  {
    private static SharedPreferences sp;

    private static SharedPreferences conectar (Context contexto){
        if(sp==null){
            sp = contexto.getSharedPreferences("datos.xml", 0);
        }
        return sp;
    }
    public static void guardar(Context contexto, Usuario usuario){
        SharedPreferences sp = conectar(contexto);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("nombre", usuario.getNombre());
        editor.putString("apellido", usuario.getApellido());
        editor.putLong("dni", usuario.getDni());
        editor.putString("email", usuario.getEmail());
        editor.putString("password", usuario.getPassword());
        editor.commit();

    }
    public static Usuario obtener(Context contexto){
        SharedPreferences sp = conectar(contexto);
        String nombre = sp.getString("nombre","-1");
        String apellido = sp.getString("apellido", "-1");
        Long dni = sp.getLong("dni", -1);
        String email = sp.getString("email", "-1");
        String password = sp.getString("password", "-1");
        return new Usuario(nombre, apellido, dni, email, password);
    }
    public static Usuario login(Context contexto, String email, String password){
        Usuario usuario = null;
        SharedPreferences sp = conectar(contexto);
        String nombre = sp.getString("nombre","-1");
        String apellido = sp.getString("apellido", "-1");
        Long dni = sp.getLong("dni", -1);
        String mail = sp.getString("email", "-1");
        String pass = sp.getString("password", "-1");
        if(mail.equals(email) && pass.equals(password)){
            usuario = new Usuario(nombre, apellido, dni, mail, pass);
        }else {
            Toast.makeText(contexto, "Usuario y/o Contraseña Incorrectos", Toast.LENGTH_SHORT).show();
        }
        return usuario;
    }
}

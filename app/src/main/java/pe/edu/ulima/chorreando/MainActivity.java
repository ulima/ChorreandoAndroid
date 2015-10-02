package pe.edu.ulima.chorreando;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.ulima.chorreando.model.dao.Usuario;
import pe.edu.ulima.chorreando.presenter.LoginRetrofitPresenter;
import pe.edu.ulima.chorreando.views.LoginView;

public class MainActivity extends Activity implements OnClickListener, LoginView{
    Button butLogin, ButLoginFacebook, butRegistrar;
    EditText eteUsername, etePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butLogin = (Button)findViewById(R.id.butLogin);
        ButLoginFacebook = (Button)findViewById(R.id.butLoginFacebook);
        butRegistrar = (Button)findViewById(R.id.butRegistrar);
        eteUsername = (EditText)findViewById(R.id.eteUsername);
        etePassword = (EditText)findViewById(R.id.etePassword);

        butLogin.setOnClickListener(this);
        ButLoginFacebook.setOnClickListener(this);
        butRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.butLogin) {
            String username = eteUsername.getText().toString();
            String password = etePassword.getText().toString();

            //new LoginPresenter(this).login(username, password);
            new LoginRetrofitPresenter(this).login(username, password);

        }else if (view.getId() == R.id.butLoginFacebook){
            Log.i("MainActivity", "Se hizo click en el boton LoginFacebook");
            Toast.makeText(
                    this,
                    "Opcion de LoginFacebook... proximamente",
                    Toast.LENGTH_LONG
            ).show();
        }else{
            Log.i("MainActivity", "Se hizo click en el boton Registrarse");
            Toast.makeText(
                    this,
                    "Opcion de Registrarse... proximamente",
                    Toast.LENGTH_LONG
            ).show();
        }
    }

    @Override
    public void onLoginCorrecto() {
        // Ir a un nuevo activity Perfil
        getApplicationController().setUsuario(new Usuario(
                1l,
                "Hernan",
                "Peru",
                "http://www.trendfollowing.com/images/V%20for%20Vendetta-751826.jpg"
        ));
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,
                ContenedorActivity.class);
        intent.putExtra("username", eteUsername.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onLoginIncorrecto() {
        // Mostrar un toast de error
        Toast.makeText(
                this,
                "Error en login",
                Toast.LENGTH_SHORT
        ).show();
        // Limpiar los edittext
        eteUsername.setText("");
        etePassword.setText("");
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(
                this,
                "EXC: " + msg,
                Toast.LENGTH_LONG
        ).show();
    }

    @Override
    public ApplicationController getApplicationController() {
        return (ApplicationController)getApplication();
    }
}

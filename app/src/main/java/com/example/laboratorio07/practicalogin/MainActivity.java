package com.example.laboratorio07.practicalogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt_Usuario;
    TextView txt_contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt_Usuario=(TextView)findViewById(R.id.txtUsuario);
        txt_contraseña=(TextView)findViewById(R.id.txtContraseña);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void irHome(View view){

        String Usser = "jperes";
        String pass = "123456";

        String usuario=txt_Usuario.getText().toString();
        String contraseña=txt_contraseña.getText().toString();

        switch (view.getId()){
            case(R.id.btnIngresar):
                if (usuario.equals(Usser) && contraseña.equals(pass)){
                    Intent irHome = new Intent(this,Home.class);
                    irHome.putExtra("usuario",Usser);
                    irHome.putExtra("contraseña",pass);
                    startActivity(irHome);
                }else {
                    Intent irMensaje_error =  new Intent(this,Mensaje_Error.class);
                    startActivity(irMensaje_error);
                } break;
            case (R.id.btnCancelar):
                txt_Usuario.setText(null);
                txt_contraseña.setText(null);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

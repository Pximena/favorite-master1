package com.i044114_i012114.proyectofinalandroid.Views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.i044114_i012114.proyectofinalandroid.Helpers.SqliteHelper;
import com.i044114_i012114.proyectofinalandroid.Models.IdUser;
import com.i044114_i012114.proyectofinalandroid.R;

public class LoginUserActivity extends AppCompatActivity {

    SqliteHelper sqliteHelper;
    private Cursor fila;
    EditText editTextUser;
    EditText editTextPassword;

    private CheckBox opcionMostrar;
    private EditText Contrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        sqliteHelper = new SqliteHelper(this, "db_contact", null, 1);

        editTextUser = (EditText) findViewById(R.id.id_et_users);
        editTextPassword = (EditText) findViewById(R.id.id_et_password);

        opcionMostrar = (CheckBox)findViewById(R.id.opcion_mostrar);
        Contrasena = (EditText)findViewById(R.id.id_et_password);

        }

    public  void  userVali(View view){

        SQLiteDatabase db = sqliteHelper.getWritableDatabase();

        String stringName = editTextUser.getText().toString();
        String stringPhone = editTextPassword.getText().toString();

        if (TextUtils.isEmpty(stringName)){
            Toast.makeText(this, "El campo de id esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringPhone)){
            Toast.makeText(this, "El campo nombre esta vacio", Toast.LENGTH_SHORT).show();
        }else {

            String usuario=editTextUser.getText().toString();
            String contrasena=editTextPassword.getText().toString();
            fila=db.rawQuery("select id, cedula, password from users where cedula='"+usuario+"' and password='"+contrasena+"'",null);
            //preguntamos si el cursor tiene algun valor almacenado
            if(fila.moveToFirst()==true){
                //capturamos los valores del cursos y lo almacenamos en variable
                int idusua=fila.getInt(0);
                String usua=fila.getString(1);
                String pass=fila.getString(2);
                //preguntamos si los datos ingresados son iguales
                if (usuario.equals(usua)&&contrasena.equals(pass)) {
                    //si son iguales entonces vamos a otra ventana
                    //Menu es una nueva actividad empty
                    Intent ven = new Intent(this, ProductListActivity.class);
                    IdUser idUsu = new IdUser();
                    idUsu.setIdusu(idusua);
                    startActivity(ven);
                    Toast.makeText(this, "Bienvenido a MediFarmBlue", Toast.LENGTH_SHORT).show();
                }
            }else {
                //limpiamos las las cajas de texto

                editTextUser.setText("");
                editTextPassword.setText("");
                Toast.makeText(this, "El usuario y contraseña no coinciden", Toast.LENGTH_SHORT).show();
            }

        }

    }
    public void mostrarContraseña(View v){
        // Salvar cursor
        int cursor = Contrasena.getSelectionEnd();

        if(opcionMostrar.isChecked()){
            Contrasena.setInputType(InputType.TYPE_CLASS_TEXT
                    | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }else{
            Contrasena.setInputType(InputType.TYPE_CLASS_TEXT
                    | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }

        // Restaurar cursor
        Contrasena.setSelection(cursor);
    }



      }
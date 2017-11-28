package com.i044114_i012114.proyectofinalandroid.Views;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.i044114_i012114.proyectofinalandroid.Adapters.FavoriteAdapter;
import com.i044114_i012114.proyectofinalandroid.Helpers.SqliteHelper;
import com.i044114_i012114.proyectofinalandroid.Models.Favorite;
import com.i044114_i012114.proyectofinalandroid.Models.IdUser;
import com.i044114_i012114.proyectofinalandroid.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {
    SqliteHelper sqliteHelper;
    RecyclerView recyclerViewFavorite;
    FavoriteAdapter favoriteAdapter;
    List<Favorite> favoriteList = new ArrayList<>();
    IdUser idUsu = new IdUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        sqliteHelper = new SqliteHelper(this, "db_contact", null, 1);

        recyclerViewFavorite = (RecyclerView) findViewById(R.id.id_rv_contacts);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewFavorite.setLayoutManager(linearLayoutManager);

        listFavorite();

    }

    public void listFavorite(){
        Toast.makeText(this, "asdsfasdfs", Toast.LENGTH_SHORT).show();


        SQLiteDatabase db = sqliteHelper.getReadableDatabase();



        Cursor cursor = db.rawQuery("select f.id_fav, p.namepro, p.cantidad, p.url from products p inner join favorite f on p.id = f.id_prod where f.id_user = "+ idUsu.getIdusu(), null);

        while (cursor.moveToNext()){
            Favorite favorite = new Favorite();
            favorite.setId_fav(cursor.getInt(0));
            //favorite.setId_user(cursor.getInt(1));
            favorite.setName(cursor.getString(1));
            favorite.setCantidad(cursor.getString(2));
            favorite.setUrl(cursor.getString(3));
           favoriteList.add(favorite);

        }

        cursor.close();

        if (favoriteList.size() != 0){
            processData();
        }else{
            Toast.makeText(this, "Lista vacia", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData(){
        favoriteAdapter = new FavoriteAdapter(favoriteList, getApplicationContext());
        recyclerViewFavorite.setAdapter(favoriteAdapter);
    }
}
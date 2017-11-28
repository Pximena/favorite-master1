package com.i044114_i012114.proyectofinalandroid.Utilities;

/**
 * Created by ACER on 13/11/2017.
 */

public class Constants {

    public static final String TABLA_NAME_USERS = "users";
    public static final String TABLA_FIELD_ID = "id";
    public static final String TABLA_FIELD_NAME = "name";
    public static final String TABLA_FIELD_CEDULA = "cedula";
    public static final String TABLA_FIELD_PASSWORD = "password";
    public static final String CREATE_TABLE_USERS =
            "CREATE TABLE "+ TABLA_NAME_USERS+" ("+
                    TABLA_FIELD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_NAME+" TEXT, "+
                    TABLA_FIELD_CEDULA+" TEXT, "+
                    TABLA_FIELD_PASSWORD+" TEXT) " ;

    public static final String TABLA_NAME_PRODUCTS = "products";
    public static final String TABLA_FIELD_ID_PRO = "id";
    public static final String TABLA_FIELD_NAME_PRODUCT = "namepro";
    public static final String TABLA_FIELD_DESCRIPTION = "description";
    public static final String TABLA_FIELD_CANTIDAD = "cantidad";
    public static final String TABLA_FIELD_URL = "url";
    public static final String CREATE_TABLE_PRODUCTS =
            "CREATE TABLE "+ TABLA_NAME_PRODUCTS+" ("+
                    TABLA_FIELD_ID_PRO+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_NAME_PRODUCT+" TEXT, "+
                    TABLA_FIELD_DESCRIPTION+" TEXT, "+
                    TABLA_FIELD_CANTIDAD+" TEXT, "+
                    TABLA_FIELD_URL+" TEXT)";

    public static final String TABLA_NAME_FAVORITE = "favorite";
    public static final String TABLA_FIELD_ID_FAV = "id_fav";
    public static final String TABLA_FIELD_ID_US = "id_user";
    public static final String TABLA_FIELD_ID_PROD= "id_prod";
    public static final String CREATE_TABLE_FAVORITE =
            "CREATE TABLE "+ TABLA_NAME_FAVORITE+" ("+
                    TABLA_FIELD_ID_FAV+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_ID_US+" INTEGER, "+
                    TABLA_FIELD_ID_PROD+" INTEGER) ";
}


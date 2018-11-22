package com.aluno.cardapio.prototipo02;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

public class DBHelper extends SQLiteOpenHelper {

    private static int versao=1;
    private static String nome="Login_Registro_BaseDados.db";

    public DBHelper(Context context) {

        super(context, nome, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE Utilizador(username TEXT PRIMARY KEY, password TEXT);";
        db.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Utilizador;");
        onCreate(db);
    }

    public long CriarUtilizador(String username, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put ("username", username);
        cv.put ("password", password);
        long result = db.insert ("Utilizador",null,cv);
        return result;
    }

    public String ValidarLogin(String username, String password){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Utilizador WHERE username=? AND password=?", new String[] {username, password});
        if (c.getCount() > 0){
            return "OK";
        }
        return "ERRO";
    }

    public int deleteItem(String username) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "username=?";
        String whereArgs[] = {username};
        return db.delete("Utilizador", whereClause, whereArgs);
    }

}

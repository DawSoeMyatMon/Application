package com.example.nyinyi.sqliteexample;

import android.app.Service;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.StringBuilderPrinter;
import android.widget.Toast;

public class myDbAdapter {
    myDbHelper myhelper;

    public myDbAdapter(Context context) {
        myhelper=new myDbHelper(context);
    }

    public long inertData(String name,String password){
        String SDCardPath= Environment.getExternalStorageDirectory().getPath();
        SQLiteDatabase dbb=myhelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAEM",name);
        contentValues.put("PASSWORD",password);
        long id=dbb.insert(myDbHelper.TABLE_NAME,null,contentValues);
        return id;
    }


    public String getData(){
        SQLiteDatabase dbb=myhelper.getWritableDatabase();
        String[] columns={myDbHelper.ID,myDbHelper.NAME,myDbHelper.PASSWORD};
        Cursor cursor=dbb.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer stringBuffer=new StringBuffer();
        while (cursor.moveToNext()){
            int cid=cursor.getInt(cursor.getColumnIndex(myDbHelper.ID));
            String cname=cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String cpassword=cursor.getString(cursor.getColumnIndex(myDbHelper.PASSWORD));
            stringBuffer.append(cid + " "+ cname + " " + cpassword);
        }
        return stringBuffer.toString();

    }

    public int delete(String uname){
        SQLiteDatabase dbb=myhelper.getWritableDatabase();
        String[] whereArgs={uname};
        int count=dbb.delete(myDbHelper.TABLE_NAME,myDbHelper.NAME + "=?",whereArgs);
        return count;

    }

    public int updateName(String oldName,String newName){
        SQLiteDatabase dbb=myhelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(myDbHelper.NAME,newName);
        String[] whereArgs={oldName};
        int count=dbb.update(myDbHelper.TABLE_NAME,contentValues,myDbHelper.NAME+"=?",whereArgs);
        return count;
    }

  static class myDbHelper extends SQLiteOpenHelper{

        private static final String DATABASE_NAME="myDatabase";
        private static final String TABLE_NAME="myTable";
        private static final int DATABASE_VERSION=1;
        private static final String ID="_id";
        private static final String NAME="NAME";
        private static final String PASSWORD="PASSWORD";
        private static final String CREATE_TABLE="CREATE TABLE"+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTO INCREMENT,"+NAME+" VARCHAR(255),"+PASSWORD+" VARCHAR(255));";
        private static final String DROP_TABLE="DROP TABLE IF EXISTS"+TABLE_NAME;
        private Context context;

      public myDbHelper(Context context){

            super(context,DATABASE_NAME,null,DATABASE_VERSION);
            this.context=context;


        }

        public void onCreate(SQLiteDatabase db){

            try{
                db.execSQL(CREATE_TABLE);
            }
            catch (Exception e){
                Message.message(context," "+e);
            }
        }

      @Override
      public void onUpgrade ( SQLiteDatabase db , int oldVersion , int newVersion ) {
          try {

              Message . message ( context , "OnUpgrade" );
              db . execSQL ( DROP_TABLE );
              onCreate ( db );
          } catch ( Exception e ) {
              Message . message ( context , "" + e );
          }

        }

    }

}

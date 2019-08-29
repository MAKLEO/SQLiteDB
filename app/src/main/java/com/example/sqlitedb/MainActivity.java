package com.example.sqlitedb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editTextRollno,editTextName,editTextMarks;
    Button buttonadd,buttondelete,buttonmodify,buttonviewall,buttonview,buttonshow;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextRollno=findViewById(R.id.editTextroll);
        editTextName=findViewById(R.id.editTextname);
        editTextMarks=findViewById(R.id.editTextmarks);
        buttonadd=findViewById(R.id.buttonAdd);
        buttondelete=findViewById(R.id.buttonDelete);
        buttonmodify=findViewById(R.id.buttonModify);
        buttonview=findViewById(R.id.buttonView);
        buttonviewall=findViewById(R.id.buttonViewall);
        buttonshow=findViewById(R.id.buttonshow);

        buttonadd.setOnClickListener(this);
        buttondelete.setOnClickListener(this);
        buttonmodify.setOnClickListener(this);
        buttonview.setOnClickListener(this);
        buttonviewall.setOnClickListener(this);
        buttonshow.setOnClickListener(this);
        sqLiteDatabase=openOrCreateDatabase("studentDB",MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,marks VARCHAR)");

    }
    @Override
    public void onClick(View view) {
//        if (view==buttonadd){
//            if(editTextRollno.getText().toString().trim().length()==0||editTextName.getText().toString().trim().length()==0||editTextMarks.getText().toString().trim().length()==0){
//                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
//                showMessage("Error","Please Enter All Values");
//                return;
//            }
//            sqLiteDatabase.execSQL("INSERT INTO student VALUES('"+editTextRollno.getText()+"','"+editTextName.getText()+"','"+editTextMarks.getText()+"');");
//            showMessage("Success","Record added");
//            clearText();
//        }
//        if (view==buttondelete){
//            if (editTextRollno.getText().toString().trim().length()==0){
//                showMessage("Error","Please Enter Roll No");
//                return;
//            }
//            Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM student WHERE rollno'"+editTextRollno.getText()+"'",null);
//            if (cursor.moveToFirst()){
//                sqLiteDatabase.execSQL("DELETE FROM student WHERE rollno='"+editTextRollno.getText()+"'");
//
//            }
//        }








        switch (view.getId()){
            case R.id.buttonAdd:
                if(editTextRollno.getText().toString().trim().length()==0||
                        editTextName.getText().toString().trim().length()==0||
                        editTextMarks.getText().toString().trim().length()==0){
                Toast.makeText(this, "INVALID INPUT", Toast.LENGTH_SHORT).show();
                shwmsg("Eroor","INVALID INPUT");
                return;
                }
                clearText();
                break;
            case R.id.buttonDelete:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonModify:
                Toast.makeText(this, "Modify", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonView:
                Toast.makeText(this, "View", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonViewall:
                Toast.makeText(this, "AllView", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonshow:
                Toast.makeText(this, "Show", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void clearText() {
        editTextRollno.setText(" ");
        editTextName.setText(" ");
        editTextMarks.setText(" ");
    }

    private void shwmsg(String eroor, String invalid_input) {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setCancelable(true);
        alertDialog.setTitle(eroor);
        alertDialog.setMessage(invalid_input);
        alertDialog.setIcon(R.mipmap.ic_launcher_round);
        alertDialog.show();
    }

//    private void clearText() {
//    }
//
//    private void showMessage(String error, String please_enter_all_values) {
//    }
}

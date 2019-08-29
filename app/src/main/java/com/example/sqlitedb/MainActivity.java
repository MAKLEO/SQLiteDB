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
                sqLiteDatabase.execSQL("INSERT INTO student VALUES('"+editTextRollno.getText()+"'," +
                        "'"+editTextName.getText()+"','"+editTextMarks.getText()+"';)");
                shwmsg("SUCCESS","Record added");
                clearText();
                break;
            case R.id.buttonDelete:
                if(editTextRollno.getText().toString().trim().length()==0)
                {
                    shwmsg("Error", "Please enter Rollno");
                    return;
                }
                Cursor c=sqLiteDatabase.rawQuery("SELECT * FROM student WHERE rollno='"+editTextRollno.getText()+"'", null);
                if(c.moveToFirst())
                {
                    sqLiteDatabase.execSQL("DELETE FROM student WHERE rollno='"+editTextRollno.getText()+"'");
                    shwmsg("Success", "Record Deleted");
                }
                else
                {
                    shwmsg("Error", "Invalid Rollno");
                }
                clearText();
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonModify:
                if(editTextRollno.getText().toString().trim().length()==0)
                {
                    shwmsg("Error", "Please enter Rollno");
                    return;
                }
                Cursor c1=sqLiteDatabase.rawQuery("SELECT * FROM student WHERE rollno='"+editTextRollno.getText()+"'", null);
                if(c1.moveToFirst())
                {
                    sqLiteDatabase.execSQL("UPDATE student SET name='"+editTextName.getText()+"',marks='"+editTextMarks.getText()+
                            "' WHERE rollno='"+editTextRollno.getText()+"'");
                    shwmsg("Success", "Record Modified");
                }
                else
                {
                    shwmsg("Error", "Invalid Rollno");
                }
                clearText();
                Toast.makeText(this, "Modify", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonView:
                if(editTextRollno.getText().toString().trim().length()==0)
                {
                    shwmsg("Error", "Please enter Rollno");
                    return;
                }
                Cursor c2=sqLiteDatabase.rawQuery("SELECT * FROM student WHERE rollno='"+editTextRollno.getText()+"'", null);
                if(c2.moveToFirst())
                {
                    editTextName.setText(c2.getString(1));
                    editTextMarks.setText(c2.getString(2));
                }
                else
                {
                    shwmsg("Error", "Invalid Rollno");
                    clearText();
                }
                Toast.makeText(this, "View", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonViewall:
                Cursor c3=sqLiteDatabase.rawQuery("SELECT * FROM student", null);
                if(c3.getCount()==0)
                {
                    shwmsg("Error", "No records found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(c3.moveToNext())
                {
                    buffer.append("Rollno: "+c3.getString(0)+"\n");
                    buffer.append("Name: "+c3.getString(1)+"\n");
                    buffer.append("Marks: "+c3.getString(2)+"\n\n");
                }
                shwmsg("Student Details", buffer.toString());
                Toast.makeText(this, "AllView", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonshow:
                Toast.makeText(this, "Show", Toast.LENGTH_SHORT).show();
                shwmsg("Developed By-","ms. Vaishnavi Hava");
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

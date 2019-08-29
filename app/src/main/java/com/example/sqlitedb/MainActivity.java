package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editTextRollno,editTextName,editTextMarks;
    Button buttonadd,buttondelete,buttonmodify,buttonviewall,buttonview,buttonshow;

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

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonAdd:
                Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
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
}

package com.example.prachitask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNameActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);
        initView();
    }

    /*initialise view*/
    private void initView(){
         edtName=findViewById(R.id.edtName);
        Button btnNext=findViewById(R.id.btnNext);

    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.btnNext:
             if (edtName.getText().toString().isEmpty()){
                 Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
             }else {
                 startActivity(new Intent(AddNameActivity.this,SelectCricketerActivity.class));
             }

             break;
     }
    }
}

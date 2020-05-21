package com.example.prachitask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SelectCricketerActivity extends AppCompatActivity implements View.OnClickListener {
    String name="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cricketer);
        initView();
    }

    private void initView(){

        Button btnNext=findViewById(R.id.btnNext);
        RadioGroup rdCricketers=findViewById(R.id.rdCricketers);
        final RadioButton rdSachin=findViewById(R.id.rdSachin);
        final RadioButton rdAdam=findViewById(R.id.rdAdam);
        final RadioButton rdJac=findViewById(R.id.rdJac);
        final RadioButton rdVirat=findViewById(R.id.rdVirat);

        rdCricketers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rdAdam.isChecked()){
                  name=rdAdam.getText().toString();
                }else if (rdSachin.isChecked()){
                  name=rdSachin.getText().toString();
                }if (rdJac.isChecked()){
                  name=rdJac.getText().toString();
                }if (rdAdam.isChecked()){
                  name=rdAdam.getText().toString();
                }if (rdVirat.isChecked()){
                  name=rdVirat.getText().toString();
                }
            }
        });

        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.btnNext:
             if (TextUtils.isEmpty(name)){
                 Toast.makeText(this, "Select Cricketer Name", Toast.LENGTH_SHORT).show();
             }else {
                 startActivity(new Intent(this,SelectIndianFlagName.class));
             }

             break;
     }
    }
}

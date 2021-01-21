package com.example.challengeintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etWeb, etCel, etMap;
    ImageView ivSad, ivBad, ivHappy;

    @Override
    public void onClick(View v) {
        if(etName.getText().toString().isEmpty() ||
                etWeb.getText().toString().isEmpty() ||
                etMap.getText().toString().isEmpty() ||
                etCel.getText().toString().isEmpty()){
            Toast.makeText(this, "Please complete all the fields!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra("name", etName.getText().toString());
            intent.putExtra("web", etWeb.getText().toString().trim());
            intent.putExtra("map", etMap.getText().toString());
            intent.putExtra("cel", etCel.getText().toString());

            if(v.getId() == R.id.ivBad){
                intent.putExtra("emoji", "bad");
            }
            else if(v.getId() == R.id.ivSad){
                intent.putExtra("emoji", "sad");
            } else {//happy
                intent.putExtra("emoji", "happy");
            }

            setResult(RESULT_OK, intent);
            Activity2.this.finish();
        }


    }

    public void SendData(String emoji){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        etName = findViewById(R.id.etName);
        etWeb = findViewById(R.id.etWeb);
        etCel = findViewById(R.id.etCel);
        etMap = findViewById(R.id.etMap);
        ivSad = findViewById(R.id.ivSad);
        ivBad = findViewById(R.id.ivBad);
        ivHappy = findViewById(R.id.ivHappy);

        ivSad.setOnClickListener(this);

        ivBad.setOnClickListener(this);

        ivHappy.setOnClickListener(this);
    }
}
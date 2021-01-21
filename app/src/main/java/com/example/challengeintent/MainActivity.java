package com.example.challengeintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnCreate;
    ImageView ivFace, ivCall, ivWeb, ivMap;
    TextView tvName;
    final int ACTIVITY2 = 2;
    String callNumber, website, googleMap, emoji;

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCreate){
            Intent intent = new Intent(MainActivity.this, com.example.challengeintent.Activity2.class);
            startActivityForResult(intent, ACTIVITY2);
        }
        else if(v.getId() == R.id.ivCall){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + callNumber));
            startActivity(intent);
        }
        else if(v.getId() == R.id.ivMap){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + googleMap));
            startActivity(intent);
        }
        else if(v.getId() == R.id.ivWeb){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + website));
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = findViewById(R.id.btnCreate);
        ivFace = findViewById(R.id.ivFace);
        ivCall = findViewById(R.id.ivCall);
        ivWeb = findViewById(R.id.ivWeb);
        ivMap = findViewById(R.id.ivMap);
        tvName = findViewById(R.id.tvName);

        ivFace.setVisibility(View.GONE);
        ivCall.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivMap.setVisibility(View.GONE);
        tvName.setVisibility(View.GONE);

        btnCreate.setOnClickListener(this);
        ivCall.setOnClickListener(this);
        ivMap.setOnClickListener(this);
        ivWeb.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY2){
            if(resultCode == RESULT_OK){
                callNumber = data.getStringExtra("cel");
                googleMap = data.getStringExtra("map");
                website = data.getStringExtra("web");
                tvName.setText(data.getStringExtra("name"));
                emoji = data.getStringExtra("emoji");

                ivFace.setVisibility(View.VISIBLE);
                ivCall.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivMap.setVisibility(View.VISIBLE);
                tvName.setVisibility(View.VISIBLE);

                if(emoji.equals("happy")){
                    ivFace.setImageResource(R.drawable.happy);
                }
                else if(emoji.equals("sad")){
                    ivFace.setImageResource(R.drawable.sad);
                }
                else if(emoji.equals("bad")){
                    ivFace.setImageResource(R.drawable.bad);

                }
            }

            if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "No data received", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
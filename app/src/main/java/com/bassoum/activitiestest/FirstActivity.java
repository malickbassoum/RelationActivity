package com.bassoum.activitiestest;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    public final static int SECOND_CALL_ID=1234;

    private EditText txtInputData;
    private Button btnOpenActivity;
    private TextView lblResultText;
    private Button btnGoHome;
    private Button btnBrowse;
    private Button btnCalculator1;
    private Button btnCalculator2;
    private Button btnCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        txtInputData= (EditText) findViewById(R.id.txtInputData);
        btnOpenActivity= (Button) findViewById(R.id.btnOpenActivity);
        lblResultText= (TextView) findViewById(R.id.lblResult);

        btnOpenActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(
                        FirstActivity.this,
                        SecondActivity.class
                );
                intent.putExtra("message", txtInputData.getText().toString() );
                startActivityForResult(intent, SECOND_CALL_ID);
            }
        });
        //...External activities....//

        btnGoHome=(Button) findViewById(R.id.btnGoHome);
        btnGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);

            }
        });

        btnBrowse=(Button) findViewById(R.id.btnBrowse);
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent( Intent.ACTION_MAIN);

                Uri uri=Uri.parse("https://openclassrooms.com/");
                Intent intent=new Intent( Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        btnCalculator1=(Button) findViewById(R.id.btnCalculator1);
        btnCalculator1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
                startActivity(intent);
            }
        });

        btnCalculator2=(Button) findViewById(R.id.btnCalculator2);
        btnCalculator2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setComponent(new ComponentName("com.android.calculator2",
                        "com.android.calculator2.Calculator"));
                startActivity(intent);


            }
        });

        btnCall=(Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("tel: 338710734");
                Intent intent=new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== SECOND_CALL_ID){
            lblResultText.setText("Result==" + resultCode);
        }
    }
}

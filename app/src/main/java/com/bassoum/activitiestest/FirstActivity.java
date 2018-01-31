package com.bassoum.activitiestest;

import android.content.Intent;
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

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== SECOND_CALL_ID){
            lblResultText.setText("Result==" + resultCode);
        }
    }
}

package com.bassoum.activitiestest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView lblInputData;
    private Button btnClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lblInputData= (TextView) findViewById(R.id.lblInputData);
        btnClose= (Button) findViewById(R.id.btnClose);

        String inputData=this.getIntent().getExtras().getString("message");
        lblInputData.setText(inputData);

        btnClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setResult(33);
                finish();

            }
        });

    }

}

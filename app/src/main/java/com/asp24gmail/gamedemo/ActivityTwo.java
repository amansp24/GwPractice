package com.asp24gmail.gamedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class ActivityTwo extends AppCompatActivity {

    TextView resultView;
    Button goBackBtn;
    public void initDisplay(){
        resultView = (TextView)findViewById(R.id.userResult);
        goBackBtn = (Button)findViewById(R.id.GoBack);
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(ActivityTwo.this, ActivityOne.class);
                startActivity(intentBack);
            }
        });
    }

    public void intentFetch(){
        Intent iRef = getIntent();
        Bundle resBundle = iRef.getBundleExtra("Bundle");
        ArrayList resArray = resBundle.getIntegerArrayList("ArrayList");
        int numberUsers = resBundle.getInt("noOfUsers");
        int count = 0;

        Integer[][] gameArray = new Integer[numberUsers][3];

        for (int i = 0; i < numberUsers; i++){
            for (int j = 0; j < 3; j++){
                gameArray[i][j] = (Integer) resArray.get(count);
                count++;
            }
        }
        

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initDisplay();
        intentFetch();
    }
}

package com.asp24gmail.gamedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;

public class ActivityOne extends AppCompatActivity {

    EditText numberUsers;
    Button subButton;
    public void initEditText(){
        numberUsers = (EditText)findViewById(R.id.noOfUsers);
        subButton = (Button)findViewById(R.id.SubmitUsers);
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noUsers = numberUsers.getText().toString().trim();
                int UsersNo = Integer.parseInt(noUsers);
                int count = UsersNo*3;
                ArrayList array = new ArrayList();
                for (int i = 1; i <= count; i++ ){
                    array.add(i);
                }
                Collections.shuffle(array);

                Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("ArrayList", array);
                bundle.putInt("noOfUsers", UsersNo);
                intent.putExtra("Bundle", bundle);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        initEditText();
    }
}

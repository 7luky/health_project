package com.example.sqlite_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerMainActivity extends AppCompatActivity {


    Button btn_memberManage, btn_trainerManage, btn_lectureManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_main);

        btn_trainerManage = findViewById(R.id.btn_trainerManage);
        GO_trainerManage_UI();
    }

    public void GO_trainerManage_UI(){
        btn_trainerManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerMainActivity.this, TrainerManage.class);
                startActivity(intent);
            }
        });
    }

}
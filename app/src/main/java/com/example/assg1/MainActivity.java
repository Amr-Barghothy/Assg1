package com.example.assg1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.assg1.respiratory_system.RespiratorySystem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    //    EditText NoseText;
    boolean NoseCheck;
    boolean MouthCheck;
    boolean TracheaCheck;
    boolean LungsCheck;
    boolean DiaphragmCheck;

    @SuppressLint({"ResourceType", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RespiratorySystem Rsystem = new RespiratorySystem();
        EditText NoseText = findViewById(R.id.NoseText);
        EditText MouthText = findViewById(R.id.MouthText);
        EditText TracheaText = findViewById(R.id.TracheaText);
        EditText LungsText = findViewById(R.id.LungsText);
        EditText DiaphragmText = findViewById(R.id.DiaphragmText);
        Button NoseButton = findViewById(R.id.NoseButton);
        Button MouthButton = findViewById(R.id.MouthButton);
        Button TracheaButton = findViewById(R.id.TracheaButton);
        Button LungsButton = findViewById(R.id.LungsButton);
        Button DiaphragmButton = findViewById(R.id.DiaphragmButton);
        TextView hintLabel = findViewById(R.id.hintLabel);
        TextView explainLabel = findViewById(R.id.explainLabel);
        Button check = findViewById(R.id.check);
        Button goTo = findViewById(R.id.goTo);
        Button rest = findViewById(R.id.rest);


        check.setOnClickListener(v -> {
            NoseCheck = NoseText.getText().toString().equals("Nose") || NoseText.getText().toString().equals("nose");

            MouthCheck = MouthText.getText().toString().equals("Mouth") || MouthText.getText().toString().equals("mouth");

            TracheaCheck = TracheaText.getText().toString().equals("Trachea") || TracheaText.getText().toString().equals("trachea");

            LungsCheck = LungsText.getText().toString().equals("Lungs") || LungsText.getText().toString().equals("lungs");

            DiaphragmCheck = DiaphragmText.getText().toString().equals("Diaphragm") || DiaphragmText.getText().toString().equals("diaphragm");

            if (NoseCheck && MouthCheck && TracheaCheck && LungsCheck && DiaphragmCheck) {
//                NoseText.setVisibility(View.GONE);
//                MouthText.setVisibility(View.GONE);
//                TracheaText.setVisibility(View.GONE);
//                LungsText.setVisibility(View.GONE);
//                DiaphragmText.setVisibility(View.GONE);
//
//                NoseButton.setVisibility(View.VISIBLE);
//                MouthButton.setVisibility(View.VISIBLE);
//                TracheaButton.setVisibility(View.VISIBLE);
//                LungsButton.setVisibility(View.VISIBLE);
//                DiaphragmButton.setVisibility(View.VISIBLE);
//                explainLabel.setVisibility(View.VISIBLE);
                check.setVisibility(View.GONE);
                goTo.setVisibility(View.VISIBLE);
                rest.setVisibility(View.GONE);
                NoseText.setBackgroundResource(R.drawable.border);
                MouthText.setBackgroundResource(R.drawable.border);
                TracheaText.setBackgroundResource(R.drawable.border);
                LungsText.setBackgroundResource(R.drawable.border);
                DiaphragmText.setBackgroundResource(R.drawable.border);
                hintLabel.setText("Press on explain to learn about each part");
            }
            if (!NoseCheck) {
                NoseText.setBackgroundResource(R.drawable.border_error);
                hintLabel.setText("Make sure you enter the right parts name");
            }

            if (!MouthCheck) {
                MouthText.setBackgroundResource(R.drawable.border_error);
                hintLabel.setText("Make sure you enter the right parts name");
            }

            if (!TracheaCheck) {
                TracheaText.setBackgroundResource(R.drawable.border_error);
                hintLabel.setText("Make sure you enter the right parts name");
            }
            if (!LungsCheck) {
                LungsText.setBackgroundResource(R.drawable.border_error);
                hintLabel.setText("Make sure you enter the right parts name");
            }

            if (!DiaphragmCheck) {
                DiaphragmText.setBackgroundResource(R.drawable.border_error);
                hintLabel.setText("Make sure you enter the right parts name");
            }
        });

        rest.setOnClickListener(v -> {
            NoseText.setText("");
            MouthText.setText("");
            TracheaText.setText("");
            LungsText.setText("");
            DiaphragmText.setText("");
        });

        goTo.setOnClickListener(v -> {
            Intent myIntent = new Intent(this, MainActivity2.class);
            startActivity(myIntent);
        });

//        NoseButton.setOnClickListener(v -> explainLabel.setText(Rsystem.getNose2()));
//        MouthButton.setOnClickListener(v -> explainLabel.setText(Rsystem.getMouth2()));
//        TracheaButton.setOnClickListener(v -> explainLabel.setText(Rsystem.getTrachea2()));
//        LungsButton.setOnClickListener(v -> explainLabel.setText(Rsystem.getLungs2()));
//        DiaphragmButton.setOnClickListener(v -> explainLabel.setText(Rsystem.getDiaphragm2()));
    }
}
package com.example.assg1;

import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.assg1.respiratory_system.RespiratoryRView;
import com.example.assg1.respiratory_system.RespiratorySystem;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<RespiratorySystem> list = new ArrayList<>();
    int[] images = {R.drawable.nose,R.drawable.mouth,R.drawable.trachea,R.drawable.lungs,R.drawable.diaphragm};
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String MY_SHARED = "explain";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sharedPreferences = getSharedPreferences(MY_SHARED,MODE_PRIVATE);
        RecyclerView recyclerView = findViewById(R.id.RView);

        setUpParts();

        RespiratoryRView rView = new RespiratoryRView(this,list);
        recyclerView.setAdapter(rView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpParts() {
        String[] partsName = getResources().getStringArray(R.array.Parts_name);
        String[] explain = getResources().getStringArray(R.array.parts_explain);
        editor = sharedPreferences.edit();

        for (int i = 0; i < partsName.length; i++) {
            list.add(new RespiratorySystem(partsName[i],explain[i],images[i]));
            editor.putString(partsName[i],explain[i]);
        }
        editor.commit();
    }
}